package com.banidevv.vasscomtestproject.uikit.group

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.banidevv.vasscomtestproject.R
import com.banidevv.vasscomtestproject.databinding.UikitAppBarBinding

class UiKitAppBar(context: Context, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {

    private val binding : UikitAppBarBinding

    private var onMenuClick : () -> Unit = {}

    init {
        binding = UikitAppBarBinding.inflate(LayoutInflater.from(context), this, true)
        binding.menu.setOnClickListener {
            onMenuClick.invoke()
        }
    }

    fun setOnMenuClickListener(onMenuClick : () -> Unit) {
        this.onMenuClick = onMenuClick
    }

}