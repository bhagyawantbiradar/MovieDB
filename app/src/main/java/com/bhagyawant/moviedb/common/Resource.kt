package com.bhagyawant.moviedb.common

sealed class Resource<T>(val data: T? = null, val message : String? = ""){
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(data: T? = null, message: String?) : Resource<T>(data,message)
    class StartLoading<T>(data: T? = null) : Resource<T>(data)
    class StopLoading<T>(data: T? = null) : Resource<T>(data)
}