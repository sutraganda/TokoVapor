package com.example.tokovapor2.repository

import com.example.tokovapor2.dao.VaporsDao
import com.example.tokovapor2.model.Vapors
import kotlinx.coroutines.flow.Flow

class VaporsRepository(private  val  vaporsDao: VaporsDao) {
    val allVapors: Flow<List<Vapors>> = vaporsDao.getALLVapors()

    suspend fun  insertVapors(vapors: Vapors){
        vaporsDao.insertVapors(vapors)
    }

    suspend fun  updateVapors(vapors: Vapors){
        vaporsDao.updateVapors(vapors)
    }

    suspend fun  deleteVapors(vapors: Vapors){
        vaporsDao.deleteVapors(vapors)
    }

}