package com.iamkurtgoz.bottomnavigationexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var navigationMenu: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigationMenu = findViewById(R.id.navigation)
        navigationMenu.setOnNavigationItemSelectedListener(this)

        //Açılışta ana ekrana getiriyoruz
        setTitle(getString(R.string.home))
        replaceFragment(HomeFragment())
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        navigationMenu.menu.findItem(item.itemId).isChecked = true //Menüde seçilen itemi belirtiyoruz
        when(item.itemId){
            R.id.home -> {
                setTitle(getString(R.string.home))
                replaceFragment(HomeFragment())
            }
            R.id.search -> {
                setTitle(getString(R.string.search))
                replaceFragment(SearchFragment())
            }
            R.id.share -> {
                setTitle(getString(R.string.share))
                replaceFragment(ShareFragment())
            }
            R.id.notifications -> {
                setTitle(getString(R.string.notifications))
                replaceFragment(NotificationFragment())
            }
            R.id.profile -> {
                setTitle(getString(R.string.profile))
                replaceFragment(ProfileFragment())
            }
        }
        return false
    }

    private fun setTitle(title: String){ //Seçilen itemin başlığını yazdırıyoruz
        val actionBar: ActionBar? = supportActionBar
        actionBar?.title = title
    }

    private fun replaceFragment(fragment: Fragment){ //Fragmenti ekliyoruz
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }
}
