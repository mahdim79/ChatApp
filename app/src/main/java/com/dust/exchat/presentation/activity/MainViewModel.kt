package com.dust.exchat.presentation.activity

import androidx.lifecycle.ViewModel
import com.dust.core.usecase.SetUser
import com.dust.exchat.framework.firebase.AuthManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val setUser: SetUser,private val authManager: AuthManager):ViewModel() {

    fun checkUserLoggedIn() = authManager.isUserLoggedIn()
}