package com.example.liuwei20180521.presenter;

import com.example.liuwei20180521.bean.WenBean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/21.
 */

public interface MyPresenterView {
    void toPresenter( List<WenBean.DataBean> data);

    void netSet(String uri, int type, int page);

    void onDestroy();
}
