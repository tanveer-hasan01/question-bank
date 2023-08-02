package com.example.diu_qustion_bank

import android.content.Context
import android.widget.Toast


 public object  Utils {

  public final  fun showToast(msg: String?, ctx: Context?) {
        Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show()
    }
}