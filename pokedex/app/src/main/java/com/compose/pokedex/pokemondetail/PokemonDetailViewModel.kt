package com.compose.pokedex.pokemondetail

import androidx.lifecycle.ViewModel
import com.compose.pokedex.data.remote.responses.Pokemon
import com.compose.pokedex.repository.PokemonRepository
import com.compose.pokedex.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
): ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemonInfo(pokemonName)
    }
}