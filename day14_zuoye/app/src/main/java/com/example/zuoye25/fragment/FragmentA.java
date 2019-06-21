package com.example.zuoye25.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.zuoye25.R;
import com.example.zuoye25.adapter.RlvAdapter1;
import com.example.zuoye25.bean.DaoBean;
import com.example.zuoye25.bean.FuliBean;
import com.example.zuoye25.m.FuliMyImpModel;
import com.example.zuoye25.p.FuliMyImpPer;
import com.example.zuoye25.util.DbUtil;
import com.example.zuoye25.v.FuliView;

import java.util.ArrayList;

/**
 * Created by 康康 on 2019/6/21.
 */

public class FragmentA extends Fragment implements FuliView, RlvAdapter1.OnItemLongClickListener {
    private View view;
    private RecyclerView mRlv;
    private RlvAdapter1 mAdapter1;
    private ArrayList<FuliBean.ResultsBean> mList=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_a, null, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        FuliMyImpPer fuliMyImpPer = new FuliMyImpPer(new FuliMyImpModel(), this);
        fuliMyImpPer.getData();
    }

    private void initView(View inflate) {
        mRlv = (RecyclerView) inflate.findViewById(R.id.rlv);
        mRlv.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter1  = new RlvAdapter1(mList, getContext());
        mRlv.setAdapter(mAdapter1);
    }

    @Override
    public void onServer(FuliBean fuliBean) {
        mList.addAll(fuliBean.getResults());
        mAdapter1.setList(mList);
        mAdapter1.notifyDataSetChanged();

        mAdapter1.setOnitem(this);
    }

    @Override
    public void onFali(String s) {
        Toast.makeText(getContext(), "失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemLongClick(View v, int position) {
        FuliBean.ResultsBean resultsBean = mList.get(position);
        DaoBean daoBean = new DaoBean();
        daoBean.setUrl(resultsBean.getUrl());
        daoBean.setType(resultsBean.getType());
        daoBean.setDesc(resultsBean.getDesc());
        DbUtil.getDbUtil().insert(daoBean);
        Toast.makeText(getContext(), "成功", Toast.LENGTH_SHORT).show();
    }
}
