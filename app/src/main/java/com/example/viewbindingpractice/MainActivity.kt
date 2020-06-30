package com.example.viewbindingpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.viewbindingpractice.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.submit_dialog.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
      var flag:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.circleArrowIcon.isEnabled=false
    }


    fun doneclosed(view: View) {
        binding.TransactionDetails.visibility = View.VISIBLE

    }


    fun Fewa(view: View) {
        binding.Account.visibility = View.VISIBLE
        binding.textvw.visibility = View.VISIBLE

    }

    fun MobileDo(view: View) {
        binding.Account.setText("971-5-494-9499")
        binding.textvw.setText("Add to Beneficary List")
    }

    fun AddList(view: View) {
        binding.textvw.visibility = View.GONE
        binding.Name.visibility = View.VISIBLE
    }

    fun Addname(view: View) {
        binding.Name.setText("Khalid Aziz")
        binding.circleArrowIcon.isEnabled=true
    }

    fun submit(view: View)
    {
                   if(binding.circleArrowIcon.isEnabled)
                   {
                       if(flag==0)
                       {
                       val dialog = AlertDialog.Builder(this)
                       val mDialogView = LayoutInflater.from(this).inflate(R.layout.submit_dialog, null)
                       dialog.setView(mDialogView)
                       //dialog.setCancelable(false)
                       dialog.show()
                       //done_tick.setOnClickListener {
                       //  val alertDialog:AlertDialog =dialog.create()
                       //alertDialog.dismiss()
                       }
                       else if(flag==1)
                       {
                           val intent =Intent(this,OtpActivity::class.java)
                           startActivity(intent)
                          // Toast.makeText(this,"Add Details",Toast.LENGTH_LONG).show()
                       }
                   }
        else
                   {
                       Toast.makeText(this,"Add Details",Toast.LENGTH_LONG).show()
                   }

    }
      fun edit(view: View)
      {
          binding.payment.setText("500")
          flag=1
      }

}


