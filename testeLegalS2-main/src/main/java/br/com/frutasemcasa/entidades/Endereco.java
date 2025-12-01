package br.com.frutasemcasa.entidades;

public class Endereco {
    private String rua;
    private int num;
    private String cidade;
    private String cep;
    private String uf;

    public Endereco(String rua, int num, String cidade, String cep, String uf) {
        this.rua = rua;
        this.num = num;
        this.cidade = cidade;
        this.cep = cep;
        this.uf = uf;
    }

    // Método para validar o endereço (Passo 17 - Sistema armazena e valida)
    public boolean validarEndereco() {
        // Lógica simplificada de validação
        return rua != null && !rua.isEmpty() && cep.length() == 8;
    }
    
    @Override
    public String toString() {
        return rua + ", " + num + " - " + cidade + "/" + uf + " (" + cep + ")";
    }
}