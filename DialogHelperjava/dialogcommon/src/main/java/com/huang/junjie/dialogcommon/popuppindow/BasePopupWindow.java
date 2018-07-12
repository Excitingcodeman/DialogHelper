package com.huang.junjie.dialogcommon.popuppindow;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.huang.junjie.dialogcommon.utils.DensityUtil;

/**
 * @create 2018/7/11
 * @auther huang
 * @description
 */
public class BasePopupWindow extends PopupWindow {
    private View contentView;

    private BasePopupWindow(@NonNull Builder builder) {
        super(builder.context);
        init(builder);
    }

    private void init(@NonNull Builder builder) {
        contentView = builder.contentView;
        setContentView(contentView);

        if (builder.height <= 0) {
            setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        } else {
            setHeight(builder.height);
        }
        if (builder.width <= 0) {
            setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        } else {
            setWidth(builder.width);
        }
        /**
         * 设置背景只有设置了这个才可以点击外边和BACK消失
         */
        setBackgroundDrawable(new ColorDrawable());
        /**
         * 设置点击外边可以消失
         */
//        setOutsideTouchable(true);

        /**
         *设置可以触摸
         */
//        setTouchable(true);


        /**
         * 设置点击外部可以消失
         */

//        setTouchInterceptor(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//                /**
//                 * 判断是不是点击了外部
//                 */
//                if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
//                    return true;
//                }
//                //不是点击外部
//                return false;
//            }
//        });
    }

    /**
     * 添加点击事件
     *
     * @param id       视图里的id
     * @param listener 点击事件
     * @return
     */
    public BasePopupWindow addListener(int id, View.OnClickListener listener) {
        contentView.findViewById(id).setOnClickListener(listener);
        return this;
    }

    /**
     * dialog的消失事件
     *
     * @param id 控件id
     * @return
     */
    public BasePopupWindow dismissListener(int id) {
        contentView.findViewById(id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return this;
    }

    public static final class Builder {
        /*上下文  必传*/
        private Context context;

        private View contentView;

        private int height, width, gravity;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setContentView(View contentView) {
            this.contentView = contentView;
            return this;
        }

        public Builder heightPx(int val) {
            this.height = val;
            return this;
        }

        public Builder gravity(int val) {
            this.gravity = val;
            return this;
        }

        public Builder widthPx(int val) {
            this.width = val;
            return this;
        }

        public Builder heightDp(int val) {
            this.height = DensityUtil.dip2px(context, val);
            return this;
        }

        public Builder widthDp(int val) {
            this.width = DensityUtil.dip2px(context, val);
            return this;
        }

        public Builder setContentView(int res) {
            this.contentView = LayoutInflater.from(context).inflate(res, null);
            return this;
        }

        public BasePopupWindow create() {
            return new BasePopupWindow(this);
        }
    }
}
