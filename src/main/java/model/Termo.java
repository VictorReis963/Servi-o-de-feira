package model;

import java.time.LocalDateTime;
public class Termo {
    private int id;
    private int idAssinatura;
    private int templateId;
    private LocalDateTime created;
    public Termo(int id, int idAssinatura, int templateId, LocalDateTime created) {
        this.id = id; this.idAssinatura = idAssinatura; this.templateId = templateId; this.created = created;
    }
    public int getId() { return id; }
    public int getIdAssinatura() { return idAssinatura; }
    public int getTemplateId() { return templateId; }
    public LocalDateTime getCreated() { return created; }
}
