package com.example.mr_zhang.projecrttaobao.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Mr_Zhang on 2017/9/14.
 */

public class FragmentAdapter  extends FragmentPagerAdapter{
    private ArrayList<Fragment> list_fargment;
    public FragmentAdapter(FragmentManager fm,ArrayList<Fragment> list_fargment) {
        super(fm);
        this.list_fargment=list_fargment;
    }

    @Override
    public Fragment getItem(int position) {
        return list_fargment.get(position);
    }

    @Override
    public int getCount() {
        return list_fargment.size();
    }
}
