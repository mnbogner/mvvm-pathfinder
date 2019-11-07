package com.mvvm.pathfinder

data class CharacterMod (val modName: String, val twoHands: Boolean, val dmgDice: Dice?,
                         var hpMod: Int, var hpPerLvlMod: Int, var strMod: Int,
                         var dexMod: Int, var conMod: Int, var intMod: Int,
                         var wisMod: Int, var chrMod: Int, var hitMod: Int,
                         var dmgMod: Int, var acMod: Int, var acArmMod: Int,
                         var acShiMod: Int, var acDefMod: Int, var acNatMod: Int,
                         var acDodMod: Int, var acSizMod: Int, var cmbMod: Int,
                         var cmdMod: Int, var fortMod: Int, var refMod: Int,
                         var willMod: Int) {

}