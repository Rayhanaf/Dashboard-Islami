package com.ryn.dashboardislami.idnsolo.zakat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ryn.dashboardislami.idnsolo.R
import com.ryn.dashboardislami.idnsolo.databinding.ActivityZakatBinding
import java.text.NumberFormat
import java.util.Locale

class ZakatActivity : AppCompatActivity() {

    private lateinit var binding: ActivityZakatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityZakatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar!!.title = "Zakat"
        actionBar.setDisplayHomeAsUpEnabled(true)

        initHitungZakat()
    }

    private fun initHitungZakat() {
        binding.btnHitung.setOnClickListener {
            val isEmptyField = false
            val totalHarta = binding.edtTotalHartaKesuluruhan.text.trim().toString()

            if(!isEmptyField){
                if(totalHarta.isEmpty()){
                    !isEmptyField
                    binding.edtTotalHartaKesuluruhan.error = "Field ini tidak boleh kosong"
                }

                if(!isEmptyField){
                    val emas = 92395000
                    val persen = 0.025
                    val localeID = Locale("in", "ID")
                    val formatRupiah: NumberFormat = NumberFormat.getCurrencyInstance(localeID)

                    if (totalHarta < emas.toString()){
                        binding.tvStatus.text = "Anda Belum wajib"
                    } else {
                        val zakat = totalHarta.toInt() * persen
                        binding.tvStatus.text = "Anda wajib membayar zakat"
                        binding.tvZakatYangDikeluarkan.text = formatRupiah.format(zakat)
                    }
                }
            }
        }
    }
}