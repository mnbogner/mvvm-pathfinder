package com.mvvm.pathfinder

import android.os.Parcel
import android.os.Parcelable

class CharacterMod (val modName: String, val twoHands: Boolean, val dmgDice: Dice?,
                         var hpMod: Int, var hpPerLvlMod: Int, var strMod: Int,
                         var dexMod: Int, var conMod: Int, var intMod: Int,
                         var wisMod: Int, var chrMod: Int, var hitMod: Int,
                         var dmgMod: Int, var acMod: Int, var acArmMod: Int,
                         var acShiMod: Int, var acDefMod: Int, var acNatMod: Int,
                         var acDodMod: Int, var acSizMod: Int, var cmbMod: Int,
                         var cmdMod: Int, var fortMod: Int, var refMod: Int,
                         var willMod: Int, var rageMod: Int, var spells1Mod: Int,
                         var spells2Mod: Int, var spells3Mod: Int) : Parcelable  {

    companion object {
        @JvmField
        val CREATOR = object : Parcelable.Creator<CharacterMod> {
            override fun createFromParcel(parcel: Parcel) = CharacterMod(parcel)
            override fun newArray(size: Int) = arrayOfNulls<CharacterMod>(size)
        }
    }

    private constructor(parcel: Parcel) : this(

        modName = parcel.readString(),
        twoHands = (parcel.readInt() == 1),
        dmgDice = Dice.valueOf(parcel.readString()),
        hpMod = parcel.readInt(),
        hpPerLvlMod = parcel.readInt(),
        strMod = parcel.readInt(),
        dexMod = parcel.readInt(),
        conMod = parcel.readInt(),
        intMod = parcel.readInt(),
        wisMod = parcel.readInt(),
        chrMod = parcel.readInt(),
        hitMod = parcel.readInt(),
        dmgMod = parcel.readInt(),
        acMod = parcel.readInt(),
        acArmMod = parcel.readInt(),
        acShiMod = parcel.readInt(),
        acDefMod = parcel.readInt(),
        acNatMod = parcel.readInt(),
        acDodMod = parcel.readInt(),
        acSizMod = parcel.readInt(),
        cmbMod = parcel.readInt(),
        cmdMod = parcel.readInt(),
        fortMod = parcel.readInt(),
        refMod = parcel.readInt(),
        willMod = parcel.readInt(),
        rageMod = parcel.readInt(),
        spells1Mod = parcel.readInt(),
        spells2Mod = parcel.readInt(),
        spells3Mod = parcel.readInt()
    )

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