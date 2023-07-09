package com.sample.fitpeo.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sample.fitpeo.R
import com.sample.fitpeo.databinding.AlbumItemLayoutBinding
import com.sample.fitpeo.models.AlbumDataItem
import com.sample.fitpeo.utils.CustomClickListener
import com.squareup.picasso.Picasso

class AlbumAdapter(var albumDataList: List<AlbumDataItem>,
                   val customClickListener: CustomClickListener?):
                   RecyclerView.Adapter<AlbumAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemRowBinding : AlbumItemLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.album_item_layout, parent,false)
            return MyViewHolder(itemRowBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val appointmentEntity: AlbumDataItem = albumDataList.get(position)
        holder.bind(appointmentEntity)
        holder.albumItemLayoutBinding.clickListener = customClickListener
    }

    override fun getItemCount(): Int {
        return  albumDataList.size
    }

    class MyViewHolder(albumItemLayoutBinding: AlbumItemLayoutBinding) :
        RecyclerView.ViewHolder(albumItemLayoutBinding.getRoot()) {

        var albumItemLayoutBinding: AlbumItemLayoutBinding

        init {
            this.albumItemLayoutBinding = albumItemLayoutBinding
        }

        fun bind(albumDataItem: AlbumDataItem) {
            albumItemLayoutBinding.albumDataItem = albumDataItem
            Picasso.get()
                .load(albumDataItem.thumbnailUrl)
                .into(albumItemLayoutBinding.albumImageView)

        }
    }
}