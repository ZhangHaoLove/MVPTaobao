package com.example.mr_zhang.projecrttaobao.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mr_zhang.projecrttaobao.Adapter.ShopAdapter.InfoShopping;
import com.example.mr_zhang.projecrttaobao.Bean.ListBean;
import com.example.mr_zhang.projecrttaobao.R;

import java.util.ArrayList;

/**
 * Created by Mr_Zhang on 2017/9/14.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private InfoShopping shopping;
    private ArrayList<ListBean.GoodsListBean> list_bean;
    public void setOncliker(InfoShopping shopping){
        this.shopping=shopping;
    }
    public MyAdapter(Context context, ArrayList<ListBean.GoodsListBean> list_bean) {
        this.context = context;
        this.list_bean = list_bean;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.recycle_demo_jz, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(context).load(list_bean.get(position).getImage()).into(holder.img);
        holder.longname.setText(list_bean.get(position).getLongName());
        holder.price.setText(list_bean.get(position).getMinSalePrice()+"");
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shopping.sendMessage(list_bean.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list_bean.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView img;
        public TextView longname;
        public TextView price;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img = (ImageView) rootView.findViewById(R.id.img);
            this.longname = (TextView) rootView.findViewById(R.id.longname);
            this.price = (TextView) rootView.findViewById(R.id.price);
        }

    }
}
