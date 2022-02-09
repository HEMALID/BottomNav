package com.example.bottomnav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.bottomnav.fragment.DashboardFragment
import com.example.bottomnav.fragment.InfoFragment
import com.example.bottomnav.fragment.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val dashboardFragment=DashboardFragment()
    private val settingFragment=SettingFragment()
    private val infoFragment=InfoFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFrahment(dashboardFragment)

        var bottom_nav=findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottom_nav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.dashboard->replaceFrahment(dashboardFragment)
                R.id.setting->replaceFrahment(settingFragment)
                R.id.info->replaceFrahment(infoFragment)
            }
            true
        }
    }
    private fun replaceFrahment(fragment: Fragment){
        if (fragment !=null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.commit()
        }
    }
}