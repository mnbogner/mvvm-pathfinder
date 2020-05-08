package com.mvvm.pathfinder

import android.os.Parcel
import android.os.Parcelable

open class CharacterMod : Parcelable  {

    var modName: String
    var twoHands: Boolean
    var dmgDice: Dice?
    var hpMod: Int
    var hpPerLvlMod: Int
    var strMod: Int
    var dexMod: Int
    var conMod: Int
    var intMod: Int
    var wisMod: Int
    var chrMod: Int
    var hitMod: Int
    var dmgMod: Int
    var acMod: Int
    var acArmMod: Int
    var acShiMod: Int
    var acDefMod: Int
    var acNatMod: Int
    var acDodMod: Int
    var acSizMod: Int
    var cmbMod: Int
    var cmdMod: Int
    var fortMod: Int
    var refMod: Int
    var willMod: Int
    var rageMod: Int
    var spells1Mod: Int
    var spells2Mod: Int
    var spells3Mod: Int

    constructor(modNameArg: String, twoHandsArg: Boolean, dmgDiceArg: Dice?,
                hpModArg: Int, hpPerLvlModArg: Int, strModArg: Int,
                dexModArg: Int, conModArg: Int, intModArg: Int,
                wisModArg: Int, chrModArg: Int, hitModArg: Int,
                dmgModArg: Int, acModArg: Int, acArmModArg: Int,
                acShiModArg: Int, acDefModArg: Int, acNatModArg: Int,
                acDodModArg: Int, acSizModArg: Int, cmbModArg: Int,
                cmdModArg: Int, fortModArg: Int, refModArg: Int,
                willModArg: Int, rageModArg: Int, spells1ModArg: Int,
                spells2ModArg: Int, spells3ModArg: Int) {
        modName = modNameArg
        twoHands = twoHandsArg
        dmgDice = dmgDiceArg
        hpMod = hpModArg
        hpPerLvlMod = hpPerLvlModArg
        strMod = strModArg
        dexMod = dexModArg
        conMod = conModArg
        intMod = intModArg
        wisMod = willModArg
        chrMod = chrModArg
        hitMod = hitModArg
        dmgMod = dmgModArg
        acMod = acModArg
        acArmMod = acArmModArg
        acShiMod = acShiModArg
        acDefMod = acDefModArg
        acNatMod = acNatModArg
        acDodMod = acDodModArg
        acSizMod = acSizModArg
        cmbMod = cmbModArg
        cmdMod = cmdModArg
        fortMod = fortModArg
        refMod = refModArg
        willMod = willModArg
        rageMod = rageModArg
        spells1Mod = spells1ModArg
        spells2Mod = spells2ModArg
        spells3Mod = spells3ModArg
    }

    constructor() {
        modName = "..."
        twoHands = false
        dmgDice = null
        hpMod = 0
        hpPerLvlMod = 0
        strMod = 0
        dexMod = 0
        conMod = 0
        intMod = 0
        wisMod = 0
        chrMod = 0
        hitMod = 0
        dmgMod = 0
        acMod = 0
        acArmMod = 0
        acShiMod = 0
        acDefMod = 0
        acNatMod = 0
        acDodMod = 0
        acSizMod = 0
        cmbMod = 0
        cmdMod = 0
        fortMod = 0
        refMod = 0
        willMod = 0
        rageMod = 0
        spells1Mod = 0
        spells2Mod = 0
        spells3Mod = 0
    }

    constructor(parcel: Parcel) {
        modName = parcel.readString()
        twoHands = (parcel.readInt() == 1)
        dmgDice = Dice.valueOf(parcel.readString())
        hpMod = parcel.readInt()
        hpPerLvlMod = parcel.readInt()
        strMod = parcel.readInt()
        dexMod = parcel.readInt()
        conMod = parcel.readInt()
        intMod = parcel.readInt()
        wisMod = parcel.readInt()
        chrMod = parcel.readInt()
        hitMod = parcel.readInt()
        dmgMod = parcel.readInt()
        acMod = parcel.readInt()
        acArmMod = parcel.readInt()
        acShiMod = parcel.readInt()
        acDefMod = parcel.readInt()
        acNatMod = parcel.readInt()
        acDodMod = parcel.readInt()
        acSizMod = parcel.readInt()
        cmbMod = parcel.readInt()
        cmdMod = parcel.readInt()
        fortMod = parcel.readInt()
        refMod = parcel.readInt()
        willMod = parcel.readInt()
        rageMod = parcel.readInt()
        spells1Mod = parcel.readInt()
        spells2Mod = parcel.readInt()
        spells3Mod = parcel.readInt()
    }

    companion object {
        @JvmField
        val CREATOR = object : Parcelable.Creator<CharacterMod> {
            override fun createFromParcel(parcel: Parcel) = CharacterMod(parcel)
            override fun newArray(size: Int) = arrayOfNulls<CharacterMod>(size)
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

        parcel.writeString(modName)
        if (twoHands) {
            parcel.writeInt(1)
        } else {
            parcel.writeInt(0)
        }
        parcel.writeString(dmgDice?.str ?: Dice.D.str)
        parcel.writeInt(hpMod)
        parcel.writeInt(hpPerLvlMod)
        parcel.writeInt(strMod)
        parcel.writeInt(dexMod)
        parcel.writeInt(conMod)
        parcel.writeInt(intMod)
        parcel.writeInt(wisMod)
        parcel.writeInt(chrMod)
        parcel.writeInt(hitMod)
        parcel.writeInt(dmgMod)
        parcel.writeInt(acMod)
        parcel.writeInt(acArmMod)
        parcel.writeInt(acShiMod)
        parcel.writeInt(acDefMod)
        parcel.writeInt(acNatMod)
        parcel.writeInt(acDodMod)
        parcel.writeInt(acSizMod)
        parcel.writeInt(cmbMod)
        parcel.writeInt(cmdMod)
        parcel.writeInt(fortMod)
        parcel.writeInt(refMod)
        parcel.writeInt(willMod)
        parcel.writeInt(rageMod)
        parcel.writeInt(spells1Mod)
        parcel.writeInt(spells2Mod)
        parcel.writeInt(spells3Mod)
    }

    override fun describeContents() = 0

}