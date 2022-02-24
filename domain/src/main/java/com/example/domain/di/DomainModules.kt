package com.example.domain.di

import com.example.domain.usecases.*
import org.koin.dsl.module


val domainModule = module {
    factory { GetPokemonUseCase(get()) }
    factory { GetAllPokemonNamesUseCase(get()) }
    factory { GetAllPokemonOfTypeUseCase(get()) }
    factory { GetFavoritePokemonListUseCase(get()) }
    factory { AddFavoritePokemonUseCase(get()) }
    factory { DeleteFavoritePokemonUseCase(get()) }
    factory { GetIsPokemonFavoriteUseCase(get()) }
}