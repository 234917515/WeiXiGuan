package gzr.weixiguan.com.util;

import com.orhanobut.logger.Logger;

import java.io.Closeable;
import java.io.IOException;

public class CloseUtil {
	private static final String TAG = "CloseUtil";
	private CloseUtil(){}
	public static void close(Closeable closeable){
		if (null != closeable) {
			try {
				closeable.close();
			} catch (IOException e) {
				Logger.e(e.toString());
			}
		}
	}
}
