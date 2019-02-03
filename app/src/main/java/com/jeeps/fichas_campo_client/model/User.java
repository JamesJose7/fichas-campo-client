package com.jeeps.fichas_campo_client.model;

public class User {
    private String username;
    private String password;

    private static volatile User userInstance;

    private User() {
        if (userInstance != null)
            throw new RuntimeException("Use getInstance() for user creation");
    }

    public static User getInstance() {
        if (userInstance == null) {
            synchronized (User.class) {
                if (userInstance == null) userInstance = new User();
            }
        }
        return userInstance;
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

    // Work when serializing
    protected User readResolve() {
        return getInstance();
    }
}
