package com.mvvm.pathfinder

class CharacterIka(characterName: String = "I'ka",
    level: Int = 10, hpPerLvl: Int = 6, bab: Int = 10,
    strBase: Int = 14, dexBase: Int = 15, conBase: Int = 14,
    intBase: Int = 8, wisBase: Int = 14, chrBase: Int = 14,
    fortBase: Int = 7, refBase: Int = 3, willBase: Int = 3) :
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
        // automatic progression - lv+1: resistance +3, deflection +2, mental prowess +4 wis, physical prowess +2 con, toughening +1
        // belt of the weasel: +2 dex
        // divine favor - tegura: natural +1
        // spells: 2+1 lv1, 1+1 lv2, 1+1 lv3
        val progressionMod: CharacterMod = CharacterMod("progression", false, null,
            0, 1, 0,       // hp, hp/lvl, str
            1+2, 2, 0,     // dex, con, int
            4, 2+1, 0,     // wis, cha, hit
            0, 0, 0,       // dmg, ac, armor
            0, 2, 1+1,     // shield, deflect, natural
            1, 0, 1,       // dodge, size, cmb
            0, 3, 1+3,     // cmd, fort, ref
            1+3, 1*10, 2+1, // will, rage*lvl, lv1 spells
            1+1, 1+1)           // lv2 spells, lv3 spells

        // cestus
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
            0, 0)

        // longspear
        // reach, brace
        val spearMod: CharacterMod = CharacterMod("spear", true, Dice.D8,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0)

        // yaku'oi ironwood scimitar
        // masterwork
        val scimitarMod: CharacterMod = CharacterMod("scimitar", false, Dice.D6,
            0, 0, 0,
            0, 0, 0,
            0, 0, 1,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0)

        // yaku'oi composite longbow
        // +1, adaptive
        val longbowMod: CharacterMod = CharacterMod("longbow", true, Dice.D8,
            0, 0, 0,
            0, 0, 0,
            0, 0, 1,
            1, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0)

        // improved grapple: +2 cmb/cmd
        // greater grapple: +2 cmb
        // grabbing style: 1 handed
        val grapplingMod: CharacterMod = CharacterMod("grappling", false, Dice.D4,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 4,
            2, 0, 0,
            0, 0, 0,
            0, 0)

        // darkleaf lamellar + armored kilt
        // automatic progression lv+1: armor attunement +2
        val armorMod: CharacterMod = CharacterMod("armor", false, null,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 4 + 1 + 2,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0)

        // yaku'oi ironwood buckler
        val shieldMod: CharacterMod = CharacterMod("shield", false, null,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            1, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0)

        // grappling modifiers
        // ignoring cmb penalty because it doesn't affect grappling while grappled
        val grappleMod: CharacterMod = CharacterMod("grapple", false, null,
            0, 0, 0,
            -4, 0, 0,
            0, 0, -2,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0)

        // pinning modifiers
        // grabbing style: don't lose dex bonus to ac when pinning
        val pinMod: CharacterMod = CharacterMod("pin", false, null,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0)

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
            0, 0)

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
            0, 0)

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
            0, 0)
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
        weapons.add(spearMod)
        weapons.add(scimitarMod)
        weapons.add(longbowMod)
        weapons.add(grapplingMod)
        return weapons
    }

    override fun getArmorMods(): ArrayList<CharacterMod> {
        var armor: ArrayList<CharacterMod> = ArrayList<CharacterMod>()
        armor.add(armorMod)
        armor.add(shieldMod)
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