package com.example.mr_zhang.projecrttaobao.View.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mr_zhang.projecrttaobao.R;
import com.example.mr_zhang.projecrttaobao.View.InfoResponse;

/**
 * A simple {@link Fragment} subclass.
 */
public class JPFragment extends Fragment implements InfoResponse{


    public JPFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_j, container, false);
        return inflate;
    }

    @Override
    public void Success(String response) {

    }

    @Override
    public void Fail(String error) {

    }
}
