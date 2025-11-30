package model;

public class Template {

    private int id;
    private String status;
    private String creationDateTime;
    private String type;

    public Template(int id, String status, String creationDateTime, String type) {
        this.id = id;
        this.status = status;
        this.creationDateTime = creationDateTime;
        this.type = type;
    }

    public boolean isAtivo() {
        return status.equalsIgnoreCase("ATIVO");
    }

    public int getId() { return id; }
    public String getStatus() { return status; }
    public String getCreationDateTime() { return creationDateTime; }
    public String getType() { return type; }
}
