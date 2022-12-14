package com.example.ecnuprevention.utilities;

import android.content.Context;

import com.example.ecnuprevention.MyApplication;

public class uDensityUtil {
    /**
     * 根据手机的分辨率从 dp(相对大小) 的单位 转成为 px(像素)
     */
    public static int dpToPx(float dpValue) {
        // 获取屏幕密度
        final float scale = MyApplication.getGlobalContext().getResources().getDisplayMetrics().density;
        // 结果+0.5是为了int取整时更接近
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp(相对大小)
     */
    public static int pxToDp(float pxValue) {
        final float scale = MyApplication.getGlobalContext().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
