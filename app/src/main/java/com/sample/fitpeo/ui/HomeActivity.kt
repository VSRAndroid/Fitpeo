package com.sample.fitpeo.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.fitpeo.databinding.ActivityMainBinding
import com.sample.fitpeo.models.AlbumDataItem
import com.sample.fitpeo.utils.Constants
import com.sample.fitpeo.utils.CustomClickListener
import com.sample.fitpeo.viewmodels.AlbumViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity(), CustomClickListener {

    lateinit var albumViewModel:AlbumViewModel
    lateinit var binding: ActivityMainBinding
    var albumListData:List<AlbumDataItem>  = ArrayList()
    var customClickListener:CustomClickListener?= null
    //lateinit var
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        customClickListener = this
        fetchAlbumData()
    }

    private fun fetchAlbumData() {
        albumViewModel = ViewModelProvider(this).get(AlbumViewModel::class.java)
        albumViewModel.albumDataList.observe(this, Observer {
            albumListData = it
            Log.d(Constants.TAG,"Album Size "+albumListData.size)
            val linearLayoutManager : LinearLayoutManager = LinearLayoutManager(this)
            binding.albumRecyclerView.layoutManager = linearLayoutManager
            val albumAdapter = AlbumAdapter(albumListData, customClickListener)
            binding.albumRecyclerView.adapter = albumAdapter

        })
    }

    override fun albumItemClickListener(albumDataItem: AlbumDataItem) {
        val intent = Intent(applicationContext, AlbumDetailsPageActivity::class.java)
        intent.putExtra("title",albumDataItem.title)
        intent.putExtra("image",albumDataItem.url)
        startActivity(intent)
    }
}