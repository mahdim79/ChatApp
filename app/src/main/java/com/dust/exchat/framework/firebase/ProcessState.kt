package com.dust.exchat.framework.firebase

sealed class ProcessState<out T> {
    class Success<T>(data: T) : ProcessState<T>()
    object Loading:ProcessState<Nothing>()
    class Failure(val message:String):ProcessState<Nothing>()
}