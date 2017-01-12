package gzr.weixiguan.com.weixiguan;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import cn.bmob.v3.Bmob;
import gzr.weixiguan.com.fragment.HabitFragment;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static  final  String APPLICATIONID = "6a005af95593a63a2b9f7f1fd202bde3";
    private FragmentManager mFragmentManager;
    private HabitFragment mHabitFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }
    private LinearLayout ll_discover;
    private void init(){
        //第一：默认初始化
        Bmob.initialize(this, APPLICATIONID);

        mHabitFragment = new HabitFragment();
        mFragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.content,mHabitFragment);
        fragmentTransaction.commit();


        ll_discover = (LinearLayout) findViewById(R.id.ll_discover);
        ll_discover.setOnClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if(id == R.id.action_add){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.ll_discover:
//                Person p2 = new Person();
//                p2.setName("lucky2");
//                p2.setAddress("广东广州");
//                p2.save(new SaveListener<String>() {
//                    @Override
//                    public void done(String objectId,BmobException e) {
//                        if(e==null){
//                            Logger.d("添加数据成功，返回objectId为："+objectId);
//                        }else{
//                            Logger.d("创建数据失败：" + e.getMessage());
//                        }
//                    }
//                });
                startActivity(new Intent(this,SearchActivity.class));
                break;
        }
    }
}
