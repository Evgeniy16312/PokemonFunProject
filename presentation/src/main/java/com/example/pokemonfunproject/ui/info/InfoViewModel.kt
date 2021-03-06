package com.example.pokemonfunproject.ui.info

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Pokemon
import com.example.domain.usecases.AddFavoritePokemonUseCase
import com.example.domain.usecases.DeleteFavoritePokemonUseCase
import com.example.domain.usecases.GetIsPokemonFavoriteUseCase
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent

class InfoViewModel(
    private val addFavoritePokemonUseCase: AddFavoritePokemonUseCase,
    private val deleteFavoritePokemonUseCase: DeleteFavoritePokemonUseCase,
    private val getIsPokemonFavoriteUseCase: GetIsPokemonFavoriteUseCase
) : ViewModel(), KoinComponent {

    fun addFavoritePokemon(pokemon: Pokemon) {
        viewModelScope.launch {
            addFavoritePokemonUseCase.addFavoritePokemon(pokemon)
        }
    }

    fun deleteFavoritePokemon(pokemon: Pokemon) {
        viewModelScope.launch {
            deleteFavoritePokemonUseCase.deleteFavoritePokemon(pokemon)
        }
    }

    fun isPokemonFavorite(id: Int): Boolean {
        return getIsPokemonFavoriteUseCase.isPokemonFavorite(id)
    }
}