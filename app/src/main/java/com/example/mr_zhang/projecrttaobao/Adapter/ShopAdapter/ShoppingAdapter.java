package com.example.mr_zhang.projecrttaobao.Adapter.ShopAdapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mr_zhang.projecrttaobao.Bean.ListBean;
import com.example.mr_zhang.projecrttaobao.R;
import com.example.mr_zhang.projecrttaobao.Shop.Checkinterface;
import com.example.mr_zhang.projecrttaobao.Shop.ModifyCountInterface;

import java.util.ArrayList;

/**
 * Created by Mr_Zhang on 2017/9/14.
 */

public class ShoppingAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ListBean.GoodsListBean> list_bean;
    private Checkinterface checkinterface;
    private ModifyCountInterface modifyCountInterface;
    private ViewHolder holder;
    private Boolean isshow=true;
    public void setInterface(Checkinterface checkinterface, ModifyCountInterface modifyCountInterface) {
        this.checkinterface = checkinterface;
        this.modifyCountInterface = modifyCountInterface;
    }
    public void isShow(Boolean flag){
        isshow=flag;
        notifyDataSetChanged();
    }
    public ShoppingAdapter(Context context, ArrayList<ListBean.GoodsListBean> list_bean) {
        this.context = context;
        this.list_bean = list_bean;
    }

    @Override
    public int getCount() {
        return list_bean.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        holder = null;
        if(view==null){
            view= LayoutInflater.from(context).inflate(R.layout.shop_demo, null);
            holder =new ViewHolder(view);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        Glide.with(context).load(list_bean.get(i).getImage()).into(holder.iv_show_pic);
        holder.name.setText(list_bean.get(i).getLongName());
        holder.tv_price.setText(list_bean.get(i).getMinSalePrice()+"");
        holder.tv_num.setText(list_bean.get(i).getCount()+"");
        holder.ck_chose.setChecked(list_bean.get(i).getCh_chouse());
        final ViewHolder finalHolder = holder;
        holder.ck_chose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkinterface.isCheck(list_bean.get(i).getGoodsId(),((CheckBox)view).isChecked());
            }
        });
        holder.iv_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                modifyCountInterface.doDecrease(list_bean.get(i).getGoodsId(),holder.tv_show_num,holder.ck_chose.isChecked());

            }
        });
        holder.iv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                modifyCountInterface.doIncrease(list_bean.get(i).getGoodsId(),holder.tv_show_num,holder.ck_chose.isChecked());
            }
        });
        holder.tv_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alert = new AlertDialog.Builder(context).create();
                alert.setTitle("操作提示");
                alert.setMessage("您确定要将这些商品从购物车中移除吗？");
                alert.setButton(DialogInterface.BUTTON_NEGATIVE, "取消",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                return;
                            }
                        });
                alert.setButton(DialogInterface.BUTTON_POSITIVE, "确定",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                modifyCountInterface.childDelete(i);//删除 目前只是从item中移除
                            }
                        });
                alert.show();
            }
        });
        if (isshow) {

            holder.rl_edit.setVisibility(View.GONE);
            holder.tv_delete.setVisibility(View.GONE);
        } else {

            holder.rl_edit.setVisibility(View.VISIBLE);
            holder.tv_delete.setVisibility(View.VISIBLE);
        }
        return view;
    }

    public static class ViewHolder {
        public View rootView;
        public CheckBox ck_chose;
        public ImageView iv_show_pic;
        public TextView name;
        public ImageView iv_sub;
        public TextView tv_show_num;
        public ImageView iv_add;
        public RelativeLayout rl_edit;
        public TextView tv_price;
        public TextView tv_num;
        public TextView tv_delete;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.ck_chose = (CheckBox) rootView.findViewById(R.id.ck_chose);
            this.iv_show_pic = (ImageView) rootView.findViewById(R.id.iv_show_pic);
            this.name = (TextView) rootView.findViewById(R.id.name);
            this.iv_sub = (ImageView) rootView.findViewById(R.id.iv_sub);
            this.tv_show_num = (TextView) rootView.findViewById(R.id.tv_show_num);
            this.iv_add = (ImageView) rootView.findViewById(R.id.iv_add);
            this.rl_edit = (RelativeLayout) rootView.findViewById(R.id.rl_edit);
            this.tv_price = (TextView) rootView.findViewById(R.id.tv_price);
            this.tv_num = (TextView) rootView.findViewById(R.id.tv_num);
            this.tv_delete = (TextView) rootView.findViewById(R.id.tv_delete);
        }

    }
}
