package com.dust.exchat.framework.firebase

import com.dust.core.model.User
import com.dust.exchat.framework.firebase.mapper.UserHashMapper
import com.dust.exchat.framework.firebase.model.UserDbModel
import com.google.firebase.database.*
import javax.inject.Inject

class DatabaseManager @Inject constructor(private val userHashMapper: UserHashMapper){
    private val firebaseDatabase = FirebaseDatabase.getInstance()
    private val rootReference = firebaseDatabase.reference
    private val userReference = rootReference.child(USER_CHILD)
    private val avatarReference = rootReference.child(PROFILE_PIC_CHILD)

    fun createNewUser(user: User,onCompletionListener: DatabaseReference.CompletionListener) {
        userReference.setValue(userHashMapper.userToHashmap(user),onCompletionListener)
    }

    fun fetchUserData(userId:String,onUserFetched:(User) -> Unit,onError:(String) -> Unit){
        userReference.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val currentUser = snapshot.getValue(UserDbModel::class.java)
                currentUser?.let {
                    if (currentUser.uid == userId)
                        onUserFetched(userHashMapper.dbModelToUser(currentUser))
                }
            }

            override fun onCancelled(error: DatabaseError) {
                onError(error.message)
            }

        })
    }

    companion object {
        const val PROFILE_PIC_CHILD = "avatar"
        const val USER_CHILD = "users"
    }
}