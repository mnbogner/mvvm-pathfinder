package com.mvvm.pathfinder

data class Character(val characterName: String) {

    var mods: ArrayList<String> = ArrayList<String>()

    var strBase: Int = 10
    var dexBase: Int = 11
    var conBase: Int = 12
    var intBase: Int = 15
    var wisBase: Int = 14
    var chrBase: Int = 13

    var strMod: Int = 0
    var dexMod: Int = 0
    var conMod: Int = 0
    var intMod: Int = 0
    var wisMod: Int = 0
    var chrMod: Int = 0

    fun getStats(): HashMap<Stat, Int> {
        var stats: HashMap<Stat, Int> = HashMap<Stat, Int>()
        stats.put(Stat.STR, strBase + strMod)
        stats.put(Stat.DEX, dexBase + dexMod)
        stats.put(Stat.CON, conBase + conMod)
        stats.put(Stat.INT, intBase + intMod)
        stats.put(Stat.WIS, wisBase + wisMod)
        stats.put(Stat.CHR, chrBase + chrMod)
        return stats
    }

    fun addMod(mod: CharacterMod) {
        if (mods.contains(mod.modName)) {
            // already added, no-op
            return
        } else {
            mods.add(mod.modName)
            strMod += mod.strMod
            dexMod += mod.dexMod
            conMod += mod.conMod
            intMod += mod.intMod
            wisMod += mod.wisMod
            chrMod += mod.chrMod
        }
    }

    fun removeMod(mod: CharacterMod) {
        if (!mods.contains(mod.modName)) {
            // already removed, no-op
            return
        } else {
            mods.remove(mod.modName)
            strMod -= mod.strMod
            dexMod -= mod.dexMod
            conMod -= mod.conMod
            intMod -= mod.intMod
            wisMod -= mod.wisMod
            chrMod -= mod.chrMod
        }
    }

    fun adjustMod(stat: Stat, mod: Int) {
        when (stat) {
            Stat.STR -> strMod += mod
            Stat.DEX -> dexMod += mod
            Stat.CON -> conMod += mod
            Stat.INT -> intMod += mod
            Stat.WIS -> wisMod += mod
            Stat.CHR -> chrMod += mod
            else -> return
        }
    }

    /*
    fun getBonus(stat: Stat): Int {
        when (stat) {
            Stat.STR -> return (strBase + strMod - 10) / 2
            Stat.DEX -> return (dexBase + dexMod - 10) / 2
            Stat.CON -> return (conBase + conMod - 10) / 2
            Stat.INT -> return (intBase + intMod - 10) / 2
            Stat.WIS -> return (wisBase + wisMod - 10) / 2
            Stat.CHR -> return (chrBase + chrMod - 10) / 2
            else -> return 0
        }
    }
    */
}