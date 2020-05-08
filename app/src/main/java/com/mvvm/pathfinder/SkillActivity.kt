package com.mvvm.pathfinder

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ContextThemeWrapper
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : AppCompatActivity() {

    // TODO: pull from view model

    // skill ranks: 4 (ranks/lvl) -1 (int modifier) +1 (finding your kin) * 10 (lvl) = 40
    // skipped trained-only skills with no ranks

    val ac_rank: Int = 4 // +1 +3 ranks/class skill
    val ap_rank: Int = 0 // +0 ranks
    val bl_rank: Int = 0 // +0 ranks
    val cl_rank: Int = 4 // +1 +3 ranks/class skill
    val cr_rank: Int = 0 // +0 +0 ranks/class skill(no ranks)
    val dp_rank: Int = 0 // +0 ranks
    val dd_rank: Int = 8 // +8 ranks
    val ds_rank: Int = 0 // +0 ranks
    val ea_rank: Int = 0 // +0 ranks
    val fl_rank: Int = 0 // +0 ranks
    val ha_rank: Int = 3 // +1 +2 ranks/racial bonus
    val hl_rank: Int = 0 // +0 ranks
    val in_rank: Int = 8 // +4 +3 +1 ranks/class skill/bred for war
    val kg_rank: Int = 1 // +1 ranks
    val kl_rank: Int = 1 // +1 ranks
    val ln_rank: Int = 1 // +1 ranks
    val pc_rank: Int = 8 // +5 +3 ranks/class skill
    val pf_rank: Int = 0 // +0 ranks
    val pr_rank: Int = 5 // +5 ranks
    val rd_rank: Int = 0 // +0 ranks/class skill(no ranks)
    val sm_rank: Int = 0 // +0 ranks
    val st_rank: Int = 8 // +8 ranks
    val sr_rank: Int = 8 // +3 +3 +2 ranks/class skill/racial bonus
    val sw_rank: Int = 4 // +1 +3 ranks/class skill

    var st_bonus: Int = 0
    var dx_bonus: Int = 0
    var cn_bonus: Int = 0
    var in_bonus: Int = 0
    var wi_bonus: Int = 0
    var ch_bonus: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        st_bonus = intent.getIntExtra(Stat.STR.name, 0)
        dx_bonus = intent.getIntExtra(Stat.DEX.name, 0)
        cn_bonus = intent.getIntExtra(Stat.CON.name, 0)
        in_bonus = intent.getIntExtra(Stat.INT.name, 0)
        wi_bonus = intent.getIntExtra(Stat.WIS.name, 0)
        ch_bonus = intent.getIntExtra(Stat.CHR.name, 0)

        ac_val.setText((ac_rank + dx_bonus).toString())
        ap_val.setText((ap_rank + in_bonus).toString())
        bl_val.setText((bl_rank + ch_bonus).toString())
        cl_val.setText((cl_rank + st_bonus).toString())
        cr_val.setText((cr_rank + in_bonus).toString())
        dp_val.setText((dp_rank + ch_bonus).toString())
        dd_val.setText((dd_rank + dx_bonus).toString())
        ds_val.setText((ds_rank + ch_bonus).toString())
        ea_val.setText((ea_rank + dx_bonus).toString())
        fl_val.setText((fl_rank + dx_bonus).toString())
        ha_val.setText((ha_rank + ch_bonus).toString())
        hl_val.setText((hl_rank + wi_bonus).toString())
        in_val.setText((in_rank + ch_bonus).toString())
        ln_val.setText((ln_rank + in_bonus).toString())
        kg_val.setText((kg_rank + in_bonus).toString())
        kl_val.setText((kl_rank + in_bonus).toString())
        pc_val.setText((pc_rank + wi_bonus).toString())
        pf_val.setText((pf_rank + ch_bonus).toString())
        pr_val.setText((pr_rank + wi_bonus).toString())
        rd_val.setText((rd_rank + dx_bonus).toString())
        sm_val.setText((sm_rank + wi_bonus).toString())
        st_val.setText((st_rank + dx_bonus).toString())
        sr_val.setText((sr_rank + wi_bonus).toString())
        sw_val.setText((sw_rank + st_bonus).toString())

        ac_skill.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("You can keep your balance while traversing narrow or treacherous surfaces. You can also dive, flip, jump, and roll, avoiding attacks and confusing your opponents.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/skills/acrobatics")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        ap_skill.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("You can evaluate the monetary value of an object.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/skills/appraise")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        bl_skill.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("You know how to tell a lie.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/skills/bluff")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        cl_skill.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("You are skilled at scaling vertical surfaces, from smooth city walls to rocky cliffs.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/skills/climb")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        cr_skill.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("You are skilled in the creation of a specific group of items, such as armor or weapons. Like Knowledge, Perform, and Profession, Craft is actually a number of separate skills. You could have several Craft skills, each with its own ranks. The most common Craft skills are alchemy, armor, baskets, books, bows, calligraphy, carpentry, cloth, clothing, glass, jewelry, leather, locks, paintings, pottery, sculptures, ships, shoes, stonemasonry, traps, and weapons.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/skills/craft")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        dp_skill.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("You can use this skill to persuade others to agree with your arguments, to resolve differences, and to gather valuable information or rumors from people. This skill is also used to negotiate conflicts by using the proper etiquette and manners suitable to the problem.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/skills/diplomacy")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        dd_skill.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("You are skilled at disarming traps and opening locks. In addition, this skill lets you sabotage simple mechanical devices, such as catapults, wagon wheels, and doors.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/skills/disable-device")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        ds_skill.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("You are skilled at changing your appearance.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/skills/disguise")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        ea_skill.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("Your training allows you to slip bonds and escape from grapples.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/skills/escape-artist")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        fl_skill.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("You are skilled at flying, either through the use of wings or magic, and you can perform daring or complex maneuvers while airborne. Note that this skill does not give you the ability to fly.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/skills/fly")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        ha_skill.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("You are trained at working with animals, and can teach them tricks, get them to follow your simple commands, or even domesticate them.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/skills/handle-animal")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        hl_skill.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("You are skilled at tending to the ailments of others.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/skills/heal")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        in_skill.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("You can use this skill to frighten your opponents or to get them to act in a way that benefits you. This skill includes verbal threats and displays of prowess.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/skills/intimidate")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        pc_skill.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("Your senses allow you to notice fine details and alert you to danger. Perception covers all five senses, including sight, hearing, touch, taste, and smell.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/skills/perception")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        pf_skill.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("You are skilled at one form of entertainment, from singing to acting to playing an instrument. Like Craft, Knowledge, and Profession, Perform is actually a number of separate skills. You could have several Perform skills, each with its own ranks.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/skills/perform")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        pr_skill.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("You are skilled at a specific job. Like Craft, Knowledge, and Perform, Profession is actually a number of separate skills. You could have several Profession skills, each with its own ranks.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/skills/profession")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        rd_skill.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("You are skilled at riding mounts, usually a horse, but possibly something more exotic, like a griffon or pegasus. If you attempt to ride a creature that is ill suited as a mount, you take a –5 penalty on your Ride checks.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/skills/ride")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        sm_skill.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("You are skilled at detecting falsehoods and true intentions.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/skills/sense-motive")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        st_skill.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("You are skilled at avoiding detection, allowing you to slip past foes or strike from an unseen position. This skill covers hiding and moving silently.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/skills/stealth")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        sr_skill.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("You are skilled at surviving in the wild and at navigating in the wilderness. You also excel at following trails and tracks left by others.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/skills/survival")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }

        sw_skill.setOnClickListener {
            var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
            dialog.setMessage("You know how to swim and can do so even in stormy water.")
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "CLOSE", DialogInterface.OnClickListener {
                    dialog, id -> dialog.cancel()
            })
            dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "LINK", DialogInterface.OnClickListener {
                    dialog, id -> run {
                dialog.cancel()
                val uri = Uri.parse("https://www.d20pfsrd.com/skills/swim")
                val i = Intent(Intent.ACTION_VIEW, uri)
                startActivity(i)
            }
            })
            dialog.show()

            var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
            message.textSize = 14f
        }
    }

}