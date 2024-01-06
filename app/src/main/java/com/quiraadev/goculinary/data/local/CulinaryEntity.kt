package com.quiraadev.goculinary.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("tbl_culinary")
data class CulinaryEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    val name : String,
    val photoUrl : String,
    val description : String,
    val location : String,
    val rating : Double,
    val price : Double,
    val totalReview : Int,
    var isWishlisted : Boolean = false
)