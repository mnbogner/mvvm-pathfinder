package com.mvvm.pathfinder

abstract class Character {

    var characterName: String
    var level: Int
    var hpPerLvl: Int
    var bab: Int
    var strBase: Int
    var dexBase: Int
    var conBase: Int
    var intBase: Int
    var wisBase: Int
    var chrBase: Int
    var fortBase: Int
    var refBase: Int
    var willBase: Int

    constructor(characterNameArg: String,
                levelArg: Int, hpPerLvlArg: Int, babArg: Int,
                strBaseArg: Int, dexBaseArg: Int, conBaseArg: Int,
                intBaseArg: Int, wisBaseArg: Int, chrBaseArg: Int,
                fortBaseArg: Int, refBaseArg: Int, willBaseArg: Int) {
        characterName = characterNameArg
        level = levelArg
        hpPerLvl = hpPerLvlArg
        bab = babArg
        strBase = strBaseArg
        dexBase = dexBaseArg
        conBase = conBaseArg
        intBase = intBaseArg
        wisBase = wisBaseArg
        chrBase = chrBaseArg
        fortBase = fortBaseArg
        refBase = refBaseArg
        willBase = willBaseArg
        System.out.println("FOO - character argument constructor")
    }

    constructor() {
        characterName = "..."
        level = 0
        hpPerLvl = 0
        bab = 0
        strBase = 0
        dexBase = 0
        conBase = 0
        intBase = 0
        wisBase = 0
        chrBase = 0
        fortBase = 0
        refBase = 0
        willBase = 0
        System.out.println("FOO - character default constructor")
    }

    /*
    init {
        characterName = characterNameArg
        level = levelArg
        hpPerLvl = hpPerLvlArg
        bab = babArg
        strBase = strBaseArg
        dexBase = dexBaseArg
        conBase = conBaseArg
        intBase = intBaseArg
        wisBase = wisBaseArg
        chrBase = chrBaseArg
        fortBase = fortBaseArg
        refBase = refBaseArg
        willBase = willBaseArg
    }
    */

    companion object {
        val unarmedMod: CharacterMod = CharacterMod("unarmed", false, Dice.D4,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0)

        fun getBonus(statVal: Int): Int {

            return (statVal - 10) / 2
        }
    }

    var mods: ArrayList<String> = ArrayList<String>()

    var tempMod: CharacterMod = CharacterMod("temp", false, null,
        0, 0, 0,
        0, 0, 0,
        0, 0, 0,
        0, 0, 0,
        0, 0, 0,
        0, 0, 0,
        0, 0, 0,
        0, 0, 0,
        0, 0)

    var acBase: Int = 10
    var cmdBase: Int = 10 // CMB base = BAB

    var strMod: Int = 0
    var dexMod: Int = 0
    var conMod: Int = 0
    var intMod: Int = 0
    var wisMod: Int = 0
    var chrMod: Int = 0

    var hpMod: Int = 0
    var hpPerLvlMod: Int = 0
    var hitMod: Int = 0
    var dmgMod: Int = 0
    var acMod: Int = 0
    var acArmMod: Int = 0
    var acShiMod: Int = 0
    var acDefMod: Int = 0
    var acNatMod: Int = 0
    var acDodMod: Int = 0
    var acSizMod: Int = 0
    var cmbMod: Int = 0
    var cmdMod: Int = 0
    var fortMod: Int = 0
    var refMod: Int = 0
    var willMod: Int = 0
    var rageMod: Int = 0

    var spells1Mod: Int = 0
    var spells2Mod: Int = 0
    var spells3Mod: Int = 0

    var dmgNonlethal: Int = 0
    var useBothHands: Int = 0
    var flatFooted: Int = 0

    var damageDice: Dice = Dice.D4

    fun getBaseStats(): HashMap<Stat, String> {
        var stats: HashMap<Stat, String> = HashMap<Stat, String>()

        var strExtra: String = ""
        var dexExtra: String = ""
        var conExtra: String = ""
        var intExtra: String = ""
        var wisExtra: String = ""
        var chrExtra: String = ""

        if (tempMod.strMod != 0) {
            strExtra = strExtra + "(" + tempMod.strMod + ")"
        }
        if (tempMod.dexMod != 0) {
            dexExtra = dexExtra + "(" + tempMod.dexMod + ")"
        }
        if (tempMod.conMod != 0) {
            conExtra = conExtra + "(" + tempMod.conMod + ")"
        }
        if (tempMod.intMod != 0) {
            intExtra = intExtra + "(" + tempMod.intMod + ")"
        }
        if (tempMod.wisMod != 0) {
            wisExtra = wisExtra + "(" + tempMod.wisMod + ")"
        }
        if (tempMod.chrMod != 0) {
            chrExtra = chrExtra + "(" + tempMod.chrMod + ")"
        }

        strExtra = strExtra + "/"
        dexExtra = dexExtra + "/"
        conExtra = conExtra + "/"
        intExtra = intExtra + "/"
        wisExtra = wisExtra + "/"
        chrExtra = chrExtra + "/"

        if (getBonus(Stat.STR) > 0) {
            strExtra = strExtra + "+"
        }
        if (getBonus(Stat.DEX) > 0) {
            dexExtra = dexExtra + "+"
        }
        if (getBonus(Stat.CON) > 0) {
            conExtra = conExtra + "+"
        }
        if (getBonus(Stat.INT) > 0) {
            intExtra = intExtra + "+"
        }
        if (getBonus(Stat.WIS) > 0) {
            wisExtra = wisExtra + "+"
        }
        if (getBonus(Stat.CHR) > 0) {
            chrExtra = chrExtra + "+"
        }

        stats.put(Stat.STR, (strBase + strMod).toString() + strExtra + getBonus(Stat.STR))  // tempMod.strMod)
        stats.put(Stat.DEX, (dexBase + dexMod).toString() + dexExtra + getBonus(Stat.DEX))  // tempMod.dexMod)
        stats.put(Stat.CON, (conBase + conMod).toString() + conExtra + getBonus(Stat.CON))  // tempMod.conMod)
        stats.put(Stat.INT, (intBase + intMod).toString() + intExtra + getBonus(Stat.INT))  // tempMod.intMod)
        stats.put(Stat.WIS, (wisBase + wisMod).toString() + wisExtra + getBonus(Stat.WIS))  // tempMod.wisMod)
        stats.put(Stat.CHR, (chrBase + chrMod).toString() + chrExtra + getBonus(Stat.CHR))  // tempMod.chrMod)
        return stats
    }

    fun getDerivedStats(): HashMap<Stat, String> {
        var stats: HashMap<Stat, String> = HashMap<Stat, String>()

        // calculate hp / nonlethal damage
        var hp: Int = ((hpPerLvl + hpPerLvlMod + getBonus(Stat.CON)) * level) + hpMod + (hpPerLvl - 2) // hp per level = avg roll, but get max hp for lv1 (1d10 avg = 6 so +4, 1d8 avg = 5 so +3, etc)
        var hpText: String = hp.toString() + "/" + (hp - tempMod.hpMod).toString()
        if (dmgNonlethal > 0) {
            hpText = hpText + "(" + dmgNonlethal + ")"
        }

        // calculate hit bonuses
        var hit: Int = bab + hitMod + getBonus(Stat.STR) + acSizMod // size mod seems to apply to hit bonus
        // TODO: add ranged flag
        if (mods.contains("longbow")) {
            System.out.println("FOO - TEMP RANGED HACK (hit)")
            hit = bab + hitMod + getBonus(Stat.DEX) + acSizMod // size mod seems to apply to hit bonus
        }
        var hitText: String = "+" + hit.toString()
        if (bab > 5) {
            hitText = hitText + "/+" + (hit - 5).toString()
        }

        // calculate damage bonus
        var dmg: Int = dmgMod + getBonus(Stat.STR)
        // TODO: add ranged flag
        if (mods.contains("longbow")) {
            System.out.println("FOO - TEMP RANGED HACK (dmg)")
            // IGNORE: got adaptive longbow, uses full strength rating
            // dmg = dmgMod
        }
        var dmgText: String = getDamageDice(damageDice).str + "+" + dmg.toString()

        // calculate ac / touch ac
        var ac: Int = acBase + acMod + getBonus(Stat.DEX) + acArmMod + acDefMod + acNatMod + acDodMod + acSizMod
        var flat1: Int = acBase + acMod + acArmMod + acDefMod + acNatMod + acSizMod
        if (useBothHands < 1) {
            ac += acShiMod
            flat1 += acShiMod
        }
        var touch: Int = acBase + acMod + getBonus(Stat.DEX) + acDefMod + acDodMod + acSizMod
        var acText: String = ac.toString() + "/" + touch.toString()

        // calculate cmb
        var cmb: Int = bab + cmbMod + getBonus(Stat.STR) - acSizMod // size mod for cmb appears to be opposite of size mod for ac
        var cmbText: String = "+" + cmb.toString()

        // calculate cmd
        var cmd: Int = cmdBase + cmdMod + bab + getBonus(Stat.STR) + getBonus(Stat.DEX) + acMod + acDefMod + acDodMod - acSizMod // size mod for cmd appears to be opposite of size mod for ac
        var flat2: Int = cmdBase + cmdMod + bab + getBonus(Stat.STR) + acMod + acDefMod - acSizMod
        var cmdText: String = cmd.toString()

        // calculate fort save
        var fort: Int = fortBase + fortMod + getBonus(Stat.CON)
        var fortText: String = "+" + fort.toString()

        // calculate ref save
        var ref: Int = refBase + refMod + getBonus(Stat.DEX)
        var refText: String = "+" + ref.toString()

        // calculate will save
        var will: Int = willBase + willMod + getBonus(Stat.WIS)
        var willText: String = "+" + will.toString()

        // calculate rounds of rage
        var rage: Int = getBaseRage() + rageMod
        var rageText: String = "RAGE(" + rage + ")"

        // calculate bonus ac from blood armor
        // currently only blood armor modifies temp ac
        var blood: Int = tempMod.acMod
        var bloodText: String = "BLOOD(" + blood + ")"

        stats.put(Stat.HP, hpText)
        stats.put(Stat.HIT, hitText)
        stats.put(Stat.DMG, dmgText)
        stats.put(Stat.AC, acText)
        stats.put(Stat.CMB, cmbText)
        stats.put(Stat.CMD, cmdText)
        stats.put(Stat.FORT, fortText)
        stats.put(Stat.REF, refText)
        stats.put(Stat.WILL, willText)
        stats.put(Stat.RAGE, rageText)
        stats.put(Stat.BLOOD, bloodText)
        return stats
    }

    fun getCurrentStat(stat: Stat): Int {
        when (stat) {
            Stat.STR -> {
                return strBase + strMod
            }
            Stat.DEX -> {
                return dexBase + dexMod
            }
            Stat.CON -> {
                return conBase + conMod
            }
            Stat.INT -> {
                return intBase + intMod
            }
            Stat.WIS -> {
                return wisBase + wisMod
            }
            Stat.CHR -> {
                return chrBase + chrMod
            }
            Stat.LV1S -> {
                return spells1Mod
            }
            Stat.LV2S -> {
                return spells2Mod
            }
            Stat.LV3S -> {
                return spells3Mod
            }
            else -> return 0
        }
    }

    abstract fun applyProgression()

    abstract fun getBaseStat(stat: Stat): Int

    fun getBaseRage(): Int {
        // 4 + constitution modifier, 2 additional rounds for each level after 1st
        return 4 + (getBonus(getBaseStat(Stat.CON))) + ((level - 1) * 2)
    }

    abstract fun getWeaponMods(): ArrayList<CharacterMod>

    abstract fun getArmorMods(): ArrayList<CharacterMod>

    abstract fun getButtonMods(): ArrayList<ButtonMod>

    abstract fun getGrappleMod(): CharacterMod

    // abstract fun getPinMod(): CharacterMod

    abstract fun getRagingMod(): CharacterMod

    abstract fun getHasteMod(): CharacterMod

    abstract fun getEnlargeMod(): CharacterMod

    //abstract fun initWeapons(): String

    //abstract fun cycleWeapons(currentWeapon: String): String

    fun addMod(mod: CharacterMod) {
        if (mods.contains(mod.modName)) {
            System.out.println("FOO: SKIP MOD " + mod.modName)
            // already added, no-op
            return
        } else {
            System.out.println("FOO: ADD MOD " + mod.modName)
            mods.add(mod.modName)
            strMod += mod.strMod
            dexMod += mod.dexMod
            conMod += mod.conMod
            intMod += mod.intMod
            wisMod += mod.wisMod
            chrMod += mod.chrMod

            hpMod += mod.hpMod
            hpPerLvlMod += mod.hpPerLvlMod
            hitMod += mod.hitMod
            dmgMod += mod.dmgMod
            acMod += mod.acMod
            acArmMod += mod.acArmMod
            acShiMod += mod.acShiMod
            acDefMod += mod.acDefMod
            acNatMod += mod.acNatMod
            acDodMod += mod.acDodMod
            acSizMod += mod.acSizMod
            cmbMod += mod.cmbMod
            cmdMod += mod.cmdMod
            fortMod += mod.fortMod
            refMod += mod.refMod
            willMod += mod.willMod
            rageMod += mod.rageMod

            spells1Mod += mod.spells1Mod
            spells2Mod += mod.spells2Mod
            spells3Mod += mod.spells3Mod

            if (mod.twoHands) {
                useBothHands++
            }

            val localDice : Dice? = mod.dmgDice

            if (localDice != null) {
                damageDice = localDice
            }
        }
    }

    fun removeMod(mod: CharacterMod) {
        if (!mods.contains(mod.modName)) {
            System.out.println("FOO: SKIP MOD " + mod.modName)
            // already removed, no-op
            return
        } else {
            System.out.println("FOO: REMOVE MOD " + mod.modName)
            mods.remove(mod.modName)
            strMod -= mod.strMod
            dexMod -= mod.dexMod
            conMod -= mod.conMod
            intMod -= mod.intMod
            wisMod -= mod.wisMod
            chrMod -= mod.chrMod

            hpMod -= mod.hpMod
            hpPerLvlMod -= mod.hpPerLvlMod
            hitMod -= mod.hitMod
            dmgMod -= mod.dmgMod
            acMod -= mod.acMod
            acArmMod -= mod.acArmMod
            acShiMod -= mod.acShiMod
            acDefMod -= mod.acDefMod
            acNatMod -= mod.acNatMod
            acDodMod -= mod.acDodMod
            acSizMod -= mod.acSizMod
            cmbMod -= mod.cmbMod
            cmdMod -= mod.cmdMod
            fortMod -= mod.fortMod
            refMod -= mod.refMod
            willMod -= mod.willMod
            rageMod -= mod.rageMod

            spells1Mod -= mod.spells1Mod
            spells2Mod -= mod.spells2Mod
            spells3Mod -= mod.spells3Mod

            if (mod.twoHands) {
                useBothHands--
            }

            if (mod.dmgDice != null) {
                damageDice = Dice.D4
            }
        }
    }

    fun adjustMod(stat: Stat, mod: Int) {

        if (!mods.contains(tempMod.modName)) {
            // register temp mods
            mods.add(tempMod.modName)
        }

        when (stat) {
            Stat.HP -> {
                hpMod += mod
                tempMod.hpMod += mod
                if (mod > 0) {
                    // hp recovery heals non lethal damage too
                    dmgNonlethal -= mod
                }
            }
            Stat.STR -> {
                strMod += mod
                tempMod.strMod += mod
            }
            Stat.DEX -> {
                dexMod += mod
                tempMod.dexMod += mod
            }
            Stat.CON -> {
                conMod += mod
                tempMod.conMod += mod
            }
            Stat.INT -> {
                intMod += mod
                tempMod.intMod += mod
            }
            Stat.WIS -> {
                wisMod += mod
                tempMod.wisMod += mod
            }
            Stat.CHR -> {
                chrMod += mod
                tempMod.chrMod += mod
            }
            Stat.RAGE -> {
                if (getBaseRage() + rageMod == 0 ) {
                    // loop around after hitting 0
                    rageMod = 0
                    tempMod.rageMod = 0
                } else {
                    rageMod += mod
                    tempMod.rageMod += mod
                }
            }
            Stat.AC -> {
                if (mod == 0) {
                    // hack to reset value
                    acMod -= tempMod.acMod
                    tempMod.acMod = 0
                } else if (tempMod.acMod == 5 ) {
                    // bonus capped at 5 (max for blood armor spell)
                    // no-op
                } else {
                    acMod += mod
                    tempMod.acMod += mod
                }
            }
            Stat.NL -> {
                dmgNonlethal += mod
            }
            Stat.LV1S -> {
                spells1Mod = mod
            }
            Stat.LV2S -> {
                spells2Mod = mod
            }
            Stat.LV3S -> {
                spells3Mod = mod
            }
            else -> return
        }
    }

    fun getBonus(stat: Stat): Int {

        when (stat) {
            Stat.STR -> {
                return getBonus(strBase + strMod)
            }
            Stat.DEX -> {
                return getBonus(dexBase + dexMod)
            }
            Stat.CON -> {
                return getBonus(conBase + conMod)
            }
            Stat.INT -> {
                return getBonus(intBase + intMod)
            }
            Stat.WIS -> {
                return getBonus(wisBase + wisMod)
            }
            Stat.CHR -> {
                return getBonus(chrBase + chrMod)
            }
            else -> return 0
        }
    }

    fun getDamageDice(baseDice: Dice): Dice {

        // 0 = medium, +1 = small, -1 = large

        if (acSizMod == 0) {
            return baseDice
        }

        when (baseDice) {
            Dice.D4 -> {
                if (acSizMod > 0) {
                    return Dice.D3
                } else {
                    return Dice.D6
                }
            }
            Dice.D6 -> {
                if (acSizMod > 0) {
                    return Dice.D4
                } else {
                    return Dice.D8
                }
            }
            Dice.D8 -> {
                if (acSizMod > 0) {
                    return Dice.D6
                } else {
                    return Dice.D6x2
                }
            }
            Dice.D10 -> {
                if (acSizMod > 0) {
                    return Dice.D8
                } else {
                    return Dice.D8x2
                }
            }
            Dice.D12 -> {
                if (acSizMod > 0) {
                    return Dice.D10
                } else {
                    return Dice.D6x3
                }
            }
            Dice.D6x2 -> {
                if (acSizMod > 0) {
                    return Dice.D10
                } else {
                    return Dice.D6x3
                }
            }
            else -> return Dice.D
        }

    }
}