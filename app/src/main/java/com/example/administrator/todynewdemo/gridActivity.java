package com.example.administrator.todynewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class gridActivity extends AppCompatActivity {

    private static String[] topStr;


    private String[] bottomStr = new String[]{"@标题A1","@标题B2","@标题C3","@标题D4","@标题E5","@标题F6","@标题G7","@标题H8","@标题I9"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        Intent intent = new Intent();
         topStr =  intent.getStringArrayExtra("Title");
        final MyGridLayout gridtop = findViewById(R.id.gi_top);
        final MyGridLayout gridbutton = findViewById(R.id.gi_bottom);
        gridtop.setEnable(true);
        gridbutton.setEnable(false);
        //将以上两个不同的字符串添加在不同的MyGridLayout中
        gridtop.addItems(topStr);
        gridbutton.addItems(bottomStr);

        //给顶部的GridLayout内的每一个textView注册点击事件
        gridtop.setOnCustomerClick(new MyGridLayout.OnCustomerClick() {
            @Override
            public void cuotomerOnClick(TextView textView) {
                //参数中的textView就是点中的textView
                //点中顶部GridLayout中的textView，将顶部的textView删除，将删除的textView在底部的GridLayout中显示
                gridtop.removeView(textView);
                gridbutton.addItemView(textView.getText().toString());
            }
        });
        //给底部的GridLayout内的每一个textView注册点击事件
        gridbutton.setOnCustomerClick(new MyGridLayout.OnCustomerClick() {
            @Override
            public void cuotomerOnClick(TextView textView) {
                //参数中的textView就是点中的textView
                //如果是点中底部GridLayout中的textView，则相反
                gridbutton.removeView(textView);
               gridtop.addItemView(textView.getText().toString());
            }
        });
    }
}


