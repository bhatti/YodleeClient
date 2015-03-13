package com.plexobject.yodlee.domain;

public class StartRefreshRequestResponse extends BaseResponse {
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StartRefreshRequestResponse [status=" + status + "]";
    }
}
