package com.huang.junjie.dialoghelper

import android.app.Dialog
import android.app.ProgressDialog.show
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.huang.junjie.dialogcommon.dialog.BaseDialog
import com.huang.junjie.dialogcommon.popuppindow.BasePopupWindow
import kotlinx.android.synthetic.main.activity_main.*
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        click.setOnClickListener {
            var view: View = LayoutInflater.from(this).inflate(R.layout.bottom_list, null)

            var dialog: Dialog = BaseDialog.Builder(this)
                    .view(view)
                    .cancelTouchOut(true)
                    .gravity(Gravity.BOTTOM)
                    .heightPx(ViewGroup.LayoutParams.WRAP_CONTENT)
                    .widthPx(ViewGroup.LayoutParams.MATCH_PARENT)
                    .style(R.style.TransparentDialog)
                    .build()
                    .addListener(R.id.dismiss, {
                        Toast.makeText(this, "取消吧", Toast.LENGTH_LONG).show()
                    })
            dialog.show()

        }

//        hello_btn.setOnClickListener {
//            var view:View=LayoutInflater.from(this).inflate(R.layout.dialog_loading,null);
//            var popupWindow:BasePopupWindow=BasePopupWindow.Builder(this)
//                    .setContentView(view)
//                    .create();
//            popupWindow.showAsDropDown(hello_btn)
//        }
    }
}
