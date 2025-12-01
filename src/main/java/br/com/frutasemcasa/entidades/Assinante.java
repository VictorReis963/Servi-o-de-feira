package br.com.frutasemcasa.entidades;

public class Assinante {
    private String nome;
    private String celular; // Passo 1: O Assinante informa seu número de celular
    private String email;
    private boolean statusValidado;

    public Assinante(String nome, String celular, String email) {
        this.nome = nome;
        this.celular = celular;
        this.email = email;
        this.statusValidado = false;
    }

    // Simula a validação por SMS (Passos 2, 3, 4)
    public boolean validarCodigoSMS(String codigoInformado) {
        // Lógica simplificada: Assume que o código é "1234"
        if ("1234".equals(codigoInformado)) {
            this.statusValidado = true;
            return true;
        }
        return false;
    }

    public String getDados() {
        return "Nome: " + nome + ", Celular: " + celular;
    }
    
    // Getters
    public String getNome() { return nome; }
    public String getCelular() { return celular; }
    public boolean isStatusValidado() { return statusValidado; }
}