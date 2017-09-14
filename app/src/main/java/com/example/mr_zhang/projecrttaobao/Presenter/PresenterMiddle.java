package com.example.mr_zhang.projecrttaobao.Presenter;

import com.example.mr_zhang.projecrttaobao.Model.InfoModel;
import com.example.mr_zhang.projecrttaobao.Model.InfoModelImp;
import com.example.mr_zhang.projecrttaobao.View.InfoResponse;

/**
 * Created by Mr_Zhang on 2017/9/14.
 */

public class PresenterMiddle implements CallBackOnclkier,SendOncliker{
    private InfoModel infoModel;
    private InfoResponse infoResponse;

    public PresenterMiddle( InfoResponse infoResponse) {
        this.infoModel = new InfoModelImp();
        this.infoResponse = infoResponse;
    }

    @Override
    public void Success(String response) {
            infoResponse.Success(response);
    }

    @Override
    public void Fail(String error) {
            infoResponse.Fail(error);
    }

    @Override
    public void getUrl() {
            infoModel.getInfo("https://api-m.mtime.cn/ECommerce/RecommendProducts.api",this);
    }
}
