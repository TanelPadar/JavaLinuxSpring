package com.example.padar.model;

public class Log {
    private String id;
    private String endpoint;
    private String method;
    private RequestBody body;
    private RequestBody oldBody;
    private String date;

    public Log(String id, String endpoint, String method, RequestBody body, RequestBody oldBody, String date) {
        this.id = id;
        this.endpoint = endpoint;
        this.method = method;
        this.body = body;
        this.oldBody = oldBody;
        this.date = date;
    }

    public Log() { }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public RequestBody getBody() {
        return body;
    }

    public void setBody(String name, String username, String email) {
        this.body = new RequestBody(name, username, email);
    }

    public RequestBody getOldBody() {
        return oldBody;
    }

    public void setOldBody(String name, String username, String email) {
        this.oldBody = new RequestBody(name, username, email);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void distinctBody() {
        if (this.oldBody.getName().equals(this.body.getName())) {
            this.oldBody.setName(null);
            this.body.setName(null);
        }
        if (this.oldBody.getUsername().equals(this.body.getUsername())) {
            this.oldBody.setUsername(null);
            this.body.setUsername(null);
        }
        if (this.oldBody.getEmail().equals(this.body.getEmail())) {
            this.oldBody.setEmail(null);
            this.body.setEmail(null);
        }
    }
}


class RequestBody {
    private String name;
    private String username;
    private String email;

    public RequestBody(String name, String username, String email) {
        this.name = name;
        this.username = username;
        this.email = email;
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