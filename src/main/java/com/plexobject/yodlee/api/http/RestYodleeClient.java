package com.plexobject.yodlee.api.http;

import java.util.Arrays;
import java.util.Properties;

import com.plexobject.yodlee.api.YodleeClient;
import com.plexobject.yodlee.domain.AddItemAndStartVerificationResponse;
import com.plexobject.yodlee.domain.CobrandLoginResponse;
import com.plexobject.yodlee.domain.ContentServiceInfoResponse;
import com.plexobject.yodlee.domain.GetItemVerificationDataResponse;
import com.plexobject.yodlee.domain.UserLoginResponse;
import com.plexobject.yodlee.util.Configuration;

public class RestYodleeClient implements YodleeClient {
    private final HttpDelegate httpDelegate;
    private final String cobrandLogin;
    private final String cobrandPassword;

    public RestYodleeClient(Configuration config) {
        this.httpDelegate = new ApacheHttpClientHttpDelegate(config);
        this.cobrandLogin = config.getProperty("cobrandLogin");
        this.cobrandPassword = config.getProperty("cobrandPassword");
    }

    @Override
    public CobrandLoginResponse loginCobrand() {
        final HttpRequest request = new HttpRequest("authenticate/coblogin",
                "cobrandLogin", cobrandLogin, "cobrandPassword",
                cobrandPassword);
        HttpResponseWrapper<CobrandLoginResponse> resp = httpDelegate.doPost(
                request, CobrandLoginResponse.class);
        return resp.getResponseBody();
    }

    @Override
    public UserLoginResponse loginUser(String session, String login,
            String password) {
        final HttpRequest request = new HttpRequest("authenticate/login",
                "cobSessionToken", session, "login", login, "password",
                password);
        HttpResponseWrapper<UserLoginResponse> resp = httpDelegate.doPost(
                request, UserLoginResponse.class);
        return resp.getResponseBody();
    }

    @Override
    public ContentServiceInfoResponse getContentServiceInfoByRoutingNumber(
            String cobSessionToken, String userSessionToken,
            String routingNumber) {
        final HttpRequest request = new HttpRequest(
                "jsonsdk/RoutingNumberService/getContentServiceInfoByRoutingNumber",
                "cobSessionToken", cobSessionToken, "userSessionToken",
                userSessionToken, "notrim", "true", "routingNumber",
                routingNumber);
        HttpResponseWrapper<ContentServiceInfoResponse> resp = httpDelegate
                .doPost(request, ContentServiceInfoResponse.class);
        return resp.getResponseBody();
    }

    @Override
    public AddItemAndStartVerificationResponse addItemAndStartVerificationDataRequest(
            String cobSessionToken, String userSessionToken) {
        final HttpRequest request = new HttpRequest(
                "jsonsdk/ExtendedInstantVerificationDataService/addItemAndStartVerificationDataRequest",
                "cobSessionToken", cobSessionToken, "userSessionToken",
                userSessionToken, "accountNumber", "503-1123001",
                "contentServiceId", "11195", "credentialFields.enclosedType",
                "com.yodlee.common.FieldInfoSingle",
                "credentialFields[0].displayName", "USLoginId",
                "credentialFields[0].fieldType", "TEXT",
                "credentialFields[0].helpText", "22059",
                "credentialFields[0].isEditable", "true",
                "credentialFields[0].maxlength", "40",
                "credentialFields[0].name", "LOGIN",
                "credentialFields[0].size", "20", "credentialFields[0].value",
                "dataservice.bank1", "credentialFields[0].valueIdentifier",
                "LOGIN", "credentialFields[0].valueMask", "LOGIN_FIELD",
                "credentialFields[1].displayName", "USPassword",
                "credentialFields[1].fieldType", "PASSWORD",
                "credentialFields[1].helpText", "22058",
                "credentialFields[1].isEditable", "true",
                "credentialFields[1].maxlength", "40",
                "credentialFields[1].name", "PASSWORD1",
                "credentialFields[1].size", "20", "credentialFields[1].value",
                "bank1", "credentialFields[1].valueIdentifier", "PASSWORD1",
                "credentialFields[1].valueMask", "LOGIN_FIELD",
                "routingNumber", "999999989");
        HttpResponseWrapper<AddItemAndStartVerificationResponse> resp = httpDelegate
                .doPost(request, AddItemAndStartVerificationResponse.class);
        return resp.getResponseBody();
    }

    @Override
    public GetItemVerificationDataResponse[] getItemVerificationData(
            String cobSessionToken, String userSessionToken, Long... itemIds) {
        final HttpRequest request = new HttpRequest(
                "jsonsdk/InstantVerificationDataService/getItemVerificationData",
                "cobSessionToken", cobSessionToken, "userSessionToken",
                userSessionToken, "itemIds[0]", String.valueOf(itemIds[0]));
        HttpResponseWrapper<GetItemVerificationDataResponse[]> resp = httpDelegate
                .doPost(request, GetItemVerificationDataResponse[].class);
        return resp.getResponseBody();
    }

}
