package com.example.administrator.todynewdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/9/11.
 */

public class viewadapter extends BaseAdapter {
    private News news;
    private ArrayList<News> data;

    public viewadapter(FragmentActivity activity, ArrayList<News> data) {
        this.data = data;
    }


    public int getItemType(int possition) {
        news = data.get(possition);
        if (news.getType() == 0) {
            return 0;
        } else if (news.getType() == 1) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public News getItem(int position) {

        return data.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        int itemViewType = getItemType(i);
        if (itemViewType == 0) {

            if (convertView == null) {
                TextView textView1;
                TextView textView2;
                ImageView imageView1;
                ImageView imageView2;
                ImageView imageView3;
                convertView = View.inflate(parent.getContext(), R.layout.item1, null);

                textView1 = convertView.findViewById(R.id.text1);
                textView2 = convertView.findViewById(R.id.text2);
                imageView1 = convertView.findViewById(R.id.imageview1);
                imageView2 = convertView.findViewById(R.id.imageview2);
                imageView3 = convertView.findViewById(R.id.imageview3);
                textView1.setText(news.getText1());
                 textView2.setText(news.getText2());
                imageView1.setImageResource(news.getImage1());
                imageView2.setImageResource(news.getImage2());
                imageView3.setImageResource(news.getImage3());



            }
        } else if (itemViewType == 1) {

            if (convertView == null) {
                convertView = View.inflate(parent.getContext(), R.layout.item3, null);
                TextView textView1;
                TextView textView2;
                ImageView imageView;
                textView1 = convertView.findViewById(R.id.textview1);
                textView2 = convertView.findViewById(R.id.textview2);
                imageView = convertView.findViewById(R.id.imageview);
                textView1.setText(news.getText1());
                textView2.setText(news.getText2());
                imageView.setImageResource(news.getImage1());

            }


        } else {

            if (convertView == null) {
                convertView = View.inflate(parent.getContext(), R.layout.item2, null);
                TextView textView1;
                TextView textView2;
                textView1 = convertView.findViewById(R.id.text1);
                textView2 = convertView.findViewById(R.id.text2);
                textView1.setText(news.getText1());
                textView2.setText(news.getText2());

            }
        }
        return convertView;

    }




}