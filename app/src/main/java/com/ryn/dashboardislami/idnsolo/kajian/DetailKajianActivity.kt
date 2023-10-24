package com.ryn.dashboardislami.idnsolo.kajian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ryn.dashboardislami.idnsolo.R
import com.ryn.dashboardislami.idnsolo.databinding.ActivityDetailKajianBinding

class DetailKajianActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailKajianBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailKajianBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}