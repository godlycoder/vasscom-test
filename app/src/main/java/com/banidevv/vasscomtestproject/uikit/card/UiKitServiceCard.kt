package com.banidevv.vasscomtestproject.uikit.card

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.core.view.isVisible
import com.banidevv.vasscomtestproject.R
import com.banidevv.vasscomtestproject.databinding.UikitServiceCardBinding
import com.banidevv.vasscomtestproject.domain.uimodel.ProductUiModel
import com.banidevv.vasscomtestproject.domain.uimodel.ServiceUiModel
import com.banidevv.vasscomtestproject.uikit.utils.dpToPx
import com.banidevv.vasscomtestproject.uikit.utils.toCurrency
import com.bumptech.glide.Glide
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.ShapeAppearanceModel

class UiKitServiceCard(context: Context, attrs: AttributeSet? = null) : FrameLayout(context, attrs) {

    private val binding : UikitServiceCardBinding

    private val shape = ShapeAppearanceModel()
        .toBuilder()
        .setAllCorners(CornerFamily.ROUNDED, dpToPx(context, 16f).toFloat())
        .build()

    init {
        binding = UikitServiceCardBinding.inflate(LayoutInflater.from(context), this, true)
        binding.ivMain.shapeAppearanceModel = shape
    }

    fun setData(data: ServiceUiModel) {
        binding.apply {
            tvTitle.text = data.title
            tvPrice.text = resources.getString(R.string.price, data.price.toCurrency())
            tvHospital.text = data.hospitalName
            tvPlace.text = data.place

            Glide.with(context)
                .load(data.imageUrl)
                .into(ivMain)
        }
    }
}