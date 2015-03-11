package com.plexobject.yodlee.domain;

public class AddItemAndStartVerificationResponse {
    public static class RefreshStatus {
        private int status;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "RefreshStatus [status=" + status + "]";
        }

    }

    private Long itemId;
    private RefreshStatus refreshStatus;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public RefreshStatus getRefreshStatus() {
        return refreshStatus;
    }

    public void setRefreshStatus(RefreshStatus refreshStatus) {
        this.refreshStatus = refreshStatus;
    }

    @Override
    public String toString() {
        return "AddItemAndStartVerificationResponse [itemId=" + itemId
                + ", refreshStatus=" + refreshStatus + "]";
    }
}
