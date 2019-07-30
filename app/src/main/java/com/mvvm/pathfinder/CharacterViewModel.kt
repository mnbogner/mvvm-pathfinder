package com.mvvm.pathfinder

import androidx.lifecycle.ViewModel

class CharacterViewModel(private val characterRepository: CharacterRepository)
    : ViewModel() {

    // wrap repo functions
    fun modifyStr(modifier: Int) {
        characterRepository.modifyStr(modifier)
    }

    fun getCharacter() = characterRepository.getCharacter()
}