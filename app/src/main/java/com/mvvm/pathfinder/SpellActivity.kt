package com.mvvm.pathfinder

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ContextThemeWrapper
import kotlinx.android.synthetic.main.activity_spell.*

class SpellActivity : AppCompatActivity() {

    companion object {

        val SPELL_RESULT: Int = 200
        val LV1_RESULT: String = "lv1"
        val LV2_RESULT: String = "lv2"
        val LV3_RESULT: String = "lv3"

    }

    var lv1Spells: Int = 0
    var lv2Spells: Int = 0
    var lv3Spells: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spell)

        lv1Spells = intent.getIntExtra(Stat.LV1S.name, 0)
        lv2Spells = intent.getIntExtra(Stat.LV2S.name, 0)
        lv3Spells = intent.getIntExtra(Stat.LV3S.name, 0)

        lv1_val.setText(lv1Spells.toString())
        lv2_val.setText(lv2Spells.toString())
        lv3_val.setText(lv3Spells.toString())

        lv1_up.setOnClickListener {
            lv1Spells++
            lv1_val.setText(lv1Spells.toString())
        }

        lv1_down.setOnClickListener {
            lv1Spells--
            lv1_val.setText(lv1Spells.toString())
        }

        lv2_up.setOnClickListener {
            lv2Spells++
            lv2_val.setText(lv2Spells.toString())
        }

        lv2_down.setOnClickListener {
            lv2Spells--
            lv2_val.setText(lv2Spells.toString())
        }

        lv3_up.setOnClickListener {
            lv3Spells++
            lv3_val.setText(lv3Spells.toString())
        }

        lv3_down.setOnClickListener {
            lv3Spells--
            lv3_val.setText(lv3Spells.toString())
        }

        mm_spell.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("A missile of magical energy darts forth from your fingertip and strikes its target, dealing 1d4+1 points of force damage.\n" +
                    "\n" +
                    "The missile strikes unerringly, even if the target is in melee combat, so long as it has less than total cover or total concealment. Specific parts of a creature can’t be singled out. Objects are not damaged by the spell.\n" +
                    "\n" +
                    "For every two caster levels beyond 1st, you gain an additional missile – two at 3rd level, three at 5th, four at 7th, and the maximum of five missiles at 9th level or higher. If you shoot multiple missiles, you can have them strike a single creature or several creatures.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/magic/all-spells/m/magic-missile")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        ep_spell.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("This spell causes instant growth of a humanoid creature, doubling its height and multiplying its weight by 8. This increase changes the creature’s size category to the next larger one. The target gains a +2 size bonus to Strength, a -2 size penalty to Dexterity (to a minimum of 1), and a -1 penalty on attack rolls and AC due to its increased size.\n" +
                    "\n" +
                    "A humanoid creature whose size increases to Large has a space of 10 feet and a natural reach of 10 feet. This spell does not change the target’s speed.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/magic/all-spells/e/enlarge-person")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        tog_spell.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("With a single touch, you reduce a creature to a fumbling clown.\n" +
                    "\n" +
                    "The target takes a penalty to its Dexterity equal to 1d6+1 per two caster levels (maximum 1d6+5). This penalty cannot drop the target’s Dexterity score below 1.\n" +
                    "\n" +
                    "In addition, if the subject moves more than half its speed, it falls prone. If the subject flies, its maneuverability is reduced by one step (perfect maneuverability becomes good, good becomes average, and so on).")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/magic/all-spells/t/touch-of-gracelessness")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        /*
        bb_spell.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("You cut yourself with the dagger, dealing yourself 1d6 points of bleed damage. So long as you keep taking this bleed damage, your targets each bleed for 1d6 points of damage at the beginning of their turns. The bleed damage on any target ends if that target receives magical healing, or if your bleed damage ends for any reason. This spell has no effect if you’re immune to bleed damage or can otherwise reduce or ignore the bleed damage to yourself.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/magic/all-spells/b/bloodbath")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }
        */

        bc_spell.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("You summon a chain from another realm, causing it to burst out from the ground and strike a target within the spell’s range. You can have the chain either make a melee attack (dealing 1d6 points of slashing damage) or attempt a trip combat maneuver against the target. The chain uses your base attack bonus plus your key spellcasting ability score modifier as its attack bonus and combat maneuver bonus. On a successful hit or combat maneuver check, the target must attempt a Will save. If it fails its save, the creature is shaken for 1d4 rounds. You summon one additional chain every 3 levels after 1st, for a total of two chains at 4th level, three at 7th level, and a maximum of four at 10th level. Multiple chains can attack the same target but the shaken effect doesn’t stack.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/magic/all-spells/b/barbed-chains")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        ih_spell.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("You anoint a wounded creature with devil’s blood or unholy water, giving it fast healing 1. This ability cannot repair damage caused by silver weapons, good-aligned weapons, or spells or effects with the good descriptor. The target detects as an evil creature for the duration of the spell and can sense the evil of the magic, though this has no long-term effect on the target’s alignment.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/magic/all-spells/i/infernal-healing")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        we_spell.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("You respond to an attack by briefly becoming vaporous and insubstantial, allowing the attack to pass harmlessly through you. You gain DR 10/magic against this attack and are immune to any poison, sneak attacks, or critical hit effect from that attack.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/magic/all-spells/w/windy-escape")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        in_spell.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("The creature or object touched becomes invisible. If the recipient is a creature carrying gear, that vanishes, too. If you cast the spell on someone else, neither you nor your allies can see the subject, unless you can normally see invisible things or you employ magic to do so.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/magic/all-spells/i/invisibility")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        aa_spell.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("You gain some of the beneficial qualities of an animal. Your base form is largely unchanged and your size is unaltered, but some of your body parts are altered. Armor or gear you are wearing adjusts to your new shape for the duration of the spell. When you cast animal aspect, choose one of the following animals to gain the associated benefits. You can only have one animal aspect or greater animal aspect spell active on you at a time.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/magic/all-spells/a/animal-aspect")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        toi_spell.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("With a touch, you reduce the target’s mental faculties. Your successful melee touch attack applies a 1d6 penalty to the target’s Intelligence, Wisdom, and Charisma scores. This penalty can’t reduce any of these scores below 1.\n" +
                    "\n" +
                    "This spell’s effect may make it impossible for the target to cast some or all of its spells, if the requisite ability score drops below the minimum required to cast spells of that level.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/magic/all-spells/t/touch-of-idiocy")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        /*
        adb_spell.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("Your blood thickens to becomes a glue-like substance upon contact with air. A piercing or slashing weapon that deals hit point damage to you is stuck fast unless the wielder succeeds at a Reflex save. A creature can pry off a stuck weapon on its turn as a standard action with a successful Strength check against the spell’s DC. Strong alcohol or universal solvent dissolves the adhesive. The glue breaks down 5 rounds after you die, or when the duration ends. ")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/magic/all-spells/a/adhesive-blood")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }
        */

        ba_spell.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("Your blood becomes as hard as iron upon contact with air. Each time you take at least 5 points of piercing or slashing damage, your armor gains a +1 enhancement bonus to your AC. This enhancement bonus stacks with itself, but not with an existing enhancement bonus, to a maximum enhancement bonus of +5.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/magic/all-spells/b/blood-armor")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        ab_spell.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("Invisible layers of solid force surround and protect the target, granting that target a +2 armor bonus to AC. Additionally, the first 5 points of lethal damage the target takes from each attack are converted into nonlethal damage. Against attacks that already deal nonlethal damage, the target gains DR 5/—. Once this spell has converted 5 points of damage to nonlethal damage per caster level (maximum 50 points), the spell is discharged.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/magic/all-spells/a/ablative-barrier")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        vt_spell.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("You must succeed on a melee touch attack. Your touch deals 1d6 points of damage per two caster levels (maximum 10d6). You gain temporary hit points equal to the damage you deal. You can’t gain more than the subject’s current hit points + the subject’s Constitution score (which is enough to kill the subject). The temporary hit points disappear 1 hour later.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/magic/all-spells/v/vampiric-touch")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        dr_spell.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("Draconic reservoir functions as protection from energy, absorbing 6 points of one type of energy damage per caster level (acid, cold, electricity, or fire, maximum 60 points). Each round, as a swift action, the subject can release 1d6 points of the absorbed energy and apply it to any melee attack, as if using an acidic, flaming, frost, or shock weapon.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/magic/all-spells/d/draconic-reservoir")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }
    }

    override fun onBackPressed() {

        System.out.println("FOO - FINISH LV1: " + lv1Spells + ", LV2: " + lv2Spells + ", LV3: " + lv3Spells)

        val i: Intent = Intent()
        i.putExtra(LV1_RESULT, lv1Spells)
        i.putExtra(LV2_RESULT, lv2Spells)
        i.putExtra(LV3_RESULT, lv3Spells)
        setResult(SPELL_RESULT, i)

        super.onBackPressed()
    }

    /*
    override fun finish() {

        System.out.println("FOO - FINISH LV1: " + lv1Spells + ", LV2: " + lv2Spells)

        val i: Intent = Intent()
        i.putExtra(LV1_RESULT, lv1Spells)
        i.putExtra(LV2_RESULT, lv2Spells)
        setResult(SPELL_RESULT, i)

        super.finish()
    }
    */

}