package com.ryn.dashboardislami.idnsolo.kajian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.ryn.dashboardislami.idnsolo.R
import com.ryn.dashboardislami.idnsolo.databinding.ActivityKajianBinding
import com.ryn.dashboardislami.idnsolo.databinding.ActivityZakatBinding
import com.ryn.dashboardislami.idnsolo.kajian.adapter.KajianAdapter
import com.ryn.dashboardislami.idnsolo.kajian.data.KajianData
import com.ryn.dashboardislami.idnsolo.kajian.model.KajianModel

class KajianActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKajianBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKajianBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.rvKajian.layoutManager = LinearLayoutManager(this)
        binding.rvKajian.setHasFixedSize(true)
        val listKajian = ArrayList<KajianModel>()
        listKajian.addAll(KajianData.listData)
        binding.rvKajian.adapter = KajianAdapter(listKajian)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}