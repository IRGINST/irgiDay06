package com.example.irgiday06

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.irgiday06.databinding.ListBinding

class MobilAdapter(private val mList: List<Mobil>): RecyclerView.Adapter<MobilAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ListBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = mList.size

    @SuppressLint("DiscouragedApi")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(mList[position]) {
                binding.nama.text = this.nama
                binding.merk.text = this.merk
                binding.harga.text = this.harga
                val context = holder.itemView.context
                val resId = context.resources.getIdentifier(this.foto, "drawable", context.packageName)
                binding.foto.setImageResource(resId)

                holder.itemView.setOnClickListener {
                    val intent = Intent(it.context, DetailActivity::class.java)
                    intent.putExtra("nama", this.nama)
                    intent.putExtra("merk", this.merk)
                    intent.putExtra("harga", this.harga)
                    intent.putExtra("foto", resId)
                    it.context.startActivity(intent)
                }
            }
        }
    }
}

