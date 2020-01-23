package com.example.oldemo.ui.home;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.ViewPager;

import com.example.oldemo.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private String[] titstr = {"推荐","返聘","志愿","养老"};
    private ArrayList<String> TIT;
    private ArrayList<ArrayList<Info_Detail>> info;
    private ArrayList<ScrollView> viewlist;
    private PagerTabStrip tabstrip;
    private ViewPager viewPager;
    private HomeViewModel homeViewModel;
    private View parent;
    private Context ac;
//    private


    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        parent = inflater.inflate(R.layout.fragment_home, container, false);
        ConstraintLayout.LayoutParams clp = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT,ConstraintLayout.LayoutParams.MATCH_PARENT);
//        clp.bottomToTop = R.id.nav_view;
        parent.setLayoutParams(clp);
        ac = this.getActivity();
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

        initView();
        renewinfo();
        viewPager.setAdapter(new PagerAdapter() {

            @Override
            public int getCount() {
                return TIT.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container,int position){
                container.addView(viewlist.get(position));
                return viewlist.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container,int position,Object objedt){
                container.removeView((View) objedt);
            }
            @Override
            public CharSequence getPageTitle(int position){
                SpannableStringBuilder ssb = new SpannableStringBuilder(TIT.get(position));
                ForegroundColorSpan fcs = new ForegroundColorSpan(Color.BLACK);
                ssb.setSpan(fcs,0,ssb.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                return ssb;
            }
        });

        return parent;
    }
    private void initView(){
        viewlist = new ArrayList<>();
        TIT = new ArrayList<>();
        viewPager = parent.findViewById(R.id.view_pager);
        tabstrip = parent.findViewById(R.id.sel_title);
        tabstrip.setTextSize(0,64);
        tabstrip.setGravity(Gravity.CENTER|Gravity.TOP);

        for(String str : titstr){
            TIT.add(str);
        }
//        tabstrip.setTabIndicatorColor(Color.RED);

    }
    private void renewinfo(){
        info = new ArrayList<>();
        ArrayList<Info_Detail> temp = homeViewModel.get_info(homeViewModel.INFO_E);
        temp.addAll(homeViewModel.get_info(homeViewModel.INFO_K));
        temp.addAll(homeViewModel.get_info(homeViewModel.INFO_Z));
        info.add(temp);
        info.add(homeViewModel.get_info(homeViewModel.INFO_E));
        info.add(homeViewModel.get_info(homeViewModel.INFO_K));
        info.add(homeViewModel.get_info(homeViewModel.INFO_Z));
//        Log.d("info", "renewinfo: info " +info.size() +" " + info.get(0).get(3).getCompany());
        SquareUiBuild suq = new SquareUiBuild(this.getActivity());
        for(int i = 0;i < info.size();++i)
            viewlist.add(suq.buildViewList(info.get(i)));
//        Log.d("viewlist", "renewinfo: viewlist " + viewlist.size());

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        homeViewModel.initInf();
    }
}