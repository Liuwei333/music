package com.example.liuwei20180521.pre;

import com.example.liuwei20180521.MyModel.Model;
import com.example.liuwei20180521.MyModel.ModelView;
import com.example.liuwei20180521.bean.VideoBean;
import com.example.liuwei20180521.bean.WenBean;
import com.example.liuwei20180521.model.MyModel;
import com.example.liuwei20180521.model.MyModelView;
import com.example.liuwei20180521.view.LogView;
import com.example.liuwei20180521.view.LogView2;

import java.util.List;

/**
 * Created by Administrator on 2018/5/21.
 */

public class Presenter implements PresenterView {
    LogView2 logView;
    private final ModelView modelView;


    public Presenter(LogView2 logView){
        this.logView=logView;
        modelView = new Model();
    }
    @Override
    public void toPresenter(List<VideoBean.DataBean> data) {

        logView.toBackView(data);
    }



    @Override
    public void netSet(String uri, int type, int page) {
        modelView.toModelView(uri,type,page,this);
    }
    @Override
    public void onDestory() {
        logView=null;
        System.gc();
    }

}
