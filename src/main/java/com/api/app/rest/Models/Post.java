package com.api.app.rest.Models;

import javax.persistence.*;
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private long user_id;
    @Column
    private String description;


    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id",insertable = false, updatable = false)
    private User user;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
}





