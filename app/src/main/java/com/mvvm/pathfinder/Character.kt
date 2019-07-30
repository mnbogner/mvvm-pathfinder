package com.mvvm.pathfinder

data class Character(val characterName: String) {

    var strBase: Int = 10
    var dexBase: Int = 10
    var conBase: Int = 10
    var intBase: Int = 10
    var wisBase: Int = 10
    var chrBase: Int = 10

    var strMod: Int = 0
    var dexMod: Int = 0
    var conMod: Int = 0
    var intMod: Int = 0
    var wisMod: Int = 0
    var chrMod: Int = 0

    fun getStrBonus(): Int {
        return (strBase + strMod - 10) / 2
    }
}