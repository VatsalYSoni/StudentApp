package com.demo.data.remote;



import com.demo.data.model.api.LoginRequest;
import com.demo.data.model.api.LoginResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;


@Singleton
public class AppApiHelper implements ApiHelper {

    private ApiService mApiService;

    @Inject
    public AppApiHelper(ApiService apiService) {
        mApiService = apiService;
    }

    @Override
    public Observable<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request) {
        return mApiService.getLoggedInUser(request);
    }

}
