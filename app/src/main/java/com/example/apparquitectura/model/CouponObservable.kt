package com.example.apparquitectura.model

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData

class CouponObservable: BaseObservable() {
    // Repository network
    private var couponRepository: CouponRepository = CouponRepositoryImpl()

    fun callCoupons(){
        couponRepository.callCouponAPI()
    }
    // ViewModel network
    fun getCoupons(): MutableLiveData<List<Coupon>>{
        return couponRepository.getCoupons()
    }

}