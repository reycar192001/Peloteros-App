package com.innovacion.peloterosapp.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.innovacion.peloterosapp.view.LoginTabFragment
import com.innovacion.peloterosapp.view.SignupTabFragment

class LoginAdapter(fm: FragmentManager, private val context: Context, private val totalTabs: Int) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int {
        return totalTabs
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> LoginTabFragment() // Retorna el fragmento de login
            1 -> SignupTabFragment() // Retorna el fragmento de registro
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }
}

