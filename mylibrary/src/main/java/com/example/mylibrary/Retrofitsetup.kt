package com.example.mylibrary

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitSetup {
    lateinit var apiService: ApiService

    // MutableLiveData to handle login status
    private  val loginStatus = MutableLiveData<String>()
    val _loginstatus :LiveData<String> = loginStatus

    init {
        retrofitBuilder()
    }

    fun retrofitBuilder() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://reqres.in")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiService = retrofit.create(ApiService::class.java)
    }

    // Coroutine-based login function
    suspend fun loginAuthentication(email: String, password: String):LiveData<String> {

            try {
                // Make the network call
                val response = apiService.login(email, password)

                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    loginResponse?.let {
                        Log.d("LoginActivity", "Token: ${it.accessToken}+${loginResponse}")
                    vIEWMODEL.settoast("SUCESS")
                    }
                } else {
                    Log.d("LoginActivity", "Token: FAIL")
                    loginStatus.postValue("Login failed: ${response.message()}")
                    vIEWMODEL.settoast("FAIL")
                }
            } catch (e: Exception) {
                Log.d("LoginActivity", "Token: ERROR :${e.message}")
                loginStatus.postValue("Error: ${e.message}")
                vIEWMODEL.settoast("ERROR")
            }
        return loginStatus
        }
    }

