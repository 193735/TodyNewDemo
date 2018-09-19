package com.example.administrator.todynewdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {
    private ArrayList<News> data = new ArrayList<>();

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        ListView listView = view.findViewById(R.id.listview);
        viewadapter viewadapter = new viewadapter(getActivity(),data);
        listView.setAdapter(viewadapter);
        initData();
        return view;
    }

    private void initData() {

            News news1 = new News(R.mipmap.main_page_table_find_normal,R.mipmap.main_page_table_find_normal,R.mipmap.main_page_table_find_normal,"assda","dsasd",1);
            data.add(news1);
            News news2 = new News(R.mipmap.main_page_table_find_normal,R.mipmap.main_page_table_find_normal,R.mipmap.main_page_table_find_normal,"assda","dsasd",2);
            data.add(news2);
            News news3 = new News(R.mipmap.main_page_table_find_normal,R.mipmap.main_page_table_find_normal,R.mipmap.main_page_table_find_normal,"assda","dsasd",1);
            data.add(news3);
            News news4 = new News(R.mipmap.main_page_table_find_normal,R.mipmap.main_page_table_find_normal,R.mipmap.main_page_table_find_normal,"assda","dsasd",2);
            data.add(news4);
            News news5 = new News(R.mipmap.main_page_table_find_normal,R.mipmap.main_page_table_find_normal,R.mipmap.main_page_table_find_normal,"assda","dsasd",1);
            data.add(news5);
            News news6 = new News(R.mipmap.main_page_table_find_normal,R.mipmap.main_page_table_find_normal,R.mipmap.main_page_table_find_normal,"assda","dsasd",2);
           data.add(news6);


    }

}
