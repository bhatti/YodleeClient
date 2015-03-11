package com.plexobject.yodlee.domain;

import com.plexobject.yodlee.domain.LoginForm.ContainerInfo;

public class ContentServiceInfoResponse {
    private Long contentServiceId;
    private Long serviceId;
    private Long organizationId;
    private String contentServiceDisplayName;
    private String organizationDisplayName;
    private Long siteId;
    private String siteDisplayName;
    private boolean custom;
    private String loginUrl;
    private String homeUrl;
    private String registrationUrl;
    private String passwordHelpUrl;
    private String contactUrl;
    private boolean isCredentialRequired;
    private boolean autoRegistrationSupported;
    private int autoLoginType;
    private boolean autoPayCardSetupSupported;
    private boolean directCardPaymentSupported;
    private boolean directCheckPaymentSupported;
    private boolean autoPayCardCancelSupported;
    private boolean paymentVerificationSupported;
    private boolean hasPaymentHistory;
    private boolean isCSCForDirectPaymRequired;
    private boolean isCSCForAutoPayRequired;
    private String timeZoneId;
    private boolean isFTEnabled;
    private boolean isOnlinePaymentSupported;
    private LoginForm loginForm;
    private ContainerInfo containerInfo;

    public ContainerInfo getContainerInfo() {
        return containerInfo;
    }

    public void setContainerInfo(ContainerInfo containerInfo) {
        this.containerInfo = containerInfo;
    }

    public LoginForm getLoginForm() {
        return loginForm;
    }

    public void setLoginForm(LoginForm loginForm) {
        this.loginForm = loginForm;
    }

    public Long getContentServiceId() {
        return contentServiceId;
    }

    public void setContentServiceId(Long contentServiceId) {
        this.contentServiceId = contentServiceId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getContentServiceDisplayName() {
        return contentServiceDisplayName;
    }

    public void setContentServiceDisplayName(String contentServiceDisplayName) {
        this.contentServiceDisplayName = contentServiceDisplayName;
    }

    public String getOrganizationDisplayName() {
        return organizationDisplayName;
    }

    public void setOrganizationDisplayName(String organizationDisplayName) {
        this.organizationDisplayName = organizationDisplayName;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public String getSiteDisplayName() {
        return siteDisplayName;
    }

    public void setSiteDisplayName(String siteDisplayName) {
        this.siteDisplayName = siteDisplayName;
    }

    public boolean isCustom() {
        return custom;
    }

    public void setCustom(boolean custom) {
        this.custom = custom;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public String getHomeUrl() {
        return homeUrl;
    }

    public void setHomeUrl(String homeUrl) {
        this.homeUrl = homeUrl;
    }

    public String getRegistrationUrl() {
        return registrationUrl;
    }

    public void setRegistrationUrl(String registrationUrl) {
        this.registrationUrl = registrationUrl;
    }

    public String getPasswordHelpUrl() {
        return passwordHelpUrl;
    }

    public void setPasswordHelpUrl(String passwordHelpUrl) {
        this.passwordHelpUrl = passwordHelpUrl;
    }

    public String getContactUrl() {
        return contactUrl;
    }

    public void setContactUrl(String contactUrl) {
        this.contactUrl = contactUrl;
    }

    public boolean isCredentialRequired() {
        return isCredentialRequired;
    }

    public void setCredentialRequired(boolean isCredentialRequired) {
        this.isCredentialRequired = isCredentialRequired;
    }

    public boolean isAutoRegistrationSupported() {
        return autoRegistrationSupported;
    }

    public void setAutoRegistrationSupported(boolean autoRegistrationSupported) {
        this.autoRegistrationSupported = autoRegistrationSupported;
    }

    public int getAutoLoginType() {
        return autoLoginType;
    }

    public void setAutoLoginType(int autoLoginType) {
        this.autoLoginType = autoLoginType;
    }

    public boolean isAutoPayCardSetupSupported() {
        return autoPayCardSetupSupported;
    }

    public void setAutoPayCardSetupSupported(boolean autoPayCardSetupSupported) {
        this.autoPayCardSetupSupported = autoPayCardSetupSupported;
    }

    public boolean isDirectCardPaymentSupported() {
        return directCardPaymentSupported;
    }

    public void setDirectCardPaymentSupported(boolean directCardPaymentSupported) {
        this.directCardPaymentSupported = directCardPaymentSupported;
    }

    public boolean isDirectCheckPaymentSupported() {
        return directCheckPaymentSupported;
    }

    public void setDirectCheckPaymentSupported(
            boolean directCheckPaymentSupported) {
        this.directCheckPaymentSupported = directCheckPaymentSupported;
    }

    public boolean isAutoPayCardCancelSupported() {
        return autoPayCardCancelSupported;
    }

    public void setAutoPayCardCancelSupported(boolean autoPayCardCancelSupported) {
        this.autoPayCardCancelSupported = autoPayCardCancelSupported;
    }

    public boolean isPaymentVerificationSupported() {
        return paymentVerificationSupported;
    }

    public void setPaymentVerificationSupported(
            boolean paymentVerificationSupported) {
        this.paymentVerificationSupported = paymentVerificationSupported;
    }

    public boolean isHasPaymentHistory() {
        return hasPaymentHistory;
    }

    public void setHasPaymentHistory(boolean hasPaymentHistory) {
        this.hasPaymentHistory = hasPaymentHistory;
    }

    public boolean isCSCForDirectPaymRequired() {
        return isCSCForDirectPaymRequired;
    }

    public void setCSCForDirectPaymRequired(boolean isCSCForDirectPaymRequired) {
        this.isCSCForDirectPaymRequired = isCSCForDirectPaymRequired;
    }

    public boolean isCSCForAutoPayRequired() {
        return isCSCForAutoPayRequired;
    }

    public void setCSCForAutoPayRequired(boolean isCSCForAutoPayRequired) {
        this.isCSCForAutoPayRequired = isCSCForAutoPayRequired;
    }

    public String getTimeZoneId() {
        return timeZoneId;
    }

    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
    }

    public boolean isFTEnabled() {
        return isFTEnabled;
    }

    public void setFTEnabled(boolean isFTEnabled) {
        this.isFTEnabled = isFTEnabled;
    }

    public boolean isOnlinePaymentSupported() {
        return isOnlinePaymentSupported;
    }

    public void setOnlinePaymentSupported(boolean isOnlinePaymentSupported) {
        this.isOnlinePaymentSupported = isOnlinePaymentSupported;
    }

    @Override
    public String toString() {
        return "ContentServiceInfoResponse [contentServiceId="
                + contentServiceId + ", serviceId=" + serviceId
                + ", organizationId=" + organizationId
                + ", contentServiceDisplayName=" + contentServiceDisplayName
                + ", organizationDisplayName=" + organizationDisplayName
                + ", siteId=" + siteId + ", siteDisplayName=" + siteDisplayName
                + ", custom=" + custom + ", loginUrl=" + loginUrl
                + ", homeUrl=" + homeUrl + ", registrationUrl="
                + registrationUrl + ", passwordHelpUrl=" + passwordHelpUrl
                + ", contactUrl=" + contactUrl + ", isCredentialRequired="
                + isCredentialRequired + ", autoRegistrationSupported="
                + autoRegistrationSupported + ", autoLoginType="
                + autoLoginType + ", autoPayCardSetupSupported="
                + autoPayCardSetupSupported + ", directCardPaymentSupported="
                + directCardPaymentSupported + ", directCheckPaymentSupported="
                + directCheckPaymentSupported + ", autoPayCardCancelSupported="
                + autoPayCardCancelSupported
                + ", paymentVerificationSupported="
                + paymentVerificationSupported + ", hasPaymentHistory="
                + hasPaymentHistory + ", isCSCForDirectPaymRequired="
                + isCSCForDirectPaymRequired + ", isCSCForAutoPayRequired="
                + isCSCForAutoPayRequired + ", timeZoneId=" + timeZoneId
                + ", isFTEnabled=" + isFTEnabled
                + ", isOnlinePaymentSupported=" + isOnlinePaymentSupported
                + ", loginForm=" + loginForm + ", containerInfo="
                + containerInfo + "]";
    }

}
