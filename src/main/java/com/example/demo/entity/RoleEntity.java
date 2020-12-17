package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "role")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String role;
    @ManyToMany(fetch  = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user",
            joinColumns = {@JoinColumn(name = "userRole")},
            inverseJoinColumns = {@JoinColumn(name = "id")})
    List<UserEntity> userEntities;

    public RoleEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<UserEntity> getUserEntities() {
        return userEntities;
    }

    public void setUserEntities(List<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }
}
