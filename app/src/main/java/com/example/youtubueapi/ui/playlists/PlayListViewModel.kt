package com.example.youtubueapi.ui.playlists

import androidx.lifecycle.LiveData
import com.example.youtubueapi.core.ui.BaseViewModel
import com.example.youtubueapi.data.remote.model.PlayLists
import com.example.youtubueapi.repository.Repository

class PlayListViewModel(private val repository: Repository): BaseViewModel() {

    fun getPlayList(): LiveData<PlayLists?>{
        return repository.getPlayList()
    }



}

