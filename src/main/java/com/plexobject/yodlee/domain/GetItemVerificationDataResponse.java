package com.plexobject.yodlee.domain;

public class GetItemVerificationDataResponse {
    public static class ItemVerificationInfo {
        private Long itemId;
        private Long contentServiceId;
        private String transactionId;
        private String requestTime;
        private RequestStatus requestStatus;
        private RequestType requestType;
        private boolean completed;
        private int statusCode;
        private String requestedLocale;
        private String derivedLocale;

        public Long getItemId() {
            return itemId;
        }

        public void setItemId(Long itemId) {
            this.itemId = itemId;
        }

        public Long getContentServiceId() {
            return contentServiceId;
        }

        public void setContentServiceId(Long contentServiceId) {
            this.contentServiceId = contentServiceId;
        }

        public String getTransactionId() {
            return transactionId;
        }

        public void setTransactionId(String transactionId) {
            this.transactionId = transactionId;
        }

        public String getRequestTime() {
            return requestTime;
        }

        public void setRequestTime(String requestTime) {
            this.requestTime = requestTime;
        }

        public RequestStatus getRequestStatus() {
            return requestStatus;
        }

        public void setRequestStatus(RequestStatus requestStatus) {
            this.requestStatus = requestStatus;
        }

        public RequestType getRequestType() {
            return requestType;
        }

        public void setRequestType(RequestType requestType) {
            this.requestType = requestType;
        }

        public boolean isCompleted() {
            return completed;
        }

        public void setCompleted(boolean completed) {
            this.completed = completed;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }

        public String getRequestedLocale() {
            return requestedLocale;
        }

        public void setRequestedLocale(String requestedLocale) {
            this.requestedLocale = requestedLocale;
        }

        public String getDerivedLocale() {
            return derivedLocale;
        }

        public void setDerivedLocale(String derivedLocale) {
            this.derivedLocale = derivedLocale;
        }

        @Override
        public String toString() {
            return "ItemVerificationInfo [itemId=" + itemId
                    + ", contentServiceId=" + contentServiceId
                    + ", transactionId=" + transactionId + ", requestTime="
                    + requestTime + ", requestStatus=" + requestStatus
                    + ", requestType=" + requestType + ", completed="
                    + completed + ", statusCode=" + statusCode
                    + ", requestedLocale=" + requestedLocale
                    + ", derivedLocale=" + derivedLocale + "]";
        }
    }

    public static class RequestStatus {
        private String verificationRequestStatus;

        public String getVerificationRequestStatus() {
            return verificationRequestStatus;
        }

        public void setVerificationRequestStatus(
                String verificationRequestStatus) {
            this.verificationRequestStatus = verificationRequestStatus;
        }

        @Override
        public String toString() {
            return "RequestStatus [verificationRequestStatus="
                    + verificationRequestStatus + "]";
        }
    }

    public static class SiteRefreshStatus {
        private int siteRefreshStatusId;
        private String siteRefreshStatus;

        public int getSiteRefreshStatusId() {
            return siteRefreshStatusId;
        }

        public void setSiteRefreshStatusId(int siteRefreshStatusId) {
            this.siteRefreshStatusId = siteRefreshStatusId;
        }

        public String getSiteRefreshStatus() {
            return siteRefreshStatus;
        }

        public void setSiteRefreshStatus(String siteRefreshStatus) {
            this.siteRefreshStatus = siteRefreshStatus;
        }

        @Override
        public String toString() {
            return "SiteRefreshStatus [siteRefreshStatusId="
                    + siteRefreshStatusId + ", siteRefreshStatus="
                    + siteRefreshStatus + "]";
        }
    }

    public static class RequestType {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "RequestType [name=" + name + "]";
        }
    }

    private ItemVerificationInfo itemVerificationInfo;

    public ItemVerificationInfo getItemVerificationInfo() {
        return itemVerificationInfo;
    }

    public void setItemVerificationInfo(
            ItemVerificationInfo itemVerificationInfo) {
        this.itemVerificationInfo = itemVerificationInfo;
    }

    @Override
    public String toString() {
        return "GetItemVerificationDataResponse [itemVerificationInfo="
                + itemVerificationInfo + "]";
    }
}
