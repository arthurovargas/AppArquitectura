package com.example.apparquitectura.model

import androidx.databinding.BaseObservable

class CouponObservable: BaseObservable() {
    // Repository network
    private var couponRepository: CouponRepository = CouponRepositoryImpl()

    fun callCoupons(){
        couponRepository.callCouponAPI()
    }
    // ViewModel network

}