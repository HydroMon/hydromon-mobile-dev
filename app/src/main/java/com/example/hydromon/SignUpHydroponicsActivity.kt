package com.example.hydromon

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.hydromon.databinding.ActivitySignUpHydroponicsBinding

class SignUpHydroponicsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpHydroponicsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpHydroponicsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val backButton : ImageView = binding.backButton
        backButton.setOnClickListener{
            finish()
        }
    }
}