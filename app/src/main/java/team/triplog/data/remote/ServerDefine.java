package team.triplog.data.remote;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class ServerDefine {
    private static String BASE_URL = "https://google.com";

    static Retrofit retrofit = new Retrofit.Builder()
            .client(new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor()).build())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build();
}
