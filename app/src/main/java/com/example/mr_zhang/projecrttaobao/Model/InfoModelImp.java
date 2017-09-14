package com.example.mr_zhang.projecrttaobao.Model;

import com.example.mr_zhang.projecrttaobao.Presenter.CallBackOnclkier;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Mr_Zhang on 2017/9/14.
 */

public class InfoModelImp implements InfoModel {
    @Override
    public void getInfo(String url, final CallBackOnclkier lisenter) {
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                lisenter.Fail(e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                lisenter.Success(response.body().string());
            }
        });
    }
}
