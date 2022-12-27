package com.dust.exchat.presentation.fragment.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dust.core.model.User
import com.dust.core.usecase.GetUser
import com.dust.core.usecase.SetUser
import com.dust.exchat.framework.firebase.AuthManager
import com.dust.exchat.framework.firebase.DatabaseManager
import com.dust.exchat.framework.firebase.ProcessState
import com.dust.exchat.utils.UserContainer
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginFragmentViewModel @Inject constructor(
    private val authManager: AuthManager,
    private val databaseManager: DatabaseManager,
    private val setUser: SetUser,
    private val getUser: GetUser
) : ViewModel() {

    val signInLiveData = MutableLiveData<ProcessState<String>>()
    val signUpLiveData = MutableLiveData<ProcessState<String>>()

    fun signUp(email: String, password: String) {
        signUpLiveData.postValue(ProcessState.Loading)
        authManager.signUp(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                if (authManager.getUserId() != null) {
                    val newUser = User(
                        null,
                        authManager.getUserId()!!,
                        email,
                        "",
                        "",
                        ""
                    )

                    databaseManager.createNewUser(newUser) { e, _ ->
                        if (e == null) {
                            updateCurrentUser(newUser)
                            signUpLiveData.postValue(
                                ProcessState.Success(
                                    authManager.getUserId() ?: ""
                                )
                            )
                        } else {
                            // failure
                            signUpLiveData.postValue(ProcessState.Failure(e.message))
                        }
                    }
                } else {
                    signUpLiveData.postValue(ProcessState.Failure("Failure occurred during login process.Please try again later."))
                }

            } else {
                signUpLiveData.postValue(ProcessState.Failure(it.exception?.message.toString()))
            }
        }
    }

    private fun signOut() = authManager.logout()

    fun signIn(email: String, password: String) {
        signInLiveData.postValue(ProcessState.Loading)
        authManager.signIn(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                if (authManager.getUserId() != null) {
                    databaseManager.fetchUserData(authManager.getUserId()!!, { user ->
                        updateCurrentUser(user)
                        signInLiveData.postValue(ProcessState.Success(user.email))
                    }, { fm ->
                        signOut()
                        signInLiveData.postValue(ProcessState.Failure(fm))
                    })
                } else {
                    signInLiveData.postValue(ProcessState.Failure("Failure occurred during login process.Please try again later."))
                }

            } else {
                signInLiveData.postValue(ProcessState.Failure(it.exception?.message.toString()))
            }
        }
    }

    private fun updateCurrentUser(user: User) {
        UserContainer.updateUser(user)
        setUser.invoke(user)
    }

}