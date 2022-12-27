package com.dust.exchat

import android.app.Application
import com.dust.core.usecase.GetUser
import com.dust.exchat.utils.UserContainer
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App:Application() {
    @Inject
    lateinit var getUser: GetUser

    override fun onCreate() {
        super.onCreate()
        initUserContainer()
    }

    private fun initUserContainer() {
        UserContainer.updateUser(getUser())
    }
}