package com.banidevv.vasscomtestproject.page.adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.banidevv.vasscomtestproject.domain.uimodel.ProductUiModel
import com.banidevv.vasscomtestproject.uikit.card.UiKitProductCard

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    private var list : ArrayList<ProductUiModel>? = null

    class ProductViewHolder(private val card: UiKitProductCard) : ViewHolder(card) {
        fun bind(item : ProductUiModel) {
            card.setData(item)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductViewHolder {
        val view = UiKitProductCard(parent.context)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        list?.get(position)?.let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int = list?.size ?: 0



    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: ArrayList<ProductUiModel>) {
        this.list = list
        notifyDataSetChanged()
    }
}