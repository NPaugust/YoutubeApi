package com.example.youtubueapi.di

import com.example.youtubueapi.core.network.networkModule
import org.koin.core.module.Module

val koinModules = listOf<Module>(
    repoModules,
    viewModules,
    networkModule
)