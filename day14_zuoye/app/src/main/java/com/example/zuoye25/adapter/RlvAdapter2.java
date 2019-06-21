package com.example.zuoye25.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zuoye25.R;
import com.example.zuoye25.bean.DaoBean;
import com.example.zuoye25.bean.FuliBean;

import java.util.ArrayList;

/**
 * Created by 康康 on 2019/6/21.
 */

public class RlvAdapter2 extends RecyclerView.Adapter {
    private ArrayList<DaoBean> mList;
    private Context mContext;
    private OnItemClickListener onitem1;
    public void setList(ArrayList<DaoBean> list) {
        mList = list;
    }

    public RlvAdapter2(ArrayList<DaoBean> list, Context context) {
        mList = list;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item, null, false);

        return new Viewholder1(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        Viewholder1 viewholder1= (Viewholder1) holder;
        Glide.with(mContext).load(mList.get(position).getUrl()).into(viewholder1.iv);
        viewholder1.tv.setText(mList.get(position).getType());
        viewholder1.tv1.setText(mList.get(position).getDesc());
        viewholder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onitem1!=null){
                    onitem1.onItemClick(v,position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class Viewholder1 extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tv;
        private TextView tv1;
        public Viewholder1(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
            tv1 = itemView.findViewById(R.id.tv1);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(View v, int position);
    }

    public void setOnitem(OnItemClickListener listener){
        this.onitem1=listener;
    }
}
