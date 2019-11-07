package com.mvvm.pathfinder

object CharacterInjector {

    // construct factory with selected character
    fun getCharacterFactoryIka(): CharacterFactory {

        // create character
        val character: Character = CharacterIka()

        return CharacterFactory(character)
    }
}