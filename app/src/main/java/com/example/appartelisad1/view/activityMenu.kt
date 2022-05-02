package com.example.appartelisad1.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.appartelisad1.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.Navigation.findNavController
import com.example.appartelisad1.databinding.ActivityMenuBinding
import com.example.appartelisad1.databinding.ActivitySplashScreenBinding

class activityMenu : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //-------------------------
        binding = ActivityMenuBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        //-------------------------
        val menuArteLista:BottomNavigationView = findViewById(R.id.buttonNavMenu)
        setupWithNavController(menuArteLista, findNavController(this, R.id.frag_nav_graph))
    }
}