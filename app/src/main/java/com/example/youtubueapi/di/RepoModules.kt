package com.example.youtubueapi.di

import com.example.youtubueapi.repository.Repository
import org.koin.core.module.Module
import org.koin.dsl.module

val repoModules: Module = module {
    single { Repository(get()) }
}