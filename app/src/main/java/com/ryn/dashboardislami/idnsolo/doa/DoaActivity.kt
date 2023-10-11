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
        binding = ActivityDoaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar?.title = "Doa Harian"
        actionBar?.setDisplayHomeAsUpEnabled(true)

        intentToListActivity()
    }

    private fun intentToListActivity() {
        binding.imgPagiMalam.setOnClickListener {
            val intent = Intent(this, ListDoaActivity::class.java)
            intent.putExtra(ListDoaActivity.EXTRA_TITLE, getString(R.string.pagi_dan_malam))
            intent.putExtra(ListDoaActivity.EXTRA_IMAGE, R.drawable.ic_doa_pagi_malam)
            startActivity(intent)
        }
        binding.imgRumah.setOnClickListener {
            val intent  = Intent(this, ListDoaActivity::class.java)
            intent.putExtra(ListDoaActivity.EXTRA_TITLE, getString(R.string.rumah))
            intent.putExtra(ListDoaActivity.EXTRA_IMAGE, R.drawable.ic_doa_rumah)
            startActivity(intent)
        }
        binding.cardMakananMinuman.setOnClickListener {
            val intent  = Intent(this, ListDoaActivity::class.java)
            intent.putExtra(ListDoaActivity.EXTRA_TITLE, getString(R.string.makanan_dan_minuman))
            intent.putExtra(ListDoaActivity.EXTRA_IMAGE, R.drawable.ic_doa_makanan_minuman)
            startActivity(intent)
        }
        binding.cardDoaPerjalanan.setOnClickListener {
            val intent = Intent(this, ListDoaActivity::class.java)
            intent.putExtra(ListDoaActivity.EXTRA_TITLE, getString(R.string.perjalanan))
            intent.putExtra(ListDoaActivity.EXTRA_IMAGE, R.drawable.ic_doa_perjalanan)
            startActivity(intent)
        }
        binding.cardEtikaBaik.setOnClickListener {
            val intent = Intent(this, ListDoaActivity::class.java)
            intent.putExtra(ListDoaActivity.EXTRA_TITLE, getString(R.string.etika_baik))
            intent.putExtra(ListDoaActivity.EXTRA_IMAGE, R.drawable.ic_doa_etika_baik)
            startActivity(intent)
        }
        binding.cardDoaShalat.setOnClickListener {
            val intent = Intent(this, ListDoaActivity::class.java)
            intent.putExtra(ListDoaActivity.EXTRA_TITLE, getString(R.string.shalat))
            intent.putExtra(ListDoaActivity.EXTRA_IMAGE, R.drawable.ic_doa_sholat)
            startActivity(intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}