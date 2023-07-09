package com.sample.fitpeo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sample.fitpeo.databinding.ActivityAlbumDetailsPageBinding
import com.squareup.picasso.Picasso

class AlbumDetailsPageActivity : AppCompatActivity() {
    lateinit var binding: ActivityAlbumDetailsPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlbumDetailsPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Picasso.get().load(intent.getStringExtra("image")).into(binding.albumImageView)
        binding.titleTextView.setText(intent.getStringExtra("title"))
    }
}