package com.example.healthnote;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;

public class AchievementActivity extends AppCompatActivity {
    private ActivityAchievementBinding binding;
    private List<TxtAndChooseBean> dataList;
    private AchievementAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = LayoutInflater.from(this);
        binding = ActivityAchievementBinding.inflate(inflater);
        setContentView(binding.getRoot());

        initData();
        initClick();
    }

    private void initData() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 7);
        binding.rv.setLayoutManager(gridLayoutManager);

        createList();
        List<RecordsBean> recordsBeans = DBflowUtil.getInstance().queryLisr(MyTimeUtil.getYear(), MyTimeUtil.getMonth());
        LogUtil.e("----------->"+recordsBeans.size());
        if (recordsBeans.size() > 0) {
            for (int i = 0; i < dataList.size(); i++) {
                for (int j = 0; j < recordsBeans.size(); j++) {
                    if (dataList.get(i).getTitle().equals(recordsBeans.get(j).getDay())) {
                        dataList.get(i).setStatus(recordsBeans.get(j).isFinish() ? 1 : 0);
                    }
                }
            }
        }

        adapter = new AchievementAdapter(this, dataList, R.layout.rv_achievement);
        binding.rv.setAdapter(adapter);
    }

    private void createList() {
        dataList = new ArrayList<>();
        int lastDay = MyTimeUtil.getCurrentMonthLastDay();
        int day = Integer.valueOf(MyTimeUtil.getDay());
        for (int i = 1; i <= lastDay; i++) {
            dataList.add(new TxtAndChooseBean(i + "", i <= day ? 0 : 2));
        }
    }

    private void initClick() {
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}