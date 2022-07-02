package com.example.apparquitectura.model

import android.util.Log
import com.example.apparquitectura.R
import com.example.apparquitectura.presenter.CouponPresenter
import com.example.apparquitectura.view.RecyclerCouponsAdapter
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CouponRepositoryImpl(private val couponPresenter: CouponPresenter): CouponRepository {


    //Implement all business logic
    override fun getCouponAPI() {

        // Call to API - Controller
        var coupons: ArrayList<Coupon>? =ArrayList<Coupon>()
        val apiAdapter = ApiAdapter()
        val apiService = apiAdapter.getClientService()
        val call = apiService.getCoupons()

        call.enqueue(object : Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.e("ERROR: ", t.message!!)
                t.stackTrace
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val offersJsonArray = response.body()?.getAsJsonArray("offers")
                offersJsonArray?.forEach { jsonElement: JsonElement ->
                    val jsonObject = jsonElement.asJsonObject
                    val coupon = Coupon(jsonObject)
                    coupons?.add(coupon)
                }
                couponPresenter.showCoupons(coupons)
            }
        })

    }
}