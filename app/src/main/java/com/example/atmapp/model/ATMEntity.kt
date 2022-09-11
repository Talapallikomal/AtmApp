package com.example.atmapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "ATMEntity")
data class ATMEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = 0,
    var atmTotalAmount: Int = 0,
    var atm100NotesCount: Int = 0,
    var atm200NotesCount: Int = 0,
    var atm500NotesCount: Int = 0,
    var atm2000NotesCount: Int = 0
)