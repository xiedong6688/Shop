package com.ls.myshop.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.ls.myshop.Base.MainApplication;
import com.ls.myshop.R;

/**
 * Created by ls on 16/1/26.
 */
public class GridViewAdapty extends BaseAdapter {
    private Context mContext;
    public String[] goods_Name = {"转账", "余额宝", "手机充值", "信用卡还款", "淘宝电影", "彩票",
            "当面付", "亲密付", "机票"};
    public String[] goods_imgs;

    public GridViewAdapty(Context mContext, String[] goods_Name, String[] goods_imgs) {
        super();
        this.mContext = mContext;
        this.goods_Name = goods_Name;
        this.goods_imgs = goods_imgs;
    }

    @Override
    public int getCount() {
        return goods_Name.length;
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.gridview_item, parent, false);
        }
        NetworkImageView networkImageView = (NetworkImageView) convertView.findViewById(R.id.niiv_gridview_item);
        TextView tv = (TextView) convertView.findViewById(R.id.tv_gridview_item);
        networkImageView.setDefaultImageResId(R.mipmap.app_aligame);
        networkImageView.setErrorImageResId(R.mipmap.ic_launcher);
        networkImageView.setImageUrl(goods_imgs[position], MainApplication.getImageLoader());
        tv.setText(goods_Name[position]);
        return convertView;
    }

}
