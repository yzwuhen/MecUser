package com.example.mechanicalapp.ui.mvp.api;

import android.util.Log;

import com.example.mechanicalapp.config.Configs;
import com.example.mechanicalapp.ui.mvp.apps.AppService;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;

public class AppsApi extends BaseApi<AppService> {
    private static final long DEFAULT_TIME_OUT = 10;

    public AppsApi() {
        super(AppService.class);
    }

    @Override
    protected OkHttpClient client() {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);

        OkHttpClient client = new OkHttpClient.Builder()
               .addInterceptor(new LogInterceptor())
                .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS) //连接超时
                .writeTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)   //写入超时
                .readTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)  //读取超时
                .build();

        return client;
    }

    @Override
    protected String baseUrl() {
        return Configs.BASE_URL;
    }

    @Override
    public AppService getService() {
        return service;
    }


    /*
     * 拦截武器
     * */
    public static class LogInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            String TAG = "NetQuest";
            long t1 = System.nanoTime();
            Request request = chain.request();
            Response response = chain.proceed(request);
            String param = "post".equalsIgnoreCase(request.method()) ? "---REQ：" + "\n" + "       " + bodyToString(request) + "\n" : "";
            String bodyString = response.body().string();
            String beautyPrint;
            long t2 = System.nanoTime();
            if (bodyString.startsWith("{") || bodyString.startsWith("[")) {
                beautyPrint = "--------------REQUEST START------------" + "\n"
                        + String.format("---URL：%s %s in %.1fms", request.url(), request.method(), (t2 - t1) / 1e6d) + "\n"
                        +param
                        + String.format("---RES：%s %d %s", response.protocol().toString(), response.code(), response.message()) + "\n";
                Log.v(TAG, beautyPrint);
                Log.v(TAG,beautyPrint);
                Log.v(TAG,bodyString);
                Log.v(TAG, "--------------REQUEST END--------------");
            } else {
                beautyPrint = "--------------REQUEST START------------" + "\n"
                        + String.format("---URL：%s %s in %.1fms", request.url(), request.method(), (t2 - t1) / 1e6d) + "\n"
                        +param
                        + String.format("---RES：%s %d %s", response.protocol().toString(), response.code(), response.message()) + "\n"
                        + bodyString + "\n"
                        + "--------------REQUEST END--------------";
                Log.v(TAG,beautyPrint);
                Log.v(TAG, beautyPrint);
            }
          //  Log.v("sssss","sssssssss"+bodyString);
            return response.newBuilder()
                    .body(ResponseBody.create(response.body().contentType(), bodyString))
                    .build();
        }
    }
    public static String bodyToString(Request request) {
        try {
            final Request copy = request.newBuilder().build();
            final Buffer buffer = new Buffer();
            copy.body().writeTo(buffer);
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }

}
