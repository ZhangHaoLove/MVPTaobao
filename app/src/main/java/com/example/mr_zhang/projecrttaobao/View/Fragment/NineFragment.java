package com.example.mr_zhang.projecrttaobao.View.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mr_zhang.projecrttaobao.Adapter.MyAdapter;
import com.example.mr_zhang.projecrttaobao.Bean.ListBean;
import com.example.mr_zhang.projecrttaobao.Presenter.PresenterMiddle;
import com.example.mr_zhang.projecrttaobao.R;
import com.example.mr_zhang.projecrttaobao.View.InfoResponse;
import com.example.mr_zhang.projecrttaobao.View.MainActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NineFragment extends Fragment implements  InfoResponse,View.OnClickListener {


    private TextView title;
    private Button finish;
    private RecyclerView recycle;
    private ArrayList<ListBean.GoodsListBean> list_bean=new ArrayList<>();
    public  MyAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_nine, container, false);
        initView(inflate);
        initAdapter();
        PresenterMiddle presenterMiddle = new PresenterMiddle(this);
        presenterMiddle.getUrl();
        return inflate;
    }

    private void initAdapter() {
        GridLayoutManager manager=new GridLayoutManager(getActivity(),2);
        recycle.setLayoutManager(manager);
        adapter = new MyAdapter(getActivity(),list_bean);
        recycle.setAdapter(adapter);
    }

    @Override
    public void Success(final String response) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {

                Gson gson=new Gson();
                Type type = new TypeToken<ListBean>() {
                }.getType();
                ListBean bean = gson.fromJson(response, type);
                list_bean.addAll(bean.getGoodsList());
                adapter.notifyDataSetChanged();
                adapter.setOncliker((MainActivity)getActivity());
            }
        });
    }

    @Override
    public void Fail(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }

    private void initView(View inflate) {
        title = (TextView) inflate.findViewById(R.id.title);
        finish = (Button) inflate.findViewById(R.id.finish);
        recycle = (RecyclerView) inflate.findViewById(R.id.recycle);
        title.setText("九折区");

        finish.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.finish:

                break;
        }
    }
}
