package com.paba.projectpaba

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapterPlayer (
    private val listPlayer: ArrayList<player>
): RecyclerView.Adapter<adapterPlayer.ListViewHolder> (){

    private lateinit var onItemClickCallback : OnItemClickCallback

    interface OnItemClickCallback {
       fun onItemClicked(data : player)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }


    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var _namaPlayer : TextView = itemView.findViewById(R.id.namaPlayer)
        var _detPlayer : TextView = itemView.findViewById(R.id.detPlayer)
        var _fotoPlayer : ImageView = itemView.findViewById(R.id.fotoPlayer)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view : View = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemplayer, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listPlayer.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        var player = listPlayer[position]

        holder._namaPlayer.setText(player.nama)
        holder._detPlayer.setText(player.detail)
        holder._fotoPlayer.setImageResource(player.foto)

        holder._fotoPlayer.setOnClickListener{
            onItemClickCallback.onItemClicked((listPlayer[position]))
        }
    }

}