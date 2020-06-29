package com.example.applicationtest.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

class Item : Serializable {
    var id : Long = 0
    var name : String? = ""
    var description : String? = ""
}