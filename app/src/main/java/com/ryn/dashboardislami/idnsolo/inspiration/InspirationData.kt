package com.ryn.dashboardislami.idnsolo.inspiration

import com.ryn.dashboardislami.idnsolo.R

object InspirationData {
    private val inspirationImage = intArrayOf(
        R.drawable.img_inspiration,
        R.drawable.img_inspiration,
        R.drawable.img_inspiration,
    )

    val listData: ArrayList<InspirationModel>
        get() {
            val list = arrayListOf<InspirationModel>()
            for (position in inspirationImage.indices){
                val inspiration = InspirationModel()
                inspiration.inspirationImage = inspirationImage[position]
                list.add(inspiration)
            }

            return listData
        }
}