package com.banidevv.vasscomtestproject.uikit.component

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat
import com.banidevv.vasscomtestproject.R

class UiKitText(context: Context, attrs: AttributeSet? = null) : AppCompatTextView(context, attrs) {

    private var typeIndex: Int = 2

    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.UiKitText)

        try {
            typeIndex = a.getInt(R.styleable.UiKitText_fontType, 2)
            setFontType()

        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            a.recycle()
        }
    }

    private fun setFontType() {
        val type = when(typeIndex) {
            0 -> UiKitTextType.HEADER
            1 -> UiKitTextType.TITLE
            2 -> UiKitTextType.BODY
            3 -> UiKitTextType.CAPTION
            else -> UiKitTextType.SUBCAPTION
        }

        typeface = ResourcesCompat.getFont(context, type.fontFamily)
        setTextSize(TypedValue.COMPLEX_UNIT_SP, type.size)
    }

    private enum class UiKitTextType(
        val fontFamily: Int,
        val size: Float
    ) {
        HEADER(R.font.poppins_extra_bold, 28f),
        TITLE(R.font.poppins_semi_bold, 16f),
        BODY(R.font.proxima_nova_semi_bold, 14f),
        CAPTION(R.font.proxima_nova_semi_bold, 12f),
        SUBCAPTION(R.font.proxima_nova_light, 10f),
    }
}