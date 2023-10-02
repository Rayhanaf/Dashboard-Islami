package com.ryn.dashboardislami.idnsolo.doa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ryn.dashboardislami.idnsolo.R
import com.ryn.dashboardislami.idnsolo.databinding.ActivityDoaBinding
import com.ryn.dashboardislami.idnsolo.databinding.ActivityMainBinding

class DoaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDoaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //navbar
        val actionBar = supportActionBar
        actionBar!!.title = "Doa Harian"
        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    //button back action bar
    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp(): Boolean {
            onBackPressed()
            return true
        }
    }
}