package com.demo.data.remote;


import com.demo.data.model.api.LoginRequest;
import com.demo.data.model.api.LoginResponse;

import io.reactivex.Observable;



public interface ApiHelper {

//    Observable<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest request);

//    Observable<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest request);

//    Observable<LogoutResponse> doLogoutApiCall();

    Observable<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request);

//    Observable<RegistrationResponse> doServerRegistrationApiCall(RegistrationRequest.ServerRegistrationRequest request);
}
