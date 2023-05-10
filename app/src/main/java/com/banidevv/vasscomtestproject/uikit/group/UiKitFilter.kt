package com.banidevv.vasscomtestproject.uikit.group

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.forEachIndexed
import com.banidevv.vasscomtestproject.R
import com.banidevv.vasscomtestproject.databinding.UikitFilterBinding
import com.banidevv.vasscomtestproject.uikit.utils.dpToPx
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.MaterialShapeDrawable.SHADOW_COMPAT_MODE_ALWAYS
import com.google.android.material.shape.ShapeAppearanceModel

class UiKitFilter(context: Context, attrs: AttributeSet?) : LinearLayoutCompat(context, attrs) {

    private val binding: UikitFilterBinding

    private val selectedTabShape = ShapeAppearanceModel()
        .toBuilder()
        .setAllCorners(CornerFamily.ROUNDED, dpToPx(context, 25f).toFloat())
        .build()

    private val verticalPadding = dpToPx(context, 7f)
    private val horizontalPadding = dpToPx(context, 25f)

    private var selectedIndex = 0
    private var buttonTitles: Array<String> = emptyArray()

    private val params = LayoutParams(WRAP_CONTENT, WRAP_CONTENT).apply {
        setMargins(0, 0, dpToPx(context, 20f), 0)
    }

    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.UiKitFilter)

        binding = UikitFilterBinding.inflate(LayoutInflater.from(context), this, true)

        try {
            val tabsString = a.getResourceId(R.styleable.UiKitFilter_buttons_string, -1)
            if (tabsString != -1) {
                buttonTitles = resources.getStringArray(tabsString)
                setData()
            }

        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            a.recycle()
        }
    }

    private fun setData() {
        buttonTitles.forEachIndexed { index, title ->
            val tab = AppCompatTextView(context)
            tab.text = title

            tab.setOnClickListener {
                selectedIndex = index
                setTabView()
            }

            tab.layoutParams = params
            binding.root.addView(tab)
        }

        setTabView()
    }

    private fun setTabView() {
        binding.root.forEachIndexed { index, tab ->
            if (tab is AppCompatTextView) {
                if (selectedIndex == index) setSelected(tab)
                else setUnselected(tab)
            }
        }
    }

    private fun setSelected(view: AppCompatTextView) {
        view.setPadding(horizontalPadding, verticalPadding, horizontalPadding, verticalPadding)
        view.typeface = ResourcesCompat.getFont(context, R.font.proxima_nova_semi_bold)
        view.setTextColor(ContextCompat.getColor(context, android.R.color.white))

        val drawable = MaterialShapeDrawable(selectedTabShape)
        drawable.shadowCompatibilityMode = SHADOW_COMPAT_MODE_ALWAYS
        drawable.setShadowColor(R.color.text_gray_50)
        drawable.elevation = dpToPx(context, 16f).toFloat()

        drawable.fillColor = ContextCompat.getColorStateList(context, R.color.donker_100)
        ViewCompat.setBackground(view, drawable)
    }

    private fun setUnselected(view: AppCompatTextView) {
        view.setPadding(horizontalPadding, verticalPadding, horizontalPadding, verticalPadding)
        view.typeface = ResourcesCompat.getFont(context, R.font.proxima_nova)
        view.setTextColor(ContextCompat.getColor(context, R.color.donker_100))

        val drawable = MaterialShapeDrawable(selectedTabShape)
        drawable.shadowCompatibilityMode = SHADOW_COMPAT_MODE_ALWAYS
        drawable.setShadowColor(R.color.text_gray_50)
        drawable.elevation = dpToPx(context, 16f).toFloat()
        drawable.fillColor = ContextCompat.getColorStateList(context, android.R.color.white)

        ViewCompat.setBackground(view, drawable)
    }
}