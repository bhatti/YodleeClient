package com.plexobject.yodlee.api;

import com.plexobject.yodlee.domain.AddItemAndStartVerificationResponse;
import com.plexobject.yodlee.domain.CobrandLoginResponse;
import com.plexobject.yodlee.domain.ContentServiceInfoResponse;
import com.plexobject.yodlee.domain.GetItemVerificationDataResponse;
import com.plexobject.yodlee.domain.UserLoginResponse;

/**
 * This interface defines primary APIs that Yodlee provides
 * 
 * @author shahzad bhatti
 *
 */
public interface YodleeClient {
    CobrandLoginResponse loginCobrand();

    UserLoginResponse loginUser(String session, String username, String password);

    ContentServiceInfoResponse getContentServiceInfoByRoutingNumber(
            String cobSessionToken, String userSessionToken,
            String routingNumber);

    AddItemAndStartVerificationResponse addItemAndStartVerificationDataRequest(
            String cobSessionToken, String userSessionToken);

    GetItemVerificationDataResponse[] getItemVerificationData(
            String cobSessionToken, String userSessionToken, Long... itemIds);
}
