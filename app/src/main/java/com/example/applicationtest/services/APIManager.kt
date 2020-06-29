package com.example.applicationtest.services

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.example.applicationtest.utilities.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class APIManager  {
    var retrofit : Retrofit

    init{
        val httpClient = OkHttpClient.Builder()


        var logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        httpClient.addInterceptor(logging)

        /*httpClient.addInterceptor { chain ->
            val original = chain.request()
            var requestBuilder = original.newBuilder()
            if (UserManager.instance.getJwt() != null) {
                requestBuilder = requestBuilder.header("Authorization", "Bearer " + UserManager.instance.getJwt())
            }
            val request = requestBuilder.build()

            var response = chain.proceed(request)

            when (response.code()) {
                200 -> -1
                401 -> setError(context, R.string.error_401)
                403 -> setError(context, R.string.error_403)
                404 -> setError(context, R.string.error_404)
                500 -> setError(context, R.string.error_500)
                504 -> setError(context, R.string.error_504)
                else -> setError(context, R.string.error_unknown)
            }
            response
        }*/

        val client = httpClient.build()
        retrofit = Retrofit.Builder()
            .baseUrl(Constants.ApiUrl)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: APIManager? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: APIManager().also { instance = it }
            }
    }

    private fun setError(context : Context, error : Int)
    {
        Thread(Runnable {
            val handler = Handler(Looper.getMainLooper())
            handler.post { Toast.makeText(context, error, Toast.LENGTH_LONG).show() }
        }).start()
    }
}