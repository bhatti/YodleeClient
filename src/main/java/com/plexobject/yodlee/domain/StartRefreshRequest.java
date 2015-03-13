package com.plexobject.yodlee.domain;

public class StartRefreshRequest {
    private String cobSessionToken;
    private String userSessionToken;
    private Long[] itemIds;

    public StartRefreshRequest() {
    }

    public StartRefreshRequest(String cobSessionToken, String userSessionToken,
            Long... itemIds) {
        this.cobSessionToken = cobSessionToken;
        this.userSessionToken = userSessionToken;
        this.itemIds = itemIds;
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

    public Long[] getItemIds() {
        return itemIds;
    }

    public void setItemIds(Long... itemIds) {
        this.itemIds = itemIds;
    }

}
