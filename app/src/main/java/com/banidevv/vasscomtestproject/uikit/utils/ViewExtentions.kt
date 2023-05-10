package com.banidevv.vasscomtestproject.uikit.utils

import android.content.Context
import android.util.TypedValue
import java.text.NumberFormat

fun dpToPx(context: Context, dp: Float): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dp,
        context.resources.displayMetrics
    ).toInt()
}


fun spToPx(sp: Float, context: Context): Int {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_SP,
        sp,
        context.resources.displayMetrics
    ).toInt()
}

fun dpToSp(dp: Float, context: Context): Int {
    return (dpToPx(context, dp) / context.resources.displayMetrics.scaledDensity).toInt()
}

fun Int.toCurrency() : String {
    val format = NumberFormat.getCurrencyInstance()
    return format.format(this.toLong())
}
