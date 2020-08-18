package com.mvvm.pathfinder

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import java.lang.reflect.Type

class CharacterModDeserializer : JsonDeserializer<CharacterMod> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): CharacterMod {
        var mod: CharacterMod = CharacterMod()
        json as JsonObject
        return mod
    }
}