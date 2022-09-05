package com.example.myapplication1;


import android.widget.ArrayAdapter;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

//定义BaseAdapter
public class UserAdapter extends ArrayAdapter {
    private Activity mContext = null; // 上下文环境
    private int mResourceId; // 列表项布局资源ID
    private String[] mItems; // 列表内容数组

    public UserAdapter(Activity context, int resId, String[] items){
        super(context, resId, items);
        // 保存参数
        mContext = context;
        mResourceId = resId;
        mItems = items;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 获取LayoutInflater对象
        LayoutInflater inflater = mContext.getLayoutInflater();
        // 装载列表项视图
        View itemView = inflater.inflate(mResourceId, null);

        // 获取列表项之组件
        TextView contentTv = (TextView) itemView.findViewById(R.id.content_tv);
        ImageView letterImg = (ImageView) itemView.findViewById(R.id.letter_img);

        // 取出要显示的数据
        String content = mItems[position].trim();

        // 给TextView设置显示值
        contentTv.setText(content);
        // 根据内容首字母判断要显示的图标
        if(content.startsWith("a") || content.startsWith("A")) {
            letterImg.setImageResource(com.google.android.material.R.drawable.abc_ic_star_black_16dp);
        } else if(content.startsWith("b") || content.startsWith("B")) {
            letterImg.setImageResource(com.google.android.material.R.drawable.abc_ic_star_black_16dp);
        } else if(content.startsWith("c") || content.startsWith("C")) {
            letterImg.setImageResource(com.google.android.material.R.drawable.abc_ic_star_black_16dp);
        } else if(content.startsWith("d") || content.startsWith("D")) {
            letterImg.setImageResource(com.google.android.material.R.drawable.abc_ic_star_black_16dp);
        } else if(content.startsWith("e") || content.startsWith("E")) {
            letterImg.setImageResource(com.google.android.material.R.drawable.abc_ic_star_black_16dp);
        }

        // 返回列表项视图
        return itemView;
    }
}

