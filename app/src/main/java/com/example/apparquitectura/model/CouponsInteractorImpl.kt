package com.example.apparquitectura.model

import com.example.apparquitectura.presenter.CouponPresenter

class CouponsInteractorImpl(private val couponPresenter: CouponPresenter) : CouponsInteractor {

    private var couponRepository: CouponRepository = CouponRepositoryImpl(couponPresenter)

    override fun getCouponsAPI() {
        couponRepository.getCouponAPI()
    }
}