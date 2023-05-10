package com.banidevv.vasscomtestproject.uikit.card

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import com.banidevv.vasscomtestproject.R
import com.banidevv.vasscomtestproject.databinding.UikitPosterCardBinding
import com.banidevv.vasscomtestproject.uikit.utils.dpToPx


class UiKitPosterCard(context: Context, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {

    private val binding : UikitPosterCardBinding

    private val params = FrameLayout.LayoutParams(
        ViewGroup.LayoutParams.WRAP_CONTENT,
        ViewGroup.LayoutParams.WRAP_CONTENT
    )

    private val constraintSet = ConstraintSet()

    private var directionIndex : Int = 0
    private var title : String = ""
    private var description : String = ""
    private var actionTitle : String = ""

    private var imageRes : Int = R.drawable.ilus_services

    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.UiKitPosterCard)

        binding = UikitPosterCardBinding.inflate(LayoutInflater.from(context), this, true)
        constraintSet.clone(binding.root)

        try {
            directionIndex = a.getInt(R.styleable.UiKitPosterCard_direction, 0)
            title = a.getString(R.styleable.UiKitPosterCard_title) ?: ""
            description = a.getString(R.styleable.UiKitPosterCard_description) ?: ""
            actionTitle = a.getString(R.styleable.UiKitPosterCard_actionTitle) ?: ""
            imageRes = a.getResourceId(R.styleable.UiKitPosterCard_android_src, R.drawable.ilus_services)

            setupView()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            a.recycle()
        }

    }

    private fun setupView() {
        when (directionIndex) {
            0 -> setLtr()
            1 -> setRtl()
        }

        binding.apply {
            tvTitle.text = title
            tvDescription.text = description
            tvAction.text = actionTitle
            ivIlus.setImageDrawable(ContextCompat.getDrawable(context, imageRes))
        }
    }

    private fun setLtr() {
        params.setMargins(0, 0, dpToPx(context, 150f), 0)
        binding.ltDesc.layoutParams = params

        constraintSet.connect(
            binding.ivIlus.id, ConstraintSet.END,
            binding.card.id,
            ConstraintSet.END,
            dpToPx(context, 18f)
        )
        constraintSet.applyTo(binding.root)
    }

    private fun setRtl() {
        params.setMargins(dpToPx(context, 150f), 0, 0, 0)
        binding.ltDesc.layoutParams = params

        constraintSet.clear(binding.ivIlus.id, ConstraintSet.END)
        constraintSet.connect(
            binding.ivIlus.id, ConstraintSet.START,
            binding.card.id, ConstraintSet.START,
            dpToPx(context, 18f)
        )
        constraintSet.applyTo(binding.root)
    }
}