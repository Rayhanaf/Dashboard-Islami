package com.ryn.dashboardislami.idnsolo.doa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ryn.dashboardislami.idnsolo.R
import com.ryn.dashboardislami.idnsolo.databinding.ActivityDetailDoaBinding
import com.ryn.dashboardislami.idnsolo.databinding.ActivityDoaBinding
import com.ryn.dashboardislami.idnsolo.doa.model.DoaModel


private lateinit var binding: ActivityDetailDoaBinding

class DetailDoaACtivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailDoaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val doa = intent.getParcelableExtra<DoaModel>(EXTRA_DOA) as DoaModel
        val actionBar = supportActionBar
        actionBar!!.title = doa.title
        actionBar.setDisplayHomeAsUpEnabled(true)

        binding.tvTitle.text = doa.title
        binding.tvArabic.text = doa.doa
        binding.tvLatin.text = doa.latin
        binding.tvTerjemahan.text = doa.terjemahan
        binding.tvPerawi.text = doa.profile
    }

    //back
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        const val EXTRA_DOA = "extra_doa"
    }
}