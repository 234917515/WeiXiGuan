package gzr.weixiguan.com.weixiguan;

import android.app.Application;

import com.orhanobut.logger.Logger;

/**
 * Created by guoziren on 2016/12/31.
 */

public class MyApplication extends Application {
    public static String TAG = "WX";
    @Override
    public void onCreate() {
        super.onCreate();
        Logger.init(TAG);
    }
}
