package com.example.pokemonfunproject.ui.favorites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Pokemon
import com.example.domain.usecases.AddFavoritePokemonUseCase
import com.example.domain.usecases.DeleteFavoritePokemonUseCase
import com.example.domain.usecases.GetFavoritePokemonListUseCase
import com.example.domain.usecases.GetIsPokemonFavoriteUseCase
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent

class FavoritesViewModel(
    private val addFavoritePokemonUseCase: AddFavoritePokemonUseCase,
    private val deleteFavoritePokemonUseCase: DeleteFavoritePokemonUseCase,
    private val getFavoritePokemonListUseCase: GetFavoritePokemonListUseCase,
    private val getIsPokemonFavoriteUseCase: GetIsPokemonFavoriteUseCase,
) : ViewModel(), KoinComponent {

    private val _myFavoritePokemons: MutableLiveData<List<Pokemon>> = MutableLiveData()
    val myFavoritePokemons: LiveData<List<Pokemon>>
        get() = _myFavoritePokemons

    init {
        getFavoritePokemonList()
    }

    fun getFavoritePokemonList() {
        try {
            viewModelScope.launch {
                _myFavoritePokemons.value = getFavoritePokemonListUseCase.getFavoritePokemonList()
            }
        } catch (e: Exception) {
        }
    }

    fun addFavoritePokemon(pokemon: Pokemon) {
        viewModelScope.launch {
            addFavoritePokemonUseCase.addFavoritePokemon(pokemon)
            getFavoritePokemonList()
        }
    }

    fun deleteFavoritePokemon(pokemon: Pokemon) {
        viewModelScope.launch {
            deleteFavoritePokemonUseCase.deleteFavoritePokemon(pokemon)
            getFavoritePokemonList()
        }
    }

    fun isPokemonFavorite(id: Int): Boolean {
        return getIsPokemonFavoriteUseCase.isPokemonFavorite(id)
    }
}