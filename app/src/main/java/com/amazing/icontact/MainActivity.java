package com.amazing.icontact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;

import com.amazing.icontact.data.DataManager;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

//启动页面，用来放广告以及预加载数据
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_tab_layout) TabLayout viewTab;
    @BindView(R.id.main_view_pager) ViewPager2 viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataManager.getInstance().prepareContacts(this);
        Log.e("prepare", "contacts size is " + DataManager.getInstance().getContacts().size());


        ButterKnife.bind(this);
        initViews();
    }

    //初始化tab和列表
    private void initViews() {
        viewTab.addTab(viewTab.newTab().setText(R.string.tab_records));
        viewTab.addTab(viewTab.newTab().setText(R.string.tab_contacts));
        viewTab.addTab(viewTab.newTab().setText(R.string.tab_setting));


        
    }
}