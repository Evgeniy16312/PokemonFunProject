package com.example.domain.usecases

import com.example.domain.model.FlavorTextEntry
import com.example.domain.model.Genera
import com.example.domain.model.Pokemon
import com.example.domain.repository.RepositoryInterface

class GetPokemonUseCase(private val repositoryInterface: RepositoryInterface) {

    suspend fun getPokemon(id: Int): Pokemon {
        val pokemon = repositoryInterface.getPokemon(id)
        val species = repositoryInterface.getSpecies(id)
        pokemon.genera = getPokemonGenera(species.genera)
        pokemon.description = getPokemonDescription(species.flavor_text_entries)
        pokemon.capture_rate = species.capture_rate
        return pokemon
    }

    private fun getPokemonDescription(flavorTextEntries: List<FlavorTextEntry>): String {
        var index = flavorTextEntries.size - 1
        while (flavorTextEntries[index].language.name != "en") {
            index--
        }
        var flavorText = flavorTextEntries[index].flavor_text
        flavorText = flavorText.replace("POKéMON", "Pokémon")
        flavorText = flavorText.replace("\n", " ")
        return flavorText
    }

    private fun getPokemonGenera(genera: List<Genera>?): String {
        var index = 0
        while (genera?.get(index)?.language?.name != "en") {
            index++
        }
        return genera[index].genus
    }
}