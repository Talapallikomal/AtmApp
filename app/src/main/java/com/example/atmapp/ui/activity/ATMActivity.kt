package com.example.atmapp.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.atmapp.R
import com.example.atmapp.adapter.TransactionAdapter
import com.example.atmapp.databinding.AtmActivityDataBinding
import com.example.atmapp.interfaces.setOnWithdrawNavigator
import com.example.atmapp.model.ATMEntity
import com.example.atmapp.model.AtmTransactionHistory
import com.example.atmapp.network.Resource
import com.example.atmapp.utils.validateEmpty
import com.example.atmapp.viewModel.AtmAmountViewModel
import com.example.atmapp.viewModel.AtmTransactionViewModel
import kotlinx.android.synthetic.main.activity_atmactivity.*
/**
 * created By Komal Talapalli
 * */
class ATMActivity : AppCompatActivity() {
    private lateinit var binding: AtmActivityDataBinding
    val TAG: String? = this::class.java.simpleName
    lateinit var viewModalAtm: AtmAmountViewModel
    lateinit var viewModalAtmTransaction: AtmTransactionViewModel
    var atmTotalAmount: Int = 10000
    var atm100AmtCount: Int = 10
    var atm200AmtCount: Int = 30
    var atm500AmtCount: Int = 2
    var atm2000AmtCount: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_atmactivity)

        // on below line we are initialing our view modal.
        viewModalAtm = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[AtmAmountViewModel::class.java]

        viewModalAtmTransaction = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[AtmTransactionViewModel::class.java]
        setUpObserver()
        setUpUi()

    }

    private fun setUpObserver() {
        viewModalAtm.atmAmountAddRoomObserver.observe(this@ATMActivity) {
            when (it.status) {
                Resource.Status.LOADING -> {

                }
                Resource.Status.SUCCESS -> {
                    Log.e(TAG, "setUpObserver: " + it.data)
                    if (it.data != null) {
                        var atmObj = it.data
                        binding.atmModel = atmObj
                    }

                }
                Resource.Status.ERROR -> {
                    Toast.makeText(this@ATMActivity, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
        viewModalAtm.getAtmAmountObserver.observe(this@ATMActivity) {
            when (it.status) {
                Resource.Status.LOADING -> {

                }
                Resource.Status.SUCCESS -> {
                    Log.e(TAG, "setUpObserver: " + it.data)
                    if ((it.data as List<ATMEntity>).isNotEmpty()) {
                        val atmObj = it.data[0]
                        binding.atmModel = atmObj
                        viewModalAtmTransaction.executeGetAtmTransactionApiCall()
                    } else {
                        val addAtmModel = ATMEntity(
                            1,
                            atmTotalAmount,
                            atm100AmtCount,
                            atm200AmtCount,
                            atm500AmtCount,
                            atm2000AmtCount
                        )
                        viewModalAtm.executeAddAtmAmount(addAtmModel)
                    }
                }
                Resource.Status.ERROR -> {
                    Toast.makeText(this@ATMActivity, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
        viewModalAtmTransaction.getAtmTransObserver.observe(this@ATMActivity) {
            when (it.status) {
                Resource.Status.LOADING -> {

                }
                Resource.Status.SUCCESS -> {
                    Log.e(TAG, "getAtmTransObserver: " + it.data)
                    if ((it.data as List<AtmTransactionHistory>).isNotEmpty()) {
                        rvYourTransaction.adapter =
                            TransactionAdapter(it.data as MutableList<AtmTransactionHistory>)
                        viewModalAtmTransaction.executeGeLastAtmTransactionApiCall()
                    }
                }
                Resource.Status.ERROR -> {
                    Toast.makeText(this@ATMActivity, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
        viewModalAtmTransaction.atmTransactionAddObserver.observe(this@ATMActivity) {
            when (it.status) {
                Resource.Status.LOADING -> {
                    binding.progressLoading.visibility = VISIBLE
                }
                Resource.Status.SUCCESS -> {
                    binding.progressLoading.visibility = GONE
                    Log.e(TAG, "atmTransactionAddObserver: " + it.data)
                    binding.edtFieldWithdraw.setText("")
                }
                Resource.Status.ERROR -> {
                    binding.progressLoading.visibility = GONE
                    Toast.makeText(this@ATMActivity, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
        viewModalAtmTransaction.getAtmLastTransObserver.observe(this@ATMActivity) {
            when (it.status) {
                Resource.Status.LOADING -> {

                }
                Resource.Status.SUCCESS -> {
                    Log.e(TAG, "setUpObserver: " + it.data)
                    if ((it.data as List<AtmTransactionHistory>).isNotEmpty()) {
                        rvTransaction.adapter =
                            TransactionAdapter(it.data as MutableList<AtmTransactionHistory>)
                    }

                }
                Resource.Status.ERROR -> {
                    Toast.makeText(this@ATMActivity, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
        viewModalAtm.updateAtmAmountObserver.observe(this@ATMActivity) {
            when (it.status) {
                Resource.Status.LOADING -> {

                }
                Resource.Status.SUCCESS -> {
                    Log.e(TAG, "setUpObserver: " + it.data)
                    if (it.data != null) {
                        val atmObj = it.data
                        binding.atmModel = atmObj
                    }

                }
                Resource.Status.ERROR -> {
                    Toast.makeText(this@ATMActivity, it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun setUpUi() {
        viewModalAtm.executeGeAtmAmountApiCall()

        binding.btnWithdraw.setOnClickListener {
            setOnWithdrawClickListner()
        }

    }

    private fun setOnWithdrawClickListner() {
        when {
            binding.edtFieldWithdraw.validateEmpty() -> {
                binding.outlinedTextFieldWithDraw.error = "Please Enter Withdraw Amount"
            }
            ((binding.edtFieldWithdraw.text.toString().trim().toInt()) % 100) != 0 -> {
                Toast.makeText(
                    this@ATMActivity,
                    "withdraw amount must be multiplication of 100",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else -> {
                withdrawAmount(binding.edtFieldWithdraw.text.toString().toInt())

            }
        }
    }

    private fun withdrawAmount(withdrawAmount: Int) {

        val notes = intArrayOf(2000, 500, 200, 100)
        val atm100NotesCount: Int = binding.atmModel?.atm100NotesCount.toString().toInt()
        val atm200NotesCount: Int = binding.atmModel?.atm200NotesCount.toString().toInt()
        val atm500NotesCount: Int = binding.atmModel?.atm500NotesCount.toString().toInt()
        val atm2000NotesCount: Int = binding.atmModel?.atm2000NotesCount.toString().toInt()
        val notesCount = intArrayOf(
            atm2000NotesCount,
            atm500NotesCount,
            atm200NotesCount,
            atm100NotesCount
        )
        val noteCounter = IntArray(4)

        val totalAmount: Int = binding.atmModel?.atmTotalAmount.toString().toInt()

        var amount = withdrawAmount
        if (amount <= totalAmount) {
            // count notes using Greedy approach
            for (i in 0..3) {
                if (amount >= notes[i]) {
                    var count = amount / notes[i]

                    if (count > notesCount[i]) {
                        noteCounter[i] = notesCount[i]
                        notes[i] = notes[i] * noteCounter[i]
                    } else {
                        noteCounter[i] = count
                    }
                    if (noteCounter[i] != 0)
                        amount %= notes[i]
                }
            }

            /*for (i in 0..3) {
                if (noteCounter[i] != 0) {
                    //notesCount[i] = notesCount[i] - noteCounter[i]
                    Log.e(
                        TAG, "withdrawAmount: ".plus(
                            notes[i].toString() + " : "
                                    + noteCounter[i] + ":::" + notesCount[i]
                        )
                    )
                }
            }*/
            val totalBal = totalAmount - withdrawAmount
            val transactionModel = AtmTransactionHistory(
                atmWithdrawAmount = withdrawAmount,
                atm100NotesCount = noteCounter[3],
                atm200NotesCount = noteCounter[2],
                atm500NotesCount = noteCounter[1],
                atm2000NotesCount = noteCounter[0]
            )
            viewModalAtmTransaction.executeAddAtmTransaction(transactionModel)
            val atm100Notes = if (atm100NotesCount != 0) atm100NotesCount - noteCounter[3] else 0
            val atm200Notes = if (atm200NotesCount != 0) atm200NotesCount - noteCounter[2] else 0
            val atm500Notes = if (atm500NotesCount != 0) atm500NotesCount - noteCounter[1] else 0
            val atm2000Notes = if (atm2000NotesCount != 0) atm2000NotesCount - noteCounter[0] else 0

            val atmModel =
                ATMEntity(1, totalBal, atm100Notes, atm200Notes, atm500Notes, atm2000Notes)
            viewModalAtm.executeUpdateAtmAmountApiCall(atmModel)

        } else {
            Toast.makeText(this@ATMActivity, "InSufficient Balance", Toast.LENGTH_SHORT).show()
        }
    }

}