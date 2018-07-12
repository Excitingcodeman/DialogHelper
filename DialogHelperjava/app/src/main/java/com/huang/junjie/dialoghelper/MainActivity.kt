package com.huang.junjie.dialoghelper

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.huang.junjie.dialogcommon.dialog.BaseDialog
import com.huang.junjie.dialogcommon.popuppindow.BasePopupWindow
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.hello_tv -> BaseDialog.Builder(this)
                    .view(R.layout.bottom_list)
                    .heightPx(ViewGroup.LayoutParams.MATCH_PARENT)
                    .widthPx(ViewGroup.LayoutParams.MATCH_PARENT)
                    .style(R.style.TransparentDialog)
                    .cancelTouchOut(true)
                    .build()
                    .addListener(R.id.dismiss, {
                        Toast.makeText(this, "取消了", Toast.LENGTH_SHORT).show()
                    })
                    .dismissListener(R.id.dismiss)
                    .show()
            R.id.hello_btn -> BasePopupWindow.Builder(this)
                    .setContentView(R.layout.dialog_loading)
                    .gravity(Gravity.CENTER)
                    .heightPx(ViewGroup.LayoutParams.WRAP_CONTENT)
                    .widthPx(ViewGroup.LayoutParams.WRAP_CONTENT)
                    .create().showAtLocation(this.window.decorView, Gravity.CENTER, 0, 0)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hello_btn.setOnClickListener(this)
        hello_tv.setOnClickListener(this)
    }
}
