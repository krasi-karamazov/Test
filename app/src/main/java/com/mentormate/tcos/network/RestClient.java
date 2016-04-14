package com.mentormate.tcos.network;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by krasimir.karamazov on 4/13/2016.
 */
public class RestClient {

    /**
     * This is our main backend/server URL.
     */
    public static final String REST_API_URL = "API URL";


    private static Retrofit s_retrofit;

    static {

        // enable logging
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        s_retrofit = new Retrofit.Builder()
                .baseUrl(REST_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    public static <T> T getService(Class<T> serviceClass) {
        return s_retrofit.create(serviceClass);
    }
}
