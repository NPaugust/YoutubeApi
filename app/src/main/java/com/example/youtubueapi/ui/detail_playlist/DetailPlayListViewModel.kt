package com.example.youtubueapi.ui.detail_playlist

import androidx.lifecycle.LiveData
import com.example.youtubueapi.core.ui.BaseViewModel
import com.example.youtubueapi.data.remote.model.PlayListItems
import com.example.youtubueapi.repository.Repository

class DetailPlayListViewModel(private val repository: Repository): BaseViewModel() {

    fun getPlayListItems(id : String): LiveData<PlayListItems?> {
        return repository.getPlayListItems(id)
    }
}