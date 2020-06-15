package com.example.healthnote;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class SigninActivity extends AppCompatActivity {
    private ActivitySigninBinding binding;
    private List<TxtAndChooseBean> dataList;
    private SignInAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = LayoutInflater.from(this);
        binding = ActivitySigninBinding.inflate(inflater);
        setContentView(binding.getRoot());

        initData();
        initClick();
    }

    private void initData() {
        dataList = new ArrayList<>();
        String value = SPUtil.getStringValue(CommonResource.TARGET);
        String[] split = value.split("-");
        for (int i = 0; i < split.length; i++) {
            dataList.add(new TxtAndChooseBean(split[i], 0));
        }

        String s = DBflowUtil.getInstance().queryContent(MyTimeUtil.getYear(), MyTimeUtil.getMonth(), MyTimeUtil.getDay());
        if (!TextUtils.isEmpty(s)) {
            String[] strArr = s.split("-");
            for (int i = 0; i < dataList.size(); i++) {
                for (int j = 0; j < strArr.length; j++) {
                    if (dataList.get(i).getTitle().equals(strArr[j])) {
                        dataList.get(i).setStatus(2);
                    }
                }
            }
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        binding.rv.setLayoutManager(linearLayoutManager);
        adapter = new SignInAdapter(this, dataList, R.layout.rv_target);
        binding.rv.setAdapter(adapter);
    }

    private void initClick() {
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        adapter.setOnItemClick(new MyRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView parent, View view, int position) {
                dataList.get(position).setStatus(dataList.get(position).getStatus() == 0 ? 1 : dataList.get(position).getStatus() == 1 ? 0 : 2);
                adapter.notifyDataSetChanged();
            }
        });

        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.btn.setEnabled(false);
                StringBuffer sb = new StringBuffer();
                boolean hasCh = false;
                boolean isFinish = true;
                for (int i = 0; i < dataList.size(); i++) {
                    if (dataList.get(i).getStatus() == 1) {
                        hasCh = true;
                        sb.append(dataList.get(i).getTitle() + "-");
                    } else if (dataList.get(i).getStatus() == 2) {
                        sb.append(dataList.get(i).getTitle() + "-");
                    } else {
                        isFinish = false;
                    }
                }

                if (hasCh) {
                    String s = sb.toString();
                    String substring = s.substring(0, s.length() - 1);

                    DBflowUtil.getInstance().insertResult(MyTimeUtil.getYear(), MyTimeUtil.getMonth(), MyTimeUtil.getDay(), substring, isFinish);
                    Toast.makeText(SignInActivity.this, "操作成功", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(SignInActivity.this, "请选择", Toast.LENGTH_SHORT).show();
                    binding.btn.setEnabled(true);
                }
            }
        });
    }


}