package com.banidevv.vasscomtestproject.uikit.card

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.banidevv.vasscomtestproject.databinding.UikitHeaderCardBinding

class UiKitHeaderCard(context: Context, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {

    private val binding : UikitHeaderCardBinding

    init {
        binding = UikitHeaderCardBinding.inflate(android.view.LayoutInflater.from(context), this, true)
    }
}