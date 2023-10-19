package com.mis.route.e_commerce

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mis.route.e_commerce.ui.categories.CategoriesFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.con, CategoriesFragment()).commit()
    }
}