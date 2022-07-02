package com.example.apparquitectura.view

import com.example.apparquitectura.model.Coupon

interface CouponView {
    // Presenter
    fun getCoupons()
    //function returning a coupons list
    fun showCoupons(coupons: ArrayList<Coupon>?)
}