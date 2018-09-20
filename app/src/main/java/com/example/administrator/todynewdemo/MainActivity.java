package com.example.administrator.todynewdemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mChenys on 2016/5/28.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private ArrayList<Fragment> fragments = new ArrayList<>();
    ArrayList<String>mTitle = new ArrayList<>();

    TabLayout mTabLayout;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();

        RadioButton btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        RadioButton btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        RadioButton btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
        RadioButton btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(this);
        RadioButton btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(this);
        initFragment();
        replicefragment(fragments.get(0));

    }



    private void initFragment() {

        fragments.add(new Fragment1());//下标：1
        fragments.add(new Fragment2());//下标：0
        fragments.add(new  Fragment3());//下标: 2


    }
    private void replicefragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.vp_pager,fragment);
        transaction.addToBackStack(null);
        transaction.commit();


    }

    /**
     *  用来改变tabLayout选中后的字体大小及颜色
     * @param
     * @param
     */




    private void initData() {


            mTitle.add("关注");
            mTitle.add("推荐");
            mTitle.add("南京");
            mTitle.add("教育");
            mTitle.add("数码");
            mTitle.add("游戏");
            mTitle.add("视频");
            mTitle.add("热点");


    }

    private void initView() {
        mTabLayout =  findViewById(R.id.tl_tab);
        mViewPager =  findViewById(R.id.vp_pager);
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            //此方法用来显示tab上的名字
            @Override
            public CharSequence getPageTitle(int position) {

                return mTitle.get(position % mTitle.size());
            }

            @Override
            public Fragment getItem(int position) {
                //创建Fragment并返回
                TabFragment fragment = new TabFragment();

                return fragment;
            }

            @Override
            public int getCount() {
                return mTitle.size();
            }
        });
        //将ViewPager关联到TabLayout上
        mTabLayout.setupWithViewPager(mViewPager);

//  设置监听,注意:如果设置了setOnTabSelectedListener,则setupWithViewPager不会生效
//  因为setupWithViewPager内部也是通过设置该监听来触发ViewPager的切换的.


        /**
         *  用来改变tabLayout选中后的字体大小及颜色
         * @param tab
         * @param isSelect
         */

        }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R .id.btn1:
                replicefragment(fragments.get(0));
                break;
            case R.id.btn2:
                replicefragment(fragments.get(1));
                break;
            case R.id.btn3:
                replicefragment(fragments.get(2));
                break;
        }
    }


//  那我们如果真的需要监听tab的点击或者ViewPager的切换,则需要手动配置ViewPager的切换,例如:

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN)
        {


            finish();

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    }




