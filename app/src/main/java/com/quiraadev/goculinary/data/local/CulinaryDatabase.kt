package com.quiraadev.goculinary.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CulinaryEntity::class], version = 2, exportSchema = false)
abstract class CulinaryDatabase : RoomDatabase() {
    abstract fun dao() : CulinaryDao
}