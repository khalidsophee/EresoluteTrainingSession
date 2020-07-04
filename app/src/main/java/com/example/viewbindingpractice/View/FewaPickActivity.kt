package com.example.viewbindingpractice.View

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.TextWatcher
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
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
import com.example.viewbindingpractice.Model.LogoModel
import com.example.viewbindingpractice.R
import com.example.viewbindingpractice.Util.OnLogoClickListener
import com.example.viewbindingpractice.ViewModel.BeneficiaryAdapter
import com.example.viewbindingpractice.ViewModel.BeneficiaryViewModel
import com.example.viewbindingpractice.ViewModel.LogoAdapter
import com.example.viewbindingpractice.databinding.ActivityFewaPickBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.submit_dialog.*


class FewaPickActivity : AppCompatActivity() ,OnItemClickListener,OnMenuClickListener,OnLogoClickListener{

    var flag:Int=0
    var choose:Int =0
    private lateinit var pickBinding: ActivityFewaPickBinding
    private lateinit var model: BeneficiaryViewModel
    private lateinit var list:List<BeneficiaryModel>
    private lateinit var d:BottomSheetDialog
    var logolist:ArrayList<LogoModel> = ArrayList()


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


             logolist.add(LogoModel(R.drawable.fewaa_logo,"fewa"))
         //    logolist.add(LogoModel(R.drawable.logo_salik,"fewa"))

        val logorecyclerview = findViewById<RecyclerView>(R.id.fewa_pick_mawakif)
        logorecyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val logoadapter = LogoAdapter(this,logolist,this)
        logorecyclerview.adapter = logoadapter



        val s = SpannableStringBuilder(getString(R.string.firstName))
        s.setSpan( ForegroundColorSpan(Color.BLUE), 12,28, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        pickBinding.fewaAddfromBeneficiary.text = s

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
            val dialog = AlertDialog.Builder(this).create()
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.submit_dialog, null)
            dialog.setView(mDialogView)
            dialog.setCancelable(false)
            dialog.show()
           val submitdialog = mDialogView.findViewById<Button>(R.id.done_tick)
            submitdialog.setOnClickListener {
                 dialog.dismiss()

                pickBinding.TransactionDetailsFewaPick.visibility=View.VISIBLE
                 pickBinding.fewaPickAccount.isEnabled=false
                pickBinding.Name.isEnabled=false
            }

        }


        if(flag==1)
        {
            val intent = Intent(this, OtpActivity::class.java)
            startActivity(intent)
        }
    }


        pickBinding.fewaPickAccount.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int,before: Int, count: Int) {
                val s = SpannableStringBuilder("Add to Beneficiary List")
                s.setSpan( ForegroundColorSpan(Color.BLUE), 7,23, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                pickBinding.fewaAddfromBeneficiary.text = s
                choose=1
                }
        })

        pickBinding.editAmount.setOnClickListener {
            pickBinding.detailsAccounttobepiadAmount.setText("500")
            pickBinding.circleArrowIcon.isEnabled=true
            flag=1
            pickBinding.editAmount.visibility=View.GONE
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

        val mDialogView = LayoutInflater.from(this).inflate(R.layout.bottomsheet_view, null)
      //  val m=mDialogView.findViewById<ImageView>(R.id.list_menu)
        val p = PopupMenu(this,view)
        p.menuInflater.inflate(R.menu.mymenu, p.menu)
        p.show()
    }

    override fun onLogoClick(index: Int) {
        if (index==0)
        {

                pickBinding.fewaPickAccount.visibility=View.VISIBLE
                pickBinding.fewaAddfromBeneficiary.visibility=View.VISIBLE
        }

        Toast.makeText(this,"you have succceed",Toast.LENGTH_LONG).show()
    }


}