package com.ryn.dashboardislami.idnsolo.sholat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import com.ryn.dashboardislami.idnsolo.R
import com.ryn.dashboardislami.idnsolo.databinding.ActivitySholatBinding
import cz.msebera.android.httpclient.Header
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class SholatActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySholatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySholatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        initSholatView()
        getPrayTImeData("1411")
    }

    private fun getPrayTImeData(location: String) {
        val calendar = Calendar.getInstance()
        val tanggal = calendar.get(Calendar.DAY_OF_MONTH)
        val bulan = calendar.get(Calendar.MONTH)
        val tahun = calendar.get(Calendar.YEAR)
        val client = AsyncHttpClient()
        val url = "https://api.myquran.com/v1/sholat/jadwal/$location/$tahun/$bulan/$tanggal"
        Log.d("SholatActivity", "getPrayTimeData: $url")

        client.get(url,object : AsyncHttpResponseHandler(){
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?
            ) {
                binding.pbJadwalSholat.visibility = View.INVISIBLE
                val responData = responseBody?.let { String(it) }

                try {
                    // Parsing JSON
                    val responseObject = JSONObject(responData)
                    val data = responseObject.getJSONObject("data")
                    val jadwal = data.getJSONObject("jadwal")
                    val lokasi = data.getJSONObject("lokasi")
                    binding.tvLocation.text = lokasi.getString("kota")
                    binding.tvDatePray.text = jadwal.getString("tanggal")
                    binding.tvPrayTimeSubuh.text =  jadwal.getString("subuh")
                    binding.tvPrayTimeDzuhur.text =  jadwal.getString("dzuhur")
                    binding.tvPrayTimeAshar.text =  jadwal.getString("ashar")
                    binding.tvPrayTimeMaghrib.text =  jadwal.getString("maghrib")
                    binding.tvPrayTimeIsya.text =  jadwal.getString("isya")
                    binding.tvPrayTimeSunrise.text =  jadwal.getString("terbit")

                }catch (error: Exception){
                    Toast.makeText(this@SholatActivity, error.message, Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?,
                error: Throwable?
            ) {
                Toast.makeText(this@SholatActivity, error?.message, Toast.LENGTH_SHORT).show()
            }

        })

    }

    private fun initSholatView() {
        val date= Calendar.getInstance().time
        val dateFormat = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.getDefault())
        val today = dateFormat.format(date)
        //menampilkan tanggal sekarang
        binding.tvDatePray.text = date.toString()

        binding.tvDatePray.text = today

        initGetDataSholat(today, "Jakarta")
    }

    private fun initGetDataSholat(today: String, s: String) {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val date = dateFormat.format(Date())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}