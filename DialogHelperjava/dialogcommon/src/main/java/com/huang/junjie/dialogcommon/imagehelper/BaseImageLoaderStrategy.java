package com.huang.junjie.dialogcommon.imagehelper;

import android.content.Context;

/**
 * @create 2018/7/12
 * @auther huang
 * @description 公共接口  使用的图片加载框架  实现这个接口进行封装
 * 作者：安东尼_Anthony
 * 链接：https://www.jianshu.com/p/e26130a93289
 * 來源：简书
 * 简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。
 */
public interface BaseImageLoaderStrategy {
    void loadImage(Context context, ImageLoader imageLoader);

}
