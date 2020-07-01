package com.example.viewbindingpractice.ViewModel

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.viewbindingpractice.Model.BeneficiaryModel
import com.example.viewbindingpractice.R

class BeneficiaryAdapter(val Beneficairylist: List<BeneficiaryModel>, val context: Context
) : RecyclerView.Adapter<BeneficiaryAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val l: LayoutInflater = LayoutInflater.from(parent.context)
        val view=l.inflate(R.layout.bottomsheet_view,parent,false)
        return ViewHolder(view)

        Log.d("am adapter",Beneficairylist.toString())
    }

    override fun getItemCount(): Int {
        return Beneficairylist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(Beneficairylist[position])
           // View.OnClickListener { listener.onItemClick(position) },DistrictImages[position])
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val beneficiaryname: TextView =itemView.findViewById(R.id.beneficiary_name) as TextView
        val beneficiaryaccount: TextView =itemView.findViewById(R.id.beneficiary_account) as TextView

        fun bind(beneficiaryModel: BeneficiaryModel)
        {

            beneficiaryname.text=beneficiaryModel.Bname
            beneficiaryaccount.text=beneficiaryModel.accountnumber.toString()
            //ivDistrict.setBackgroundResource(imgs.resIcon)
                //card.setOnClickListener(listener)
        }
    }
}