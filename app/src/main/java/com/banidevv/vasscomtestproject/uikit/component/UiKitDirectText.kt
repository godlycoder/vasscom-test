package com.banidevv.vasscomtestproject.uikit.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.LinearLayoutCompat
import com.banidevv.vasscomtestproject.R
import com.banidevv.vasscomtestproject.databinding.UikitDirectTextBinding

class UiKitDirectText(context: Context, attrs: AttributeSet?) : LinearLayoutCompat(context, attrs) {

    private var binding : UikitDirectTextBinding

    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.UiKitDirectText)

        binding = UikitDirectTextBinding.inflate(LayoutInflater.from(context), this, true)

        try {
            binding.tvDesc.text = a.getString(R.styleable.UiKitDirectText_description)
            binding.tvAction.text = a.getString(R.styleable.UiKitDirectText_action_text)

        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            a.recycle()
        }
    }
}