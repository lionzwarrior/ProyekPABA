package com.paba.projectpaba

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class VideoAdapter (
    private val videoArrayList: ArrayList<Video>
) : RecyclerView.Adapter<VideoAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun openVideo(pos: Int)
        fun deleteVideo(pos: Int)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var _videoImage: ImageView = itemView.findViewById(R.id.video_image)
        var _videoTitle: TextView = itemView.findViewById(R.id.video_title)
        var _videoDescription: TextView = itemView.findViewById(R.id.video_description)
        var _deleteVideoButton: ImageView = itemView.findViewById(R.id.delete_video_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoAdapter.ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.video_item, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoAdapter.ListViewHolder, position: Int) {
        val video = videoArrayList[position]
        Picasso.get().load(video.image).placeholder(R.drawable.image).centerCrop().resize(150, 150)
            .into(holder._videoImage)
        holder._videoTitle.text = video.title
        holder._videoDescription.text = video.description

        holder._videoImage.setOnClickListener {
            onItemClickCallback.openVideo(position)
        }

        holder._videoTitle.setOnClickListener {
            onItemClickCallback.openVideo(position)
        }

        holder._videoDescription.setOnClickListener {
            onItemClickCallback.openVideo(position)
        }

        holder._deleteVideoButton.setOnClickListener {
            onItemClickCallback.deleteVideo(position)
        }
    }

    override fun getItemCount(): Int {
        return videoArrayList.size
    }
}