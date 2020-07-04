package com.example.viewbindingpractice.ViewModel

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmpractice.Util.OnItemClickListener
import com.example.mvvmpractice.Util.OnMenuClickListener
import com.example.viewbindingpractice.Model.BeneficiaryModel
import com.example.viewbindingpractice.R

class BeneficiaryAdapter(
    private val listener: OnItemClickListener,private val menulistener: OnMenuClickListener,
    val Beneficairylist: List<BeneficiaryModel>,
    val context: Context
) : RecyclerView.Adapter<BeneficiaryAdapter.ViewHolder>() {

private lateinit var view: View
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
           val l: LayoutInflater = LayoutInflater.from(parent.context)
           view = l.inflate(R.layout.bottomsheet_view, parent, false)
           return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return Beneficairylist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(
            Beneficairylist[position],
            View.OnClickListener { listener.onItemClick(position)},
                View.OnClickListener { menulistener.onMenuClick(position,view) }
        )
        // View.OnClickListener { listener.onItemClick(position) },DistrictImages[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val beneficiaryname: TextView = itemView.findViewById(R.id.beneficiary_name) as TextView
        val beneficiaryaccount: TextView = itemView.findViewById(R.id.beneficiary_account) as TextView
        val linearlayout = itemView.findViewById<ConstraintLayout>(R.id.listview_layout)
        val menu = itemView.findViewById<ImageView>(R.id.list_menu)

        fun bind(beneficiaryModel: BeneficiaryModel, listener: View.OnClickListener,menulistener: View.OnClickListener) {

            beneficiaryname.text = beneficiaryModel.Bname
            beneficiaryaccount.text = beneficiaryModel.accountnumber.toString()
            //ivDistrict.setBackgroundResource(imgs.resIcon)
            linearlayout.setOnClickListener(listener)
            menu.setOnClickListener(menulistener)
        }
    }
}