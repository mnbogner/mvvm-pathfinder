package com.mvvm.pathfinder

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        val SPELL_REQUEST: Int = 100
    }

    private lateinit var viewModelFactory: CharacterFactory
    private lateinit var viewModel: CharacterViewModel
    private lateinit var defaultWeapon: String

    // currently working with a fixed set of buttons
    private var buttonToggle: Array<Boolean> = Array<Boolean>(5) {i -> false}
    private var buttonLimit: Array<Int> = Array<Int>(5) {i -> 0}
    private var buttonValue: Array<Int> = Array<Int>(5) {i -> 0}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setup()

        weapon_button.setText(defaultWeapon)
        weapon_button.setOnClickListener {
            defaultWeapon = viewModel.cycleWeapons(defaultWeapon)
            weapon_button.setText(defaultWeapon)
        }

        setupButtons()

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

    private fun setupButtons() {

        // currently working with a fixed set of buttons
        var buttons: ArrayList<Button> = ArrayList<Button>()
        buttons.add(button_one)
        buttons.add(button_two)
        buttons.add(button_three)
        buttons.add(button_four)
        buttons.add(button_five)

        var buttonMods: ArrayList<ButtonMod> = viewModel.buttonMods

        // fill as many buttons as possible
        for (i in 0 until 5) {
            if (i < buttonMods.size) {
                var button: Button = buttons.get(i)
                var buttonMod: ButtonMod = buttonMods.get(i)

                button.setText(buttonMod.modName + "(off)")

                // streamline button setup
                if (buttonMod.longPress) {

                    System.out.println("FOO - set up long press mod " + buttonMod.modName)

                    buttonLimit[i] = buttonMod.limit
                    if (!buttonMod.increment) {
                        // if decrementing, start at limit
                        buttonValue[i] = buttonMod.limit
                    } else {
                        // if incrementing, start at 0
                    }

                    button.setOnClickListener {

                        System.out.println("FOO - on click for " + buttonMod.modName)

                        if (buttonToggle[i]) {

                            System.out.println("FOO - button toggled for " + buttonMod.modName)

                            if (buttonMod.increment) {
                                System.out.println("FOO - increment for " + buttonMod.modName)
                                // handle value increment
                                if (buttonValue[i] == buttonLimit[i]) {
                                    // if loop flag set, wrap around to 0, else no-op
                                    if (buttonMod.loop) {
                                        buttonValue[i] = 0
                                    }
                                } else {
                                    System.out.println("FOO - add 1 for " + buttonMod.modName)
                                    // if not at limit, increment value
                                    buttonValue[i]++
                                }
                            } else {
                                System.out.println("FOO - on click decrement for " + buttonMod.modName)
                                // handle value decrement
                                if (buttonValue[i] == 0) {
                                    // if loop flag set, wrap around to max, else no-op
                                    if (buttonMod.loop) {
                                        buttonValue[i] = buttonLimit[i]
                                    }
                                } else {
                                    System.out.println("FOO - subtract 1 for " + buttonMod.modName)
                                    // if not at 0, decrement value
                                    buttonValue[i]--
                                }
                            }
                            button.setText(buttonMod.modName + "(" + buttonValue[i] + ")")
                        } else {
                            System.out.println("FOO - button not toggled for " + buttonMod.modName)
                        }
                    }

                    button.setOnLongClickListener {

                        System.out.println("FOO - on long click for " + buttonMod.modName)

                        buttonToggle[i] = !buttonToggle[i]
                        viewModel.toggleMod(buttonToggle[i], buttonMod)
                        if (buttonToggle[i]) {
                            // if value doesn't loop, reset when toggled
                            if (!buttonMod.loop) {
                                if (buttonMod.increment) {
                                    // if incrementing, start at 0
                                    buttonValue[i] = 0
                                } else {
                                    // if decrementing, start at max
                                    buttonValue[i] = buttonLimit[i]
                                }
                            }
                            button.setText(buttonMod.modName + "(" + buttonValue[i] + ")")
                        } else {
                            button.setText(buttonMod.modName + "(off)")
                        }
                        true
                    }
                } else {
                    button.setOnClickListener {
                        buttonToggle[i] = !buttonToggle[i]
                        viewModel.toggleMod(buttonToggle[i], buttonMod)
                        if (buttonToggle[i]) {
                            button.setText(buttonMod.modName + "(on)")
                        } else {
                            button.setText(buttonMod.modName + "(off)")
                        }
                    }
                }
            } else {
                break
            }
        }
    }

    private fun setup() {

        viewModelFactory = CharacterInjector.loadJsonCharacter("ika.json", this)
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
