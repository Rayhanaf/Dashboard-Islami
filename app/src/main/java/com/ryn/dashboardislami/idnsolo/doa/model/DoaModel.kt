package com.ryn.dashboardislami.idnsolo.doa.model

import android.icu.text.CaseMap.Title
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DoaModel(
    var title: String = "",
    var doa: String = " ",
    var latin: String = " ",
    var terjemahan: String = "",
    var profile: String = "",
) : Parcelable
