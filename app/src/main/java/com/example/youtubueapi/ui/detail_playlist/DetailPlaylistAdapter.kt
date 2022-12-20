package com.example.youtubueapi.ui.detail_playlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.youtubueapi.data.remote.model.ItemsPLI
import com.example.youtubueapi.databinding.ItemDetailPlaylistBinding

class DetailPlaylistAdapter(
    val list: ArrayList<ItemsPLI>,
    private val clickListener: (video: String, title: String, description: String) -> Unit
) : RecyclerView.Adapter<DetailPlaylistAdapter.DetailPlayListViewHolder>() {

    inner class DetailPlayListViewHolder(val binding: ItemDetailPlaylistBinding)
        :RecyclerView.ViewHolder(binding.root){
        fun onBind(item : ItemsPLI){
         binding.tvDetailPlaylistName.text = item.snippet.title
         binding.imgDetailPlaylist.load(item.snippet.thumbnails.standard.url)
            itemView.setOnClickListener {
                clickListener(item.snippet.resourceId.videoId,item.snippet.title, item.snippet.description)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailPlayListViewHolder {
        return DetailPlayListViewHolder(
            ItemDetailPlaylistBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DetailPlayListViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount() = list.size
}