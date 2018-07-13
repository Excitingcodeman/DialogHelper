package com.huang.junjie.dialogcommon.imagehelper;

import android.widget.ImageView;

import com.huang.junjie.dialogcommon.R;

/**
 * @create 2018/7/12
 * @auther huang
 * @description
 */
public class ImageLoader {
    /*类型 (大图，中图，小图)*/
    private int type;
    /*需要解析的url*/
    private String url;
    /*当没有成功加载的时候显示的图片*/
    private int placeHolder;
    /*ImageView的实例*/
    private ImageView imgView;
    /*加载策略，是否在wifi下才加载*/
    private int wifiStrategy;

    private ImageLoader(Builder builder) {
        this.type = builder.type;
        this.url = builder.url;
        this.placeHolder = builder.placeHolder;
        this.imgView = builder.imgView;
        this.wifiStrategy = builder.wifiStrategy;
    }

    public int getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public int getPlaceHolder() {
        return placeHolder;
    }

    public ImageView getImgView() {
        return imgView;
    }

    public int getWifiStrategy() {
        return wifiStrategy;
    }

    public static class Builder {
        private int type;
        private String url;
        private int placeHolder;
        private ImageView imgView;
        private int wifiStrategy;

        public Builder() {
            this.type = ImageConstant.PIC_SMALL;
            this.url = "";
            this.placeHolder = R.drawable.dialog_loading_img;
            this.imgView = null;
            this.wifiStrategy = ImageConstant.LOAD_STRATEGY_NORMAL;
        }

        public Builder type(int type) {
            this.type = type;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder placeHolder(int placeHolder) {
            this.placeHolder = placeHolder;
            return this;
        }

        public Builder imgView(ImageView imgView) {
            this.imgView = imgView;
            return this;
        }

        public Builder strategy(int strategy) {
            this.wifiStrategy = strategy;
            return this;
        }

        public ImageLoader build() {
            return new ImageLoader(this);
        }

    }
}
