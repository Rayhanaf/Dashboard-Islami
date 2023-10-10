package com.ryn.dashboardislami.idnsolo.doa.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ryn.dashboardislami.idnsolo.R
import com.ryn.dashboardislami.idnsolo.databinding.ActivityDetailListDoaBinding
import com.ryn.dashboardislami.idnsolo.doa.DetailDoaACtivity
import com.ryn.dashboardislami.idnsolo.doa.model.DoaModel
import java.security.PrivateKey

class DoaListAdapter(
    private val listDoa: ArrayList<DoaModel>,
    private val title: String,
    private val logo: Int
) : RecyclerView.Adapter<DoaListAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgDoa: ImageView = itemView.findViewById(R.id.imgDoa)
        var tvDoa: TextView = itemView.findViewById(R.id.tvDoa)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_doa, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listDoa.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val doa = listDoa[position]

        holder.tvDoa.text = doa.title
        Glide.with(holder.itemView.context)
            .load(logo)
            .into(holder.imgDoa)

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailDoaACtivity::class.java)
            intent.putExtra(DetailDoaACtivity.EXTRA_DOA, doa)
            it.context.startActivity(intent)
        }
    }
}