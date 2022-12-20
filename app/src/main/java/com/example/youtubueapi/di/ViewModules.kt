package com.example.youtubueapi.di

import com.example.youtubueapi.ui.detail_playlist.DetailPlayListViewModel
import com.example.youtubueapi.ui.playlists.PlayListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModules: Module = module {
    viewModel { PlayListViewModel(get()) }
    viewModel { DetailPlayListViewModel(get()) }
}