package com.example.apparquitectura.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CouponRepositoryImpl: CouponRepository {
    // MutableLiveData refresh changes automatically
    private var coupons = MutableLiveData<List<Coupon>>()
    //Implement all business logic
    override fun callCouponAPI() {

        // Call to API - Controller
        var couponsList: ArrayList<Coupon>? =ArrayList<Coupon>()
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
                    couponsList?.add(coupon)
                }
                coupons.value = couponsList
            }
        })

    }

    override fun getCoupons(): MutableLiveData<List<Coupon>> {
        return  coupons
    }
}