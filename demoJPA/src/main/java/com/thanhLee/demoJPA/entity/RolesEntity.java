package com.thanhLee.demoJPA.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name="roles")
public class RolesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @Column(name ="name")
    private String name ;
    @Column(name ="description")
    private String description ;

    @OneToMany(mappedBy = "roles")
    Set<UsersEntity> users ;
    public int getId() {
        return id;
    }

    public Set<UsersEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<UsersEntity> users) {
        this.users = users;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
