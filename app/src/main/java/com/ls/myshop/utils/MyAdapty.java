package com.ls.myshop.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.ls.myshop.R;
/**
 * Created by ls on 16/1/26.
 */
public class MyAdapty extends BaseAdapter {
    private Context mContext;
    public String[] img_text = {"转账", "余额宝", "手机充值", "信用卡还款", "淘宝电影", "彩票",
            "当面付", "亲密付", "机票"};
    public int[] imgs = {R.mipmap.app_transfer, R.mipmap.app_fund,
            R.mipmap.app_phonecharge, R.mipmap.app_creditcard,
            R.mipmap.app_movie, R.mipmap.app_lottery,
            R.mipmap.app_facepay, R.mipmap.app_close, R.mipmap.app_plane};

    public MyAdapty(Context mContext) {
        super();
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return img_text.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.gridview_item, parent,false);
        }
        ImageView iv = (ImageView) convertView.findViewById(R.id.iv_gridview_item);
        TextView tv = (TextView) convertView.findViewById(R.id.tv_gridview_item);
        iv.setBackgroundResource(imgs[position]);
        tv.setText(img_text[position]);
        return convertView;
    }

}
