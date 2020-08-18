package com.mvvm.pathfinder

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CharacterViewModel(private val character: Character) : ViewModel() {

    val baseStats: MutableLiveData<HashMap<Stat, String>> = MutableLiveData<HashMap<Stat, String>>()
    val derivedStats: MutableLiveData<HashMap<Stat, String>> = MutableLiveData<HashMap<Stat, String>>()
    val weaponMods: ArrayList<CharacterMod> = character.getWeaponMods()
    val armorMods: ArrayList<CharacterMod> = character.getArmorMods()
    val buttonMods: ArrayList<ButtonMod> = character.getButtonMods()

    fun initStats(): String {
        var defaultWeapon: CharacterMod = Character.unarmedMod

        // level up
        character.applyProgression()

        // equip default weapon
        if (weaponMods.isNotEmpty()) {
            defaultWeapon = weaponMods.get(0)
            character.addMod(defaultWeapon)
        }

        // equip all armor
        for (armor in armorMods) {
            character.addMod(armor)
        }

        updateStats()
        return defaultWeapon.modName
    }

    fun getCurrentStat(stat: Stat): Int {
        return character.getCurrentStat(stat)
    }

    fun updateStats() {
        baseStats.value = character.getBaseStats()
        derivedStats.value = character.getDerivedStats()
    }

    fun incrementStat(stat: Stat) {
        character.adjustMod(stat, 1)
        updateStats()
    }

    fun decrementStat(stat: Stat) {
        character.adjustMod(stat, -1)
        updateStats()
    }

    // this doesn't actually set the stat, it adds the mod value to the stat
    fun setStat(stat: Stat, mod: Int) {
        character.adjustMod(stat, mod)
        updateStats()
    }

    fun cycleWeapons(currentWeapon: String): String {

        var oldWeapon: CharacterMod = Character.unarmedMod
        var newWeapon: CharacterMod = Character.unarmedMod

        var i: Int = 0
        for (weapon in weaponMods) {
            if (weapon.modName == currentWeapon) {
                oldWeapon = weapon
                var j: Int = i + 1
                if (j == weaponMods.size) {
                    j = 0
                }
                newWeapon = weaponMods.get(j)
            }
            i++
        }

        character.removeMod(oldWeapon)
        character.addMod(newWeapon)
        updateStats()
        return newWeapon.modName
    }

    fun toggleMod(toggle: Boolean, mod: CharacterMod) {
        if (toggle) {
            character.addMod(mod)
        } else {
            character.removeMod(mod)
        }
        updateStats()
    }
}