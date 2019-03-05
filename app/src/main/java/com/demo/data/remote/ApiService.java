package com.demo.data.remote;


import com.demo.data.model.api.LoginRequest;
import com.demo.data.model.api.LoginResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {

    @POST("588d15f5100000a8072d2945/")
    Observable<LoginResponse> getLoggedInUser(@Body LoginRequest.ServerLoginRequest user);
}
