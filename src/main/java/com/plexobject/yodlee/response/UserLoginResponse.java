package com.plexobject.yodlee.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.plexobject.yodlee.domain.Credentials;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserLoginResponse {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class UserContext {
        private Long cobrandId;
        private Credentials conversationCredentials;
        private boolean valid;
        private boolean isPasswordExpired;
        private boolean isConfirmed;
        private String applicationId;
        private Credentials cobrandConversationCredentials;

        public Long getCobrandId() {
            return cobrandId;
        }

        public void setCobrandId(Long cobrandId) {
            this.cobrandId = cobrandId;
        }

        public Credentials getConversationCredentials() {
            return conversationCredentials;
        }

        public void setConversationCredentials(
                Credentials conversationCredentials) {
            this.conversationCredentials = conversationCredentials;
        }

        public boolean isValid() {
            return valid;
        }

        public void setValid(boolean valid) {
            this.valid = valid;
        }

        public boolean isPasswordExpired() {
            return isPasswordExpired;
        }

        public void setPasswordExpired(boolean isPasswordExpired) {
            this.isPasswordExpired = isPasswordExpired;
        }

        public boolean isConfirmed() {
            return isConfirmed;
        }

        public void setConfirmed(boolean isConfirmed) {
            this.isConfirmed = isConfirmed;
        }

        public String getApplicationId() {
            return applicationId;
        }

        public void setApplicationId(String applicationId) {
            this.applicationId = applicationId;
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
            return "UserContext [cobrandId=" + cobrandId
                    + ", conversationCredentials=" + conversationCredentials
                    + ", valid=" + valid + ", isPasswordExpired="
                    + isPasswordExpired + ", isConfirmed=" + isConfirmed
                    + ", applicationId=" + applicationId
                    + ", cobrandConversationCredentials="
                    + cobrandConversationCredentials + "]";
        }

    }

    private Long userId;
    private UserContext userContext;
    private long lastLoginTime;
    private long loginCount;
    private String emailAddress;
    private String loginName;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public UserContext getUserContext() {
        return userContext;
    }

    public void setUserContext(UserContext userContext) {
        this.userContext = userContext;
    }

    public long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public long getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(long loginCount) {
        this.loginCount = loginCount;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getCobrandSessionToken() {
        return userContext != null
                && userContext.cobrandConversationCredentials != null ? userContext.cobrandConversationCredentials
                .getSessionToken() : null;
    }

    public String getUserSessionToken() {
        return userContext != null
                && userContext.conversationCredentials != null ? userContext.conversationCredentials
                .getSessionToken() : null;
    }

    @Override
    public String toString() {
        return "UserLoginResponse [userId=" + userId + ", userContext="
                + userContext + ", lastLoginTime=" + lastLoginTime
                + ", loginCount=" + loginCount + ", emailAddress="
                + emailAddress + ", loginName=" + loginName + "]";
    }
}
