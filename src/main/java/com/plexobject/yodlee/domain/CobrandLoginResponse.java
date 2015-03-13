package com.plexobject.yodlee.domain;


public class CobrandLoginResponse extends BaseResponse {
    private Long cobrandId;
    private String applicationId;
    private Credentials cobrandConversationCredentials;

    public Long getCobrandId() {
        return cobrandId;
    }

    public void setCobrandId(Long cobrandId) {
        this.cobrandId = cobrandId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getSessionToken() {
        return cobrandConversationCredentials != null ? cobrandConversationCredentials
                .getSessionToken() : null;
    }

    public Credentials getCobrandConversationCredentials() {
        return cobrandConversationCredentials;
    }

    public void setCobrandConversationCredentials(
            Credentials cobrandConversationCredentials) {
        this.cobrandConversationCredentials = cobrandConversationCredentials;
    }

    @Override
    public String toString() {
        return "LoginResponse [cobrandId=" + cobrandId + ", applicationId="
                + applicationId + ", cobrandConversationCredentials="
                + cobrandConversationCredentials + "]";
    }
}
