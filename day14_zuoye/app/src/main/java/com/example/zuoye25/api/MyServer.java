package com.example.zuoye25.api;

import com.example.zuoye25.bean.FuliBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by 康康 on 2019/6/21.
 */

public interface MyServer {
    String FuliUrl="https://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/";
    @GET("1")
    Observable<FuliBean> getData();
}
