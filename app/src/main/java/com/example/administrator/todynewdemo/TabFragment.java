package com.example.administrator.todynewdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */



import android.util.TypedValue;
import android.view.Gravity;

import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mChenys on 2016/5/28.
 */
public class TabFragment extends Fragment {
    private ArrayList<News> data = new ArrayList<>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tabfragment, container, false);
        ListView listView = view.findViewById(R.id.listview);
        viewadapter viewadapter = new viewadapter(getActivity(),data);
        listView.setAdapter(viewadapter);
        initData();
        return view;

    }
    private void initData() {
         for(int i = 0;i<3;i++){
            News news1 = new News(R.mipmap.pic, R.mipmap.pic, R.mipmap.pic, "[独家V观] 习近平致贺首个中国农民丰收节", "央视新闻移动网", 2);
            data.add(news1);
            News news2 = new News(R.mipmap.pic, R.mipmap.pic, R.mipmap.pic, "[独家V观] 习近平致贺首个中国农民丰收节", "央视新闻移动网", 1);
            data.add(news2);
            News news3 = new News(R.mipmap.pic, R.mipmap.pic, R.mipmap.pic, "[独家V观] 习近平致贺首个中国农民丰收节", "央视新闻移动网", 0);
            data.add(news3);
         }
     }

 }
