package com.banidevv.vasscomtestproject.uikit.component

import android.content.Context
import android.util.AttributeSet
import androidx.core.content.res.ResourcesCompat
import com.banidevv.vasscomtestproject.R
import com.banidevv.vasscomtestproject.uikit.utils.dpToPx
import com.google.android.material.button.MaterialButton

class UiKitButton(context: Context, attrs: AttributeSet? = null) : MaterialButton(context, attrs) {

    private var typeIndex : Int = 0

    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.UiKitButton)

        try {
            isAllCaps = false

            typeIndex = a.getInt(R.styleable.UiKitButton_buttonType, 0)
            setRounded()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            a.recycle()
        }
    }

    fun setType(type: UiKitButtonType) {
        typeIndex = type.ordinal

        setRounded()
    }

    private fun setRounded() {
        val type = when(typeIndex) {
            1 -> UiKitButtonType.ROUNDED
            else -> UiKitButtonType.PRIMARY
        }
        cornerRadius = dpToPx(context, type.rounded)
        typeface = ResourcesCompat.getFont(context, type.fontFamily)
    }


    enum class UiKitButtonType(
        val fontFamily: Int,
        val rounded: Float
    ) {
        PRIMARY(R.font.poppins_semi_bold, 8f),
        ROUNDED(R.font.sf_pro_light, 23f)
    }
}