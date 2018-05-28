package com.example.liuwei20180521.presenter;

import com.example.liuwei20180521.bean.WenBean;
import com.example.liuwei20180521.model.MyModel;
import com.example.liuwei20180521.model.MyModelView;
import com.example.liuwei20180521.view.LogView;

import java.util.List;

/**
 * Created by Administrator on 2018/5/21.
 */

public class MyPresenter implements MyPresenterView {

LogView logView;
    private final MyModelView myModelView;

    public MyPresenter(LogView logView){
this.logView=logView;
        myModelView = new MyModel();
    }
    @Override
    public void toPresenter(List<WenBean.DataBean> data) {

        logView.toBackView(data);
    }

    @Override
    public void netSet(String uri, int type, int page) {
        myModelView.toModelView(uri,type,page,this);
    }

    @Override
    public void onDestroy() {
        logView=null;
        System.gc();
    }
}
