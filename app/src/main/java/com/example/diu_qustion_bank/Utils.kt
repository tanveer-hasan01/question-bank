package com.example.diu_qustion_bank

import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar


object Utils {

    fun showToast(msg: String?, context: Context?) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    fun showSnackBar(msg: CharSequence?,view: View){

        val snackbar = Snackbar.make(view, msg!!,
            Snackbar.LENGTH_LONG).setAction("ok", null)
        snackbar.setActionTextColor(Color.WHITE)
        val snackbarView = snackbar.view
        snackbarView.setBackgroundColor( view.resources.getColor(R.color.success))
        val textView =
            snackbarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
        textView.setTextColor(Color.WHITE)
        snackbar.show()
    }

    fun showErrorSnackBar(msg: CharSequence?,view: View){

        val snackbar = Snackbar.make(view, msg!!,
            Snackbar.LENGTH_LONG).setAction("ok", null)
        snackbar.setActionTextColor(Color.WHITE)
        val snackbarView = snackbar.view
        snackbarView.setBackgroundColor( view.resources.getColor(R.color.error))
        val textView =
            snackbarView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
        textView.setTextColor(Color.WHITE)
        snackbar.show()
    }
}