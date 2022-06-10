package com.example.hydromon

import com.google.gson.annotations.SerializedName
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

data class RegisterResponse(
    @field:SerializedName("code")
    val code: String,

    @field:SerializedName("status")
    val status: String,

    @field:SerializedName("data")
    val data: List<DataUser>
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
    val token: String
)

interface ApiService {

    @POST("auth/register")
    fun register(
        @Field("username")username:String,
        @Field("email")email:String,
        @Field("password")password:String,
        @Field("number")number:Boolean,
        ): Call<RegisterResponse>

    @POST("auth/login")
    fun login(
        @Body requestBody: RequestBody
    ) : Call<LoginResponse>
}