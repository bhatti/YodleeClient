package com.plexobject.yodlee.api.http;

import java.util.HashMap;
import java.util.Map;

import com.plexobject.yodlee.api.YodleeClient;
import com.plexobject.yodlee.domain.AddItemAndStartVerificationRequest;
import com.plexobject.yodlee.domain.AddItemAndStartVerificationResponse;
import com.plexobject.yodlee.domain.CobrandLoginResponse;
import com.plexobject.yodlee.domain.ContentServiceInfoResponse;
import com.plexobject.yodlee.domain.FormField;
import com.plexobject.yodlee.domain.GetItemVerificationDataRequest;
import com.plexobject.yodlee.domain.GetItemVerificationDataResponse;
import com.plexobject.yodlee.domain.UserLoginRequest;
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
    public UserLoginResponse loginUser(UserLoginRequest request) {
        final HttpRequest httpRequest = new HttpRequest("authenticate/login",
                "cobSessionToken", request.getCobSessionToken(), "login",
                request.getUsername(), "password", request.getPassword());
        HttpResponseWrapper<UserLoginResponse> resp = httpDelegate.doPost(
                httpRequest, UserLoginResponse.class);
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
            AddItemAndStartVerificationRequest request) {
        final Map<String, String> params = new HashMap<>();
        params.put("cobSessionToken", request.getCobSessionToken());
        params.put("userSessionToken", request.getUserSessionToken());
        params.put("accountNumber", request.getAccountNumber());
        params.put("contentServiceId",
                String.valueOf(request.getContentServiceId()));
        params.put("credentialFields.enclosedType",
                "com.yodlee.common.FieldInfoSingle");
        int i = 0;
        for (FormField field : request.getFields()) {
            params.put("credentialFields[" + i + "].name", field.getName());
            params.put("credentialFields[" + i + "].displayName",
                    field.getDisplayName());
            params.put("credentialFields[" + i + "].fieldType", field
                    .getFieldType().getTypeName());
            params.put("credentialFields[" + i + "].helpText",
                    field.getHelpText());
            params.put("credentialFields[" + i + "].isEditable",
                    String.valueOf(field.isEditable()));
            params.put("credentialFields[" + i + "].maxlength",
                    String.valueOf(field.getMaxlength()));
            params.put("credentialFields[" + i + "].size",
                    String.valueOf(field.getSize()));
            params.put("credentialFields[" + i + "].value", field.getValue());
            params.put("credentialFields[" + i + "].valueIdentifier",
                    field.getValueIdentifier());
            params.put("credentialFields[" + i + "].valueMask",
                    field.getValueMask());
            i++;
        }
        final HttpRequest httpRequest = new HttpRequest(
                "jsonsdk/ExtendedInstantVerificationDataService/addItemAndStartVerificationDataRequest",
                0, params);
        HttpResponseWrapper<AddItemAndStartVerificationResponse> resp = httpDelegate
                .doPost(httpRequest, AddItemAndStartVerificationResponse.class);
        return resp.getResponseBody();
    }

    @Override
    public GetItemVerificationDataResponse[] getItemVerificationData(
            GetItemVerificationDataRequest request) {
        final HttpRequest httpRequest = new HttpRequest(
                "jsonsdk/InstantVerificationDataService/getItemVerificationData",
                "cobSessionToken", request.getCobSessionToken(),
                "userSessionToken", request.getUserSessionToken(),
                "itemIds[0]", String.valueOf(request.getItemIds()[0]));
        HttpResponseWrapper<GetItemVerificationDataResponse[]> resp = httpDelegate
                .doPost(httpRequest, GetItemVerificationDataResponse[].class);
        return resp.getResponseBody();
    }

}
