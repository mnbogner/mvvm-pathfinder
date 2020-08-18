package com.mvvm.pathfinder

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import java.lang.reflect.Type

class CharacterModSerializer : JsonSerializer<CharacterMod> {
    override fun serialize(
        src: CharacterMod?,
        typeOfSrc: Type?,
        context: JsonSerializationContext?
    ): JsonElement {
        val jsonObject: JsonObject = JsonObject()
        jsonObject.add("modName", context?.serialize(src?.modName))
        jsonObject.add("twoHands", context?.serialize(src?.twoHands))
        jsonObject.add("dmgDice", context?.serialize(src?.dmgDice?.str))
        jsonObject.add("hpMod", context?.serialize(src?.hpMod))
        jsonObject.add("hpPerLvlMod", context?.serialize(src?.hpPerLvlMod))
        jsonObject.add("strMod", context?.serialize(src?.strMod))
        jsonObject.add("dexMod", context?.serialize(src?.dexMod))
        jsonObject.add("conMod", context?.serialize(src?.conMod))
        jsonObject.add("intMod", context?.serialize(src?.intMod))
        jsonObject.add("wisMod", context?.serialize(src?.wisMod))
        jsonObject.add("chrMod", context?.serialize(src?.chrMod))
        jsonObject.add("hitMod", context?.serialize(src?.hitMod))
        jsonObject.add("dmgMod", context?.serialize(src?.dmgMod))
        jsonObject.add("acMod", context?.serialize(src?.acMod))
        jsonObject.add("acArmMod", context?.serialize(src?.acArmMod))
        jsonObject.add("acShiMod", context?.serialize(src?.acShiMod))
        jsonObject.add("acDefMod", context?.serialize(src?.acDefMod))
        jsonObject.add("acNatMod", context?.serialize(src?.acNatMod))
        jsonObject.add("acDodMod", context?.serialize(src?.acDodMod))
        jsonObject.add("acSizMod", context?.serialize(src?.acSizMod))
        jsonObject.add("cmbMod", context?.serialize(src?.cmbMod))
        jsonObject.add("cmdMod", context?.serialize(src?.cmdMod))
        jsonObject.add("fortMod", context?.serialize(src?.fortMod))
        jsonObject.add("refMod", context?.serialize(src?.refMod))
        jsonObject.add("willMod", context?.serialize(src?.willMod))
        jsonObject.add("spells1Mod", context?.serialize(src?.spells1Mod))
        jsonObject.add("spells2Mod", context?.serialize(src?.spells2Mod))
        jsonObject.add("spells3Mod", context?.serialize(src?.spells3Mod))
        return jsonObject
    }
}