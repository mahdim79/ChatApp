package com.dust.exchat.presentation.activity

import androidx.lifecycle.ViewModel
import com.dust.core.usecase.SetUser
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val setUser: SetUser):ViewModel() {
}