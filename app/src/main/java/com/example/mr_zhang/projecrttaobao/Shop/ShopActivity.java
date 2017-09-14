package com.example.mr_zhang.projecrttaobao.Shop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mr_zhang.projecrttaobao.Adapter.ShopAdapter.ShoppingAdapter;
import com.example.mr_zhang.projecrttaobao.Bean.ListBean;
import com.example.mr_zhang.projecrttaobao.R;

import java.util.ArrayList;

public class ShopActivity extends AppCompatActivity implements Checkinterface,ModifyCountInterface, View.OnClickListener {

    private TextView tv_edit;
    private ListView list_shopping_cart;
    private CheckBox ck_all;
    private Boolean flag=false;
    private TextView tv_settlement;
    private TextView tv_show_price;
    private RelativeLayout rl_bottom;
    private ArrayList<ListBean.GoodsListBean> list_bean=new ArrayList<>();
    private int total;
    private int count;
    private ShoppingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        initView();

        initAdapter();

        initData();

        adapter.setInterface(this,this);
    }

    private void initData() {
        Bundle extras = getIntent().getExtras();
        ListBean.GoodsListBean bean = (ListBean.GoodsListBean) extras.getSerializable("bean");
        bean.setCh_chouse(true);
        list_bean.add(bean);
        adapter.notifyDataSetChanged();
    }

    private void initAdapter() {
        adapter = new ShoppingAdapter(this,list_bean);
        list_shopping_cart.setAdapter(adapter);
    }

    private void initView() {
        tv_edit = (TextView) findViewById(R.id.tv_edit);
        list_shopping_cart = (ListView) findViewById(R.id.list_shopping_cart);
        ck_all = (CheckBox) findViewById(R.id.ck_all);
        tv_settlement = (TextView) findViewById(R.id.tv_settlement);
        tv_show_price = (TextView) findViewById(R.id.tv_show_price);
        rl_bottom = (RelativeLayout) findViewById(R.id.rl_bottom);
        tv_edit.setOnClickListener(this);
    }

    @Override
    public void isCheck(int position, Boolean isChecked) {
        ListBean.GoodsListBean aTrue = getTrue(position);
        aTrue.setCh_chouse(isChecked);
        submit();
        adapter.notifyDataSetChanged();
//        if(isChecked){
//            Toast.makeText(this, "选中", Toast.LENGTH_SHORT).show();
//        }else{
//            Toast.makeText(this, "为选中", Toast.LENGTH_SHORT).show();
//        }
    }

    @Override
    public void doIncrease(int position, View showCountView, boolean isChecked) {
        ListBean.GoodsListBean aTrue = getTrue(position);
        int count = aTrue.getCount();
        count++;
        aTrue.setCount(count);
        ((TextView)showCountView).setText(aTrue.getCount()+"");
        adapter.notifyDataSetChanged();
        submit();

    }

    @Override
    public void doDecrease(int position, View showCountView, boolean isChecked) {
        ListBean.GoodsListBean aTrue = getTrue(position);
        int count = aTrue.getCount();
        if(count!=0){
            count--;
        }
        aTrue.setCount(count);
        ((TextView)showCountView).setText(aTrue.getCount()+"");
        adapter.notifyDataSetChanged();
        submit();
    }

    @Override
    public void childDelete(int position) {
        ListBean.GoodsListBean aTrue = getTrue(position);
        list_bean.remove(aTrue);
        adapter.notifyDataSetChanged();
        submit();
    }
    public ListBean.GoodsListBean getTrue(int position){
        for (ListBean.GoodsListBean l:list_bean){
            if(l.getGoodsId()==position){
                return l;
            }
        }
        return null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_edit:
                if(!flag){
                    tv_edit.setText("完成");
                    adapter.isShow(false);
                    flag=true;
                }else{
                    tv_edit.setText("编辑");
                    adapter.isShow(true);
                    flag=false;
                }
                break;
        }
    }
    public void submit(){
            total=0;
            count=0;
        for (int i = 0; i < list_bean.size(); i++) {
            ListBean.GoodsListBean goodsListBean = list_bean.get(i);
            if(goodsListBean.getCh_chouse()){
                count++;
                total+=goodsListBean.getCount()*goodsListBean.getMinSalePrice();
            }
            tv_show_price.setText("合计:" + total);
            tv_settlement.setText("结算(" + count + ")");
        }
    }
}
