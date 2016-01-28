package com.ls.myshop.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by ls on 16/1/26.
 */
public class GoodsInfoGridView extends GridView {

    public GoodsInfoGridView(Context context) {
        super(context);
    }

    public GoodsInfoGridView(Context context, AttributeSet attri) {
        super(context, attri);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec=MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
