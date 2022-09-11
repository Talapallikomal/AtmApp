package com.example.atmapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.example.atmapp.model.ATMEntity
import com.example.atmapp.repository.AtmRepository
import com.example.atmapp.room.database.AtmDatabase

class AtmAmountViewModel(application: Application) : AndroidViewModel(application) {


    private val atmRepository: AtmRepository
    init {
        val dao = AtmDatabase.getDatabase(application.applicationContext).getAtmDao()
        atmRepository = AtmRepository(dao)
    }

    //add atm amount data
    private val _tagAtmAmountData = MutableLiveData<Boolean>()
    private var atmModel = MutableLiveData<ATMEntity>()
    val atmAmountAddRoomObserver = _tagAtmAmountData.switchMap {
        addAtmAmountApiCall()
    }

    private fun addAtmAmountApiCall() =
        atmRepository.invokeAddAtmData(atmModel.value!!)

    fun executeAddAtmAmount(atmEntity: ATMEntity) {
        atmModel.value = atmEntity
        _tagAtmAmountData.value = true
    }

    //get Atm Amounts
    private val _tagGetAtmAmount = MutableLiveData<Boolean>()
    val getAtmAmountObserver = _tagGetAtmAmount.switchMap {
        getAtmAmountsCall()
    }

    private fun getAtmAmountsCall() =
        atmRepository.getAtmAmountData()

    fun executeGeAtmAmountApiCall() {
        _tagGetAtmAmount.value = true
    }

    //update Amount Balance and count

    private val _tagUpdateAtmAmount = MutableLiveData<Boolean>()
    val updateAtmAmountObserver = _tagUpdateAtmAmount.switchMap {
        updateAtmAmountsCall()
    }

    private fun updateAtmAmountsCall() =
        atmRepository.invokeUpdateAtmData(atmModel.value!!)

    fun executeUpdateAtmAmountApiCall(atmEntity: ATMEntity) {
        atmModel.value = atmEntity
        _tagUpdateAtmAmount.value = true
    }
}