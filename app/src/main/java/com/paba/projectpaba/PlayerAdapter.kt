package com.paba.projectpaba

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlayerAdapter(private val playerList: List<String>, private val context: Context) :
    RecyclerView.Adapter<PlayerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewPlayer: TextView = itemView.findViewById(R.id.textViewPlayer)
        val imageViewYouTube: ImageView = itemView.findViewById(R.id.imageViewYouTube)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_player, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val player = playerList[position]
        holder.textViewPlayer.text = player

        holder.imageViewYouTube.setOnClickListener {
            openYouTubeVideo()
        }
    }

    override fun getItemCount(): Int {
        return playerList.size
    }

    private fun openYouTubeVideo() {
        val intentApp = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:@bwftv"))
        val intentWeb = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://www.youtube.com/@bwftv")
        )

        try {
            context.startActivity(intentApp)
        } catch (ex: Exception) {
            context.startActivity(intentWeb)
        }
    }
}
