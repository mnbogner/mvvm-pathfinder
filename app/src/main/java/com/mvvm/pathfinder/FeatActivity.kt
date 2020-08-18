package com.mvvm.pathfinder

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ContextThemeWrapper
import kotlinx.android.synthetic.main.activity_feat.*

class FeatActivity : AppCompatActivity() {

    // TODO: load objects from json

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feat)

        // currently working with a fixed set of buttons
        var featSlots: ArrayList<TextView> = ArrayList<TextView>()
        featSlots.add(lc1_feat)
        featSlots.add(lc2_feat)
        featSlots.add(lc3_feat)
        featSlots.add(lc4_feat)
        featSlots.add(lc5_feat)
        featSlots.add(rc1_feat)
        featSlots.add(rc2_feat)
        featSlots.add(rc3_feat)
        featSlots.add(rc4_feat)
        featSlots.add(rc5_feat)

        val cocObject = InfoObject(
            "Combat Casting",
            "You get a +4 bonus on concentration checks made to cast a spell or use a spell-like ability when casting on the defensive or while grappled.",
            "https://www.d20pfsrd.com/feats/general-feats/combat-casting",
            0,
            0,
            0
        )

        val graObject = InfoObject(
            "Grabbing Style",
            "When you use this style, you do not take a –4 penalty on combat maneuver checks to grapple a foe with only one hand. Additionally, you do not lose your Dexterity bonus to AC while pinning an opponent.",
            "https://www.d20pfsrd.com/feats/combat-feats/grabbing-style-combat-style",
            0,
            0,
            0
        )

        val impObject = InfoObject(
            "Improved Grapple",
            "You do not provoke an attack of opportunity when performing a grapple combat maneuver. In addition, you receive a +2 bonus on checks made to grapple a foe. You also receive a +2 bonus to your Combat Maneuver Defense whenever an opponent tries to grapple you.",
            "https://www.d20pfsrd.com/feats/combat-feats/improved-grapple-combat",
            0,
            0,
            0
        )

        val grgObject = InfoObject(
            "Greater Grapple",
            "You receive a +2 bonus on checks made to grapple a foe. This bonus stacks with the bonus granted by Improved Grapple. Once you have grappled a creature, maintaining the grapple is a move action. This feat allows you to make two grapple checks each round (to move, harm, or pin your opponent), but you are not required to make two checks. You only need to succeed at one of these checks to maintain the grapple.",
            "https://www.d20pfsrd.com/feats/combat-feats/greater-grapple-combat/",
            0,
            0,
            0
        )

        val rapObject = InfoObject(
            "Rapid Grappler",
            "Whenever you use Greater Grapple to successfully maintain a grapple as a move action, you can then spend a swift action to make a grapple combat maneuver check at a –5 penalty.",
            "https://www.d20pfsrd.com/feats/combat-feats/rapid-grappler-combat/",
            0,
            0,
            0
        )

        val bodObject = InfoObject(
            "Body Shield",
            "As an immediate action while you are grappling an adjacent creature, you can make a grapple combat maneuver check against that creature to gain cover against a single attack. If you are successful and the attack misses you, that attack targets the creature you used as cover, using the same attack roll. You cannot use this feat against a creature grappling you, and the cover you gain ends after the attack you gained cover against is resolved.",
            "https://www.d20pfsrd.com/feats/combat-feats/body-shield-combat/",
            0,
            0,
            0
        )

        val enfObject = InfoObject(
            "Enforcer",
            "Whenever you deal nonlethal damage with a melee weapon, you can make an Intimidate check to demoralize your target as a free action. If you are successful, the target is shaken for a number of rounds equal to the damage dealt. If your attack was a critical hit, your target is frightened for 1 round with a successful Intimidate check, as well as being shaken for a number of rounds equal to the damage dealt.",
            "https://www.d20pfsrd.com/feats/combat-feats/enforcer-combat/",
            0,
            0,
            0
        )

        val disObject = InfoObject(
            "Disruptive",
            "The DC to cast spells defensively increases by +4 for all enemies that are within your threatened area. This increase to casting spells defensively only applies if you are aware of the enemy’s location and are capable of taking an attack of opportunity. If you can only take one attack of opportunity per round and have already used that attack, this increase does not apply.",
            "https://www.d20pfsrd.com/feats/combat-feats/disruptive-combat/",
            0,
            0,
            0
        )

        val corObject = InfoObject(
            "Combat Reflexes",
            "You may make a number of additional attacks of opportunity per round equal to your Dexterity bonus. With this feat, you may also make attacks of opportunity while flat-footed.",
            "https://www.d20pfsrd.com/feats/combat-feats/combat-reflexes-combat/",
            0,
            0,
            0
        )

        val comObject = InfoObject(
            "Compression",
            "The creature can move through an area as small as one-quarter its space without squeezing or one-eighth its space when squeezing.",
            "https://www.d20pfsrd.com/bestiary/rules-for-monsters/universal-monster-rules#TOC-Compression-Ex-",
            0,
            0,
            0
        )

        var feats: ArrayList<InfoObject> = ArrayList<InfoObject>()
        feats.add(cocObject)
        feats.add(graObject)
        feats.add(impObject)
        feats.add(grgObject)
        feats.add(rapObject)
        feats.add(bodObject)
        feats.add(enfObject)
        feats.add(disObject)
        feats.add(corObject)
        feats.add(comObject)

        for (i in 0 until featSlots.size) {
            if (i < feats.size) {
                var feat = feats.get(i)
                var featSlot = featSlots.get(i)
                featSlot.setText(feat.name)
                featSlot.setOnClickListener {
                    var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
                    dialog.setMessage(feat.text)
                    dialog.setButton(
                        AlertDialog.BUTTON_POSITIVE,
                        "CLOSE",
                        DialogInterface.OnClickListener { dialog, id ->
                            dialog.cancel()
                        })
                    dialog.setButton(
                        AlertDialog.BUTTON_NEGATIVE,
                        "LINK",
                        DialogInterface.OnClickListener { dialog, id ->
                            run {
                                dialog.cancel()
                                val uri =
                                    Uri.parse(feat.link)
                                val i = Intent(Intent.ACTION_VIEW, uri)
                                startActivity(i)
                            }
                        })
                    dialog.show()

                    var message: TextView =
                        dialog.getWindow().findViewById(android.R.id.message) as TextView
                    message.textSize = 14f
                }
            } else {
                var featSlot = featSlots.get(i)
                featSlot.visibility = View.GONE
            }
        }

        var abilitySlots: ArrayList<TextView> = ArrayList<TextView>()
        abilitySlots.add(lc1_ability)
        abilitySlots.add(lc2_ability)
        abilitySlots.add(lc3_ability)
        abilitySlots.add(lc4_ability)
        abilitySlots.add(lc5_ability)
        abilitySlots.add(lc6_ability)
        abilitySlots.add(lc7_ability)
        abilitySlots.add(rc1_ability)
        abilitySlots.add(rc2_ability)
        abilitySlots.add(rc3_ability)
        abilitySlots.add(rc4_ability)
        abilitySlots.add(rc5_ability)
        abilitySlots.add(rc6_ability)
        abilitySlots.add(rc7_ability)

        val blrObject = InfoObject(
            "Bloodrage",
            "A bloodrager can enter a bloodrage as a free action. While in a bloodrage, a bloodrager gains a +4 morale bonus to his Strength and Constitution, as well as a +2 morale bonus on Will saves. In addition, he takes a –2 penalty to Armor Class. The increase to Constitution grants the bloodrager 2 hit points per Hit Die, but these disappear when the bloodrage ends and are not lost first like temporary hit points. While bloodraging, a bloodrager cannot use any Charisma-, Dexterity-, or Intelligence-based skills (except Acrobatics, Fly, Intimidate, and Ride) or any ability that requires patience or concentration.",
            "https://www.d20pfsrd.com/classes/hybrid-classes/Bloodrager/#Bloodrage_Su",
            0,
            0,
            0
        )

        val arcObject = InfoObject(
            "Arcane Bloodrage",
            "At 8th level, when entering a bloodrage, you can choose to apply the effects of either displacement or haste to yourself. These effects last for as long as you continue bloodraging, regardless of the spell’s normal duration.",
            "https://www.d20pfsrd.com/classes/hybrid-classes/bloodrager/bloodrager-bloodlines/paizo-bloodrager-bloodlines/Arcane/#Greater_Arcane_Bloodrage_Sp",
            0,
            0,
            0
        )

        val grbObject = InfoObject(
            "Greater Bloodrage",
            "At 11th level, when a bloodrager enters a bloodrage, the morale bonus to his Strength and Constitution increases to +6 and the morale bonus on his Will saves increases to +3. In addition, upon entering a bloodrage, the bloodrager can apply the effects a bloodrager spell he knows of 2nd level or lower to himself. The spell must have a range of touch or personal. If the spell’s duration is greater than 1 round, it instead lasts for the duration of the bloodrage.",
            "https://www.d20pfsrd.com/classes/hybrid-classes/Bloodrager/#TOC-Greater-Bloodrage-Su",
            0,
            0,
            0
        )

        val blsObject = InfoObject(
            "Blood Sanctuary",
            "At 3rd level, due to the power of his blood, a bloodrager can stand confidently amid the effects of spells cast by himself or his allies. He gains a +2 bonus on saving throws against spells that he or an ally casts.",
            "https://www.d20pfsrd.com/classes/hybrid-classes/Bloodrager/#Blood_Sanctuary_Su",
            0,
            0,
            0
        )

        val blcObject = InfoObject(
            "Blood Casting",
            "At 4th level, the bloodrager gains the ability to cast spells even while bloodraging. He can also cast these spells defensively and can make concentration checks for these spells while bloodraging. While bloodraging, he can cast and concentrate on only his bloodrager spells (see below); spells from other classes cannot be cast during this state.",
            "https://www.d20pfsrd.com/classes/hybrid-classes/Bloodrager/#Blood_Casting_Su",
            0,
            0,
            0
        )

        val escObject = InfoObject(
            "Eschew Materials",
            "You can cast any spell with a material component costing 1 gp or less without needing that component. The casting of the spell still provokes attacks of opportunity as normal. If the spell requires a material component that costs more than 1 gp, you must have the material component on hand to cast the spell, as normal.",
            "https://www.d20pfsrd.com/feats/general-feats/eschew-materials",
            0,
            0,
            0
        )

        val dibObject = InfoObject(
            "Disruptive Bloodrage",
            "At 1st level, the DC to cast spells defensively increases by 2 for enemies within your threatened area. This increase stacks with that granted by the Disruptive feat.",
            "https://www.d20pfsrd.com/classes/hybrid-classes/bloodrager/bloodrager-bloodlines/paizo-bloodrager-bloodlines/Arcane/#Disruptive_Bloodrage_Su",
            0,
            0,
            0
        )

        val speObject = InfoObject(
            "Spell Conduit",
            "At 5th level, as long as a blood conduit is wearing light or no armor, he can deliver bloodrager spells with a range of touch through bodily contact. When he succeeds at a combat maneuver check to bull rush, grapple, pin, reposition, or trip an opponent, or makes an unarmed strike against an enemy, he can as a swift action cast a touch spell on the creature that he affected with the combat maneuver, requiring no further touch attack roll. If this spell would usually require a successful touch attack, his successful combat maneuver check counts as this attack.",
            "https://www.d20pfsrd.com/classes/hybrid-classes/bloodrager/archetypes/paizo-bloodrager-archetypes/blood-conduit",
            0,
            0,
            0
        )

        val ragObject = InfoObject(
            "Raging Grappler",
            "As long as you are raging, whenever you succeed at a check to start a grapple, you can choose to deal damage as if you had also succeeded at a check to maintain the grapple. In addition, while raging, whenever you succeed at a combat maneuver check to maintain a grapple, you can choose to give yourself, the target of your grapple, or both the prone condition as a free action while continuing to maintain the grapple.",
            "https://www.d20pfsrd.com/classes/core-classes/barbarian/rage-powers/paizo-rage-powers/raging-grappler-ex",
            0,
            0,
            0
        )

        val lesObject = InfoObject(
            "Lesser Fiend Totem",
            "While raging, the barbarian grows a pair of large horns, gaining a gore attack. This attack is a primary attack (unless she is also attacking with weapons, in which case it is a secondary attack) and is made at the barbarian’s full base attack bonus (–5 if it is a secondary attack). The gore attack deals 1d8 points of piercing damage (1d6 if Small) plus the barbarian’s Strength modifier (1/2 if it is a secondary attack).",
            "https://www.d20pfsrd.com/classes/core-classes/barbarian/rage-powers/paizo-rage-powers/fiend-totem-lesser-su",
            0,
            0,
            0
        )

        val damObject = InfoObject(
            "Damage Reduction",
            "At 7th level, a bloodrager gains damage reduction. Subtract 1 from the damage the bloodrager takes each time he is dealt damage from a weapon or a natural attack. At 10th level, and every 3 levels thereafter, this damage reduction increases by 1 point. Damage Reduction can reduce damage to 0, but not below 0.",
            "https://www.d20pfsrd.com/classes/hybrid-classes/Bloodrager/#Damage_Reduction_Ex",
            0,
            0,
            0
        )

        val celObject = InfoObject(
            "Celestial Resistance",
            "Aasimars have acid resistance 5, cold resistance 5, and electricity resistance 5.",
            "https://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Energy-Resistance",
            0,
            0,
            0
        )

        val darObject = InfoObject(
            "Darkvision",
            "Aasimar have darkvision 60 ft. (they can see perfectly in the dark up to 60 feet.)",
            "https://www.d20pfsrd.com/gamemastering/special-abilities#TOC-Darkvision",
            0,
            0,
            0
        )

        var abilities: ArrayList<InfoObject> = ArrayList<InfoObject>()
        abilities.add(blrObject)
        abilities.add(arcObject)
        abilities.add(grbObject)
        abilities.add(blsObject)
        abilities.add(blcObject)
        abilities.add(escObject)
        abilities.add(dibObject)
        abilities.add(speObject)
        abilities.add(ragObject)
        abilities.add(lesObject)
        abilities.add(damObject)
        abilities.add(celObject)
        abilities.add(darObject)

        for (i in 0 until abilitySlots.size) {
            if (i < abilities.size) {
                var ability = abilities.get(i)
                var abilitySlot = abilitySlots.get(i)
                abilitySlot.setText(ability.name)
                abilitySlot.setOnClickListener {
                    var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
                    dialog.setMessage(ability.text)
                    dialog.setButton(
                        AlertDialog.BUTTON_POSITIVE,
                        "CLOSE",
                        DialogInterface.OnClickListener { dialog, id ->
                            dialog.cancel()
                        })
                    dialog.setButton(
                        AlertDialog.BUTTON_NEGATIVE,
                        "LINK",
                        DialogInterface.OnClickListener { dialog, id ->
                            run {
                                dialog.cancel()
                                val uri =
                                    Uri.parse(ability.link)
                                val i = Intent(Intent.ACTION_VIEW, uri)
                                startActivity(i)
                            }
                        })
                    dialog.show()
                    var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
                    message.textSize = 14f
                }
            } else {
                var abilitySlot = abilitySlots.get(i)
                abilitySlot.visibility = View.GONE
            }
        }
    }
}