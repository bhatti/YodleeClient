package com.plexobject.yodlee.domain;

import java.util.Arrays;
import java.util.List;

public class AddItemAndStartVerificationRequest {
    private Long contentServiceId;
    private String cobSessionToken;
    private String userSessionToken;
    private String routingNumber;
    private String accountNumber;
    private List<FormField> fields;

    public AddItemAndStartVerificationRequest() {
    }

    public AddItemAndStartVerificationRequest(String cobSessionToken,
            String userSessionToken, Long contentServiceId,
            String routingNumber, String accountNumber, FormField... fields) {
        this(cobSessionToken, userSessionToken, contentServiceId,
                routingNumber, accountNumber, Arrays.asList(fields));
    }

    public AddItemAndStartVerificationRequest(String cobSessionToken,
            String userSessionToken, Long contentServiceId,
            String routingNumber, String accountNumber, List<FormField> fields) {
        this.cobSessionToken = cobSessionToken;
        this.userSessionToken = userSessionToken;
        this.contentServiceId = contentServiceId;
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
        this.fields = fields;
    }

    public Long getContentServiceId() {
        return contentServiceId;
    }

    public void setContentServiceId(Long contentServiceId) {
        this.contentServiceId = contentServiceId;
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public List<FormField> getFields() {
        return fields;
    }

    public void setFields(List<FormField> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "AddItemAndStartVerificationRequest [contentServiceId="
                + contentServiceId + ", cobSessionToken=" + cobSessionToken
                + ", userSessionToken=" + userSessionToken + ", routingNumber="
                + routingNumber + ", accountNumber=" + accountNumber
                + ", fields=" + fields + "]";
    }
}
