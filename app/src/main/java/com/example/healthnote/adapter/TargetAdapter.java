package com.example.healthnote.adapter;

import android.content.Context;

import com.example.healthnote.R;

public class TargetAdapter extends MyRecyclerAdapter<TxtAndChooseBean> {
    public TargetAdapter(Context context, List<TxtAndChooseBean> mList, int mLayoutId) {
        super(context, mList, mLayoutId);
    }

    @Override
    public void convert(RecyclerViewHolder holder, TxtAndChooseBean data, int position) {
        holder.setText(R.id.rv_target_txt, data.getTitle())
                .setImageResource(R.id.rv_target_img, data.isChoose() ? R.drawable.img_xuanzhong_zi : R.drawable.icon_weixuanzhong);
    }
}
