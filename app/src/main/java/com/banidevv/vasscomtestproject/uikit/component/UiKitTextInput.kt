package com.banidevv.vasscomtestproject.uikit.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.LinearLayoutCompat
import com.banidevv.vasscomtestproject.R
import com.banidevv.vasscomtestproject.databinding.UikitTextInputBinding
import com.google.android.material.textfield.TextInputLayout

class UiKitTextInput(context: Context, attrs: AttributeSet?) : LinearLayoutCompat(context, attrs) {

    private var binding : UikitTextInputBinding

    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.UiKitTextInput)

        binding = UikitTextInputBinding.inflate(LayoutInflater.from(context), this, true)

        try {
            binding.etMain.hint = a.getString(R.styleable.UiKitTextInput_android_hint)
            binding.tvTitle.text = a.getString(R.styleable.UiKitTextInput_title)

            val isPasswordMode = a.getBoolean(R.styleable.UiKitTextInput_passwordToggleEnabled, false)

            if (isPasswordMode) {
                binding.etLayout.endIconMode = TextInputLayout.END_ICON_PASSWORD_TOGGLE
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            a.recycle()
        }
    }
}