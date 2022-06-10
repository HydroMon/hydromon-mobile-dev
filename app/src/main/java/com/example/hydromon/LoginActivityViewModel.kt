package com.example.hydromon

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivityViewModel: ViewModel() {

    private val loginResponse = MutableLiveData<LoginResponse>()

    fun loginRequest(email: String, password: String) {
//        Log.d("empw","${email}, ${password}")
        val jsonObject = JSONObject()
        jsonObject.put("email", email)
        jsonObject.put("password", password)

        val jsonObjectString = jsonObject.toString()
        val requestBody = jsonObjectString.toRequestBody("application/json".toMediaTypeOrNull())
        val loginRequest = ApiConfig.getApiService().login(requestBody)
        loginRequest.enqueue(object : Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                Log.d("isi", "${response}")
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    if (responseBody != null) {
                        Log.d("response login berhasil", "${responseBody}")
                        loginResponse.postValue(responseBody)
                    }
                }else{
                    Log.d("response login gagal", "${response.message()}")
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.e("api gagal", "${t.message}")
            }
        })
    }

    fun getLoginRequest(): LiveData<LoginResponse>{
        return loginResponse
    }
}