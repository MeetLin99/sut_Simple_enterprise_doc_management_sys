package model;

import java.util.Date;

//一般里面存的是实体类的模型,后台从数据库取了数据转化为前端需要的数据直接传给前端
public class DocumentInfo {
    private Integer id;
public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    private String name;
public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    private String content;
public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    private String documentCategory;
public String getDocumentCategory() {
        return documentCategory;
    }
    public void setDocumentCategory(String documentCategory) {
        this.documentCategory = documentCategory;
    }
}