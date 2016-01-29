package com.ls.myshop.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ls.myshop.Contants.RequestConfig;
import com.ls.myshop.R;
import com.ls.myshop.utils.GoodsInfoGridView;
import com.ls.myshop.utils.GridViewAdapty;

/**
 * Created by Administrator on 2016/1/28.
 */
public class PageFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    private GoodsInfoGridView goodsInfoGridView;

    public static PageFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PageFragment pageFragment = new PageFragment();
        pageFragment.setArguments(args);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);
        initViewDelayed(view);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    /**
     * 初始化控件
     *
     * @param view
     */
    private void initView(View view) {
        goodsInfoGridView = (GoodsInfoGridView) view.findViewById(R.id.mygv_goods);
        goodsInfoGridView.setAdapter(new GridViewAdapty(getContext(), RequestConfig.title, RequestConfig.urls));
    }

    /**
     * 延迟初始化
     *
     * @param view
     */
    private void initViewDelayed(final View view) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                initView(view);
            }
        }, 800);
    }
}
