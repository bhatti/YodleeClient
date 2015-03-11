package com.plexobject.yodlee.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.plexobject.yodlee.domain.Credentials;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CobrandLoginResponse {
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
