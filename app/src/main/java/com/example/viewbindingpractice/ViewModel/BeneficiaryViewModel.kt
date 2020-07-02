package com.example.viewbindingpractice.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.viewbindingpractice.Model.BeneficiaryModel

class BeneficiaryViewModel : ViewModel() {

    var beneficiaryList: MutableLiveData<List<BeneficiaryModel>>? = null
    var beneficiaryDetails: List<BeneficiaryModel>? = null
    var bnflist:ArrayList<BeneficiaryModel> = ArrayList()

    fun getBeneficiary(): LiveData<List<BeneficiaryModel>> {
        //if the list is null
        if (beneficiaryList == null) {
            beneficiaryList = MutableLiveData<List<BeneficiaryModel>>()
            loadBeneficiary()
        }

        return beneficiaryList!!
    }

    private fun loadBeneficiary()
    {



        bnflist.add(BeneficiaryModel("Khalid",1234567))
        bnflist.add(BeneficiaryModel("Imran",1567892))
        bnflist.add(BeneficiaryModel("Quresh",12389789877))
        bnflist.add(BeneficiaryModel("Farhan",1674534))
        bnflist.add(BeneficiaryModel("samrat",123434567))
        bnflist.add(BeneficiaryModel("Adnan",1234567))
        bnflist.add(BeneficiaryModel("Adnan",1234567))
        bnflist.add(BeneficiaryModel("Adnan",1234567))
        beneficiaryList!!.value = bnflist
        beneficiaryDetails=bnflist

    }
    fun addBeneficiary(account:Int,name:String)
    {
        bnflist.add(BeneficiaryModel(name,account))
        beneficiaryList!!.value = bnflist
    }



}
