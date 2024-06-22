package com.example.budget_buddy.presentation.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.budget_buddy.data.models.FinanceType
import com.example.budget_buddy.databinding.FinanceCardBinding
import com.example.budget_buddy.presentation.data.models.FinanceItemHomePresentation

class FinanceCardAdapter(val goToList: (type: FinanceType) -> Unit) : RecyclerView.Adapter<FinanceCardAdapter.FinanceCardViewHolder>() {

    var list: List<FinanceItemHomePresentation> = emptyList()
    private lateinit var context: Context
    private lateinit var binding: FinanceCardBinding

    fun setUpList(list: List<FinanceItemHomePresentation>) {
        this.list = list.filter { it.type != FinanceType.Unknown }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FinanceCardViewHolder {
        context = parent.context
        binding = FinanceCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FinanceCardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FinanceCardViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int = list.size

    inner class FinanceCardViewHolder(private val binding: FinanceCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(financeCard: FinanceItemHomePresentation) {
            try {
                binding.financeCard = financeCard
                binding.executePendingBindings()

                binding.root.setOnClickListener {
                    goToList(financeCard.type)
                }
            } catch (e: Exception) {
                Log.e("FinanceCardAdapter", "Error binding item: ${e.message}")
            }
        }
    }
}
