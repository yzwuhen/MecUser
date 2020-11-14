package com.example.mechanicalapp.ui.mvp.api;

import android.util.Log;

import com.example.mechanicalapp.App;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseApi<T> {

    private static final int CACHE_SIZE = 10 * 1024 * 1024;
    private static final String CACHE_DIR = "_recommend";


    protected T service;
    private Class<T> clazz;

    BaseApi(Class<T> clazz) {
        this.clazz = clazz;
        initRequestClient();
    }

    private void initRequestClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .client(client())
                .baseUrl(baseUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        service = retrofit.create(clazz);
    }

    protected Cache cache() {
        File file = new File(App.getInstance().getApplicationContext().getCacheDir(), CACHE_DIR);
        return new Cache(file, CACHE_SIZE);
    }

    protected abstract OkHttpClient client();

    protected abstract String baseUrl();

    public abstract T getService();

    protected HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
        @Override
        public void log(String message) {
            //if (BuildConfig.DEBUG)
                Log.i("OKHttp-----", message);
        }
    });
}
