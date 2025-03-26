package com.example.dampokedex.repository

import com.example.dampokedex.data.remote.PokeApi
import com.example.dampokedex.data.remote.responses.Pokemon
import com.example.dampokedex.data.remote.responses.PokemonList
import com.example.dampokedex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit,offset)
        } catch (e: Exception) {
            return Resource.Error("An Unknown Error occurred.")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("An Unknown Error occurred.")
        }
        return Resource.Success(response)
    }
}