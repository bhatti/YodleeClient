package com.plexobject.yodlee.api;

import com.plexobject.yodlee.domain.AddItemAndStartVerificationRequest;
import com.plexobject.yodlee.domain.AddItemAndStartVerificationResponse;
import com.plexobject.yodlee.domain.CobrandLoginResponse;
import com.plexobject.yodlee.domain.ContentServiceInfoResponse;
import com.plexobject.yodlee.domain.GetItemVerificationDataRequest;
import com.plexobject.yodlee.domain.GetItemVerificationDataResponse;
import com.plexobject.yodlee.domain.UserLoginRequest;
import com.plexobject.yodlee.domain.UserLoginResponse;

/**
 * This interface defines primary APIs that Yodlee provides
 * 
 * @author shahzad bhatti
 *
 */
public interface YodleeClient {
    CobrandLoginResponse loginCobrand();

    UserLoginResponse loginUser(UserLoginRequest request);

    ContentServiceInfoResponse getContentServiceInfoByRoutingNumber(
            String cobSessionToken, String userSessionToken,
            String routingNumber);

    AddItemAndStartVerificationResponse addItemAndStartVerificationDataRequest(
            AddItemAndStartVerificationRequest request);

    GetItemVerificationDataResponse[] getItemVerificationData(
            GetItemVerificationDataRequest request);
}
