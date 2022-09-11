package com.example.atmapp.utils

import android.text.TextUtils
import androidx.appcompat.widget.AppCompatEditText

//validate Empty Text
fun AppCompatEditText?.validateEmpty(): Boolean {
    val temp = (TextUtils.isEmpty(this?.text?.trim().toString()))
    if (temp) this?.requestFocus()
    return temp
}