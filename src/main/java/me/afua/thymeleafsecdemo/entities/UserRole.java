package me.afua.thymeleafsecdemo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Set;

@Entity
public class UserRole {
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole() {
    }

    public UserRole(String role) {
        this.role=role;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;


    private String email;

    //Can only have one role or use @Unique mean the sting shouldnt be replicated inside database in any other row
    @Column(unique=true)
    private String role;

    //Telling you what its is mapped by looked in the entity of this type USERDATE and find the table to get the
    @ManyToMany(mappedBy = "roles",fetch=FetchType.LAZY)
    private Set<UserData> users;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<UserData> getUsers() {
        return users;
    }

    public void setUsers(Set<UserData> users) {
        this.users = users;
    }


}