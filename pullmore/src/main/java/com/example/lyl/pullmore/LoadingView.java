package com.example.lyl.pullmore;

import android.content.Context;
import android.widget.LinearLayout;



public class LoadingView extends LinearLayout {

    public LoadingView(Context context) {
        super(context);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.loading_view_layout ,this);
    }
}
