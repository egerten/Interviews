package com.falcon.example.dockerspring.model;


import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {
    private String id;
    private String name;
    private Long categoryNo;

    public Product(String id) {
        this.id = id;
    }

    public Product(String id, String name, Long categoryNo) {
        this.id = id;
        this.name = name;
        this.categoryNo = categoryNo;
    }

    public Product() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getCategoryNo() {
        return categoryNo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategoryNo(Long categoryNo) {
        this.categoryNo = categoryNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(getId(), product.getId()) &&
                Objects.equals(getName(), product.getName()) &&
                Objects.equals(getCategoryNo(), product.getCategoryNo());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getName(), getCategoryNo());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", categoryNo=" + categoryNo +
                '}';
    }
}
