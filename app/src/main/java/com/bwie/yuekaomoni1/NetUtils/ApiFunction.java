package com.bwie.yuekaomoni1.NetUtils;

import com.bwie.yuekaomoni1.Bean.AddBena;
import com.bwie.yuekaomoni1.Bean.GoodBean;
import com.bwie.yuekaomoni1.Bean.LunBoBean;
import com.bwie.yuekaomoni1.Bean.ShowCartBean;
import com.bwie.yuekaomoni1.Bean.XiangQingBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by dell on 2018/3/3.
 */

public interface ApiFunction {
    @GET("ad/getAd")
    Observable<LunBoBean> LunboRetrofit();
    @POST
    @FormUrlEncoded
    Observable<GoodBean>  GoodRetrofit(@Url String url, @FieldMap Map<String,String> map);
    @POST
    @FormUrlEncoded
    Observable<XiangQingBean>  XiangRetrofit(@Url String url, @FieldMap Map<String,String> map);
    @POST
    @FormUrlEncoded
    Observable<AddBena>  AddRetrofit(@Url String url, @FieldMap Map<String,String> map);
    @POST
    @FormUrlEncoded
    Observable<ShowCartBean>  ShowRetrofit(@Url String url, @FieldMap Map<String,String> map);
}
