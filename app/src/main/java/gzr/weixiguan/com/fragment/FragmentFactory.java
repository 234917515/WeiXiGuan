package gzr.weixiguan.com.fragment;

import android.app.Fragment;

/**
 * Created by guoziren on 2017/1/17.
 */

public class FragmentFactory {
    public static <T extends Fragment>  T newInstance(Class<T> clz){
        Fragment f = null;
        try {
            f = (Fragment) Class.forName(clz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T) f;
    }
}
