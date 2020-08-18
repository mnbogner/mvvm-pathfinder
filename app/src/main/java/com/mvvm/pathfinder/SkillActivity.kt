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
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : AppCompatActivity() {

    // TODO: load objects from json, pull stats from view model

    // skill ranks: 4 (ranks/lvl) -1 (int modifier) +1 (finding your kin) * 11 (lvl) = 44 (4 left)
    // skipped trained-only skills with no ranks
    val ac_rank: Int = 4 // +1 +3 ranks/class skill
    val ap_rank: Int = 0 // +0 ranks
    val bl_rank: Int = 0 // +0 ranks
    val cl_rank: Int = 10 // +7 +3 ranks/class skill
    val cr_rank: Int = 0 // +0 +0 ranks/class skill(no ranks)
    val dp_rank: Int = 0 // +0 ranks
    val ds_rank: Int = 0 // +0 ranks
    val ea_rank: Int = 0 // +0 ranks
    val fl_rank: Int = 0 // +0 ranks
    val ha_rank: Int = 4 // +1 +3 ranks/class skill
    val hl_rank: Int = 0 // +0 ranks
    val in_rank: Int = 10 // +7 +3 ranks/class skill
    val kg_rank: Int = 1 // +1 ranks
    val kl_rank: Int = 1 // +1 ranks
    val ln_rank: Int = 1 // +1 ranks
    val pc_rank: Int = 7 // +4 +3 ranks/class skill
    val pf_rank: Int = 0 // +0 ranks
    val pr_rank: Int = 10 // +10 ranks
    val rd_rank: Int = 0 // +0 ranks/class skill(no ranks)
    val sm_rank: Int = 0 // +0 ranks
    val st_rank: Int = 0 // +0 ranks
    val sr_rank: Int = 7 // +4 +3 ranks/class skill
    val sw_rank: Int = 10 // +7 +3 ranks/class skill

    var st_bonus: Int = 0
    var dx_bonus: Int = 0
    var cn_bonus: Int = 0
    var in_bonus: Int = 0
    var wi_bonus: Int = 0
    var ch_bonus: Int = 0

    val han_bonus = 2 // handle animal asiamar bonus
    val int_bonus = 1 // intimidate bred for war bonus
    val sur_bonus = 2 // survival asiamar bonus

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        st_bonus = intent.getIntExtra(Stat.STR.name, 0)
        dx_bonus = intent.getIntExtra(Stat.DEX.name, 0)
        cn_bonus = intent.getIntExtra(Stat.CON.name, 0)
        in_bonus = intent.getIntExtra(Stat.INT.name, 0)
        wi_bonus = intent.getIntExtra(Stat.WIS.name, 0)
        ch_bonus = intent.getIntExtra(Stat.CHR.name, 0)

        // currently working with a fixed set of buttons
        var skillNames: ArrayList<TextView> = ArrayList<TextView>()
        skillNames.add(lc1_skill)
        skillNames.add(lc2_skill)
        skillNames.add(lc3_skill)
        skillNames.add(lc4_skill)
        skillNames.add(lc5_skill)
        skillNames.add(lc6_skill)
        skillNames.add(lc7_skill)
        skillNames.add(lc8_skill)
        skillNames.add(lc9_skill)
        skillNames.add(lc10_skill)
        skillNames.add(lc11_skill)
        skillNames.add(lc12_skill)
        skillNames.add(rc1_skill)
        skillNames.add(rc2_skill)
        skillNames.add(rc3_skill)
        skillNames.add(rc4_skill)
        skillNames.add(rc5_skill)
        skillNames.add(rc6_skill)
        skillNames.add(rc7_skill)
        skillNames.add(rc8_skill)
        skillNames.add(rc9_skill)
        skillNames.add(rc10_skill)
        skillNames.add(rc11_skill)
        skillNames.add(rc12_skill)

        var skillRanks: ArrayList<TextView> = ArrayList<TextView>()
        skillRanks.add(lc1_val)
        skillRanks.add(lc2_val)
        skillRanks.add(lc3_val)
        skillRanks.add(lc4_val)
        skillRanks.add(lc5_val)
        skillRanks.add(lc6_val)
        skillRanks.add(lc7_val)
        skillRanks.add(lc8_val)
        skillRanks.add(lc9_val)
        skillRanks.add(lc10_val)
        skillRanks.add(lc11_val)
        skillRanks.add(lc12_val)
        skillRanks.add(rc1_val)
        skillRanks.add(rc2_val)
        skillRanks.add(rc3_val)
        skillRanks.add(rc4_val)
        skillRanks.add(rc5_val)
        skillRanks.add(rc6_val)
        skillRanks.add(rc7_val)
        skillRanks.add(rc8_val)
        skillRanks.add(rc9_val)
        skillRanks.add(rc10_val)
        skillRanks.add(rc11_val)
        skillRanks.add(rc12_val)

        val acObject = InfoObject(
            "Acrobatics",
            "You can keep your balance while traversing narrow or treacherous surfaces. You can also dive, flip, jump, and roll, avoiding attacks and confusing your opponents.",
            "https://www.d20pfsrd.com/skills/acrobatics",
            ac_rank,
            dx_bonus,
            0
        )

        val apObject = InfoObject(
            "Appraise",
            "You can evaluate the monetary value of an object.",
            "https://www.d20pfsrd.com/skills/appraise",
            ap_rank,
            in_bonus,
            0
        )

        val blObject = InfoObject(
            "Bluff",
            "You know how to tell a lie.",
            "https://www.d20pfsrd.com/skills/bluff",
            bl_rank,
            ch_bonus,
            0
        )

        val clObject = InfoObject(
            "Climb",
            "You are skilled at scaling vertical surfaces, from smooth city walls to rocky cliffs.",
            "https://www.d20pfsrd.com/skills/climb",
            cl_rank,
            st_bonus,
            0
        )

        val crObject = InfoObject(
            "Craft",
            "You are skilled in the creation of a specific group of items, such as armor or weapons. Like Knowledge, Perform, and Profession, Craft is actually a number of separate skills. You could have several Craft skills, each with its own ranks. The most common Craft skills are alchemy, armor, baskets, books, bows, calligraphy, carpentry, cloth, clothing, glass, jewelry, leather, locks, paintings, pottery, sculptures, ships, shoes, stonemasonry, traps, and weapons.",
            "https://www.d20pfsrd.com/skills/craft",
            cr_rank,
            in_bonus,
            0
        )

        val dpObject = InfoObject(
            "Diplomacy",
            "You can use this skill to persuade others to agree with your arguments, to resolve differences, and to gather valuable information or rumors from people. This skill is also used to negotiate conflicts by using the proper etiquette and manners suitable to the problem.",
            "https://www.d20pfsrd.com/skills/diplomacy",
            dp_rank,
            ch_bonus,
            0
        )

        val dsObject = InfoObject(
            "Disguise",
            "You are skilled at changing your appearance.",
            "https://www.d20pfsrd.com/skills/disguise",
            ds_rank,
            ch_bonus,
            0
        )

        val eaObject = InfoObject(
            "Escape Artist",
            "Your training allows you to slip bonds and escape from grapples.",
            "https://www.d20pfsrd.com/skills/escape-artist",
            ea_rank,
            dx_bonus,
            0
        )

        val flObject = InfoObject(
            "Fly",
            "You are skilled at flying, either through the use of wings or magic, and you can perform daring or complex maneuvers while airborne. Note that this skill does not give you the ability to fly.",
            "https://www.d20pfsrd.com/skills/fly",
            fl_rank,
            dx_bonus,
            0
        )

        val haObject = InfoObject(
            "Handle Animal",
            "You are trained at working with animals, and can teach them tricks, get them to follow your simple commands, or even domesticate them.",
            "https://www.d20pfsrd.com/skills/handle-animal",
            ha_rank,
            ch_bonus,
            han_bonus
        )

        val hlObject = InfoObject(
            "Heal",
            "You are skilled at tending to the ailments of others.",
            "https://www.d20pfsrd.com/skills/heal",
            hl_rank,
            wi_bonus,
            0
        )

        val inObject = InfoObject(
            "Intimidate",
            "You can use this skill to frighten your opponents or to get them to act in a way that benefits you. This skill includes verbal threats and displays of prowess.",
            "https://www.d20pfsrd.com/skills/intimidate",
            in_rank,
            ch_bonus,
            int_bonus
        )

        val kgObject = InfoObject(
            "Knowledge:Geo",
            "Geography: lands, terrain, climate, people, also used for astronomy.",
            "https://www.d20pfsrd.com/skills/knowledge",
            kg_rank,
            in_bonus,
            0
        )

        val klObject = InfoObject(
            "Knowledge:Local",
            "Local: legends, personalities, inhabitants, laws, customs, traditions, humanoids.",
            "https://www.d20pfsrd.com/skills/knowledge",
            kl_rank,
            in_bonus,
            0
        )

        val lnObject = InfoObject(
            "Linguistics",
            "You are skilled at working with language, in both its spoken and written forms.",
            "https://www.d20pfsrd.com/skills/linguistics",
            ln_rank,
            in_bonus,
            0
        )

        val pcObject = InfoObject(
            "Perception",
            "Your senses allow you to notice fine details and alert you to danger. Perception covers all five senses, including sight, hearing, touch, taste, and smell.",
            "https://www.d20pfsrd.com/skills/perception",
            pc_rank,
            wi_bonus,
            0
        )

        val pfObject = InfoObject(
            "Perform",
            "You are skilled at one form of entertainment, from singing to acting to playing an instrument. Like Craft, Knowledge, and Profession, Perform is actually a number of separate skills. You could have several Perform skills, each with its own ranks.",
            "https://www.d20pfsrd.com/skills/perform",
            pf_rank,
            ch_bonus,
            0
        )

        val prObject = InfoObject(
            "Profession:Soldier",
            "You are skilled at a specific job. Like Craft, Knowledge, and Perform, Profession is actually a number of separate skills. You could have several Profession skills, each with its own ranks.",
            "https://www.d20pfsrd.com/skills/profession",
            pr_rank,
            wi_bonus,
            0
        )

        val rdObject = InfoObject(
            "Ride",
            "You are skilled at riding mounts, usually a horse, but possibly something more exotic, like a griffon or pegasus. If you attempt to ride a creature that is ill suited as a mount, you take a –5 penalty on your Ride checks.",
            "https://www.d20pfsrd.com/skills/ride",
            rd_rank,
            dx_bonus,
            0
        )

        val smObject = InfoObject(
            "Sense Motive",
            "You are skilled at detecting falsehoods and true intentions.",
            "https://www.d20pfsrd.com/skills/sense-motive",
            sm_rank,
            wi_bonus,
            0
        )

        val stObject = InfoObject(
            "Stealth",
            "You are skilled at avoiding detection, allowing you to slip past foes or strike from an unseen position. This skill covers hiding and moving silently.",
            "https://www.d20pfsrd.com/skills/stealth",
            st_rank,
            dx_bonus,
            0
        )

        val srObject = InfoObject(
            "Survival",
            "You are skilled at surviving in the wild and at navigating in the wilderness. You also excel at following trails and tracks left by others.",
            "https://www.d20pfsrd.com/skills/survival",
            sr_rank,
            wi_bonus,
            sur_bonus
        )

        val swObject = InfoObject(
            "Swim",
            "You know how to swim and can do so even in stormy water.",
            "https://www.d20pfsrd.com/skills/swim",
            sw_rank,
            st_bonus,
            0
        )

        var skills: ArrayList<InfoObject> = ArrayList<InfoObject>()
        skills.add(acObject)
        skills.add(apObject)
        skills.add(blObject)
        skills.add(clObject)
        skills.add(crObject)
        skills.add(dpObject)
        skills.add(dsObject)
        skills.add(eaObject)
        skills.add(flObject)
        skills.add(haObject)
        skills.add(hlObject)
        skills.add(inObject)
        skills.add(kgObject)
        skills.add(klObject)
        skills.add(lnObject)
        skills.add(pcObject)
        skills.add(pfObject)
        skills.add(prObject)
        skills.add(rdObject)
        skills.add(smObject)
        skills.add(stObject)
        skills.add(srObject)
        skills.add(swObject)

        for (i in 0 until skillNames.size) {
            if (i < skills.size) {
                var skill = skills.get(i)
                var skillName = skillNames.get(i)
                var skillRank = skillRanks.get(i)
                skillName.setText(skill.name)
                skillName.setOnClickListener {
                    var dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.AppTheme)).create()
                    dialog.setMessage(skill.text)
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
                                    Uri.parse(skill.link)
                                val i = Intent(Intent.ACTION_VIEW, uri)
                                startActivity(i)
                            }
                        })
                    dialog.show()
                    var message: TextView = dialog.getWindow().findViewById(android.R.id.message) as TextView
                    message.textSize = 14f
                }
                skillRank.setText("" + (skill.rank + skill.stat + skill.bonus))
            } else {
                var skillName = skillNames.get(i)
                var skillRank = skillRanks.get(i)
                skillName.visibility = View.GONE
                skillRank.visibility = View.GONE
            }
        }
    }
}