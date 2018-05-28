package com.example.liuwei20180521.model;

import com.example.liuwei20180521.bean.WenBean;
import com.example.liuwei20180521.presenter.MyPresenterView;
import com.example.liuwei20180521.utils.OkHttpUtils;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/5/21.
 */

public class MyModel implements MyModelView {
    @Override
    public void toModelView(String uri, int type, int page, final MyPresenterView presenterView) {
        //解析
        Observable<WenBean> wenBeanObservable = OkHttpUtils.getInstance(uri).getApi().doGet(type, page);

        wenBeanObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<WenBean>() {
                    @Override
                    public void accept(WenBean wenBean) throws Exception {
                        List<WenBean.DataBean> data = wenBean.getData();
                    presenterView.toPresenter(data);
                    }
                });
    }
}
