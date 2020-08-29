package com.vidor.entity;

public class User {
    private String host;
    private String user;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "User{" +
                "host='" + host + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
