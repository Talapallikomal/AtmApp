package com.example.atmapp.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.atmapp.model.ATMEntity
import com.example.atmapp.model.AtmTransactionHistory
import com.example.atmapp.room.dao.ATMDao
import com.example.atmapp.room.dao.AtmTransactionDao

@Database(entities = [ATMEntity::class,AtmTransactionHistory::class], version = 1)
abstract class AtmDatabase : RoomDatabase() {
    abstract fun getAtmDao(): ATMDao
    abstract fun getAtmTransactionDao(): AtmTransactionDao

    companion object {
        // Volatile annotation means any change to this field
        // are immediately visible to other threads.
        private var INSTANCE: AtmDatabase? = null

        private const val DB_NAME = "atm_database.db"

        fun getDatabase(context: Context): AtmDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            // here synchronised used for blocking the other thread
            // from accessing another while in a specific code execution.
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AtmDatabase::class.java,
                    DB_NAME
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}