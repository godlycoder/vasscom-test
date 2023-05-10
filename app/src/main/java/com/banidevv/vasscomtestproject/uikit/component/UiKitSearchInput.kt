package com.banidevv.vasscomtestproject.uikit.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.LinearLayoutCompat
import com.banidevv.vasscomtestproject.databinding.UikitSearchInputBinding

class UiKitSearchInput(context: Context, attrs: AttributeSet?) :
    LinearLayoutCompat(context, attrs) {

    private val binding : UikitSearchInputBinding

    init {
        binding = UikitSearchInputBinding.inflate(LayoutInflater.from(context), this, true)
    }
}