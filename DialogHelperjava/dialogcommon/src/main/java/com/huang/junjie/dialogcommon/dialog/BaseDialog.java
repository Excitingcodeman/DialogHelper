package com.huang.junjie.dialogcommon.dialog;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;


import com.huang.junjie.dialogcommon.R;
import com.huang.junjie.dialogcommon.utils.DensityUtil;
import com.huang.junjie.dialogcommon.utils.SystemBarTintManager;

/**
 * @create 2018/7/11
 * @auther huang
 * @description
 */
public class BaseDialog extends Dialog {
    private Context context;
    private int height, width, gravity;
    private boolean cancelTouchOut;
    private View view;
    private SystemBarTintManager manager;

    private BaseDialog(@NonNull Builder builder) {
        super(builder.context);
        init(builder);
    }

    private BaseDialog(@NonNull Builder builder, int themeResId) {
        super(builder.context, themeResId);
        init(builder);
    }


    private void init(@NonNull Builder builder) {
        this.context = builder.context;
        this.height = builder.height;
        this.width = builder.width;
        this.cancelTouchOut = builder.cancelTouchOut;
        this.view = builder.view;
        this.gravity = builder.gravity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window win = getWindow();
        WindowManager.LayoutParams lp = win.getAttributes();
        lp.gravity = gravity;
        lp.height = height;
        lp.width = width;
        win.setAttributes(lp);
        setContentView(view);
        setCanceledOnTouchOutside(cancelTouchOut);
    }

    private void initTintManager() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }
        manager = new SystemBarTintManager((Activity) context);
        manager.setStatusBarTintEnabled(true);
        manager.setNavigationBarTintEnabled(true);
        manager.setStatusBarTintResource(R.color.transparent);
    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean b) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (b) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    /**
     * 添加视图内控件的事件
     *
     * @param id       控件id
     * @param listener 点击事件
     *
     */
    public BaseDialog addListener(int id, View.OnClickListener listener) {
        view.findViewById(id).setOnClickListener(listener);
        return this;
    }

    /**
     * dialog的消失事件
     *
     * @param id 控件id
     * @return
     */
    public BaseDialog dismissListener(int id) {
        view.findViewById(id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return this;
    }

    public View getView() {
        return view;
    }

    public static final class Builder {

        private Context context;
        private int height, width, gravity;
        private boolean cancelTouchOut;
        private View view;
        private int resStyle = -1;


        public Builder(Context context) {
            this.context = context;
        }

        public Builder view(int resView) {
            view = LayoutInflater.from(context).inflate(resView, null);
            return this;
        }

        public Builder view(View resView) {
            view = resView;
            return this;
        }

        public Builder heightPx(int val) {
            height = val;
            return this;
        }

        public Builder gravity(int val) {
            gravity = val;
            return this;
        }

        public Builder widthPx(int val) {
            width = val;
            return this;
        }

        public Builder heightDp(int val) {
            height = DensityUtil.dip2px(context, val);
            return this;
        }

        public Builder widthDp(int val) {
            width = DensityUtil.dip2px(context, val);
            return this;
        }

        public Builder style(int resStyle) {
            this.resStyle = resStyle;
            return this;
        }

        public Builder cancelTouchOut(boolean val) {
            cancelTouchOut = val;
            return this;
        }


        public BaseDialog build() {
            if (resStyle != -1) {
                return new BaseDialog(this, resStyle);
            } else {
                return new BaseDialog(this, R.style.TransparentDialog);
            }
        }
    }


}
