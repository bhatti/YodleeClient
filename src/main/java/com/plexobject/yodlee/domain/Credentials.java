package com.plexobject.yodlee.domain;


public class Credentials {
    private String sessionToken;

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    @Override
    public String toString() {
        return "Credentials [sessionToken=" + sessionToken + "]";
    }
}
