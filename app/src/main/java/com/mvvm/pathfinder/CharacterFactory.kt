package com.mvvm.pathfinder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CharacterFactory(private val character: Character): ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T: ViewModel?> create(characterClass: Class<T>): T {
        val viewModel = CharacterViewModel(character)
        @Suppress("UNCHECKED_CAST")
        return viewModel as T
    }
}