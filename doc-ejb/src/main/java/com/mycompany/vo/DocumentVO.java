package com.mycompany.vo;

import java.sql.Date;
import java.util.Set;

/**
 * Document service object
 */
public class DocumentVO {
    private Integer id;
    private Integer code;
    private Date date;
    private String name;
    private Set<DocumentItemVO> items;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<DocumentItemVO> getItems() {
        return items;
    }

    public void setItems(Set<DocumentItemVO> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        StringBuilder build = new StringBuilder();
        build.append("Document: ")
                .append("Id = " + id)
                .append("; \n Code = " + code)
                .append("; \n Name = " + name)
                .append("; \n Date = " + date);
        for (DocumentItemVO item: items) {
            build.append(item.toString());
        }
        return build.toString();
    }
}
