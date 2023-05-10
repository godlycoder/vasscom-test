package com.banidevv.vasscomtestproject.uikit.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.banidevv.vasscomtestproject.R
import com.banidevv.vasscomtestproject.databinding.UikitDirectOptionBinding

class UiKitDirectOption(context: Context, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {

    private val binding : UikitDirectOptionBinding

    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.UiKitDirectOption)
        binding = UikitDirectOptionBinding.inflate(LayoutInflater.from(context), this, true)

        try {
            binding.tvTitle.text = a.getString(R.styleable.UiKitDirectOption_title)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            a.recycle()
        }
    }
}