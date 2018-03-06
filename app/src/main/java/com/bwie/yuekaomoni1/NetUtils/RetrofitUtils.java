package com.bwie.yuekaomoni1.NetUtils;

import android.os.Environment;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dell on 2018/3/3.
 */

public class RetrofitUtils {
    private static RetrofitUtils retrofitUtils;//工具类对象
    private static ApiFunction apiFunction;//请求网络接口
    public static OkHttpClient okHttpClient;

    //静态快,获取OkHttpClient对象
    static {
        getOkHttpClient();
    }

    //单例锁模式
    public static RetrofitUtils getInstence(){
        if(retrofitUtils==null){
            synchronized (RetrofitUtils.class){
                if (retrofitUtils==null){
                    retrofitUtils=new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }
    //单例模式获取okhttp
    public static OkHttpClient getOkHttpClient(){
        if(okHttpClient==null){
            synchronized (OkHttpClient.class){
                if(okHttpClient==null){
                    File fileDir = new File(Environment.getExternalStorageDirectory(), "cache");
                    long fileSize = 10 * 1024 * 1024;
                    okHttpClient=new OkHttpClient.Builder()
                            //打印拦截器日志
                            .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                            .connectTimeout(15, TimeUnit.SECONDS)//设置连接超时时间
                            .readTimeout(15, TimeUnit.SECONDS)//设置读取超时时间
                            .writeTimeout(15, TimeUnit.SECONDS)//设置写入超时时间
                            //.cache(new Cache(fileDir,fileSize))//写入sd卡
                            .build();
                }
            }
        }
        return okHttpClient;
    }
    //私有的无参构造
    private RetrofitUtils(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Constants.Base_url)
                .addConverterFactory(GsonConverterFactory.create())//添加gson转换器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//添加rxjava转换器
                .client(okHttpClient)//添加okhttp
                .build();
        apiFunction=retrofit.create(ApiFunction.class);
    }

    //获取
    public  ApiFunction API(){
        return apiFunction;
    }
}


