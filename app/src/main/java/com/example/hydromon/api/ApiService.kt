package com.example.hydromon.api

import com.google.gson.annotations.SerializedName
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

data class RegisterResponse(
    @field:SerializedName("code")
    val code: Int,

    @field:SerializedName("status")
    val status: String,
)

data class DataUser(
    @field:SerializedName("createdAt")
    val createdAt: String,

    @field:SerializedName("password")
    val password: String,

    @field:SerializedName("role")
    val role: String,

    @field:SerializedName("nama_lengkap")
    val namaLengkap: String,

    @field:SerializedName("telepon")
    val telepon: String,

    @field:SerializedName("_id")
    val id: String,

    @field:SerializedName("email")
    val email: String,

    @field:SerializedName("username")
    val username: String,

    @field:SerializedName("updatedAt")
    val updatedAt: String
)

data class LoginResponse(
    @field:SerializedName("code")
    val code: String,

    @field:SerializedName("status")
    val status: String,

    @field:SerializedName("token")
    val token: String,

    @field:SerializedName("data")
    val data: DataLogin?
)

data class DataLogin(
    @field:SerializedName("role")
    val role: Int?=null,
)

data class Response(

    @field:SerializedName("protocol")
    val protocol: String? = null,

    @field:SerializedName("code")
    val code: String? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("url")
    val url: String? = null
)

interface ApiService {

    @POST("auth/register")
    fun register(
        @Body requestBody: RequestBody
        ): Call<RegisterResponse>

    @POST("auth/login")
    fun login(
        @Body requestBody: RequestBody
    ) : Call<LoginResponse>
}