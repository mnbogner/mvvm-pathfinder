package com.mvvm.pathfinder

import android.content.Context
import com.google.gson.Gson
import java.io.InputStream
import java.io.InputStreamReader
import java.io.Reader

object CharacterInjector {

    // load character from specified json file
    fun loadJsonCharacter(filename: String, context: Context): CharacterFactory {
        var input: InputStream = context.assets.open(filename)
        var reader: Reader = InputStreamReader(input)
        val gson: Gson = Gson()
        val character: CharacterJson = gson.fromJson(reader, CharacterJson::class.java)
        return CharacterFactory(character)
    }
}