package com.innovacion.peloterosapp.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager.widget.ViewPager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.innovacion.peloterosapp.R
import com.innovacion.peloterosapp.adapter.LoginAdapter

class LoginActivity : AppCompatActivity() {
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager
    private lateinit var fb: FloatingActionButton
    private lateinit var google: FloatingActionButton
    private lateinit var twitter: FloatingActionButton
    private var v: Float = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Inicializar vistas
        tabLayout = findViewById(R.id.tab_layout)
        viewPager = findViewById(R.id.view_pager)
        fb = findViewById(R.id.fab_fb)
        google = findViewById(R.id.fab_google)
        twitter = findViewById(R.id.fab_twitter)

        // Configurar TabLayout
        tabLayout.addTab(tabLayout.newTab().setText("Login"))
        tabLayout.addTab(tabLayout.newTab().setText("Registrate"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        // Configurar ViewPager con Adapter
        val adapter = LoginAdapter(supportFragmentManager, this, tabLayout.tabCount)
        viewPager.adapter = adapter

        // Sincronizar ViewPager con TabLayout
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        // Sincronizar el clic en las pestañas
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                // Cambiar la vista del ViewPager cuando se haga clic en una pestaña
                viewPager.currentItem = tab?.position ?: 0
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        // Animación de los FloatingActionButtons y TabLayout
        fb.translationY = 300f
        google.translationY = 300f
        twitter.translationY = 300f
        tabLayout.translationY = 300f

        fb.alpha = v
        google.alpha = v
        twitter.alpha = v
        tabLayout.alpha = v

        fb.animate().translationY(0f).alpha(1f).setDuration(1000).setStartDelay(400).start()
        google.animate().translationY(0f).alpha(1f).setDuration(1000).setStartDelay(600).start()
        twitter.animate().translationY(0f).alpha(1f).setDuration(1000).setStartDelay(800).start()
        tabLayout.animate().translationY(0f).alpha(1f).setDuration(1000).setStartDelay(100).start()
    }
}