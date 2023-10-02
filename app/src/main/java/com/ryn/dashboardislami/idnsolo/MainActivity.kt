package com.ryn.dashboardislami.idnsolo

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ryn.dashboardislami.idnsolo.databinding.ActivityMainBinding
import com.ryn.dashboardislami.idnsolo.doa.DoaActivity
import com.ryn.dashboardislami.idnsolo.inspiration.InspirationData
import com.ryn.dashboardislami.idnsolo.inspiration.InspirationListAdaptor
import com.ryn.dashboardislami.idnsolo.inspiration.InspirationModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showRecylerlist()
        showMenu()
    }

    private fun showMenu() {
        binding.btnDoa.setOnClickListener {
            startActivity(Intent(this, DoaActivity::class.java))
        }
    }

    private fun initRecyclerViewInspiration() {
        val list : ArrayList<InspirationModel> = arrayListOf()
        binding.rvInspiration.setHasFixedSize(true)
        list.addAll(InspirationData.listData)
        binding.rvInspiration.layoutManager = LinearLayoutManager(this)
        val inspirationAdapter = InspirationListAdaptor(list)
        binding.rvInspiration.adapter = inspirationAdapter
    }
}