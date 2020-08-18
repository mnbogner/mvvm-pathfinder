package com.mvvm.pathfinder

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import java.lang.reflect.Type

class ButtonModDeserializer : JsonDeserializer<ButtonMod> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): ButtonMod {
        var mod: ButtonMod = ButtonMod()
        json as JsonObject
        return mod
    }
}