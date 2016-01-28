package com.ls.myshop.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.ls.myshop.fragment.PageFragment;

/**
 * Created by Administrator on 2016/1/28.
 */
public class FragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {
    int PAGE_COUNT = 7;
    private String tabTitles[] = new String[]{"tab1", "tab2", "tab3", "tab4", "tab5", "tab6", "tab7"};

    /**
     * FragmentPagerAdapter Fragment的Adapter
     *
     * @param fragmentManager FragmentManager对象
     * @param pageCount       title的个数
     * @param tabTitles       tab的名字
     */
    public FragmentPagerAdapter(FragmentManager fragmentManager, int pageCount, String tabTitles[]) {
        super(fragmentManager);
        this.PAGE_COUNT = pageCount;
        this.tabTitles = tabTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
