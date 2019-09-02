package com.uesleiramos.extratobancario.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uesleiramos.extratobancario.R
import com.uesleiramos.extratobancario.model.Dados
import kotlinx.android.synthetic.main.details_item.view.*

class DetailsAdapter(val dados: List<Dados>) : RecyclerView.Adapter<DetailsAdapter.DetailsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.details_item, parent, false)
        return DetailsViewHolder(itemView)
    }

    override fun getItemCount() = dados.count()

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        holder.bindView(dados[position])
    }

    class DetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title = itemView.text_title
        private val desc = itemView.text_desc
        private val date = itemView.text_date
        private val value = itemView.text_value

        fun bindView(dados: Dados) {
            title.text = dados.title
            desc.text = dados.desc
            date.text = dados.date
            value.text = dados.value.toString()
        }
    }
}