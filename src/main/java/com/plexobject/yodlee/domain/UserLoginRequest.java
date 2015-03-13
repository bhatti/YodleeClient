package com.plexobject.yodlee.domain;

public class UserLoginRequest {
    private String cobSessionToken;
    private String username;
    private String password;

    public UserLoginRequest() {

    }

    public UserLoginRequest(String cobSessionToken, String username,
            String password) {
        this.cobSessionToken = cobSessionToken;
        this.username = username;
        this.password = password;
    }

    public String getCobSessionToken() {
        return cobSessionToken;
    }

    public void setCobSessionToken(String cobSessionToken) {
        this.cobSessionToken = cobSessionToken;
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
}
