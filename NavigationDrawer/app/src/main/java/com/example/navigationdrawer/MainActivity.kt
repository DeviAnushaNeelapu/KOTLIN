package com.example.navigationdrawer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.MenuItem



import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var toolbar : Toolbar
    lateinit var navigationView:NavigationView
    lateinit var drawerlayout : DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        navigationView = findViewById(R.id.navigation_view)
        drawerlayout = findViewById(R.id.drawerlayout)
        val toggle = ActionBarDrawerToggle(this, drawerlayout, toolbar
            ,0,0)
        drawerlayout.addDrawerListener(toggle)
        toggle.syncState()

        navigationView.setNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val fm : FragmentManager = supportFragmentManager
        val ft : FragmentTransaction = fm.beginTransaction()
        var fragment = RedFragment()
        when(item.itemId)
        {
            R.id.walk -> {
                fragment = RedFragment()
            }
            R.id.edit -> {

            }
        }
        ft.replace(R.id.contentspace,fragment)
        ft.commit()
        drawerlayout.closeDrawer(GravityCompat.START)
        return true
    }

   }