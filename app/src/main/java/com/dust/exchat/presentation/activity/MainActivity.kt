package com.dust.exchat.presentation.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.dust.exchat.R
import com.dust.exchat.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val mViewModel by viewModels<MainViewModel>()
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        initNavController()
        showSplashScreen()

    }

    private fun initNavController() {
        navController =
            (supportFragmentManager.findFragmentById(R.id.fcv_main_host) as NavHostFragment).navController
    }

    private fun showSplashScreen() {
        navController.setGraph(R.navigation.nav_splash)
        lifecycleScope.launch(Dispatchers.IO) {
            delay(2000)
            withContext(Dispatchers.Main) {
                if (mViewModel.checkUserLoggedIn())
                    navController.setGraph(R.navigation.nav_main)
                else
                    navController.setGraph(R.navigation.nav_login_signup)
            }
        }
    }
}