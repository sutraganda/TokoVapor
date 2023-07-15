package com.example.tokovapor2.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.tokovapor2.model.Vapors
import kotlinx.coroutines.flow.Flow


@Dao
interface VaporsDao {
    @Query("SELECT * FROM vapors_table ORDER BY name ASC")
    fun getALLVapors(): Flow<List<Vapors>>

    @Insert
    suspend fun  insertVapors(vapors: Vapors)

    @Delete
    suspend fun deleteVapors(vapors: Vapors)

    @Update
    suspend fun updateVapors(vapors: Vapors)
}