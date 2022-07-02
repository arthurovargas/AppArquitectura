package com.example.apparquitectura.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apparquitectura.R

class MainActivity : AppCompatActivity() {

    private var rvCoupons: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        //Generate list of coupon offers - View
        rvCoupons = findViewById(R.id.rvCoupons)
        rvCoupons?.layoutManager = LinearLayoutManager(this)
    }
}