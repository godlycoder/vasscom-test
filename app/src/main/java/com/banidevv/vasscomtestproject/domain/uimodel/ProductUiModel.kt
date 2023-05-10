package com.banidevv.vasscomtestproject.domain.uimodel

data class ProductUiModel(
    val title: String,
    val price: Int,
    val rating: Float,
    val imageUrl : String,
    val isReadyStock: Boolean = false
)
