package com.dust.exchat.framework.firebase

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthProvider
import javax.inject.Inject

class AuthManager @Inject constructor() {
    private val firebaseAuth = FirebaseAuth.getInstance()

    fun signIn(email:String,password:String):Task<AuthResult> = firebaseAuth.signInWithEmailAndPassword(email,password)

    fun signUp(email:String,password:String):Task<AuthResult> = firebaseAuth.createUserWithEmailAndPassword(email,password)

    fun logout() = firebaseAuth.signOut()

    fun isUserLoggedIn():Boolean = firebaseAuth.currentUser != null

    fun getUserId():String? = firebaseAuth.uid

}