package com.example.liuwei20180521.MyModel;

import com.example.liuwei20180521.pre.PresenterView;
import com.example.liuwei20180521.presenter.MyPresenterView;

/**
 * Created by Administrator on 2018/5/21.
 */

public interface ModelView {
    void toModelView(String uri, int type, int page, PresenterView presenterView);
}
