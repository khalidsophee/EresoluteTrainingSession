package com.example.viewbindingpractice.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.viewbindingpractice.Model.BeneficiaryModel

class BeneficiaryViewModel : ViewModel() {

    var beneficiaryList: MutableLiveData<List<BeneficiaryModel>>? = null
    var districtDetails: List<BeneficiaryModel>? = null


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

        var bnflist:ArrayList<BeneficiaryModel> = ArrayList()

        bnflist.add(BeneficiaryModel("Adnan",1234567))
        bnflist.add(BeneficiaryModel("Adnan",1234567))
        bnflist.add(BeneficiaryModel("Adnan",1234567))
        bnflist.add(BeneficiaryModel("Adnan",1234567))
        bnflist.add(BeneficiaryModel("Adnan",1234567))
        bnflist.add(BeneficiaryModel("Adnan",1234567))
        bnflist.add(BeneficiaryModel("Adnan",1234567))
        bnflist.add(BeneficiaryModel("Adnan",1234567))



        beneficiaryList!!.value = bnflist
        //districtDetails = response.body()?.data!!

    }

}
