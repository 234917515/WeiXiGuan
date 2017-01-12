package gzr.weixiguan.com.myapplication;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        btn = (Button) findViewById(R.id.btn);
        //createColorlist();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Drawable ddd = getButtonRoundDrawable(Color.WHITE,Color.GRAY,10);
           RippleDrawable r = new RippleDrawable(createColorlist(Color.GRAY,Color.GRAY ),ddd,null);
            //r.setId(,android.R.id.mask);
            btn.setBackground(r);
        }
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private ColorStateList createColorlist(int color1,int color2) {
        int[][] statelist = new int[2][];
        statelist[0] = new int[]{};
        statelist[1] = new int[]{android.R.attr.state_pressed};
        int[] colors = new int[]{color2,Color.RED};
        return new ColorStateList(statelist,colors);
    }
    public  Drawable getButtonRoundDrawable(int bgColorNormal, int bgColorFocused, int corner) {
        // normal
        GradientDrawable bg = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{bgColorNormal, bgColorNormal});
        bg.setStroke(2, bgColorNormal);
        bg.setShape(GradientDrawable.RECTANGLE);
        bg.setCornerRadii(new float[]{corner, corner, corner, corner, corner, corner, corner, corner});

        // pressed
        GradientDrawable bg2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{bgColorFocused, bgColorFocused});
        bg2.setStroke(2, bgColorFocused);
        bg2.setShape(GradientDrawable.RECTANGLE);
        bg2.setCornerRadii(new float[]{corner, corner, corner, corner, corner, corner, corner, corner});



        // add drawables into statelist
        StateListDrawable states = new StateListDrawable();
        states.addState(new int[]{android.R.attr.state_pressed}, bg2);
       // states.addState(new int[]{android.R.attr.state_focused}, bg2);
        states.addState(new int[]{}, bg);

        return states;
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
        }

        return super.onOptionsItemSelected(item);
    }
}
