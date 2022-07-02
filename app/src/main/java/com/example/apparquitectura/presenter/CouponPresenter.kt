package com.example.apparquitectura.presenter

import com.example.apparquitectura.model.Coupon

interface CouponPresenter {
    // Interactor
    fun getCoupons()
    // function returning a coupons list
    fun showCoupons(coupons: ArrayList<Coupon>?)
}