package com.example.atmapp.viewModel


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.example.atmapp.model.AtmTransactionHistory
import com.example.atmapp.repository.AtmTransactionRepository
import com.example.atmapp.room.database.AtmDatabase

class AtmTransactionViewModel(application: Application): AndroidViewModel(application) {

    private var atmTransactionRepository: AtmTransactionRepository

    init {
        val dao = AtmDatabase.getDatabase(application.applicationContext).getAtmTransactionDao()
        atmTransactionRepository = AtmTransactionRepository(dao)
    }

    //add atm transaction data
    private val _tagAtmTransactionData = MutableLiveData<Boolean>()
    private var atmTransactionHistory = MutableLiveData<AtmTransactionHistory>()
    val atmTransactionAddObserver = _tagAtmTransactionData.switchMap {
        addAtmTransactionApiCall()
    }

    private fun addAtmTransactionApiCall() =
        atmTransactionRepository.invokeAddAtmTransactionData(atmTransactionHistory.value!!)

    fun executeAddAtmTransaction(atmTrans: AtmTransactionHistory) {
        atmTransactionHistory.value = atmTrans
        _tagAtmTransactionData.value = true
    }


    //get Atm Transaction
    private val _tagGetAtmTransaction = MutableLiveData<Boolean>()
    val getAtmTransObserver = _tagGetAtmTransaction.switchMap {
        getAtmTransactionCall()
    }

    private fun getAtmTransactionCall() =
        atmTransactionRepository.getAllTransactionData()

    fun executeGetAtmTransactionApiCall() {
        _tagGetAtmTransaction.value = true
    }

    //get Last Transaction
    private val _tagGetLastAtmTransaction = MutableLiveData<Boolean>()
    val getAtmLastTransObserver = _tagGetLastAtmTransaction.switchMap {
        getAtmLastTransactionCall()
    }

    private fun getAtmLastTransactionCall() =
        atmTransactionRepository.getLastTransactionData()

    fun executeGeLastAtmTransactionApiCall() {
        _tagGetLastAtmTransaction.value = true
    }
}