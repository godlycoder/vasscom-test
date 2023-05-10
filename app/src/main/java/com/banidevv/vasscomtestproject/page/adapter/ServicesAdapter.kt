package com.banidevv.vasscomtestproject.page.adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.banidevv.vasscomtestproject.domain.uimodel.ServiceUiModel
import com.banidevv.vasscomtestproject.uikit.card.UiKitServiceCard

class ServicesAdapter : RecyclerView.Adapter<ServicesAdapter.ServicesViewHolder>() {
    private var list : ArrayList<ServiceUiModel>? = null

    class ServicesViewHolder(private val card: UiKitServiceCard) : ViewHolder(card) {
        fun bind(item: ServiceUiModel) {
            card.setData(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicesViewHolder {
        val view = UiKitServiceCard(parent.context)
        return  ServicesViewHolder(view)
    }

    override fun getItemCount(): Int = list?.size ?: 0

    override fun onBindViewHolder(holder: ServicesViewHolder, position: Int) {
        list?.get(position)?.let {
            holder.bind(it)
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: ArrayList<ServiceUiModel>) {
        this.list = list
        notifyDataSetChanged()
    }
}