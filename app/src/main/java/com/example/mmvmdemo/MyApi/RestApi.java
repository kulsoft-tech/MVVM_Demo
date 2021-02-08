package com.example.mmvmdemo.MyApi;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RestApi {

    @FormUrlEncoded
    @POST("send_login_otp.php")
    Call<ResponseBody> login(@Field("mobile_number") String username,
                             @Field("password") String password);

}
