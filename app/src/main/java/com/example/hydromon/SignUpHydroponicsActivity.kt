package com.example.hydromon

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.example.hydromon.databinding.ActivitySignUpHydroponicsBinding

class SignUpHydroponicsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpHydroponicsBinding
    companion object{
        private var locationMapText = ""
        private var kodeHydroponicText = ""
        private var namaHydroponicText = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpHydroponicsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val locationMap : EditText = binding.locationMap
        locationMap.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                locationMapText = p0.toString()
            }
        })

        val kodeHydroponic : EditText = binding.inputEditTextHc
        kodeHydroponic.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                kodeHydroponicText = p0.toString()
            }
        })

        val namaHydroponic : EditText = binding.inputEditTextHn
        namaHydroponic.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                namaHydroponicText = p0.toString()
            }
        })

        val backButton : ImageView = binding.backButton
        backButton.setOnClickListener{
            finish()
        }

        val signUpButton : Button = binding.signUpButton
        signUpButton.setOnClickListener{
            Log.d("input hydroponics attribute", "${namaHydroponicText} dan ${kodeHydroponicText} dan ${locationMapText}")
        }
    }
}