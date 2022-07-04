package com.example.apparquitectura.view

import android.content.Intent
import android.icu.text.Transliterator
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.apparquitectura.BR
import com.example.apparquitectura.model.Coupon
import com.example.apparquitectura.R
import com.example.apparquitectura.viewmodel.CouponViewmodel
import com.squareup.picasso.Picasso

class RecyclerCouponsAdapter(var couponViewmodel: CouponViewmodel ,var resource: Int) :
    RecyclerView.Adapter<RecyclerCouponsAdapter.CardCouponHolder>()  {

    var coupons : List<Coupon>? = null

    fun setCouponsList(coupon: List<Coupon>?){
        this.coupons = coupons
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CardCouponHolder {
        var layoutInflater: LayoutInflater = LayoutInflater.from(p0.context)
        var binding: ViewDataBinding = DataBindingUtil.inflate(layoutInflater, p1, p0, false)
        return CardCouponHolder(binding)
    }

    override fun getItemCount(): Int {
        return coupons?.size ?: 0
    }

    override fun onBindViewHolder(p0: CardCouponHolder, p1: Int) {
        p0.setDataCard(couponViewmodel, p1)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    fun getLayoutIdForPosition(position: Int): Int {
        return resource
    }

    class CardCouponHolder(binding:ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
        private var binding: ViewDataBinding? = null
        init {
            this.binding = binding
        }

        fun setDataCard(couponViewmodel: CouponViewmodel, position:Int){
            binding?.setVariable(BR.model, couponViewmodel)
            binding?.setVariable(BR.position, position)
            binding?.executePendingBindings()
        }
    }
}