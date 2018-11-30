package com.bw.movie.mvp.model.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.bw.movie.app.Myapp;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpUtils {
    private static HttpUtils ourInstance ;
    public final Api api;

    public static HttpUtils getInstance() {
        Context context = null;

        if (context==null){

            Myapp app = Myapp.getApp();
            context = app.getApplicationContext();
        }
        if (ourInstance == null) {
            synchronized (HttpUtils.class) {
                if (ourInstance == null) {
                    ourInstance = new HttpUtils(context);
                }
            }
        }
        return ourInstance;
    }

    private HttpUtils(final Context context) {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {

                        SharedPreferences user = context.getSharedPreferences("user", Context.MODE_PRIVATE);
                        int userId = user.getInt("userId", 0);
                        String userid = String.valueOf(userId);
                        String sessionId = user.getString("sessionId", "");

                        Log.i("userid", "intercept: userId==="+userid);
                        Log.i("sessionId", "intercept: sessionId==="+sessionId);

                        Request build = chain.request().newBuilder()
                                .addHeader("userId", userid)
                                .addHeader("sessionId", sessionId)
                                .build();

                        return chain.proceed(build);
                    }
                })
                .addNetworkInterceptor(new LogginInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Catans.URL_POST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        api = retrofit.create(Api.class);
    }

    class LogginInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {

           Request request = chain.request();
                    /* .newBuilder()
                    .addHeader("userId","18")
                    .addHeader("sessionId","15320748258726")
                    .build();*/

            long time = System.nanoTime();

            Response response = chain.proceed(request);
            long time1 = System.nanoTime();

            return response;
        }
    }

}
