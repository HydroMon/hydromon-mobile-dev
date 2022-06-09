package com.example.hydromon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.hydromon.databinding.ActivityChooseRoleBinding

class ChooseRoleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChooseRoleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val signUpHydroponics : Button = binding.hydroponics
        val trackOwnerHydroponics : Button = binding.viewer

        signUpHydroponics.setOnClickListener{
            val intent = Intent(this@ChooseRoleActivity, SignUpHydroponicsActivity::class.java)
            startActivity(intent)
        }

        trackOwnerHydroponics.setOnClickListener{
//            val intent = Intent(this@ChooseRoleActivity, )
        }
    }
}