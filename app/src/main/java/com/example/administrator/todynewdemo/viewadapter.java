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


    public int getItemViewType(int possition) {
        news  = data.get(possition);
        if (news.getType() == 1) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
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

        int itemViewType = getItemViewType(i);
        if (itemViewType == 0) {
            picViewHolder picViewHolder ;
            if (convertView == null) {
                convertView = View.inflate(parent.getContext(), R.layout.item1, null);
                picViewHolder = new picViewHolder();
                picViewHolder.textView1 = convertView.findViewById(R.id.text1);
                picViewHolder.textView2 = convertView.findViewById(R.id.text2);
                picViewHolder.imageView1 = convertView.findViewById(R.id.imageview1);
                picViewHolder.imageView2 = convertView.findViewById(R.id.imageview2);
                picViewHolder.imageView3 = convertView.findViewById(R.id.imageview3);
                picViewHolder.textView1.setText(news.getText1());
                picViewHolder.textView1.setText(news.getText2());


                convertView.setTag(picViewHolder);

            } else {

                picViewHolder = (picViewHolder) convertView.getTag();
                convertView.setTag(picViewHolder);

            }
        }else {
            textpicViewHolder textpicViewHolder;
            if (convertView == null) {
                convertView = View.inflate(parent.getContext(), R.layout.item3, null);
                textpicViewHolder = new textpicViewHolder();
                textpicViewHolder.textView1=convertView.findViewById(R.id.textview1);
                textpicViewHolder.textView2=convertView.findViewById(R.id.textview2);
                textpicViewHolder.imageView = convertView.findViewById(R.id.imageview);
                convertView.setTag(textpicViewHolder);
            }else {

                textpicViewHolder = (textpicViewHolder) convertView.getTag();
                convertView.setTag(textpicViewHolder);
            }


        }
                  return convertView;
        }


    }



    class picViewHolder{
        TextView textView1;
        TextView textView2;
        ImageView imageView1;
        ImageView imageView2;
        ImageView imageView3;


    }

    class textpicViewHolder{
        TextView textView1;
        TextView textView2;
        ImageView imageView;

    }
