package com.mvvm.pathfinder

class CharacterJson : Character {

    constructor():super() {
        System.out.println("FOO - json constructor")
    }

    override fun applyProgression() {
        return
    }

    override fun getBaseStat(stat: Stat): Int {
        return 0
    }

    override fun getWeaponMods(): ArrayList<CharacterMod> {
        val mods : ArrayList<CharacterMod> = ArrayList<CharacterMod>()
        return mods
    }

    override fun getArmorMods(): ArrayList<CharacterMod> {
        val mods: ArrayList<CharacterMod> = ArrayList<CharacterMod>()
        return mods
    }

    override fun getButtonMods(): ArrayList<ButtonMod> {
        var buttons: ArrayList<ButtonMod> = ArrayList<ButtonMod>()
        return buttons
    }

    override fun getGrappleMod(): CharacterMod {
        val mod: CharacterMod = CharacterMod("foo", false, Dice.D4,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0)
        return mod
    }

    override fun getRagingMod(): CharacterMod {
        val mod: CharacterMod = CharacterMod("foo", false, Dice.D4,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0)
        return mod
    }

    override fun getHasteMod(): CharacterMod {
        val mod: CharacterMod = CharacterMod("foo", false, Dice.D4,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0)
        return mod
    }

    override fun getEnlargeMod(): CharacterMod {
        val mod: CharacterMod = CharacterMod("foo", false, Dice.D4,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0)
        return mod
    }




}