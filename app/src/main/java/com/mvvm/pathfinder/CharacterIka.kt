package com.mvvm.pathfinder

// TODO: copy info in comments to somewhere else now that character is loaded from json file

class CharacterIka : Character {

    constructor():super("I'ka", 11, 6, 11, 14, 15, 14, 8, 14, 14, 7, 3, 3) {
        // racial abilities - aasimar/agathion: +2 con, +2 chr, +2 cmd (replaces spell-like ability)
        // traits: +1 cmb/intimidate (bred for war), +1 hp/skill per lvl (finding your kin)
        // stats: +1 dex lv4, +1 cha lv8
        // favored class bonus: +1 hp per lvl
        // automatic progression - lv+1: resistance +3, deflection +2, mental prowess +4 wis, physical prowess +4 str, toughening +1
        // belt of the weasel: +2 dex
        // caster torque: +2 lv1 spells
        // divine favor - tegura: natural +1
        // spells: 2+1 lv1, 1+1 lv2, 1+1 lv3
        progressionMod = CharacterMod("progression", false, null,
            0, 1+1, 4,        // hp, hp/lvl, str
            1+2, 2, 0,      // dex, con, int
            4, 2+1, 0,      // wis, chr, hit
            0, 0, 0,        // dmg, ac, armor
            0, 2, 1+1,      // shield, deflect, natural
            0, 0, 1,        // dodge, size, cmb
            2, 3, 3,      // cmd, fort, ref
            3, 2+1+2, // will, rage*lvl, lv1 spells (2 base spells doubled by ring/torc of wizardry)
            1+1, 1+1)       // lv2 spells, lv3 spells
    }

    companion object {
        // cestus
        // automatic progression lv+1: weapon attunement +2
        val cestusMod: CharacterMod = CharacterMod("cestus", false, Dice.D4,
            0, 0, 0,
            0, 0, 0,
            0, 0, 2,
            2, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0,
            0, 0)

        // longspear
        // reach, brace
        val spearMod: CharacterMod = CharacterMod("spear", true, Dice.D8,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0,
            0, 0)

        // yaku'oi ironwood scimitar
        // masterwork
        val scimitarMod: CharacterMod = CharacterMod("scimitar", false, Dice.D6,
            0, 0, 0,
            0, 0, 0,
            0, 0, 1,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0,
            0, 0)

        // yaku'oi composite longbow
        // +1, adaptive
        val longbowMod: CharacterMod = CharacterMod("longbow", true, Dice.D8,
            0, 0, 0,
            0, 0, 0,
            0, 0, 1,
            1, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0,
            0, 0)

        // improved grapple: +2 cmb/cmd
        // greater grapple: +2 cmb
        // grabbing style: 1 handed
        val grapplingMod: CharacterMod = CharacterMod("grappling", false, Dice.D4,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 4,
            2, 0, 0,
            0, 0,
            0, 0)

        // darkleaf lamellar
        val armorMod: CharacterMod = CharacterMod("armor", false, null,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 4,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0,
            0, 0)

        // yaku'oi ironwood buckler
        // automatic progression lv+1: armor attunement +2
        val shieldMod: CharacterMod = CharacterMod("shield", false, null,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            1+2, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0,
            0, 0)

        // grappling modifiers
        // ignoring cmb penalty because it doesn't affect grappling while grappled
        val grappleButton: ButtonMod = ButtonMod("grapple", false, null,
            0, 0, 0,
            -4, 0, 0,
            0, 0, -2,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0,
            0, 0, false,
            false, false, 0)

        // rage modifiers
        val ragingButton: ButtonMod = ButtonMod("rage", false, null,
            0, 0, 6,
            0, 6, 0,
            0, 0, 0,
            0, -2, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            3, 0,
            0, 0, true,
            false, true, 25)

        // haste modifiers
        val hasteButton: ButtonMod = ButtonMod("haste", false, null,
            0, 0, 0,
            0, 0, 0,
            0, 0, 1,
            0, 0, 0,
            0, 0, 0,
            1, 0, 0,
            0, 0, 1,
            0, 0,
            0, 0, false,
            false, false, 0)

        // enlarge modifiers
        val enlargeButton: ButtonMod = ButtonMod("enlarge", false, null,
            0, 0, 2,
            -2, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, -1, 0,
            0, 0, 0,
            0, 0,
            0, 0, false,
            false, false, 0)

        // blood armor modifiers
        val bloodButton: ButtonMod = ButtonMod("blood", false, null,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0, 0,
            0, 0,
            0, 0, true,
            true, false, 5)
    }

    override fun applyProgression() {
        addMod(progressionMod)
    }

    override fun getBaseStat(stat: Stat): Int {
        // just need CON for now to calculate rounds of rage
        return conBase + progressionMod.conMod
    }

    override fun getWeaponMods(): ArrayList<CharacterMod> {
        var weapons: ArrayList<CharacterMod> = ArrayList<CharacterMod>()
        weapons.add(cestusMod)
        weapons.add(spearMod)
        weapons.add(scimitarMod)
        weapons.add(longbowMod)
        weapons.add(grapplingMod)
        return weapons
    }

    override fun getArmorMods(): ArrayList<CharacterMod> {
        var armor: ArrayList<CharacterMod> = ArrayList<CharacterMod>()
        armor.add(armorMod)
        armor.add(shieldMod)
        return armor
    }

    override fun getButtonMods(): ArrayList<ButtonMod> {
        var buttons: ArrayList<ButtonMod> = ArrayList<ButtonMod>()
        buttons.add(grappleButton)
        buttons.add(ragingButton)
        buttons.add(hasteButton)
        buttons.add(enlargeButton)
        buttons.add(bloodButton)
        return buttons
    }
}