package com.example.healthnote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.getRoot());

        initData();
        initClick();
    }

    private void initData() {
        if (!(MyTimeUtil.getYear() + MyTimeUtil.getMonth() + MyTimeUtil.getDay()).equals(SPUtil.getStringValue(CommonResource.DAY))) {
            DBflowUtil.getInstance().insertResult(MyTimeUtil.getYear(), MyTimeUtil.getMonth(), MyTimeUtil.getDay(), "", false);
        }
        SPUtil.addParm(CommonResource.DAY, MyTimeUtil.getYear() + MyTimeUtil.getMonth() + MyTimeUtil.getDay());
    }

    private void initClick() {
        binding.target.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TargetActivity.class));
            }
        });

        binding.signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = SPUtil.getStringValue(CommonResource.TARGET);
                if (TextUtils.isEmpty(value)) {
                    Toast.makeText(MainActivity.this, "请先设定目标", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(MainActivity.this, SignInActivity.class));
                }
            }
        });

        binding.achievement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = SPUtil.getStringValue(CommonResource.TARGET);
                if (TextUtils.isEmpty(value)) {
                    Toast.makeText(MainActivity.this, "请先设定目标", Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(new Intent(MainActivity.this, AchievementActivity.class));
                }
            }
        });
    }


}
