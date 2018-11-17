package com.bw.movie.mvp.present;


import com.bw.movie.mvp.view.IView.IBaseView;

public class BasePresent<V extends IBaseView> {

    private V iv;

    public void attachView(V v) {
        this.iv = v;
    }

    public void dettachView() {
        this.iv = null;
    }

    public V getView(){
        return iv;
    }


}
