package com.example.liuwei20180521.pre;

import com.example.liuwei20180521.bean.VideoBean;

import java.util.List;

/**
 * Created by Administrator on 2018/5/21.
 */

public interface PresenterView {
    void toPresenter(List<VideoBean.DataBean> data);

    void onDestory();

    void netSet(String uri, int type, int page);
}
