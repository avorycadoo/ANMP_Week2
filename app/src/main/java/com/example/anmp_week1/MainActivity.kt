package com.example.anmp_week1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.anmp_week1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private  lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = (supportFragmentManager.findFragmentById(R.id.navHost)
                as NavHostFragment).navController
        NavigationUI.setupActionBarWithNavController(this, navController,
            binding.drawerlayout)

        NavigationUI.setupWithNavController(binding.navView, navController) //yang sembunyi tadi

        binding.bottomNav.setupWithNavController(navController)
    }
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, binding.drawerlayout)
                || super.onSupportNavigateUp()
    }

}