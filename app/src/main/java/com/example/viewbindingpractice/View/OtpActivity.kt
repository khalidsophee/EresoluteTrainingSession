package com.example.viewbindingpractice.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.viewbindingpractice.R
import com.example.viewbindingpractice.databinding.ActivityOtpBinding

class OtpActivity : AppCompatActivity() {
    private lateinit var otpbinding: ActivityOtpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        otpbinding = ActivityOtpBinding.inflate(layoutInflater)
        val view = otpbinding.root
        setContentView(view)
    }

    fun otpdesign(view: View) {
        otpbinding.otp1.setText("1")
        otpbinding.otp2.setText("2")
        otpbinding.otp3.setText("3")
        otpbinding.otp4.setText("4")
        otpbinding.otp5.setText("5")
        otpbinding.otp6.setText("6")
        val dialog = AlertDialog.Builder(this).create()
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.successdialog, null)
        dialog.setView(mDialogView)
        dialog.setCancelable(false)
        dialog.show()

        val successdialog = mDialogView.findViewById<Button>(R.id.done_tick)
        successdialog.setOnClickListener {
            dialog.dismiss()
            val intent = Intent(this,FewaPickActivity::class.java)
            startActivity(intent)
        }
    }

}