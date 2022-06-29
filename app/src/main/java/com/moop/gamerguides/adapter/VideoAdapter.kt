package com.moop.gamerguides.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.android.material.imageview.ShapeableImageView
import com.moop.gamerguides.R
import com.moop.gamerguides.adapter.model.Videos
import com.squareup.picasso.Picasso

class VideoAdapter(options: FirebaseRecyclerOptions<Videos>) :
    FirebaseRecyclerAdapter<Videos, VideoAdapter.ViewHolder>(options) {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val videoTitle: TextView = itemView.findViewById(R.id.video_title)
        val videoImage: ShapeableImageView = itemView.findViewById(R.id.video_image)
        val videoLayout: CardView = itemView.findViewById(R.id.item_video_container)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_video, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, model: Videos) {
        // set video title
        holder.videoTitle.text = model.title

        // set video image
        if (model.image == "") {
            holder.videoImage.setImageResource(R.drawable.gamerguides_logo)
        }
        else {
            Picasso.get()
                .load(model.image)
                .into(holder.videoImage)
        }
    }
}