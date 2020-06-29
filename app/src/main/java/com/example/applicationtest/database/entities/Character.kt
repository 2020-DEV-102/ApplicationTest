package com.example.applicationtest.database.entities

import androidx.room.ColumnInfo
import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Character ( @PrimaryKey(autoGenerate = true) val cid: Int = 0,
                        @ColumnInfo(name = "name") val name: String?,
                        @ColumnInfo(name = "description") val description: String?)
{

}