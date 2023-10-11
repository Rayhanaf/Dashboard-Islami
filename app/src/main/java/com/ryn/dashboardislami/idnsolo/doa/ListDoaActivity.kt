package com.ryn.dashboardislami.idnsolo.doa

import android.icu.text.CaseMap.Title
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.ryn.dashboardislami.idnsolo.R
import com.ryn.dashboardislami.idnsolo.databinding.ActivityDetailListDoaBinding
import com.ryn.dashboardislami.idnsolo.doa.Adapter.DoaListAdapter
import com.ryn.dashboardislami.idnsolo.doa.data.DoaEtikaBaik
import com.ryn.dashboardislami.idnsolo.doa.data.DoaMakananMinuman
import com.ryn.dashboardislami.idnsolo.doa.data.DoaPagiMalam
import com.ryn.dashboardislami.idnsolo.doa.data.DoaPerjalanan
import com.ryn.dashboardislami.idnsolo.doa.data.DoaRumah
import com.ryn.dashboardislami.idnsolo.doa.data.DoaShalat
import com.ryn.dashboardislami.idnsolo.doa.model.DoaModel


private lateinit var binding: ActivityDetailListDoaBinding

class ListDoaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailListDoaBinding
    lateinit var title: String
    var logo: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailListDoaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = intent.getStringExtra(EXTRA_TITLE).toString()
        logo = intent.getIntExtra(EXTRA_IMAGE, 0)

        val actionBar = supportActionBar
        actionBar?.title = intent.getStringExtra(EXTRA_TITLE)
        actionBar?.setDisplayHomeAsUpEnabled(true)

        initRecyclerView()

    }

    private fun initRecyclerView() {
        val list: ArrayList<DoaModel> = arrayListOf()
        when (title) {
            getString(R.string.pagi_dan_malam) -> {
                list.addAll(DoaPagiMalam.listDoaPagiDanMalam)
            }

            getString(R.string.rumah) -> {
                list.addAll(DoaRumah.listDoaRumah)
            }
            getString(R.string.makanan_dan_minuman) -> {
                list.addAll(DoaMakananMinuman.listDoaMakananDanMinuman)
            }
            getString(R.string.perjalanan) -> {
                list.addAll(DoaPerjalanan.listDoaPerjalanan)
            }
            getString(R.string.etika_baik) -> {
                list.addAll(DoaEtikaBaik.listDoaEtikaBaik)
            }
            getString(R.string.shalat) -> {
                list.addAll(DoaShalat.listDoaShalat)
            }
        }
        binding.rvListDoa.hasFixedSize()
        binding.rvListDoa.layoutManager = LinearLayoutManager(this)
        val adapter = DoaListAdapter(list, title, logo)
        binding.rvListDoa.adapter = adapter
    }

    companion object {
        const val EXTRA_TITLE = "extra_title"
        const val EXTRA_IMAGE = "extra_image"
    }
}