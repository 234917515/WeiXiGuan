package gzr.weixiguan.com.weixiguan;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import gzr.weixiguan.com.adapter.SimpleFragmentPagerAdapter;
import gzr.weixiguan.com.fragment.EfficiencyFragment;
import gzr.weixiguan.com.fragment.FragmentFactory;
import gzr.weixiguan.com.fragment.HealthFragment;
import gzr.weixiguan.com.fragment.HotFragment;
import gzr.weixiguan.com.fragment.LearningFragment;
import gzr.weixiguan.com.fragment.SportFragment;
import gzr.weixiguan.com.fragment.ThinkingFragment;

/**
 * Created by guoziren on 2017/1/12.
 */

public class SearchActivity extends AppCompatActivity {
    private SimpleFragmentPagerAdapter pagerAdapter;

    private ViewPager viewPager;

    private TabLayout tabLayout;

    private List<Fragment> mFragmentList = new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.serarch_layout);
        Logger.d("onCreate: ");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
    }
    private void init(){
          mFragmentList.add(FragmentFactory.newInstance(HotFragment.class)) ;
          mFragmentList.add(FragmentFactory.newInstance(LearningFragment.class)) ;
          mFragmentList.add(FragmentFactory.newInstance(SportFragment.class)) ;
          mFragmentList.add(FragmentFactory.newInstance(EfficiencyFragment.class)) ;
          mFragmentList.add(FragmentFactory.newInstance(HealthFragment.class)) ;
          mFragmentList.add(FragmentFactory.newInstance(ThinkingFragment.class)) ;

        pagerAdapter = new SimpleFragmentPagerAdapter(getFragmentManager(), this ,mFragmentList);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(pagerAdapter);
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case android.R.id.home:
                this.finish();//真正实现回退功能的代码
            default:break;

        }
        return super.onOptionsItemSelected(item);
    }
}
