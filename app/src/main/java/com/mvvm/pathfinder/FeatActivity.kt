package com.mvvm.pathfinder

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ContextThemeWrapper
import kotlinx.android.synthetic.main.activity_feat.*

class FeatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feat)

        cc_feat.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("You get a +4 bonus on concentration checks made to cast a spell or use a spell-like ability when casting on the defensive or while grappled.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                        dialog.cancel()
                        val uri = Uri.parse("https://www.d20pfsrd.com/feats/general-feats/combat-casting/")
                        val i = Intent(Intent.ACTION_VIEW, uri)
                        startActivity(i)
                    }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        gs_feat.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("When you use this style, you do not take a –4 penalty on combat maneuver checks to grapple a foe with only one hand. Additionally, you do not lose your Dexterity bonus to AC while pinning an opponent.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/feats/combat-feats/grabbing-style-combat-style/")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        ig_feat.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("You do not provoke an attack of opportunity when performing a grapple combat maneuver. In addition, you receive a +2 bonus on checks made to grapple a foe. You also receive a +2 bonus to your Combat Maneuver Defense whenever an opponent tries to grapple you.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/feats/combat-feats/improved-grapple-combat/")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        gg_feat.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("You receive a +2 bonus on checks made to grapple a foe. This bonus stacks with the bonus granted by Improved Grapple. Once you have grappled a creature, maintaining the grapple is a move action. This feat allows you to make two grapple checks each round (to move, harm, or pin your opponent), but you are not required to make two checks. You only need to succeed at one of these checks to maintain the grapple.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/feats/combat-feats/greater-grapple-combat/")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        bs_feat.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("As an immediate action while you are grappling an adjacent creature, you can make a grapple combat maneuver check against that creature to gain cover against a single attack. If you are successful and the attack misses you, that attack targets the creature you used as cover, using the same attack roll. You cannot use this feat against a creature grappling you, and the cover you gain ends after the attack you gained cover against is resolved.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/feats/combat-feats/body-shield-combat/")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        do_feat.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("You gain a +1 dodge bonus to your AC. A condition that makes you lose your Dex bonus to AC also makes you lose the benefits of this feat.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/feats/combat-feats/dodge-combat/")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        en_feat.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("Whenever you deal nonlethal damage with a melee weapon, you can make an Intimidate check to demoralize your target as a free action. If you are successful, the target is shaken for a number of rounds equal to the damage dealt. If your attack was a critical hit, your target is frightened for 1 round with a successful Intimidate check, as well as being shaken for a number of rounds equal to the damage dealt.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/feats/combat-feats/enforcer-combat/")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        di_feat.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("The DC to cast spells defensively increases by +4 for all enemies that are within your threatened area. This increase to casting spells defensively only applies if you are aware of the enemy’s location and are capable of taking an attack of opportunity. If you can only take one attack of opportunity per round and have already used that attack, this increase does not apply.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/feats/combat-feats/disruptive-combat/")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        cr_feat.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("You may make a number of additional attacks of opportunity per round equal to your Dexterity bonus. With this feat, you may also make attacks of opportunity while flat-footed.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/feats/combat-feats/combat-reflexes-combat/")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        br_ability.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("A bloodrager can enter a bloodrage as a free action. While in a bloodrage, a bloodrager gains a +4 morale bonus to his Strength and Constitution, as well as a +2 morale bonus on Will saves. In addition, he takes a –2 penalty to Armor Class. The increase to Constitution grants the bloodrager 2 hit points per Hit Die, but these disappear when the bloodrage ends and are not lost first like temporary hit points. While bloodraging, a bloodrager cannot use any Charisma-, Dexterity-, or Intelligence-based skills (except Acrobatics, Fly, Intimidate, and Ride) or any ability that requires patience or concentration.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/classes/hybrid-classes/Bloodrager/#Bloodrage_Su")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        ab_ability.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("At 8th level, when entering a bloodrage, you can choose to apply the effects of either displacement or haste to yourself. These effects last for as long as you continue bloodraging, regardless of the spell’s normal duration.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/classes/hybrid-classes/bloodrager/bloodrager-bloodlines/paizo-bloodrager-bloodlines/Arcane/#Greater_Arcane_Bloodrage_Sp")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        bs_ability.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("At 3rd level, due to the power of his blood, a bloodrager can stand confidently amid the effects of spells cast by himself or his allies. He gains a +2 bonus on saving throws against spells that he or an ally casts.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/classes/hybrid-classes/Bloodrager/#Blood_Sanctuary_Su")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        bc_ability.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("At 4th level, the bloodrager gains the ability to cast spells even while bloodraging. He can also cast these spells defensively and can make concentration checks for these spells while bloodraging. While bloodraging, he can cast and concentrate on only his bloodrager spells (see below); spells from other classes cannot be cast during this state.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/classes/hybrid-classes/Bloodrager/#Blood_Casting_Su")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        em_ability.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("You can cast any spell with a material component costing 1 gp or less without needing that component. The casting of the spell still provokes attacks of opportunity as normal. If the spell requires a material component that costs more than 1 gp, you must have the material component on hand to cast the spell, as normal.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/feats/general-feats/eschew-materials")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        db_ability.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("At 1st level, the DC to cast spells defensively increases by 2 for enemies within your threatened area. This increase stacks with that granted by the Disruptive feat.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/classes/hybrid-classes/bloodrager/bloodrager-bloodlines/paizo-bloodrager-bloodlines/Arcane/#Disruptive_Bloodrage_Su")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        sc_ability.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("At 5th level, as long as a blood conduit is wearing light or no armor, he can deliver bloodrager spells with a range of touch through bodily contact. When he succeeds at a combat maneuver check to bull rush, grapple, pin, reposition, or trip an opponent, or makes an unarmed strike against an enemy, he can as a swift action cast a touch spell on the creature that he affected with the combat maneuver, requiring no further touch attack roll. If this spell would usually require a successful touch attack, his successful combat maneuver check counts as this attack.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/classes/hybrid-classes/bloodrager/archetypes/paizo-bloodrager-archetypes/blood-conduit")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        rg_ability.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("As long as you are raging, whenever you succeed at a check to start a grapple, you can choose to deal damage as if you had also succeeded at a check to maintain the grapple. In addition, while raging, whenever you succeed at a combat maneuver check to maintain a grapple, you can choose to give yourself, the target of your grapple, or both the prone condition as a free action while continuing to maintain the grapple.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/classes/core-classes/barbarian/rage-powers/paizo-rage-powers/raging-grappler-ex")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        ig_ability.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("The barbarian can make an Intimidate check against one adjacent foe as a move action. If the barbarian successfully demoralizes her opponent, the foe is shaken for 1d4 rounds + 1 round for every 5 points by which the barbarian’s check exceeds the DC.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/classes/core-classes/barbarian/rage-powers/paizo-rage-powers/intimidating-glare-ex")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        dr_ability.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("At 7th level, a bloodrager gains damage reduction. Subtract 1 from the damage the bloodrager takes each time he is dealt damage from a weapon or a natural attack. At 10th level, and every 3 levels thereafter, this damage reduction increases by 1 point. Damage Reduction can reduce damage to 0, but not below 0.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/classes/hybrid-classes/Bloodrager/#Damage_Reduction_Ex")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        /*
        cc_feat.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("foo")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("foo")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }
        */
    }
}