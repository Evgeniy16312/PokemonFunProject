package com.example.domain.usecases

import com.example.domain.model.PokemonResults
import com.example.domain.repository.RepositoryInterface

class GetAllPokemonNamesUseCase(private val repositoryInterface: RepositoryInterface) {
    suspend fun getAllPokemonNames(limit: Int): PokemonResults =
        repositoryInterface.getPokemonList(limit)
}