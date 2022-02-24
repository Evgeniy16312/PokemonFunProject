package com.example.pokemonfunproject.ui.home

import androidx.lifecycle.ViewModel
import com.example.domain.usecases.GetAllPokemonNamesUseCase
import com.example.domain.usecases.GetAllPokemonOfTypeUseCase
import com.example.domain.usecases.GetPokemonUseCase
import org.koin.core.KoinComponent

class HomeViewModel(
    private val getPokemonUseCase: GetPokemonUseCase,
    private val getAllPokemonOfTypeUseCase: GetAllPokemonOfTypeUseCase,
    private val getAllPokemonNamesUseCase: GetAllPokemonNamesUseCase
) : ViewModel(), KoinComponent {

}