package com.example.oldemo.ui.home;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.oldemo.R;

import java.util.ArrayList;

public class SquareUiBuild {
    public final int SELECT_EMPLOYMENT = 1;
    public final int SELECT_VOLUNTEER = 2;
    public final int SELECT_NURSING_HOME = 3;
    public LinearLayout showzone;
    private Activity parentactivity;

//    private
    private ArrayList<Info_Detail> info_cache;


    public SquareUiBuild(Activity ac) {
        parentactivity = ac;

//        init_SquareUi();
//        showSquareUi();
    }
//    protected void init_SquareUi(){sqsv.removeAllViews();}
//    protected void showSquareUi(){init_SquareUi();sqsv.addView(buildViewList(info_cache));}

    protected ScrollView buildViewList(ArrayList<Info_Detail> cache) {
        info_cache = cache;
        ScrollView sqsv = new ScrollView(parentactivity);
        sqsv.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        showzone = new LinearLayout(parentactivity);
        LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
        showzone.setLayoutParams(llp);
        showzone.setOrientation(LinearLayout.VERTICAL);


        for(int i = 0;i < cache.size();++i){
            LinearLayout tl = bulidOne(cache.get(i));
            showzone.addView(tl);
        }


//        showzone.addView(buildOne());
        TextView ltv = new TextView(parentactivity);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.CENTER|Gravity.BOTTOM;
        ltv.setLayoutParams(lp);

        ltv.setGravity(Gravity.CENTER);
        ltv.setText(R.string.scrollbottom_text);
        showzone.addView(ltv);
        sqsv.addView(showzone);
        return sqsv;

    }

    protected LinearLayout bulidOne(Info_Detail in) {
        //info_detail in

        LinearLayout ll = new LinearLayout(parentactivity);
        LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,250);
        llp.topMargin = llp.leftMargin = llp.rightMargin = 10;
        ll.setLayoutParams(llp);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setBackgroundResource(R.drawable.info_bar);

        LinearLayout line1 = new LinearLayout(parentactivity);
        LinearLayout line2 = new LinearLayout(parentactivity);
        line1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT,3));
        line2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT,2));
        line1.setOrientation(LinearLayout.HORIZONTAL);
        line2.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout.LayoutParams tvlp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT,1);
        tvlp.gravity = Gravity.CENTER;
        TextView tv1 = new TextView(parentactivity);
        tv1.setLayoutParams(tvlp);
        tv1.setText(in.getPofession());
        tv1.setTextColor(Color.RED);
        tv1.setGravity(Gravity.CENTER);
        tv1.setTextSize(24);

        TextView tv2 = new TextView(parentactivity);
        tv2.setLayoutParams(tvlp);
        tv2.setText(in.getMoney());
        tv2.setGravity(Gravity.CENTER);
        tv2.setTextSize(24);

        TextView tv3 = new TextView(parentactivity);
        tv3.setLayoutParams(tvlp);
        tv3.setText(in.getCompany());
        tv3.setGravity(Gravity.CENTER);
        tv3.setTextSize(16);

        TextView tv4 = new TextView(parentactivity);
        tv4.setLayoutParams(tvlp);
        tv4.setText(in.getInfo());
        tv4.setGravity(Gravity.CENTER);
        tv4.setTextSize(16);

        line1.addView(tv1);
        line1.addView(tv2);
        line2.addView(tv3);
        line2.addView(tv4);

        ll.addView(line1);
        ll.addView(line2);
        return ll;
    }
}

