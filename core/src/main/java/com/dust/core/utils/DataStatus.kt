package com.dust.core.utils

sealed class DataStatus<out T>{
    class Success<T>(dat:T):DataStatus<T>()
    object Loading:DataStatus<Nothing>()
    class Error(val message:String):DataStatus<Nothing>()
}
