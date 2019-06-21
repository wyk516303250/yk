package com.example.zuoye25.m;

import com.example.zuoye25.api.MyServer;
import com.example.zuoye25.bean.FuliBean;
import com.example.zuoye25.callback.FuliCallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 康康 on 2019/6/21.
 */

public class FuliMyImpModel implements FuliMyModel {
    @Override
    public void getData(final FuliCallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(MyServer.FuliUrl)
                .build();

        MyServer myServer = retrofit.create(MyServer.class);

        Observable<FuliBean> data = myServer.getData();

        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FuliBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FuliBean fuliBean) {
                        callBack.onServer(fuliBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFali(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
