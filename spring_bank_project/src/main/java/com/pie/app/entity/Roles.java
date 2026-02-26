package com.pie.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name="roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Roles(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    public Roles() {}
    @Override
    public String toString() {
        return "Roles [id=" + id + ", name=" + name + "]";
    }

}
