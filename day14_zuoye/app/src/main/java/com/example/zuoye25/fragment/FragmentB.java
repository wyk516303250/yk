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
import com.example.zuoye25.adapter.RlvAdapter2;
import com.example.zuoye25.bean.DaoBean;
import com.example.zuoye25.util.DbUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 康康 on 2019/6/21.
 */

public class FragmentB extends Fragment implements RlvAdapter2.OnItemClickListener {
    private View view;
    private RecyclerView mRlv1;
    private RlvAdapter2 mAdapter2;
    private ArrayList<DaoBean> mList=new ArrayList<>();

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(getUserVisibleHint()){
            initData();
        }else{
            if(mList!=null&&mList.size()>0){
                mList.clear();
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_b, null, false);
        initView(inflate);
        return inflate;
    }

    private void initData() {
        List<DaoBean> query = DbUtil.getDbUtil().query();
        mList.addAll(query);
        mAdapter2.setList(mList);
        mAdapter2.notifyDataSetChanged();
    }

    private void initView(View inflate) {
        mRlv1 = (RecyclerView) inflate.findViewById(R.id.rlv1);
        mRlv1.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter2  = new RlvAdapter2(mList, getContext());
        mRlv1.setAdapter(mAdapter2);
        mAdapter2.setOnitem(this);
    }

    @Override
    public void onItemClick(View v, int position) {
        DaoBean daoBean = mList.get(position);
        DbUtil.getDbUtil().delete(daoBean);
        mList.remove(daoBean);
        mAdapter2.setList(mList);
        mAdapter2.notifyDataSetChanged();
        Toast.makeText(getContext(), "删除成功", Toast.LENGTH_SHORT).show();
    }
}
