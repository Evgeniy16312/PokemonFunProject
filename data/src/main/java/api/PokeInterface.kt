package api

import api.Constants.Companion.GET_POKEMON
import api.Constants.Companion.GET_POKEMON_RESULT
import api.Constants.Companion.GET_POKEMON_TYPE_RESULT
import api.Constants.Companion.GET_SPECIES
import com.example.domain.model.Pokemon
import com.example.domain.model.PokemonResults
import com.example.domain.model.PokemonTypeResults
import com.example.domain.model.Species
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeInterface {
    @GET(GET_POKEMON)
    suspend fun getPokemon(
        @Path("id") id: Int,
    ): Pokemon

    @GET(GET_SPECIES)
    suspend fun getSpecies(
        @Path("id") id: Int,
    ): Species

    @GET(GET_POKEMON_RESULT)
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
    ): PokemonResults

    @GET(GET_POKEMON_TYPE_RESULT)
    suspend fun getPokemonTypeList(
        @Path("type") type: String,
    ): PokemonTypeResults
}