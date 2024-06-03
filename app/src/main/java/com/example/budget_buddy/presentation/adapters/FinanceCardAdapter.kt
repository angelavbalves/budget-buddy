package com.example.budget_buddy.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.budget_buddy.data.models.FinanceType
import com.example.budget_buddy.databinding.FinanceCardBinding
import com.example.budget_buddy.presentation.data.models.FinanceItemHomePresentation

class FinanceCardAdapter(
    val financeCards: List<FinanceItemHomePresentation>,
    val goToList: (type: FinanceType) -> Unit
) :
    RecyclerView.Adapter<FinanceCardAdapter.FinanceCardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FinanceCardViewHolder {
        val binding = FinanceCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FinanceCardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FinanceCardViewHolder, position: Int) {
        holder.bind(financeCards[position], type = financeCards[position].type)
    }

    override fun getItemCount(): Int = financeCards.size

    override fun getItemViewType(position: Int): Int = financeCards.size

    inner class FinanceCardViewHolder(private val binding: FinanceCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(financeCard: FinanceItemHomePresentation, type: FinanceType) {
            binding.financeCard = financeCard
            binding.executePendingBindings()

            binding.root.setOnClickListener {
                goToList(type)
            }
        }
    }
}
