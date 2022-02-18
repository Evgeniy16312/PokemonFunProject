package com.example.pokemonfunproject.di

import com.example.pokemonfunproject.ui.favorites.FavoritesFragment
import com.example.pokemonfunproject.ui.favorites.FavoritesViewModel
import com.example.pokemonfunproject.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { HomeViewModel(get(), get(), get(), get(), get(), get()) }
    viewModel { FavoritesViewModel(get(),get(),get(),get())}
}