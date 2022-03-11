package com.example.fitnessapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.fitnessapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main)
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)

        replaceFragment(HomeFragment())

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            Log.i("main", "id selected " + menuItem.itemId  )
            when(menuItem.itemId) {
                R.id.bottom_nav_home -> {
                    Log.d("main","switching to home")
                    replaceFragment(HomeFragment())
                    return@setOnItemSelectedListener true
                }
                R.id.bottom_nav_activities -> {
                    Log.d("main","switching to activities")
                    replaceFragment(ActivityFragment())
                    return@setOnItemSelectedListener true
                }
                R.id.bottom_nav_social -> {
                    Log.d("main","switching to social")
                    replaceFragment(SocialFragment())
                    return@setOnItemSelectedListener true
                }
                R.id.bottom_nav_leaderboard -> {
                    Log.d("main","switching to leader")
                    replaceFragment(LeaderBoardFragment())
                    return@setOnItemSelectedListener true
                }
                R.id.bottom_nav_shop -> {
                    Log.d("main","switching to shop")
                    replaceFragment(ShopFragment())
                    return@setOnItemSelectedListener true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout,fragment)
        transaction.commit()
    }
}