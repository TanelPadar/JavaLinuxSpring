package com.example.padar.model;


import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.annotation.CreatedBy;

import java.util.ArrayList;
import java.util.List;

public class User {
    @Schema(example= "1" ,  description = "id", hidden = true)

    private int id;
    @Schema(description = "name", example= "Jaanika")
    private String name;
    @Schema(description = "username",example= "jaanika22")
    private String username;
    @Schema(description = "email" ,example= "Jaanika@hot.ee")
    private String email;



    @Override
    public String toString() {
        return "{\"name\":\"" + name + "\"," +
                "\"username\":\"" + username + "\"," +
                "\"email\":\"" + email + "\"}";
    }

    public User(int id, String name, String username, String email) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;

    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setid(int id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
