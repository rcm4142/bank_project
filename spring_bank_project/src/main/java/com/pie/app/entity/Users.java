package com.pie.app.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(nullable = false, unique = true)
    private String username;
    private String password;

    @ManyToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name="user_role",
            joinColumns=@JoinColumn(name="user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="role_id",referencedColumnName = "id")
    )
    private Set<Roles> role;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Roles> getRole() {
        return role;
    }

    public void setRole(Set<Roles> role) {
        this.role = role;
    }

    public Users(Long id, String name, String username, String password, Set<Roles> role) {
        super();
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Users() {}

    @Override
    public String toString() {
        return "Users [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + ", role="
                + role + "]";
    }

}
