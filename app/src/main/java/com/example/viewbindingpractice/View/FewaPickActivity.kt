package com.example.viewbindingpractice.View

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmpractice.Util.OnItemClickListener
import com.example.mvvmpractice.Util.OnMenuClickListener
import com.example.viewbindingpractice.Model.BeneficiaryModel
import com.example.viewbindingpractice.R
import com.example.viewbindingpractice.ViewModel.BeneficiaryAdapter
import com.example.viewbindingpractice.ViewModel.BeneficiaryViewModel
import com.example.viewbindingpractice.databinding.ActivityFewaPickBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.bottomsheet_view.*


class FewaPickActivity : AppCompatActivity() ,OnItemClickListener,OnMenuClickListener{

    var flag:Int=0
    var choose:Int =0
    private lateinit var pickBinding: ActivityFewaPickBinding
    private lateinit var model: BeneficiaryViewModel
    private lateinit var list:List<BeneficiaryModel>
    private lateinit var d:BottomSheetDialog



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pickBinding = ActivityFewaPickBinding.inflate(layoutInflater)
        val view = pickBinding.root
        setContentView(view)
        model = ViewModelProviders.of(this).get(BeneficiaryViewModel::class.java)
        model.getBeneficiary().observe(this,
          Observer { t ->
              list=t
                      })
            pickBinding.circleArrowIcon.isEnabled=false

        pickBinding.fewaPickMawakif.setOnClickListener {
            pickBinding.fewaPickAccount.visibility=View.VISIBLE
            pickBinding.fewaAddfromBeneficiary.visibility=View.VISIBLE

        }



    pickBinding.fewaAddfromBeneficiary.setOnClickListener {
        if(choose==0) {
            d = BottomSheetDialog(this)
            val bottomsheet = layoutInflater.inflate(R.layout.bottom_sheet, null)
            d.setContentView(bottomsheet)
            d.show()
            val rec = bottomsheet.findViewById<RecyclerView>(R.id.recyclerviewid)
            rec.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            val adapter = BeneficiaryAdapter(this, this, list, this)
            rec.adapter = adapter
        }
        else
        {
            pickBinding.fewaAddfromBeneficiary.visibility=View.GONE
            pickBinding.Name.visibility=View.VISIBLE
            pickBinding.circleArrowIcon.isEnabled=true
            Toast.makeText(this,"add to list",Toast.LENGTH_LONG).show()
        }
    }
    pickBinding.circleArrowIcon.setOnClickListener {
        if(flag==0) {
            //val a=Integer.parseInt(pickBinding.fewaPickAccount.toString())
            model.addBeneficiary(9999999, pickBinding.Name.toString())
            val dialog = AlertDialog.Builder(this)
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.submit_dialog, null)
            dialog.setView(mDialogView)
           // dialog.setCancelable(false)
            dialog.show()
            pickBinding.TransactionDetailsFewaPick.visibility=View.VISIBLE
         //   val submitdialog = findViewById<Button>(R.id.done_tick)
           // submitdialog.setOnClickListener {

            //}

        }
        if(flag==1)
        {
            val intent = Intent(this, OtpActivity::class.java)
            startActivity(intent)
        }
    }
            pickBinding.fewaPickAccount.setOnClickListener {
                pickBinding.fewaAddfromBeneficiary.setText("Add to Beneficiary List")
                choose=1
            }

        pickBinding.editAmount.setOnClickListener {
            pickBinding.payment.setText("500")
            flag=1

        }



              }

    override fun onItemClick(index: Int) {

        model.beneficiaryDetails?.let {
            pickBinding.Name.visibility=View.VISIBLE
            pickBinding.fewaPickAccount.setText(it[index].accountnumber.toString())
            pickBinding.Name.setText(it[index].Bname)
            pickBinding.TransactionDetailsFewaPick.visibility = View.VISIBLE
            pickBinding.fewaAddfromBeneficiary.visibility = View.GONE
            pickBinding.Name.isFocusableInTouchMode=false
            pickBinding.fewaPickAccount.isFocusableInTouchMode=false
            pickBinding.Name.isEnabled=false
            pickBinding.fewaPickAccount.isEnabled=false
             d.dismiss()
        }
    }
    override fun onMenuClick(index: Int, view: View) {
        val p = PopupMenu(this, view)
        p.menuInflater.inflate(R.menu.mymenu, p.menu)
        p.show()
    }



}