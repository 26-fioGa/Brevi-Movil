package com.miempresa.brevi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_app.*

class App : AppCompatActivity() {

    private val locationsFragment = Locations()
    private val mapsFragment = Map()
    private val routesFragment = Routes()
    private val profileFragment = Profile()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)
        replaceFragment(mapsFragment)

        bottom_navigation.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.locations -> replaceFragment(locationsFragment)
                R.id.map -> replaceFragment(mapsFragment)
                R.id.routes -> replaceFragment(routesFragment)
                R.id.profile -> replaceFragment(profileFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        if (fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }
}