package com.example.atmapp.repository

import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.example.atmapp.model.AtmTransactionHistory
import com.example.atmapp.network.Resource.Companion.loading
import com.example.atmapp.network.Resource.Companion.success
import com.example.atmapp.room.dao.AtmTransactionDao

class AtmTransactionRepository(private val atmTransactionDao: AtmTransactionDao) {


    //add transaction data
    fun invokeAddAtmTransactionData(transactionHistory: AtmTransactionHistory) =
        liveData {
            emit(loading(null))
            atmTransactionDao.insertTransactionData(transactionHistory)
            val data=atmTransactionDao.getAllTransactionHistory().map {
                success(it, "fatched")
            }
            emitSource(data)
        }

    //getAllTransaction Data
    fun getAllTransactionData() = liveData {
        emit(loading(null))
        val data =
            atmTransactionDao.getAllTransactionHistory().map {
                success(it, "fatched")
            }
        emitSource(data)
    }

    //getLastTransaction Data
    fun getLastTransactionData() = liveData {
        emit(loading(null))
        val data =
            atmTransactionDao.getLastTransactionHistory().map {
                success(it, "fatched")
            }
        emitSource(data)
    }
}