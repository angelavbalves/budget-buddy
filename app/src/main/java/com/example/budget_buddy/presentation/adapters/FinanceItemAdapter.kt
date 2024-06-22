package com.example.budget_buddy.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.budget_buddy.databinding.FinanceListItemBinding
import com.example.budget_buddy.presentation.data.models.FinanceItemListPresentation

class FinanceItemAdapter : RecyclerView.Adapter<FinanceItemAdapter.FinanceItemViewHolder>() {

    private var list: List<FinanceItemListPresentation> = emptyList()
    private lateinit var context: Context

    fun setUpList(list: List<FinanceItemListPresentation>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FinanceItemViewHolder {
        context = parent.context
        val binding = FinanceListItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return FinanceItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FinanceItemViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class FinanceItemViewHolder(private val binding: FinanceListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: FinanceItemListPresentation) {
            binding.item = item
            binding.executePendingBindings()
        }
    }
}
