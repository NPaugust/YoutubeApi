package com.example.youtubueapi.ui.video

import android.view.LayoutInflater
import com.example.youtubueapi.core.ui.BaseActivity
import com.example.youtubueapi.databinding.ActivityVideoBinding
import com.example.youtubueapi.ui.detail_playlist.DetailPlaylistActivity
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener


class VideoActivity : BaseActivity<ActivityVideoBinding>() {
    override fun inflateViewBinding(inflater: LayoutInflater): ActivityVideoBinding {
        return ActivityVideoBinding.inflate(layoutInflater)
    }

    override fun checkInternet() {

    }

    override fun initView() {
        val title = intent.getSerializableExtra(DetailPlaylistActivity.DPLA_VA_TITLE) as String
        val description = intent.getSerializableExtra(DetailPlaylistActivity.DPLA_VA_DESCRIPTION) as String
        val video = intent.getSerializableExtra(DetailPlaylistActivity.DPLA_VA_VIDEOID) as String

        binding.titleVideo.text = title
        binding.descriptionVideo.text = description

        lifecycle.addObserver(binding.playerVideo)

        binding.playerVideo.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(video, 0f)
            }
        })
    }

    override fun initObservers() {

    }

    override fun initListener() {

    }

}