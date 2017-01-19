package gzr.weixiguan.com.weixiguan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import edittextfirework.FireworkView;

/**
 * Created by guoziren on 2017/1/18.
 */

public class LoginActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private FireworkView mFireworkView;
    private FireworkView mFireworkView2;
    private Button login;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        init();
    }
    private void init(){
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        mFireworkView = (FireworkView) findViewById(R.id.fireworkview);
       // mFireworkView2 = (FireworkView) findViewById(R.id.fireworkview2);

      //  fireworkView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        mFireworkView.bindEditText(username);
       // mFireworkView2.bindEditText(password);
    }
}
