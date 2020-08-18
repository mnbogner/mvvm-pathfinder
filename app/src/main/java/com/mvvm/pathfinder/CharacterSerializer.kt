package com.mvvm.pathfinder

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class CharacterSerializer : JsonSerializer<Character> {
    override fun serialize(
        src: Character?,
        typeOfSrc: Type?,
        context: JsonSerializationContext?
    ): JsonElement {
        val cModToken = object : TypeToken<List<CharacterMod>>() {}.type
        val bModToken = object : TypeToken<List<ButtonMod>>() {}.type
        val jsonObject: JsonObject = JsonObject()
        jsonObject.add("weaponModList", context?.serialize(src?.weaponModList, cModToken))
        jsonObject.add("armorModList", context?.serialize(src?.armorModList, cModToken))
        jsonObject.add("buttonModList", context?.serialize(src?.buttonModList, bModToken))
        jsonObject.add("characterName", context?.serialize(src?.characterName))
        jsonObject.add("level", context?.serialize(src?.level))
        jsonObject.add("hpPerLvl", context?.serialize(src?.hpPerLvl))
        jsonObject.add("bab", context?.serialize(src?.bab))
        jsonObject.add("strBase", context?.serialize(src?.strBase))
        jsonObject.add("dexBase", context?.serialize(src?.dexBase))
        jsonObject.add("conBase", context?.serialize(src?.conBase))
        jsonObject.add("intBase", context?.serialize(src?.intBase))
        jsonObject.add("wisBase", context?.serialize(src?.wisBase))
        jsonObject.add("chrBase", context?.serialize(src?.chrBase))
        jsonObject.add("fortBase", context?.serialize(src?.fortBase))
        jsonObject.add("refBase", context?.serialize(src?.refBase))
        jsonObject.add("willBase", context?.serialize(src?.willBase))
        return jsonObject
    }
}