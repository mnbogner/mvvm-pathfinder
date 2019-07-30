package com.mvvm.pathfinder

class FakeDatabase private constructor() {

    // maintain a collection of daos
    var characterDao = FakeCharacterDao()
        private set

    companion object {
        // @Volatile: writes immediately visible to all threads
        @Volatile private var instance: FakeDatabase? = null

        // enforce singleton, thread-safe instantiation
        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: FakeDatabase().also { instance = it }
            }
    }
}