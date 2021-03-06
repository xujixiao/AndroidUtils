package cn.test.mylibrary.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;

public class NetHelper {

    /**
     * 是否联网
     *
     * @param context
     * @return
     */

    public static boolean isConnectInternet(final Context context) {
        try {
            if (null != context) {
                ConnectivityManager manger = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                if (manger != null) {
                    NetworkInfo info = manger.getActiveNetworkInfo();
                    return (info != null && info.isConnected());
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    /**
     * 是否连接WiFi网络
     *
     * @param context
     * @return
     */

    public static boolean checkNetworkConnection(Context context) {
        if (null == context) {
            return false;
        }

        final ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (null != connMgr) {
            final NetworkInfo wifi = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

            if (null != wifi && wifi.isAvailable()) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * 判断GPS是否开启，GPS或者AGPS开启一个就认为是开启的（我们的应用要求GPS开启）
     * @param context
     * @return
     */

    public static final boolean isGPSOpen(final Context context) {

        try {
            if (null != context) {
                LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
                if (null != locationManager) {
                    // 通过GPS卫星定位，定位级别可以精确到街（通过24颗卫星定位，在室外和空旷的地方定位准确、速度快）
                    boolean gps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
                    // 通过WLAN或移动网络(3G/2G)确定的位置（也称作AGPS，辅助GPS定位。主要用于在室内或遮盖物（建筑群或茂密的深林等）密集的地方定位）
                    // boolean network = locationManager
                    // .isProviderEnabled(LocationManager.NETWORK_PROVIDER);
                    return gps;
                }
            }
        } catch (SecurityException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    /**
     * 进入定位服务设置页面
     *
     * @param context
     */
    public static final void openLocationService(Context context) {

        // 进入GPS设置页面
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try {
            context.startActivity(intent);

        } catch (ActivityNotFoundException ex) {

            // The Android SDK doc says that the location settings activity
            // may not be found. In that case show the general settings.

            // General settings activity
            intent.setAction(Settings.ACTION_SETTINGS);
            try {
                context.startActivity(intent);
            } catch (Exception e) {
            }
        }

    }
}
