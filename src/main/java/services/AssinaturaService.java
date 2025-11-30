package services;

import dao.*;
import dto.AssinaturaDTO;
import dto.AssinaturaWithOwner;
import model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/*
 assinatura service refeito
 - usa os daos existentes (planos, produtos, assinatura, cesta, itemcesta, pagamento, endereco, entrega, termo, consentimento)
 - validacao de itens vs plano
 - pagamento fake: cartao que comeca com 4 eh aprovado
 - grava em todos os arquivos csv via daos
 - comentarios curtos, sem acentos
*/
public class AssinaturaService {

    private final PlanoDAO planoDAO = new PlanoDAO();
    private final ProdutoDAO produtoDAO = new ProdutoDAO();
    private final AssinaturaDAO assinaturaDAO = new AssinaturaDAO();
    private final CestaDAO cestaDAO = new CestaDAO();
    private final ItemCestaDAO itemCestaDAO = new ItemCestaDAO();
    private final PagamentoDAO pagamentoDAO = new PagamentoDAO();
    private final EnderecoDAO enderecoDAO = new EnderecoDAO();
    private final EntregaDAO entregaDAO = new EntregaDAO();
    private final TermoDAO termoDAO = new TermoDAO();
    private final ConsentimentoDAO consentimentoDAO = new ConsentimentoDAO();

    // cria a assinatura completa; recebe dto e numero do cartao (string)
    public String criarAssinatura(AssinaturaDTO dto, String cartaoNumero) {

        try {
            // 1) carregar plano
            Plano plano = planoDAO.findById(dto.planoId);
            if (plano == null) return "erro: plano invalido";

            // 2) carregar produtos e montar mapa por id
            List<Produto> produtos = produtoDAO.loadAll();
            Map<Integer, Produto> produtoMap = produtos.stream()
                    .collect(Collectors.toMap(Produto::getId, p -> p));

            // 3) validar itens da cesta contra o plano
            String valida = validarItens(dto, plano, produtoMap);
            if (!"ok".equals(valida)) return "erro: " + valida;

            // 4) processar pagamento (fake)
            if (cartaoNumero == null || cartaoNumero.trim().isEmpty())
                return "erro: cartao nao informado";

            boolean pago = cartaoNumero.trim().startsWith("4");
            if (!pago) return "erro: pagamento recusado";

            // opcional: criar objeto Cartao (integracao futura)
            Cartao cartao = new Cartao(cartaoNumero, "", "", dto.nome);

            // 5) gerar ids e persistir dados sequenciais
            // assinatura
            int idAss = assinaturaDAO.nextId();
            String protocolo = UUID.randomUUID().toString().substring(0, 8);
            LocalDate dataInicio = LocalDate.now();
            // gravar assinatura com owner (nome + email) no csv
            AssinaturaWithOwner owner = new AssinaturaWithOwner(
                    idAss, dto.nome, dto.email, protocolo, "ATIVA", dataInicio.toString()
            );
            assinaturaDAO.save(owner);

            // cesta
            int idCesta = cestaDAO.nextId();
            Cesta cesta = new Cesta(idCesta, idAss, 1, "ATIVA");
            cestaDAO.save(cesta);

            // itens da cesta
            int nextItemId = itemCestaDAO.nextId();
            for (AssinaturaDTO.Item it : dto.itens) {
                // validar se produto existe (ja garantido na validacao, mas double-check)
                if (!produtoMap.containsKey(it.produtoId)) continue;
                ItemCesta ic = new ItemCesta(nextItemId++, idCesta, it.produtoId, it.quantidade);
                itemCestaDAO.save(ic);
            }

            // pagamento
            int idPagamento = pagamentoDAO.nextId();
            float valor = plano.getValorBase();
            String transacao = UUID.randomUUID().toString().replace("-", "").substring(0, 12);
            Pagamento pagamento = new Pagamento(idPagamento, idAss, valor, "PAGO", transacao);
            pagamentoDAO.save(pagamento);

            // endereco (pode ser solicitado na UI futuramente); aqui gravamos placeholder
            int idEndereco = enderecoDAO.nextId();
            Endereco endereco = new Endereco(idEndereco, idAss, "nao informado", "-", "-", "-");
            enderecoDAO.save(endereco);

            // entrega (data prevista +3 dias)
            int idEntrega = entregaDAO.nextId();
            Entrega entrega = new Entrega(idEntrega, idAss, LocalDate.now().plusDays(3), "08-12");
            entregaDAO.save(entrega);

            // termo (associa template id 1)
            int idTermo = termoDAO.nextId();
            Termo termo = new Termo(idTermo, idAss, 1, LocalDateTime.now());
            termoDAO.save(termo);

            // consentimento
            int idConsent = consentimentoDAO.nextId();
            Consentimento consent = new Consentimento(idConsent, idAss, LocalDate.now(), "ACEITO");
            consentimentoDAO.save(consent);

            // 6) retorno de sucesso com protocolo
            return "sucesso: protocolo=" + protocolo;

        } catch (Exception e) {
            e.printStackTrace();
            return "erro interno: " + e.getMessage();
        }
    }

    // valida itens do dto contra limites do plano
    // retorna "ok" ou mensagem de erro curta
    private String validarItens(AssinaturaDTO dto, Plano plano, Map<Integer, Produto> produtoMap) {

        if (dto.itens == null || dto.itens.isEmpty()) return "cesta vazia";

        int frutas = 0, legumes = 0, verduras = 0;

        for (AssinaturaDTO.Item it : dto.itens) {
            if (it.quantidade <= 0) return "quantidade invalida para produto " + it.produtoId;
            Produto p = produtoMap.get(it.produtoId);
            if (p == null) return "produto inexistente id=" + it.produtoId;

            String tipo = p.getTipo();
            if ("FRUTA".equalsIgnoreCase(tipo)) frutas += it.quantidade;
            else if ("LEGUME".equalsIgnoreCase(tipo)) legumes += it.quantidade;
            else verduras += it.quantidade;
        }

        if (frutas > plano.getQtdFrutas())
            return "excedeu limite de frutas: " + frutas + " > " + plano.getQtdFrutas();
        if (legumes > plano.getQtdLegumes())
            return "excedeu limite de legumes: " + legumes + " > " + plano.getQtdLegumes();
        if (verduras > plano.getQtdVerduras())
            return "excedeu limite de verduras: " + verduras + " > " + plano.getQtdVerduras();

        return "ok";
    }
}
