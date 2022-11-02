package com.example.ecnuprevention.webservice;

import com.example.ecnuprevention.MyApplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    private static volatile Retrofit retrofit;
    private static final Properties properties = new Properties();
    static {
        try {
        InputStream is = MyApplication.getGlobalContext()
                .getAssets().open("webservice.properties");
        properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Retrofit getRetrofit() {
        if(retrofit == null) {
            synchronized (RetrofitManager.class) {
                if(retrofit == null) {
                    //初始化一个OkHttpClient
                    OkHttpClient.Builder builder = new OkHttpClient.Builder()
                            .connectTimeout(Long.parseLong(properties.getProperty("connectTimeout")), TimeUnit.MILLISECONDS)
                            .readTimeout(Long.parseLong(properties.getProperty("readTimeout")), TimeUnit.MILLISECONDS)
                            .writeTimeout(Long.parseLong(properties.getProperty("writeTimeout")), TimeUnit.MILLISECONDS);
                    builder.addInterceptor(new AuthenticationInterceptor());
                    OkHttpClient okHttpClient = builder.build();

                    //使用该OkHttpClient创建一个Retrofit对象
                    retrofit = new Retrofit.Builder()
                            //添加Gson数据格式转换器支持
                            .addConverterFactory(GsonConverterFactory.create())
                            //指定网络请求client
                            .client(okHttpClient)
                            .baseUrl(properties.getProperty("baseUrl"))
                            .build();
                }
            }
        }
        return retrofit;
    }
}
