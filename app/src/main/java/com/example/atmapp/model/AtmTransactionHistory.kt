package com.example.atmapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "AtmTransactionHistoryTable")
data class AtmTransactionHistory(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "trans_id") var transId: Int?= null,
    @ColumnInfo(name = "atm_withdraw_amount") var atmWithdrawAmount: Int?=0,
    @ColumnInfo(name = "atm_100_notes_count") var atm100NotesCount: Int?=0,
    @ColumnInfo(name = "atm_200_notes_count") var atm200NotesCount: Int?=0,
    @ColumnInfo(name = "atm_500_notes_count") var atm500NotesCount: Int?=0,
    @ColumnInfo(name = "atm_2000_notes_count") var atm2000NotesCount: Int?=0
)