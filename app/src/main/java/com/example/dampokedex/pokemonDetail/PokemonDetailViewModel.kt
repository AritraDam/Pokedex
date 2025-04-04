package com.example.dampokedex.pokemonDetail

import androidx.lifecycle.ViewModel
import com.example.dampokedex.data.remote.responses.Pokemon
import com.example.dampokedex.repository.PokemonRepository
import com.example.dampokedex.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel()  {
    suspend fun getPokemonInfo(pokemonName: String) : Resource<Pokemon> {
        return repository.getPokemonInfo(pokemonName)
    }
}