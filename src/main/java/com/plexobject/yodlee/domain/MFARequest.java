package com.plexobject.yodlee.domain;

public class MFARequest {
    private String cobSessionToken;
    private String userSessionToken;
    private Long itemId;

    public MFARequest() {

    }

    public MFARequest(String cobSessionToken, String userSessionToken,
            Long itemId) {
        this.cobSessionToken = cobSessionToken;
        this.userSessionToken = userSessionToken;
        this.itemId = itemId;
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

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

}
