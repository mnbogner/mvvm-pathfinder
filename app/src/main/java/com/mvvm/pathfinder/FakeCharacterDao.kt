package com.mvvm.pathfinder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeCharacterDao {

    // data, replace with actual db
    private val characterData = Character("John Doe")

    // observable
    private val characterLiveData = MutableLiveData<Character>()

    init {
        // link data with observable
        characterLiveData.value = characterData
    }

    // don't give other classes access to the mutable version
    fun getCharacter() = characterData as LiveData<Character>

    fun modifyStr(modifier: Int) {
        characterData.strMod = characterData.strMod + modifier
        // update live data to notify observers
        characterLiveData.value = characterData
    }
}