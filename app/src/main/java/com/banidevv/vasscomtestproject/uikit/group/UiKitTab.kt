package com.banidevv.vasscomtestproject.uikit.group

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.forEachIndexed
import com.banidevv.vasscomtestproject.R
import com.banidevv.vasscomtestproject.databinding.UikitTabBinding
import com.banidevv.vasscomtestproject.uikit.utils.dpToPx
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel

class UiKitTab(context: Context, attrs: AttributeSet?) : LinearLayoutCompat(context, attrs) {

    private var binding : UikitTabBinding

    private val selectedTabShape = ShapeAppearanceModel()
        .toBuilder()
        .setAllCorners(CornerFamily.ROUNDED, dpToPx(context, 25f).toFloat())
        .build()

    private val verticalPadding = dpToPx(context, 5f)
    private val horizontalPadding = dpToPx(context, 17f)

    private var selectedIndex = 0
    private var tabTitles: Array<String> = emptyArray()

    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.UiKitTab)

        binding = UikitTabBinding.inflate(LayoutInflater.from(context), this, true)

        try {
            val tabsString = a.getResourceId(R.styleable.UiKitTab_tabs_string, -1)
            if (tabsString != -1) {
                tabTitles = resources.getStringArray(tabsString)
                setData()
            }

        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            a.recycle()
        }
    }

    private fun setData() {
        tabTitles.forEachIndexed { index, title ->
            val tab = AppCompatTextView(context)
            tab.text = title
            tab.setTextColor(ContextCompat.getColor(context, R.color.donker_100))

            tab.setOnClickListener {
                selectedIndex = index
                setTabView()
            }

            binding.layout.addView(tab)
        }

        setTabView()
    }

    private fun setTabView() {
        binding.layout.forEachIndexed { index, tab ->
            if (tab is AppCompatTextView) {
                if (selectedIndex == index) setSelected(tab)
                else setUnselected(tab)
            }
        }
    }

    private fun setSelected(view: AppCompatTextView) {
        view.setPadding(horizontalPadding, verticalPadding, horizontalPadding, verticalPadding)
        view.typeface = ResourcesCompat.getFont(context, R.font.proxima_nova_semi_bold)

        val drawable = MaterialShapeDrawable(selectedTabShape)
        drawable.fillColor = ContextCompat.getColorStateList(context, R.color.ocean_100)
        ViewCompat.setBackground(view, drawable)
    }

    private fun setUnselected(view: AppCompatTextView) {
        view.setPadding(horizontalPadding, verticalPadding, horizontalPadding, verticalPadding)
        view.typeface = ResourcesCompat.getFont(context, R.font.proxima_nova)

        val drawable = MaterialShapeDrawable(selectedTabShape)
        drawable.fillColor = ContextCompat.getColorStateList(context, android.R.color.transparent)
        ViewCompat.setBackground(view, drawable)
    }

}