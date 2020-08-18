package com.mvvm.pathfinder

import com.google.gson.*
import java.lang.reflect.Type

class CharacterDeserializer : JsonDeserializer<Character> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Character {
        val jsonString = json?.asJsonObject?.asString
        val gson: Gson = Gson()
        val character: CharacterJson = gson.fromJson(jsonString, CharacterJson::class.java)
        return character
    }
}