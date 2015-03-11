package com.plexobject.yodlee.api;

import com.plexobject.yodlee.domain.User;
import com.plexobject.yodlee.response.CobrandLoginResponse;
import com.plexobject.yodlee.response.UserLoginResponse;

/**
 * This interface defines primary APIs that Yodlee provides
 * 
 * @author shahzad bhatti
 *
 */
public interface YodleeClient {
    CobrandLoginResponse loginCobrand();

    String registerUser(String session, User user);

    String getRoutingNumbersInfo(String cobSessionToken, String userSessionToken);

    UserLoginResponse loginUser(String session, String username, String password);
}
