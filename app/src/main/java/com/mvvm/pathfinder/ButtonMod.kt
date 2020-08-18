package com.mvvm.pathfinder

import android.os.Parcel

class ButtonMod : CharacterMod  {

    var longPress: Boolean
    var increment: Boolean
    var loop: Boolean
    var limit: Int

    constructor(modNameArg: String, twoHandsArg: Boolean, dmgDiceArg: Dice?,
                hpModArg: Int, hpPerLvlModArg: Int, strModArg: Int,
                dexModArg: Int, conModArg: Int, intModArg: Int,
                wisModArg: Int, chrModArg: Int, hitModArg: Int,
                dmgModArg: Int, acModArg: Int, acArmModArg: Int,
                acShiModArg: Int, acDefModArg: Int, acNatModArg: Int,
                acDodModArg: Int, acSizModArg: Int, cmbModArg: Int,
                cmdModArg: Int, fortModArg: Int, refModArg: Int,
                willModArg: Int, spells1ModArg: Int,
                spells2ModArg: Int, spells3ModArg: Int, longPressArg: Boolean,
                incrementArg: Boolean, loopArg: Boolean, limitArg: Int):super(
        modNameArg, twoHandsArg, dmgDiceArg, hpModArg, hpPerLvlModArg, strModArg,
        dexModArg, conModArg, intModArg, wisModArg, chrModArg, hitModArg,
        dmgModArg, acModArg, acArmModArg, acShiModArg, acDefModArg, acNatModArg,
        acDodModArg, acSizModArg, cmbModArg, cmdModArg, fortModArg, refModArg,
        willModArg, spells1ModArg, spells2ModArg, spells3ModArg) {
        longPress = longPressArg
        increment = incrementArg
        loop = loopArg
        limit = limitArg
    }

    constructor():super() {
        longPress = false
        increment = false
        loop = false
        limit = 0
    }

    constructor(parcel: Parcel):super(parcel) {
        longPress = (parcel.readInt() == 1)
        increment = (parcel.readInt() == 1)
        loop = (parcel.readInt() == 1)
        limit = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        super.writeToParcel(parcel, flags)
        if (longPress) {
            parcel.writeInt(1)
        } else {
            parcel.writeInt(0)
        }
        if (increment) {
            parcel.writeInt(1)
        } else {
            parcel.writeInt(0)
        }
        if (loop) {
            parcel.writeInt(1)
        } else {
            parcel.writeInt(0)
        }
        parcel.writeInt(limit)
    }
}