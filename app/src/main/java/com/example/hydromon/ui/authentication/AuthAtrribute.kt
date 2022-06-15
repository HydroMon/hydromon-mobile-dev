package com.example.hydromon.ui.authentication

data class LoginAtrribute(
    var email:String="",
    var password:String=""
)

data class RegisterAttribute(
    var username:String="",
    var email:String="",
    var password:String=""
)

data class LoginCookieAttribute(
    var role:Int=-1,
    var token:String=""
)
