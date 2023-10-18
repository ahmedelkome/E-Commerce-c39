package com.mis.route.e_commerce.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mis.route.e_commerce.R
import com.mis.route.e_commerce.ui.activities.home.HomeActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // TODO: to be replaced later
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}