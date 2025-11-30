package services;

import dao.*;
import dto.AssinaturaDTO;
import model.*;
import util.CsvUtils;

import java.time.LocalDate;
import java.util.*;

public class AssinaturaService {

    private PlanoDAO planoDAO = new PlanoDAO();
    private ProdutoDAO produtoDAO = new ProdutoDAO();
    private AssinaturaDAO assinaturaDAO = new AssinaturaDAO();
    private CestaDAO cestaDAO = new CestaDAO();
    private ItemCestaDAO itemCestaDAO = new ItemCestaDAO();
    private PagamentoDAO pagamentoDAO = new PagamentoDAO();
    private EnderecoDAO enderecoDAO = new EnderecoDAO();
    private EntregaDAO entregaDAO = new EntregaDAO();
    private TermoDAO termoDAO = new TermoDAO();
    private ConsentimentoDAO consentimentoDAO = new ConsentimentoDAO();

    // ========================================================================
    // cria assinatura completa a partir do dto
    // este e o metodo oficial usado pelo controller
    // ========================================================================
    public Assinatura criarAssinatura(AssinaturaDTO dto, String dataCriacao) throws Exception {

        // valida existencia do plano
        Plano plano = planoDAO.buscarPorId(dto.plano.getIdPlano());
        if (plano == null) {
            throw new Exception("plano inexistente");
        }

        // valida itens
        validarCesta(dto.cesta, plano, dto.itens, produtoDAO.listarTodos());

        // salva cesta
        int idCesta = cestaDAO.salvar(dto.cesta);

        // salva itens da cesta
        for (ItemCesta item : dto.itens) {
            item.setIdCesta(idCesta);
            itemCestaDAO.salvar(item);
        }

        // salva endereco
        int idEndereco = enderecoDAO.salvar(dto.endereco);

        // salva pagamento
        int idPagamento = pagamentoDAO.salvar(dto.pagamento);

        // cria assinatura
        Assinatura assinatura = new Assinatura(
                0,
                dto.assinante,
                plano,
                dto.cesta,
                LocalDate.now().toString(),
                "ATIVA"
        );

        int idAssinatura = assinaturaDAO.salvar(assinatura);

        // salva entrega
        Entrega entrega = new Entrega(
                0,
                idAssinatura,
                idEndereco,
                "pendente",
                LocalDate.now().toString()
        );

        entregaDAO.salvar(entrega);

        // salva termo
        Termo termo = new Termo(
                0,
                idAssinatura,
                "v1",
                LocalDate.now().toString()
        );

        int idTermo = termoDAO.salvar(termo);

        // salva consentimento
        Consentimento c = new Consentimento(
                0,
                idTermo,
                true,
                LocalDate.now().toString()
        );

        consentimentoDAO.salvar(c);

        return assinatura;
    }

    // ========================================================================
    // valida cesta conforme regras do plano
    // ========================================================================
    public void validarCesta(Cesta cesta, Plano plano,
                             List<ItemCesta> itens, List<Produto> todosProdutos) throws Exception {

        int frutas = 0;
        int legumes = 0;
        int verduras = 0;

        Map<Integer, Produto> mapa = new HashMap<>();
        for (Produto p : todosProdutos) mapa.put(p.getIdProduto(), p);

        for (ItemCesta item : itens) {

            Produto p = mapa.get(item.getIdProduto());
            if (p == null) throw new Exception("produto inexistente: " + item.getIdProduto());

            String tipo = p.getTipo().toLowerCase();

            if (tipo.contains("fruta")) frutas++;
            else if (tipo.contains("legume")) legumes++;
            else if (tipo.contains("verdura")) verduras++;
        }

        if (frutas > plano.getQtdFrutasPermitidas())
            throw new Exception("muitas frutas para o plano escolhido");

        if (legumes > plano.getQtdLegumesPermitidos())
            throw new Exception("muitos legumes para o plano escolhido");

        if (verduras > plano.getQtdVerdurasPermitidas())
            throw new Exception("muitas verduras para o plano escolhido");
    }
}
