package com.example.appnewst3h.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.appnewst3h.fragment.FragmentContent;

public class PageAdapter extends FragmentPagerAdapter {
    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        FragmentContent content = new FragmentContent();
        if(position==0){
            content.setLink("https://www.24h.com.vn");
        }else {
            if (position==1){
                content.setLink("https://www.24h.com.vn/tin-tuc-quoc-te-c415.html");
            }else {
                content.setLink("https://www.24h.com.vn/bong-da-c48.html");
            }
        }
        return content;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position==0){
            return "Khám Phá";
        }
        if(position==1){
            return "Tin mới";
        }
        return "Tin Hot";
    }
}
