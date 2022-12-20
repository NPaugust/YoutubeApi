package com.example.youtubueapi.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.youtubueapi.BuildConfig
import com.example.youtubueapi.data.remote.ApiService
import com.example.youtubueapi.data.remote.model.PlayListItems
import com.example.youtubueapi.data.remote.model.PlayLists
import kotlinx.coroutines.Dispatchers

class Repository(private val apiService: ApiService) {

    fun getPlayList(): LiveData<PlayLists?> {
        return liveData(Dispatchers.IO) {
            val response = apiService.getPlayList(
                "snippet,contentDetails",
                "UC8M5YVWQan_3Elm-URehz9w",
                BuildConfig.API_KEY,
                10
            )
            if (response.isSuccessful) {
                emit(response.body())
            }
        }
    }

    fun getPlayListItems(id: String): LiveData<PlayListItems?>{
        return liveData(Dispatchers.IO){
            val response = apiService.getPlayListItems(
                part = "snippet",
                playlistId = id,
                BuildConfig.API_KEY
            )
            if (response.isSuccessful){
                emit(response.body())
            }
        }
    }
}

