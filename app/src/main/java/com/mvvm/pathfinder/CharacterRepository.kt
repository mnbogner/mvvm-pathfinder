package com.mvvm.pathfinder

class CharacterRepository private constructor(private val characterDao: FakeCharacterDao) {

    // wrap dao functions
    fun modifyStr(modifier: Int) {
        characterDao.modifyStr(modifier)
    }

    fun getCharacter() = characterDao.getCharacter()

    companion object {
        // @Volatile: writes immediately visible to all threads
        @Volatile private var instance: CharacterRepository? = null

        // enforce singleton, thread-safe instantiation
        fun getInstance(characterDao: FakeCharacterDao) =
            instance ?: synchronized(this) {
                instance ?: CharacterRepository(characterDao).also { instance = it }
            }
    }
}