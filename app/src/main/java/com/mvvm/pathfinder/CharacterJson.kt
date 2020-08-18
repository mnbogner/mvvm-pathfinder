package com.mvvm.pathfinder

class CharacterJson : Character {

    constructor():super() {

    }

    override fun applyProgression() {
        // loaded into base class from json
        addMod(progressionMod)
    }

    override fun getBaseStat(stat: Stat): Int {
        return 0
    }

    override fun getWeaponMods(): ArrayList<CharacterMod> {
        // loaded into base class from json
        return weaponModList
    }

    override fun getArmorMods(): ArrayList<CharacterMod> {
        // loaded into base class from json
        return armorModList
    }

    override fun getButtonMods(): ArrayList<ButtonMod> {
        // loaded into base class from json
        return buttonModList
    }
}