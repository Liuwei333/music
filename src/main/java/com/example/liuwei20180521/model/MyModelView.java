package com.example.liuwei20180521.model;

import com.example.liuwei20180521.presenter.MyPresenterView;

/**
 * Created by Administrator on 2018/5/21.
 */

public interface MyModelView {

    void toModelView(String uri,int type,int page, MyPresenterView presenterView);
}
