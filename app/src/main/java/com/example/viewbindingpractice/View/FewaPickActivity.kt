package com.example.viewbindingpractice.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.viewbindingpractice.R
import com.example.viewbindingpractice.ViewModel.BeneficiaryAdapter
import com.example.viewbindingpractice.ViewModel.BeneficiaryViewModel
import com.example.viewbindingpractice.databinding.ActivityFewaPickBinding
import com.example.viewbindingpractice.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class FewaPickActivity : AppCompatActivity() {


    private lateinit var pickBinding: ActivityFewaPickBinding
    private lateinit var model: BeneficiaryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pickBinding = ActivityFewaPickBinding.inflate(layoutInflater)
        val view = pickBinding.root
        setContentView(view)
    }

    fun ShowList(view: View) {
        val d = BottomSheetDialog(this)
        val bottomsheet = layoutInflater.inflate(R.layout.bottom_sheet, null)
        d.setContentView(bottomsheet)
        d.show()
        model = ViewModelProviders.of(this).get(BeneficiaryViewModel::class.java)

    model.getBeneficiary().observe(this,
            Observer { t ->
                val rec = bottomsheet.findViewById<RecyclerView>(R.id.benificiary_recyclerview_id)
                rec.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                val adapter = BeneficiaryAdapter(t,this)
                Log.d("hello",t.toString())
                Toast.makeText(this,t.toString(),Toast.LENGTH_LONG).show()
                rec.adapter = adapter
            })

    }

}