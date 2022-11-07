package com.api.app.rest.Models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "userbossdysek")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "`FName`")
    private String firstName;
    @Column(name = "`LName`")
    private String lastName;
    @Column(name = "`UserName`")
    private String userName;
    @Column(name = "`Password`")
    private String password;
    @Column(name = "`Age`")
    private int age;
    @Column(name = "`Occupation`")
    private String occupation;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Post> post;
    public User() {

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
