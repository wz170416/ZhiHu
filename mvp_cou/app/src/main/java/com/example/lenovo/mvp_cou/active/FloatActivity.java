package com.example.lenovo.mvp_cou.active;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.lenovo.mvp_cou.R;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class FloatActivity extends AppCompatActivity {

    private MaterialCalendarView mater;
    private TextView float_tv;
    private CalendarDay mDatas;
private String dad ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_float);
        initView();
        mater.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                mDatas = date;
                int day = mDatas.getDay();
                int month = mDatas.getMonth();
                int year = mDatas.getYear();
                dad = ""+year+month+day;
            }
        });
        float_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDatas != null) {
                    EventBus.getDefault().postSticky(dad);
                }
                finish();
            }
        });
    }


    private void initView() {
        mater = (MaterialCalendarView) findViewById(R.id.mater);
        float_tv = (TextView) findViewById(R.id.float_tv);
    }



}
