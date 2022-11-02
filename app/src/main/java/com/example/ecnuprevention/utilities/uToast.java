package com.example.ecnuprevention.utilities;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.example.ecnuprevention.MyApplication;

public class uToast {
    private static Toast toast;
    public static void show(String str) {
        if(toast != null) {
            toast.cancel();
            toast = null;
        }
        try {
            toast = Toast.makeText(MyApplication.getGlobalContext(), str, Toast.LENGTH_LONG);
            toast.show();
        } catch (Exception e) {
            new Handler(Looper.getMainLooper())
                    .post(new Runnable() {
                        @Override
                        public void run() {
                            toast = Toast.makeText(MyApplication.getGlobalContext(), str, Toast.LENGTH_LONG);
                            toast.show();
                        }
                    });
        }

    }
    public static void networkError() {
        show("网络连接出错");
    }
    public static void serviceFailed() {
        show("服务不可用");
    }
    public static void operationSucceeded() {
        show("操作成功");
    }
    public static void wrongUsernameOrPassword() {
        show("用户名或密码错误");
    }
    public static void unauthorized() {
        show("未授权，请登录");
    }
}
