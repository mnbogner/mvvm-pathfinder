package com.mvvm.pathfinder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CharacterViewModel

    private val viewModelFactory = object : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            val character: Character = Character("I'ka")
            val viewModel = CharacterViewModel(character)
            @Suppress("UNCHECKED_CAST")
            return viewModel as T
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setup()

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

        viewModel.initStats()
    }

    private fun setup() {

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(CharacterViewModel::class.java)

        viewModel.stats.observe(this, Observer { stats ->
            st_val.setText(stats.getOrDefault(Stat.STR, 10).toString())
            dx_val.setText(stats.getOrDefault(Stat.DEX, 10).toString())
            cn_val.setText(stats.getOrDefault(Stat.CON, 10).toString())
            in_val.setText(stats.getOrDefault(Stat.INT, 10).toString())
            wi_val.setText(stats.getOrDefault(Stat.WIS, 10).toString())
            ch_val.setText(stats.getOrDefault(Stat.CHR, 10).toString())
        })
    }


}
