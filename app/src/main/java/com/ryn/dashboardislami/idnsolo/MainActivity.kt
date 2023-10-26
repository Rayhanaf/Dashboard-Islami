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
import com.ryn.dashboardislami.idnsolo.zakat.ZakatActivity
import java.text.SimpleDateFormat
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showRecylerlist()
        moveActivity()
        initTimeForShalat()
    }

    private fun initTimeForShalat() {
        val timeNow = Calendar.getInstance()
        val timeFormat = SimpleDateFormat("HH")
        val time = timeFormat.format(timeNow.time)

        when {
            //0..6
            time.toInt() in 0 .. 5 -> binding.imgHeader.setImageResource(
                R.drawable.bg_header_dashboard_night
            )
            time.toInt() in 6..11 -> binding.imgHeader.setImageResource(
                R.drawable.bg_header_dashboard_morning
            )
            time.toInt() in 12..17 -> binding.imgHeader.setImageResource(
                R.drawable.bg_header_dashboard_afternoon
            )
            time.toInt() in 6..10 -> binding.imgHeader.setImageResource(
                R.drawable.bg_header_dashboard_night
            )
        }
    }

    private fun moveActivity() {
        binding.btnDoa.setOnClickListener {
            startActivity(Intent(this, DoaActivity::class.java))
        }
        binding.btnDzakat.setOnClickListener {
            startActivity(Intent(this, ZakatActivity::class.java))
        }
        binding.btnKajian.setOnClickListener {
            startActivity(Intent(this, ZakatActivity::class.java))
        }
    }

    private fun showRecylerlist() {
        val list: ArrayList<InspirationModel> = arrayListOf()
        binding.rvInspiration.setHasFixedSize(true)
        list.addAll(InspirationData.listData)
        binding.rvInspiration.layoutManager = LinearLayoutManager(this)
        val inspirationAdapter = InspirationListAdaptor(list)
        binding.rvInspiration.adapter = inspirationAdapter
    }
