package com.dust.exchat.presentation.fragment.home

import androidx.lifecycle.ViewModel
import com.dust.exchat.framework.firebase.AuthManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(private val authManager: AuthManager):ViewModel() {
    fun logout() = authManager.logout()
}