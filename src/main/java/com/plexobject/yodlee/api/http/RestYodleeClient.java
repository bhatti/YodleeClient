package com.plexobject.yodlee.api.http;

import java.util.Properties;

import com.plexobject.yodlee.api.YodleeClient;
import com.plexobject.yodlee.domain.User;
import com.plexobject.yodlee.response.CobrandLoginResponse;
import com.plexobject.yodlee.response.UserLoginResponse;
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
    public String getRoutingNumbersInfo(String cobSessionToken,
            String userSessionToken) {
        final HttpRequest request = new HttpRequest(
                "jsonsdk/RTNDiscoveryService/getRoutingNumbersInfo",
                "cobSessionToken", cobSessionToken, "userSessionToken",
                userSessionToken, "searchFilter.name", "NORTHWEST PLUS CU",
                "searchFilter.abbreviatedName", "NORTHWEST PLUS CU",
                "searchFilter.stateDet.stateName", "WASHINGTON",
                "searchFilter.stateDet.abbreviation", "WA",
                "searchFilter.city", "TULALIP");
        HttpResponseWrapper<String> resp = httpDelegate.doPost(request,
                String.class);
        return resp.getResponseBody();
    }

    @Override
    public String registerUser(String session, User user) {
        final HttpRequest request = new HttpRequest(
                "jsonsdk/UserRegistration/register3", "cobSessionToken",
                session, "userProfile.objectInstanceType",
                "com.yodlee.core.usermanagement.UserProfile_US",
                "userCredentials.objectInstanceType",
                "com.yodlee.ext.login.PasswordCredentials",
                "userPreferences[0]", "PREFERRED_CURRENCY~USD",
                "userPreferences[1]", "PREFERRED_DATE_FORMAT~MM/dd/yyyy",
                "userCredentials.loginName", user.getLoginName(),
                "userCredentials.password", user.getPassword(),
                "userProfile.address1", user.getAddress1(),
                "userProfile.address2", user.getAddress2(), "userProfile.city",
                user.getCity(), "userProfile.emailAddress",
                user.getEmailAddress(), "userProfile.firstName",
                user.getFirstName(), "userProfile.lastName",
                user.getLastName(), "userProfile.middleInitial",
                user.getMiddleInitial());
        HttpResponseWrapper<String> resp = httpDelegate.doPost(request,
                String.class);
        return resp.getResponseBody();
    }

}
