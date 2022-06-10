package com.example.hydromon.ui.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.hydromon.MainActivityOwner
import com.example.hydromon.R
import com.example.hydromon.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btRegister : Button = binding.btRegister
        btRegister.setOnClickListener{
            val intent = Intent(this@RegisterActivity, MainActivityOwner::class.java)
            startActivity(intent)
        }
    }
}