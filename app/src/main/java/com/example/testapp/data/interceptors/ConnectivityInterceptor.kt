package com.example.testapp.data.interceptors

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.example.testapp.data.exceptions.NoConnectivityException
import okhttp3.Interceptor
import okhttp3.Response

class ConnectivityInterceptor(private val context: Context) : Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        if(!isOnline(context)){
            throw NoConnectivityException("No internet connection")
        }

        val builder = chain.request().newBuilder()
        return chain.proceed(builder.build())
    }

    private fun isOnline(context: Context): Boolean{
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE)
        return if(connectivityManager is ConnectivityManager){
            val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
            networkInfo?.isConnected ?: false
        }
        else false
    }
}