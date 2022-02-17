package com.example.data.di

import com.example.data.database.RoomPokemonDatabase
import com.example.data.database.RoomPokemonRepository
import com.example.domain.repository.RepositoryInterface
import org.koin.dsl.module
import com.example.data.repository.Repository
import com.example.domain.repository.RoomRepositoryInterface
import org.koin.android.ext.koin.androidApplication

val dataModule = module {

    factory<RepositoryInterface> { Repository() }

    factory<RoomRepositoryInterface>
    {
        RoomPokemonRepository(
            RoomPokemonDatabase.getDatabase(androidApplication()).roomPokemonDao()
        )
    }
}