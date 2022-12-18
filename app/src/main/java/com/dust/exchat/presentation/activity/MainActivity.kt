package com.dust.exchat.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.dust.exchat.R
import com.dust.exchat.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val mainViewModel by viewModels<MainViewModel>()

    private lateinit var mbinding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mbinding = ActivityMainBinding.inflate(layoutInflater)
    }
}