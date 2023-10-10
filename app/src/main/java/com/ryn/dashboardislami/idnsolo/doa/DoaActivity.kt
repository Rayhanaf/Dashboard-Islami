package com.ryn.dashboardislami.idnsolo.doa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ryn.dashboardislami.idnsolo.R
import com.ryn.dashboardislami.idnsolo.databinding.ActivityDoaBinding
import com.ryn.dashboardislami.idnsolo.databinding.ActivityMainBinding

class DoaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDoaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val actionBar = supportActionBar
        actionBar?.title = "Doa Harian"
        actionBar?.setDisplayHomeAsUpEnabled(true)

        intentToListActivity()
    }

    private fun intentToListActivity() {
        val intent  = Intent(this, ListDoaActivity::class.java)
        intent.putExtra(ListDoaActivity.EXTRA_TITLE, getString(R.string.pagi_dan_malam))
        intent.putExtra(ListDoaActivity.EXTRA_IMAGE, getString(R.string.pagi_dan_malam)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}