package cn.test.mylibrary.utils;

/**
 * Created by xujixiao on 2016/2/4.20:46
 * 邮箱：1107313740@qq.com
 * 检测是否是快速点击
 */
public class CheckDoubleUtils {
    private static long lastClickTime;


    /**
     * 判断是否是快速点击
     * @return
     */
    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < 600) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

    /**
     * 判断是否是自定义时间的快速点击
     * @param overTime
     * @return
     */
    public static boolean isShortDoubleClick(int overTime) {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < overTime) {
            return true;
        }
        lastClickTime = time;
        return false;
    }


}
