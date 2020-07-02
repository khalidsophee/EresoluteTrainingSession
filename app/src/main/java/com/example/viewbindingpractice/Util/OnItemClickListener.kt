package com.example.mvvmpractice.Util

import android.view.View

interface OnItemClickListener {
        fun onItemClick(index: Int)

}

interface OnMenuClickListener {
        fun onMenuClick(index: Int,view:View)

}
