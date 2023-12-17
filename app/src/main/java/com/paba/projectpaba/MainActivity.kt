package com.paba.projectpaba

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class MainActivity : AppCompatActivity() {

    companion object {
        val videoArrayList: ArrayList<Video> = arrayListOf()
        @SuppressLint("StaticFieldLeak")
        val db = Firebase.firestore
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val _bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        _bottomNavigationView.setupWithNavController(navController)
    }
}