package com.example.atmapp.repository

import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.example.atmapp.model.ATMEntity
import com.example.atmapp.network.Resource.Companion.loading
import com.example.atmapp.network.Resource.Companion.success
import com.example.atmapp.room.dao.ATMDao

data class AtmRepository(private val atmDao: ATMDao) {

    //add atm data
    fun invokeAddAtmData(atmEntity: ATMEntity) =
        liveData {
            emit(loading(null))
            atmDao.insertATMEntry(atmEntity)
            emit(success(atmEntity, "saved"))
        }

    //getAtmData
    fun getAtmAmountData() = liveData {
        emit(loading(null))
        val data =
            atmDao.getAtmAmounts().map {
                success(it, "fatched")
            }
        emitSource(data)
    }

    //update amount balance and count
    //add atm data
    fun invokeUpdateAtmData(atmEntity: ATMEntity) =
        liveData {
            emit(loading(null))
            atmDao.updateAtmAmounts(1,atmEntity.atmTotalAmount,atmEntity.atm100NotesCount,atmEntity.atm200NotesCount,atmEntity.atm500NotesCount,atmEntity.atm2000NotesCount)
            emit(success(atmEntity, "saved"))
        }
}