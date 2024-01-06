package com.quiraadev.goculinary.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CulinaryDao {
    @Query("SELECT * FROM tbl_culinary")
    fun getAllCulinaryItem(): Flow<List<CulinaryEntity>>

    @Query("SELECT * FROM tbl_culinary WHERE isWishlisted = 1")
    fun getAllWishlistedCulinary(): Flow<List<CulinaryEntity>>

    @Query("SELECT * FROM tbl_culinary WHERE id = :id")
    fun getCulinary(id: Int): Flow<CulinaryEntity>

    @Query("SELECT * FROM tbl_culinary WHERE name LIKE '%' || :query || '%'")
    fun searchCulinary(query: String): Flow<List<CulinaryEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCulinary(culinaries : List<CulinaryEntity>)

    @Query("UPDATE tbl_culinary SET isWishlisted = :isWishlisted WHERE id = :id")
    fun updateWishlistedCulinary(id : Int, isWishlisted : Boolean)

}