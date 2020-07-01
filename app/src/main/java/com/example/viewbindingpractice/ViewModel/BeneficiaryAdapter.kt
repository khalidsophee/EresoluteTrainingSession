package com.example.viewbindingpractice.ViewModel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.viewbindingpractice.Model.BeneficiaryModel

class BeneficiaryAdapter(val Beneficairylist: List<BeneficiaryModel>,
                       val context: Context
) : RecyclerView.Adapter<BeneficiaryAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val l: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View =l.inflate(R.layout.bottomsheet_view,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return Beneficairylist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(Beneficairylist[position],
           // View.OnClickListener { listener.onItemClick(position) },DistrictImages[position])
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val beneficiary_name: TextView =itemView.findViewById(R.id.beneficiary_name) as TextView
        private var ivDistrict = itemView.findViewById<ImageView>(R.id.beneficiary_account) as TextView
       // val card=itemView.findViewById<CardView>(R.id.card)


        fun bind(beneficiaryModel: BeneficiaryModel)
        {
            beneficiary_name.text=beneficiaryModel.Bname
            beneficiary_name.text=beneficiaryModel.accountnumber
            //ivDistrict.setBackgroundResource(imgs.resIcon)
                //card.setOnClickListener(listener)
        }
    }
}