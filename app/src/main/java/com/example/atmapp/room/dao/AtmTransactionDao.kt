package com.example.atmapp.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.atmapp.model.AtmTransactionHistory

@Dao
interface AtmTransactionDao {

    //insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransactionData(transaction : AtmTransactionHistory)

    //all transaction history
    @Query("select * from AtmTransactionHistoryTable")
    fun getAllTransactionHistory(): LiveData<List<AtmTransactionHistory>>

    //get last transaction
    @Query("select * from AtmTransactionHistoryTable ORDER BY trans_id DESC LIMIT 1")
    fun getLastTransactionHistory(): LiveData<List<AtmTransactionHistory>>


}