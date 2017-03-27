package com.mycompany.vo;

import java.math.BigDecimal;

/**
 * Document service object
 */
public class DocumentItemVO {
    private Integer id;
    private String name;
    private BigDecimal price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder build = new StringBuilder();
        build.append("   Item: ")
                .append("Id = " + id)
                .append("; \n Name = " + name)
                .append("; \n Price = " + price);
        return build.toString();
    }
}
