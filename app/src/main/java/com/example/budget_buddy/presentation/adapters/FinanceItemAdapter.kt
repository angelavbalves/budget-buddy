package com.example.budget_buddy.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.budget_buddy.databinding.FinanceListItemBinding
import com.example.budget_buddy.presentation.data.models.FinanceItemListPresentation

class FinanceItemAdapter(
    private var items: List<FinanceItemListPresentation>
) : RecyclerView.Adapter<FinanceItemAdapter.FinanceItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FinanceItemViewHolder {
        val binding = FinanceListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FinanceItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FinanceItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class FinanceItemViewHolder(private val binding: FinanceListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: FinanceItemListPresentation) {
            binding.item = item
            binding.executePendingBindings()
        }
    }
}
