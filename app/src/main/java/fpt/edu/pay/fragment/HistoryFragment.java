package fpt.edu.pay.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import fpt.edu.pay.R;
import fpt.edu.pay.adepter.HistoryAdapter;

public class HistoryFragment extends Fragment  {

    private HistoryAdapter pagerAdapter;
    private ViewPager2 viewPager;

    private TabLayout tabLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_history, container, false);
        viewPager=view.findViewById(R.id.view_pager2);
        pagerAdapter= new HistoryAdapter(getChildFragmentManager(), getLifecycle());
        viewPager.setAdapter(pagerAdapter);
        tabLayout= view.findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) ->{
                    if(position==0) {
                        tab.setText("Tất cả");
                    }
                    else if(position==1) {
                        tab.setText("Điện thoại");
                    }
                }
        ).attach();
        return view;
    }

}