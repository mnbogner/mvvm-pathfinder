package com.mvvm.pathfinder

abstract class Character(val characterName: String,
                     val level: Int, val hpPerLvl: Int, val bab: Int,
                     val strBase: Int, val dexBase: Int, val conBase: Int,
                     val intBase: Int, val wisBase: Int, val chrBase: Int,
                     val fortBase: Int, val refBase: Int, val willBase: Int) {

    companion object {
        val unarmedMod: CharacterMod = CharacterMod("unarmed", false, Dice.D4,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0)
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
        0)

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

    var dmgNonlethal: Int = 0
    var roundsRage: Int = 0
    var useBothHands: Int = 0
    var flatFooted: Int = 0

    var damageDice: Dice = Dice.D4

    fun getBaseStats(): HashMap<Stat, String> {
        var stats: HashMap<Stat, String> = HashMap<Stat, String>()
        stats.put(Stat.STR, (strBase + strMod).toString() + "/" + tempMod.strMod)
        stats.put(Stat.DEX, (dexBase + dexMod).toString() + "/" + tempMod.dexMod)
        stats.put(Stat.CON, (conBase + conMod).toString() + "/" + tempMod.conMod)
        stats.put(Stat.INT, (intBase + intMod).toString() + "/" + tempMod.intMod)
        stats.put(Stat.WIS, (wisBase + wisMod).toString() + "/" + tempMod.wisMod)
        stats.put(Stat.CHR, (chrBase + chrMod).toString() + "/" + tempMod.chrMod)
        return stats
    }

    fun getDerivedStats(): HashMap<Stat, String> {
        var stats: HashMap<Stat, String> = HashMap<Stat, String>()

        // calculate hp / nonlethal damage
        var hp: Int = ((hpPerLvl + hpPerLvlMod + getBonus(Stat.CON)) * level) + hpMod + (hpPerLvl - 2) // hp per level = avg roll, but get max hp for lv1 (1d10 avg = 6 so +4, 1d8 avg = 5 s0 +3, etc)
        var hpText: String = hp.toString()
        if (dmgNonlethal > 0) {
            hpText = hpText + "(" + dmgNonlethal + ")"
        }

        // calculate hit bonuses
        var hit: Int = bab + hitMod + getBonus(Stat.STR) + acSizMod // size mod seems to apply to hit bonus
        var hitText: String = "+" + hit.toString()
        if (bab > 5) {
            hitText = hitText + "/+" + (hit - 5).toString()
        }

        // calculate damage bonus
        var dmg: Int = dmgMod + getBonus(Stat.STR)
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

        stats.put(Stat.HP, hpText)
        stats.put(Stat.HIT, hitText)
        stats.put(Stat.DMG, dmgText)
        stats.put(Stat.AC, acText)
        stats.put(Stat.CMB, cmbText)
        stats.put(Stat.CMD, cmdText)
        stats.put(Stat.FORT, fortText)
        stats.put(Stat.REF, refText)
        stats.put(Stat.WILL, willText)
        return stats
    }

    abstract fun applyProgression()

    abstract fun getWeaponMods(): ArrayList<CharacterMod>

    abstract fun getArmorMods(): ArrayList<CharacterMod>

    abstract fun getGrappleMod(): CharacterMod

    abstract fun getPinMod(): CharacterMod

    abstract fun getRageMod(): CharacterMod

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

            if (mod.twoHands) {
                useBothHands++
            }

            if (mod.dmgDice != null) {
                damageDice = mod.dmgDice
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
            else -> return
        }
    }

    fun getBonus(stat: Stat): Int {

        when (stat) {
            Stat.STR -> {
                return (strBase + strMod - 10) / 2
            }
            Stat.DEX -> {
                return (dexBase + dexMod - 10) / 2
            }
            Stat.CON -> {
                return (conBase + conMod - 10) / 2
            }
            Stat.INT -> {
                return (intBase + intMod - 10) / 2
            }
            Stat.WIS -> {
                return (wisBase + wisMod - 10) / 2
            }
            Stat.CHR -> {
                return (chrBase + chrMod - 10) / 2
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