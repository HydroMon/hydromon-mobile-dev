package com.example.hydromon.ui.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.hydromon.*
import com.example.hydromon.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding:ActivityLoginBinding
    private lateinit var loginViewModel : LoginActivityViewModel
    private var loginAtrribute : LoginAtrribute = LoginAtrribute()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        loginViewModel = ViewModelProvider(this@LoginActivity).get(LoginActivityViewModel::class.java)

//        val emailtext : String = binding.etEmail.text.toString().trim()
//        val passwordText : String = binding.etPassword.text.toString().trim()

        val emailtext : EditText = binding.etEmail
        emailtext.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                if (p0.toString().isEmpty()) {

                }else{
                    loginAtrribute.email = p0.toString()
                }
            }
        })

        val passwordText : EditText = binding.etPassword
        passwordText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                loginAtrribute.password = p0.toString()
            }

        })

        val buttonLogin : Button = binding.btLogin
        buttonLogin.setOnClickListener{
            Log.d("login", "${loginAtrribute.email} dan ${loginAtrribute.password}")
            loginViewModel.loginRequest(loginAtrribute.email,loginAtrribute.password)
            loginViewModel.getLoginRequest().observe(this,{
                if (it.code == "200") {
                    val intent = Intent(this@LoginActivity, MainActivityOwner::class.java)
                    startActivity(intent)
                }else{

                }
            })
        }

        val daftarSekarang : TextView = binding.daftarSekarang
        daftarSekarang.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}