package com.mvvm.pathfinder

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {

        val SPELL_REQUEST: Int = 100

    }

    private val viewModelFactory = CharacterInjector.getCharacterFactoryIka()

    private lateinit var viewModel: CharacterViewModel
    private lateinit var defaultWeapon: String

    private var grappleToggle: Boolean = false
    private var pinToggle: Boolean = false
    private var rageToggle: Boolean = false
    private var hasteToggle: Boolean = false
    private var enlargeToggle: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setup()

        weapon_button.setText(defaultWeapon)
        weapon_button.setOnClickListener {
            defaultWeapon = viewModel.cycleWeapons(defaultWeapon)
            weapon_button.setText(defaultWeapon)
        }
        grapple_button.setText("GRAPPLE(off)")
        grapple_button.setOnClickListener {
            grappleToggle = !grappleToggle
            viewModel.toggleGrapple(grappleToggle)
            if (grappleToggle) {
                grapple_button.setText("GRAPPLE(on)")
            } else {
                grapple_button.setText("GRAPPLE(off)")
            }
        }
        pin_button.setText("PIN(off)")
        pin_button.setOnClickListener {
            pinToggle = !pinToggle
            viewModel.togglePin(pinToggle)
            if (pinToggle) {
                pin_button.setText("PIN(on)")
            } else {
                pin_button.setText("PIN(off)")
            }
        }
        rage_button.setText("RAGE(off)")
        rage_button.setOnClickListener {
            if (rageToggle) {
                viewModel.decrementStat(Stat.RAGE)
            }
        }
        rage_button.setOnLongClickListener {
            rageToggle = !rageToggle
            if (rageToggle) {
                rage_button.setText("RAGE(?)")
            } else {
                rage_button.setText("RAGE(off)")
            }
            viewModel.toggleRage(rageToggle)
            true
        }
        haste_button.setText("HASTE(off)")
        haste_button.setOnClickListener {
            hasteToggle = !hasteToggle
            viewModel.toggleHaste(hasteToggle)
            if (hasteToggle) {
                haste_button.setText("HASTE(on)")
            } else {
                haste_button.setText("HASTE(off)")
            }
        }
        enlarge_button.setText("ENLARGE(off)")
        enlarge_button.setOnClickListener {
            enlargeToggle = !enlargeToggle
            viewModel.toggleEnlarge(enlargeToggle)
            if (enlargeToggle) {
                enlarge_button.setText("ENLARGE(on)")
            } else {
                enlarge_button.setText("ENLARGE(off)")
            }
        }

        skill_button.setOnClickListener {
            val i: Intent = Intent(this, SkillActivity::class.java)
            // TODO: fix to pass parcelable character and mods (or just access view model from skill activity?)
            i.putExtra(Stat.STR.name, Character.getBonus(viewModel.getCurrentStat(Stat.STR)))
            i.putExtra(Stat.DEX.name, Character.getBonus(viewModel.getCurrentStat(Stat.DEX)))
            i.putExtra(Stat.CON.name, Character.getBonus(viewModel.getCurrentStat(Stat.CON)))
            i.putExtra(Stat.INT.name, Character.getBonus(viewModel.getCurrentStat(Stat.INT)))
            i.putExtra(Stat.WIS.name, Character.getBonus(viewModel.getCurrentStat(Stat.WIS)))
            i.putExtra(Stat.CHR.name, Character.getBonus(viewModel.getCurrentStat(Stat.CHR)))
            startActivity(i)
        }
        spell_button.setOnClickListener {
            val i: Intent = Intent(this, SpellActivity::class.java)
            // TODO: fix to pass parcelable character and mods (or just access view model from spell activity?)
            i.putExtra(Stat.LV1S.name, viewModel.getCurrentStat(Stat.LV1S))
            i.putExtra(Stat.LV2S.name, viewModel.getCurrentStat(Stat.LV2S))
            i.putExtra(Stat.LV3S.name, viewModel.getCurrentStat(Stat.LV3S))
            this.startActivityForResult(i, SPELL_REQUEST)
        }
        feat_button.setOnClickListener {
            val i: Intent = Intent(this, FeatActivity::class.java)
            this.startActivity(i)
        }

        st_up.setOnClickListener {
            viewModel.incrementStat(Stat.STR)
        }
        st_down.setOnClickListener {
            viewModel.decrementStat(Stat.STR)
        }
        dx_up.setOnClickListener {
            viewModel.incrementStat(Stat.DEX)
        }
        dx_down.setOnClickListener {
            viewModel.decrementStat(Stat.DEX)
        }
        cn_up.setOnClickListener {
            viewModel.incrementStat(Stat.CON)
        }
        cn_down.setOnClickListener {
            viewModel.decrementStat(Stat.CON)
        }
        in_up.setOnClickListener {
            viewModel.incrementStat(Stat.INT)
        }
        in_down.setOnClickListener {
            viewModel.decrementStat(Stat.INT)
        }
        wi_up.setOnClickListener {
            viewModel.incrementStat(Stat.WIS)
        }
        wi_down.setOnClickListener {
            viewModel.decrementStat(Stat.WIS)
        }
        ch_up.setOnClickListener {
            viewModel.incrementStat(Stat.CHR)
        }
        ch_down.setOnClickListener {
            viewModel.decrementStat(Stat.CHR)
        }
        hp_up.setOnClickListener {
            viewModel.incrementStat(Stat.HP)
        }
        hp_down.setOnClickListener {
            viewModel.decrementStat(Stat.HP)
        }
        nonlethal_down.setOnClickListener {
            viewModel.incrementStat(Stat.NL)
        }

    }

    private fun setup() {

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(CharacterViewModel::class.java)

        viewModel.baseStats.observe(this, Observer { stats ->
            st_val.setText(stats.getOrDefault(Stat.STR, "?"))
            dx_val.setText(stats.getOrDefault(Stat.DEX, "?"))
            cn_val.setText(stats.getOrDefault(Stat.CON, "?"))
            in_val.setText(stats.getOrDefault(Stat.INT, "?"))
            wi_val.setText(stats.getOrDefault(Stat.WIS, "?"))
            ch_val.setText(stats.getOrDefault(Stat.CHR, "?"))
        })

        viewModel.derivedStats.observe(this, Observer { stats ->
            hp_val.setText(stats.getOrDefault(Stat.HP, "?"))
            hit_val.setText(stats.getOrDefault(Stat.HIT, "?"))
            dmg_val.setText(stats.getOrDefault(Stat.DMG, "?"))
            ac_val.setText(stats.getOrDefault(Stat.AC, "?"))
            cmb_val.setText(stats.getOrDefault(Stat.CMB, "?"))
            cmd_val.setText(stats.getOrDefault(Stat.CMD, "?"))
            fort_val.setText(stats.getOrDefault(Stat.FORT, "?"))
            ref_val.setText(stats.getOrDefault(Stat.REF, "?"))
            will_val.setText(stats.getOrDefault(Stat.WILL, "?"))
            if (rageToggle) {
                rage_button.setText(stats.getOrDefault(Stat.RAGE, "?"))
            }
        })

        defaultWeapon = viewModel.initStats()

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, i: Intent?) {

        if (requestCode == SPELL_REQUEST) {
            if (resultCode == SpellActivity.SPELL_RESULT && i != null) {

                System.out.println("FOO - RESULT LV1: " + i.getIntExtra(SpellActivity.LV1_RESULT, 0)
                        + ", LV2: " + i.getIntExtra(SpellActivity.LV2_RESULT, 0)
                        + ", LV3: " + i.getIntExtra(SpellActivity.LV3_RESULT, 0))

                viewModel.setStat(Stat.LV1S, i.getIntExtra(SpellActivity.LV1_RESULT, 0))
                viewModel.setStat(Stat.LV2S, i.getIntExtra(SpellActivity.LV2_RESULT, 0))
                viewModel.setStat(Stat.LV3S, i.getIntExtra(SpellActivity.LV3_RESULT, 0))
            } else {
                System.out.println("FOO - WRONG RESULT: " + resultCode)
            }
        } else {
            System.out.println("FOO - WRONG REQUEST: " + requestCode)
        }

        super.onActivityResult(requestCode, resultCode, i)
    }
}
