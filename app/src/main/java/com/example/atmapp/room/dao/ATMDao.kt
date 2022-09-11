package com.example.atmapp.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.atmapp.model.ATMEntity

@Dao
interface ATMDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertATMEntry(atm :ATMEntity)

    @Query("select * from ATMEntity")
    fun getAtmAmounts(): LiveData<List<ATMEntity>>

    @Query("UPDATE ATMEntity set atmTotalAmount=:balanceAmt,atm100NotesCount=:amount100Count,atm200NotesCount=:amount200Count,atm500NotesCount=:amount500Count,atm2000NotesCount=:amount2000Count where  id=:id")
    suspend fun updateAtmAmounts(id: Int, balanceAmt:Int,amount100Count:Int,amount200Count:Int,amount500Count:Int,amount2000Count: Int)

}