package com.mvvm.pathfinder

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CharacterViewModel(private val character: Character) : ViewModel() {

    val stats: MutableLiveData<HashMap<Stat, Int>> = MutableLiveData<HashMap<Stat, Int>>()

    fun initStats() {
        if (stats.value == null) {
            stats.value = character.getStats()
        }
    }

    fun updateStats() {
        stats.value = character.getStats()
    }

    fun incrementStat(stat: Stat) {
        character.adjustMod(stat, 1)
        updateStats()
    }

    fun decrementStat(stat: Stat) {
        character.adjustMod(stat, -1)
        updateStats()
    }
}