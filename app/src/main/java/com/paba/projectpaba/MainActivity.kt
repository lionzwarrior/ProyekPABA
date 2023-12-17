package com.paba.projectpaba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    companion object {
        val videoArrayList: ArrayList<Video> = arrayListOf()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.nav_fragment)
        val _bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        _bottomNavigationView.setupWithNavController(navController)
    }
}