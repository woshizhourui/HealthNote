package com.example.healthnote.adapter;

import android.content.Context;

import com.example.healthnote.R;

public class SignInAdapter extends MyRecyclerAdapter<TxtAndChooseBean> {
    public SignInAdapter(Context context, List<TxtAndChooseBean> mList, int mLayoutId) {
        super(context, mList, mLayoutId);
    }

    @Override
    public void convert(RecyclerViewHolder holder, TxtAndChooseBean data, int position) {
        holder.setText(R.id.rv_target_txt, data.getTitle())
                .setImageResource(R.id.rv_target_img, data.getStatus() == 0 ? R.drawable.weixuanzhong_fang :
                        data.getStatus() == 1 ? R.drawable.xuanzhong_fang_zi : R.drawable.xuanzhong_fang_hei);
    }
}

