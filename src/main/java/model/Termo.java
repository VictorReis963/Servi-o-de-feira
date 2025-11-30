package model;

import java.util.Date;

public class Termo {

    private int id;
    private Date creationDateTime;
    private Template template;

    public Termo(int id, Date creationDateTime, Template template) {
        this.id = id;
        this.creationDateTime = creationDateTime;
        this.template = template;
    }

    public int getId() { return id; }
    public Date getCreationDateTime() { return creationDateTime; }
    public Template getTemplate() { return template; }
}
