package com.plexobject.yodlee.domain;

public class ContentServiceInfoRequest {
    private String cobSessionToken;
    private String userSessionToken;
    private String routingNumber;

    public ContentServiceInfoRequest() {

    }

    public ContentServiceInfoRequest(String cobSessionToken,
            String userSessionToken, String routingNumber) {
        this.cobSessionToken = cobSessionToken;
        this.userSessionToken = userSessionToken;
        this.routingNumber = routingNumber;
    }

    public String getCobSessionToken() {
        return cobSessionToken;
    }

    public void setCobSessionToken(String cobSessionToken) {
        this.cobSessionToken = cobSessionToken;
    }

    public String getUserSessionToken() {
        return userSessionToken;
    }

    public void setUserSessionToken(String userSessionToken) {
        this.userSessionToken = userSessionToken;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }

}
