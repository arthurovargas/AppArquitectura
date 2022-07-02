package com.example.apparquitectura.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apparquitectura.model.Coupon
import com.example.apparquitectura.model.CouponObservable

class CouponViewmodel: ViewModel() {
    //Management view status
    private var couponObservable: CouponObservable = CouponObservable()

    fun callCoupons(){
        couponObservable.callCoupons()
    }
    fun getCoupons(): MutableLiveData<List<Coupon>> {
        return couponObservable.getCoupons()
    }
}