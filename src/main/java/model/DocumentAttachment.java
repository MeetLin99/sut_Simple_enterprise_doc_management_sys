package model;

import java.util.Date;

public class DocumentAttachment {
    private Integer id;
public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }//Integer的默认值为null
    private String name;
public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private String path;
public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    private Integer size;
public Integer getSize() {
        return size;
    }
    public void setSize(Integer size) {
        this.size = size;
    }
    private Integer documentId;
public Integer getDocumentId() {
        return documentId;
    }
    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }
}