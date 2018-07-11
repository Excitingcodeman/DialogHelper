package com.huang.junjie.dialogcommon.utils;

import android.content.Context;

/**
 * @create 2018/7/11
 * @auther huang
 * @description 尺寸转换工具
 */
public class DensityUtil {
    /**
     * 将dp值转换为px值
     *
     * @param context context
     * @param dpValue dpValue
     * @return
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 将px值转换为dp值
     *
     * @param context context
     * @param pxValue pxValue
     * @return
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /***
     * 将px值转换为sp值
     * @param context context
     * @param pxValue pxValue
     * @return
     */
    public static int px2sp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将sp值转换为px值
     *
     * @param context context
     * @param dpValue dpValue
     * @return
     */
    public static int sp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (dpValue * scale + 0.5f);
    }

}
