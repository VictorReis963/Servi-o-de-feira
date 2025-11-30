package model;

public class Consentimento {

    private int id;
    private String data;
    private String status;

    public Consentimento(int id, String data, String status) {
        this.id = id;
        this.data = data;
        this.status = status;
    }

    public int getId() { return id; }
    public String getData() { return data; }
    public String getStatus() { return status; }
}
