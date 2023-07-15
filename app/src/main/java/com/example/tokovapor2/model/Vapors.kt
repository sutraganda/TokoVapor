package com.example.tokovapor2.model

import android.location.Address
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "vapors_table")
data class Vapors(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val address: String,
    val goods: String,
    val type: String,
    val amountgoods: String,
    val latitude: Double?,
    val longitude: Double?
) : Parcelable
