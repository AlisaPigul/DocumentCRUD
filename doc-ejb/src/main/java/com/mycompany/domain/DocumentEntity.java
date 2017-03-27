package com.mycompany.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

/**
 * Document entity
 */
@Entity
@Table(name = "document")
public class DocumentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "code")
    private Integer code;

    @Column(name = "date")
    private Date date;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL, mappedBy = "document", orphanRemoval=true)
    private Set<DocumentItemEntity> items;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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

    public Set<DocumentItemEntity> getItems() {
        return items;
    }

    public void setItems(Set<DocumentItemEntity> items) {
        this.items = items;
    }
}
