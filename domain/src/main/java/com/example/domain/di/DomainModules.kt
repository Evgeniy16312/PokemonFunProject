package com.example.domain.di

import com.example.domain.usecases.GetAllPokemonNamesUseCase
import com.example.domain.usecases.GetAllPokemonOfTypeUseCase
import com.example.domain.usecases.GetPokemonUseCase
import org.koin.dsl.module


val domainModule = module {
    factory { GetPokemonUseCase(get()) }
    factory { GetAllPokemonNamesUseCase(get()) }
    factory { GetAllPokemonOfTypeUseCase(get()) }
}