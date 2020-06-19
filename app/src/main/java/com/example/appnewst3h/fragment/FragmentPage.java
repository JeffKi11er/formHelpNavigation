package com.example.appnewst3h.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.appnewst3h.adapter.PageAdapter;
import com.example.appnewst3h.R;
import com.google.android.material.tabs.TabLayout;

public class FragmentPage extends Fragment {
    ViewPager viewPager;
    TabLayout tabLayout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page,container,false);
        tabLayout = view.findViewById(R.id.tab);
        viewPager = view.findViewById(R.id.view);
        viewPager.setAdapter(new PageAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        //tabLayout.setTabTextColors(Color.WHITE,Color.RED);
        return view;
    }
}
