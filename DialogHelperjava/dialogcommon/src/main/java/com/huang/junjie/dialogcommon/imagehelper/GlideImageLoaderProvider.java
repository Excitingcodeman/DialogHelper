package com.huang.junjie.dialogcommon.imagehelper;


import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.stream.StreamModelLoader;

import java.io.IOException;
import java.io.InputStream;


/**
 * @create 2018/7/12
 * @auther huang
 * @description  Glide的封装图片框架
 */
public class GlideImageLoaderProvider implements BaseImageLoaderStrategy {
    @Override
    public void loadImage(Context context, ImageLoader imageLoader) {

        int wifiStrategy = imageLoader.getWifiStrategy();
        if (wifiStrategy == ImageConstant.LOAD_STRATEGY_ONLY_WIFI) {
//如果是在wifi下才加载图片，并且当前网络是wifi,直接加载


            //如果是在wifi下才加载图片，并且当前网络不是wifi，加载缓存
        } else {
            loadNormal(context, imageLoader);
        }
    }


    private void loadNormal(Context context, ImageLoader imageLoader) {
        Glide.with(context)
                .load(imageLoader.getUrl())
                .placeholder(imageLoader.getPlaceHolder())
                .into(imageLoader.getImgView());
    }

    private void loadCache(Context context, ImageLoader imageLoader) {
        Glide.with(context).using(new StreamModelLoader<String>() {

            @Override
            public DataFetcher<InputStream> getResourceFetcher(final String model, int width, int height) {
                return new DataFetcher<InputStream>() {
                    @Override
                    public InputStream loadData(Priority priority) throws Exception {
                        throw new IOException();
                    }

                    @Override
                    public void cleanup() {

                    }

                    @Override
                    public String getId() {
                        return model;
                    }

                    @Override
                    public void cancel() {

                    }
                };
            }
        }).load(imageLoader.getUrl())
                .placeholder(imageLoader.getPlaceHolder())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageLoader.getImgView());
    }
}
