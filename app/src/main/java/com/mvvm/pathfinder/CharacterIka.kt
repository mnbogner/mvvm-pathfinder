package com.mvvm.pathfinder

class CharacterIka(characterName: String = "I'ka",
    level: Int = 9, hpPerLvl: Int = 6, bab: Int = 9,
    strBase: Int = 14, dexBase: Int = 15, conBase: Int = 14,
    intBase: Int = 8, wisBase: Int = 14, chrBase: Int = 14,
    fortBase: Int = 6, refBase: Int = 3, willBase: Int = 3) :
    Character(characterName,
    level, hpPerLvl, bab,
    strBase, dexBase, conBase,
    intBase, wisBase, chrBase,
    fortBase, refBase, willBase) {

    companion object {
        // racial abilities - human: +2 cha, +1 ac (dodge), +1 ref/will (heart of the fey)
        // traits: +1 cmb/intimidate (bred for war), +1 hp/skill per lvl (finding your kin)
        // stats: +1 dex lv4, +1 cha lv8
        // favored class bonus: +1 round rage per lvl
        // automatic progression - lv+1: resistance +3, deflection +2, mental prowess +2 wis, physical prowess +2 con, toughening +1
        // belt of the weasel: +2 dex
        // divine favor - tegura: natural +1
        // spells: 2+1 lv1, 1+1 lv2
        val progressionMod: CharacterMod = CharacterMod("progression", false, null,
            0, 1, 0,
            3, 2, 0,
            2, 3, 0,
            0, 0, 0,
            0, 2, 2,
            1, 0, 1,
            0, 3, 4,
            4, 9, 3,
            2)

        // automatic progression lv+1: weapon attunement +2
        val cestusMod: CharacterMod = CharacterMod("cestus", false, Dice.D4,
            0, 0, 0,
            0, 0, 0,
            0, 0, 2,
            2, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0)

        // silvered: -1 dmg
        val gladiusMod: CharacterMod = CharacterMod("gladius", false, Dice.D6,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            -1, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0)

        // improved grapple: +2 cmb/cmd
        // greater grapple: +2 cmb
        val grapplingMod: CharacterMod = CharacterMod("grappling", false, Dice.D4,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 4,
            2, 0, 0,
            0, 0, 0,
            0)

        // automatic progression lv+1: kilt + armor attunement +2
        val chainMod: CharacterMod = CharacterMod("armor", false, null,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 4 + 1 + 2,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0)

        val bucklerMod: CharacterMod = CharacterMod("shield", false, null,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            1, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0)

        // grappling modifiers
        val grappleMod: CharacterMod = CharacterMod("grapple", false, null,
            0, 0, 0,
            -4, 0, 0,
            0, 0, -2,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0)

        val pinMod: CharacterMod = CharacterMod("pin", false, null,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0)

        // rage modifiers
        val ragingMod: CharacterMod = CharacterMod("rage", false, null,
            0, 0, 4,
            0, 4, 0,
            0, 0, 0,
            0, -2, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            2, 0, 0,
            0)

        // haste modifiers
        val hasteMod: CharacterMod = CharacterMod("haste", false, null,
            0, 0, 0,
            0, 0, 0,
            0, 0, 1,
            0, 0, 0,
            0, 0, 0,
            1, 0, 0,
            0, 0, 1,
            0, 0, 0,
            0)

        // enlarge modifiers
        val enlargeMod: CharacterMod = CharacterMod("enlarge", false, null,
            0, 0, 2,
            -2, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, -1, 0,
            0, 0, 0,
            0, 0, 0,
            0)
    }

    override fun applyProgression() {
        addMod(progressionMod)
    }

    override fun getBaseStat(stat: Stat): Int {
        // just need CON for now to calculate rounds of rage
        return conBase + progressionMod.conMod
    }

    override fun getWeaponMods(): ArrayList<CharacterMod> {
        var weapons: ArrayList<CharacterMod> = ArrayList<CharacterMod>()
        weapons.add(cestusMod)
        weapons.add(gladiusMod)
        weapons.add(grapplingMod)
        return weapons
    }

    override fun getArmorMods(): ArrayList<CharacterMod> {
        var armor: ArrayList<CharacterMod> = ArrayList<CharacterMod>()
        armor.add(chainMod)
        armor.add(bucklerMod)
        return armor
    }

    override fun getGrappleMod(): CharacterMod {
        return grappleMod
    }

    override fun getPinMod(): CharacterMod {
        return pinMod
    }

    override fun getRagingMod(): CharacterMod {
        return ragingMod
    }

    override fun getHasteMod(): CharacterMod {
        return hasteMod
    }

    override fun getEnlargeMod(): CharacterMod {
        return enlargeMod
    }
}