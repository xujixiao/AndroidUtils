package cn.test.mylibrary.utils;

import android.content.Context;
import android.content.Intent;

/**
 * Created by Administrator on 2017/10/10.
 */

public class BroadCastUtils {
    //发送广播
    public static void SendBroadCast(Context mContext, Class cla, String[] names, Object... param){
        Intent intent  = null;
        intent = new Intent(mContext,cla);
        for (int i = 0; i < param.length; i++) {
            if (param[i].getClass().equals(Integer.class)) {
                intent.putExtra(names[i], (Integer) param[i]);
            } else if (param[i].getClass().equals(String.class)) {
                intent.putExtra(names[i], (String) param[i]);
            } else if (param[i].getClass().equals(Boolean.class)) {
                intent.putExtra(names[i], (Boolean) param[i]);
            } else if (param[i].getClass().equals(Float.class)) {
                intent.putExtra(names[i], (Float) param[i]);
            } else if (param[i].getClass().equals(Double.class)) {
                intent.putExtra(names[i], (Double) param[i]);
            }
        }
        mContext.sendBroadcast(intent);
    }


    public static void SendBroadCast(Context mContext, Class cla) {
        Intent intent = null;
        intent = new Intent(mContext, cla);
        mContext.sendBroadcast(intent);
    }
}
