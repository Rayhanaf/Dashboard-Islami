package com.ryn.dashboardislami.idnsolo.doa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ryn.dashboardislami.idnsolo.R
import com.ryn.dashboardislami.idnsolo.databinding.ActivityDetailDoaBinding
import com.ryn.dashboardislami.idnsolo.databinding.ActivityDoaBinding


private lateinit var binding: ActivityDetailDoaBinding

class DetailDoaACtivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailDoaBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}