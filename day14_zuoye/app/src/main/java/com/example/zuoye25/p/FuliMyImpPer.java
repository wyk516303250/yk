package com.example.zuoye25.p;

import com.example.zuoye25.bean.FuliBean;
import com.example.zuoye25.callback.FuliCallBack;
import com.example.zuoye25.m.FuliMyModel;
import com.example.zuoye25.v.FuliView;

/**
 * Created by 康康 on 2019/6/21.
 */

public class FuliMyImpPer implements FuliMyPer, FuliCallBack {
    private FuliMyModel mFuliMyModel;
    private FuliView mFuliView;

    public FuliMyImpPer(FuliMyModel fuliMyModel, FuliView fuliView) {
        mFuliMyModel = fuliMyModel;
        mFuliView = fuliView;
    }

    @Override
    public void getData() {
        if(mFuliMyModel!=null){
            mFuliMyModel.getData(this);
        }
    }

    @Override
    public void onServer(FuliBean fuliBean) {
        if(mFuliView!=null){
            mFuliView.onServer(fuliBean);
        }
    }

    @Override
    public void onFali(String s) {
        if(mFuliView!=null){
            mFuliView.onFali(s);
        }
    }
}
