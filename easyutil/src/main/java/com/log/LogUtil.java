package com.log;

import android.util.Log;

/**
 * @author：李佳模 ON：2020/11/2
 * description: log 日志工具类
 */
public class LogUtil {
    /**
     * 是否显示log
     */
    private static boolean ifShow = true;
    public static void setIfShow(boolean b) {
        ifShow = b;
    }

    public static void i(String string) {
        StackTraceElement[] s = Thread.currentThread().getStackTrace();
        String methodName = s[3].getMethodName();
        String fileName = s[3].getFileName();
        int lineNum = s[3].getLineNumber();
        if (ifShow) {
            Log.i(fileName, "methodName："+methodName +" lineNum:" +lineNum+" msg:" + string);
        }
    }

    public static void e(String string) {
        StackTraceElement[] s = Thread.currentThread().getStackTrace();
        String methodName = s[3].getMethodName();
        String fileName = s[3].getFileName();
        int lineNum = s[3].getLineNumber();
        if (ifShow) {
            Log.e(fileName, "methodName："+methodName +" lineNum:" +lineNum+" msg:" + string);
        }

    }
}
