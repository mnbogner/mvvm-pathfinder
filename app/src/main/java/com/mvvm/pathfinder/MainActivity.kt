package com.mvvm.pathfinder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

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
            rageToggle = !rageToggle
            viewModel.toggleRage(rageToggle)
            if (rageToggle) {
                rage_button.setText("RAGE(on)")
            } else {
                rage_button.setText("RAGE(off)")
            }
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
        })

        defaultWeapon = viewModel.initStats()

    }


}
