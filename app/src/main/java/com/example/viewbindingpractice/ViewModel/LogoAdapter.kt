package com.example.viewbindingpractice.ViewModel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmpractice.Util.OnItemClickListener
import com.example.mvvmpractice.Util.OnMenuClickListener
import com.example.viewbindingpractice.Model.BeneficiaryModel
import com.example.viewbindingpractice.Model.LogoModel
import com.example.viewbindingpractice.R
import com.example.viewbindingpractice.Util.OnLogoClickListener


class LogoAdapter(
    private val listener: OnLogoClickListener,
    val Logolist: List<LogoModel>,
    val context: Context
) : RecyclerView.Adapter<LogoAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val l: LayoutInflater = LayoutInflater.from(parent.context)
        val view = l.inflate(R.layout.logo_recyclerview_layout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return Logolist.size
    }

    override fun onBindViewHolder(holder: LogoAdapter.ViewHolder, position: Int) {
               holder.bind( Logolist[position],
                View.OnClickListener { listener.onLogoClick(position) }
                )
                // View.OnClickListener { listener.onItemClick(position) },DistrictImages[position])
            }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val logoimage = itemView.findViewById<ImageView>(R.id.logo_image)
        //val image = itemView.findViewById<ImageView>(R.id.logo_image)

        fun bind(logomodel:LogoModel, listener: View.OnClickListener) {

            logoimage.setImageResource(logomodel.logo)

          // beneficiaryaccount.text = beneficiaryModel.accountnumber.toString()
            //ivDistrict.setBackgroundResource(imgs.resIcon)
            //linearlayout.setOnClickListener(listener)
            //menu.setOnClickListener(menulistener)
            logoimage.setOnClickListener(listener)
        }
    }



}