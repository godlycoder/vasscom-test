package com.banidevv.vasscomtestproject.uikit.card

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.banidevv.vasscomtestproject.R
import com.banidevv.vasscomtestproject.databinding.UikitProductCardBinding
import com.banidevv.vasscomtestproject.domain.uimodel.ProductUiModel
import com.banidevv.vasscomtestproject.uikit.utils.dpToPx
import com.banidevv.vasscomtestproject.uikit.utils.toCurrency
import com.bumptech.glide.Glide
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel

class UiKitProductCard(context: Context, attrs: AttributeSet? = null) : FrameLayout(context, attrs) {

    private val binding : UikitProductCardBinding

    private val labelShape = ShapeAppearanceModel()
        .toBuilder()
        .setAllCorners(CornerFamily.ROUNDED, dpToPx(context, 4f).toFloat())
        .build()

    private val drawable = MaterialShapeDrawable(labelShape).apply {
        fillColor = ContextCompat.getColorStateList(context, R.color.green_30)
    }

    init {
        binding = UikitProductCardBinding.inflate(LayoutInflater.from(context), this, true)
        binding.tvLabel.background = drawable
    }

    fun setData(data: ProductUiModel) {
        binding.apply {
            tvTitle.text = data.title
            tvPrice.text = resources.getString(R.string.price, data.price.toCurrency())
            tvRating.text = data.rating.toString()
            tvLabel.isVisible = data.isReadyStock

            Glide.with(context)
                .load(data.imageUrl)
                .into(ivMain)
        }
    }

}