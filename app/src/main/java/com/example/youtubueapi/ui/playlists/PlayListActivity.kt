package com.example.youtubueapi.ui.playlists

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.view.LayoutInflater
import androidx.core.view.isVisible
import com.example.youtubueapi.core.ui.BaseActivity
import com.example.youtubueapi.core.utils.CheckInternetConnection
import com.example.youtubueapi.data.remote.model.Items
import com.example.youtubueapi.databinding.ActivityPlaylistBinding
import com.example.youtubueapi.ui.detail_playlist.DetailPlaylistActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class PlayListActivity : BaseActivity<ActivityPlaylistBinding>() {

    private val viewModel: PlayListViewModel by viewModel()

    lateinit var adapter: PlaylistsAdapter
    override fun checkInternet() {
        CheckInternetConnection((getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager))
            .observe(this) {
                binding.includedInternet.constInternet.isVisible = !it
                binding.recyclerPlaylists.isVisible = it

                if (it == true) {
                    initObservers()
                }
            }
    }

    override fun initView() {
    }

    override fun initObservers() {

        viewModel.getPlayList().observe(this) {
            if (it != null) {
                adapter = PlaylistsAdapter(it.items as ArrayList<Items>, this::clickListener)
            }
            binding.recyclerPlaylists.adapter = adapter
        }


    }

    private fun clickListener(id: String, title: String) {
        val intent = Intent(this, DetailPlaylistActivity::class.java)
        intent.putExtra(PLA_DPLA_ID, id)
        intent.putExtra(PLA_DPLA_TITLE, title)
        startActivity(intent)
    }

    override fun initListener() {

    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityPlaylistBinding {
        return ActivityPlaylistBinding.inflate(layoutInflater)
    }

    companion object {
        const val PLA_DPLA_ID = "pladplaid"
        const val PLA_DPLA_TITLE = "pladplatitle"
    }


}