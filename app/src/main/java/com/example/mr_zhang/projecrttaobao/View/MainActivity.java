package com.example.mr_zhang.projecrttaobao.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.mr_zhang.projecrttaobao.Adapter.FragmentAdapter;
import com.example.mr_zhang.projecrttaobao.Adapter.ShopAdapter.InfoShopping;
import com.example.mr_zhang.projecrttaobao.Bean.ListBean;
import com.example.mr_zhang.projecrttaobao.R;
import com.example.mr_zhang.projecrttaobao.Shop.ShopActivity;
import com.example.mr_zhang.projecrttaobao.View.Fragment.JPFragment;
import com.example.mr_zhang.projecrttaobao.View.Fragment.NineFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, InfoShopping {

    private ViewPager pager;
    private Button btn_jz;
    private Button btn_jp;
    public static NineFragment nineFragment;
    private JPFragment jpFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();



    }


    private void initView() {
        pager = (ViewPager) findViewById(R.id.pager);
        btn_jz = (Button) findViewById(R.id.btn_jz);
        btn_jp = (Button) findViewById(R.id.btn_jp);
        ArrayList<Fragment> list_fragment=new ArrayList<>();
        nineFragment = new NineFragment();
        list_fragment.add(nineFragment);
        jpFragment = new JPFragment();
        list_fragment.add(jpFragment);
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(),list_fragment);
        pager.setAdapter(fragmentAdapter);

        btn_jz.setOnClickListener(this);
        btn_jp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_jz:
                pager.setCurrentItem(0);
                break;
            case R.id.btn_jp:
                pager.setCurrentItem(1);
                break;
        }
    }

    @Override
    public void sendMessage(ListBean.GoodsListBean bean) {
        Intent intent=new Intent(MainActivity.this, ShopActivity.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("bean",bean);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
