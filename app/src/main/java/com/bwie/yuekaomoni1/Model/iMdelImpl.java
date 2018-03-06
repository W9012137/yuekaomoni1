package com.bwie.yuekaomoni1.Model;

import com.bwie.yuekaomoni1.Bean.AddBena;
import com.bwie.yuekaomoni1.Bean.GoodBean;
import com.bwie.yuekaomoni1.Bean.LunBoBean;
import com.bwie.yuekaomoni1.Bean.ShowCartBean;
import com.bwie.yuekaomoni1.Bean.XiangQingBean;
import com.bwie.yuekaomoni1.NetUtils.Constants;
import com.bwie.yuekaomoni1.NetUtils.RetrofitUtils;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dell on 2018/3/3.
 */

public class iMdelImpl implements iModel {
    @Override
    public void LunboData(final LoadListener loadListener) {
        RetrofitUtils.getInstence()
                .API()
                .LunboRetrofit()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LunBoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LunBoBean value) {
                        loadListener.Success(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        loadListener.Error(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void GoodData(Map<String, String> map, final LoadListener2 loadListener2) {
        RetrofitUtils.getInstence()
                .API()
                .GoodRetrofit(Constants.Good_url, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GoodBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GoodBean value) {
                        loadListener2.Success(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        loadListener2.Error(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void XiangQingData(Map<String, String> map, final LoadListener3 loadListener3) {
        RetrofitUtils.getInstence()
                .API()
                .XiangRetrofit(Constants.Xiang_url, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<XiangQingBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(XiangQingBean value) {
                        loadListener3.Success(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        loadListener3.Error(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void AddCart(Map<String, String> map, final LoadListener4 loadListener4) {
        RetrofitUtils.getInstence()
                .API()
                .AddRetrofit(Constants.Add_url, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AddBena>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AddBena value) {
                        loadListener4.Success(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        loadListener4.Error(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void ShowCart(Map<String, String> map, final LoadListener5 loadListener5) {
        RetrofitUtils.getInstence()
                .API()
                .ShowRetrofit(Constants.Show_url, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShowCartBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShowCartBean value) {
                        loadListener5.Success(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        loadListener5.Error(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void ShuaCart(Map<String, String> map, final LoadListener5 loadListener5) {
        RetrofitUtils.getInstence()
                .API()
                .ShowRetrofit(Constants.Shua_url, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ShowCartBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ShowCartBean value) {
                        loadListener5.Success(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        loadListener5.Error(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
