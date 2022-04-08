package com.whmh.pushService.netty.utils;

/**
 * 消息日志log
 */
public class LogUtils {

    public static String format(final String fmt, Object... params) {
        String f;
        if (params != null) {
            f = String.format(fmt, params);
        } else {
            f = fmt;
        }

        return f;
    }
}
