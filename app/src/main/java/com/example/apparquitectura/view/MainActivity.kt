package com.example.apparquitectura.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.apparquitectura.R
import com.example.apparquitectura.databinding.ActivityMainBinding
import com.example.apparquitectura.model.Coupon
import com.example.apparquitectura.viewmodel.CouponViewmodel

class MainActivity : AppCompatActivity() {

    private var couponViewmodel: CouponViewmodel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        setupBindings(savedInstanceState)
    }

    fun setupBindings(savedInstanceState: Bundle?){
        val activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this,R.layout.activity_main )
        couponViewmodel = ViewModelProvider.NewInstanceFactory().create(CouponViewmodel::class.java)
        activityMainBinding.model
        setupListUpdate()
    }

    private fun setupListUpdate(){
        couponViewmodel?.callCoupons()
        couponViewmodel?.getCoupons()?.observe(this, Observer {
                coupons:List<Coupon> -> Log.w("COUPON", coupons[0].title)
            couponViewmodel?.setCouponsInRecyclerAdapter(coupons)
        })
    }
}