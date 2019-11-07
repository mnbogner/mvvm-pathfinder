package com.mvvm.pathfinder

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CharacterViewModel(private val character: Character) : ViewModel() {

    val baseStats: MutableLiveData<HashMap<Stat, String>> = MutableLiveData<HashMap<Stat, String>>()
    val derivedStats: MutableLiveData<HashMap<Stat, String>> = MutableLiveData<HashMap<Stat, String>>()

    val weaponMods: ArrayList<CharacterMod> = character.getWeaponMods()
    val armorMods: ArrayList<CharacterMod> = character.getArmorMods()
    val grappleMod: CharacterMod = character.getGrappleMod()
    val pinMod: CharacterMod = character.getPinMod()
    val rageMod: CharacterMod = character.getRageMod()
    val hasteMod: CharacterMod = character.getHasteMod()
    val enlargeMod: CharacterMod = character.getEnlargeMod()

    fun initStats(): String {

        var defaultWeapon: CharacterMod = Character.unarmedMod

        // level up
        character.applyProgression()

        // equip gear
        if (weaponMods.isNotEmpty()) {
            defaultWeapon = weaponMods.get(0)
            character.addMod(defaultWeapon)
        }

        for (armor in armorMods) {
            character.addMod(armor)
        }

        updateStats()

        /*
        if (baseStats.value == null) {
            baseStats.value = character.getBaseStats()
        }
        if (derivedStats.value == null) {
            derivedStats.value = character.getDerivedStats()
        }
        */

        return defaultWeapon.modName
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

    fun toggleGrapple(toggle: Boolean) {
        if (toggle) {
            character.addMod(grappleMod)
        } else {
            character.removeMod(grappleMod)
        }
        updateStats()
    }

    fun togglePin(toggle: Boolean) {
        if (toggle) {
            character.addMod(pinMod)
        } else {
            character.removeMod(pinMod)
        }
        updateStats()
    }

    fun toggleRage(toggle: Boolean) {
        if (toggle) {
            character.addMod(rageMod)
        } else {
            character.removeMod(rageMod)
        }
        updateStats()
    }

    fun toggleHaste(toggle: Boolean) {
        if (toggle) {
            character.addMod(hasteMod)
        } else {
            character.removeMod(hasteMod)
        }
        updateStats()
    }

    fun toggleEnlarge(toggle: Boolean) {
        if (toggle) {
            character.addMod(enlargeMod)
        } else {
            character.removeMod(enlargeMod)
        }
        updateStats()
    }
}