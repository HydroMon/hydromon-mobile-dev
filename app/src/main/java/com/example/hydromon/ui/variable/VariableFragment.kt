package com.example.hydromon.ui.variable

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.hydromon.VariableValue
import com.example.hydromon.databinding.FragmentVariableBinding
import java.util.*
import kotlin.concurrent.schedule

class VariableFragment : Fragment() {

    private var _binding: FragmentVariableBinding? = null

    private val binding get() = _binding!!
    private lateinit var variableValue:VariableValue

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val notificationsViewModel = ViewModelProvider(this).get(VariableViewModel::class.java)

        _binding = FragmentVariableBinding.inflate(inflater, container, false)
        val root: View = binding.root
        variableValue = loadVariable()

        Log.d("fragment created", "${variableValue}")

        val tdsValueScreen: TextView = binding.tdsValue
        val tdsPlusButton : ImageView = binding.tdsPlusButton
        var tdsValue = variableValue.tds
        val tdsMinusButton : ImageView = binding.tdsMinusButton

        tdsValueScreen.text = tdsValue.toString()
        tdsPlusButton.setOnClickListener{
            tdsPlusButton.setBackgroundColor(Color.GREEN)
            tdsValue = tdsValue + 1
            variableValue.tds++
            tdsValueScreen.text = tdsValue.toString()
            Handler().postDelayed({
                tdsPlusButton.setBackgroundColor(0x00000000)
            }, 100)
        }

        tdsMinusButton.setOnClickListener{
            tdsMinusButton.setBackgroundColor(Color.RED)
            tdsValue--
            tdsValueScreen.text = tdsValue.toString()
            variableValue.tds--
            Handler().postDelayed({
                tdsMinusButton.setBackgroundColor(0x00000000)
            }, 100)
        }

        val phValueScreen: TextView = binding.phValue
        val phPlusButton : ImageView = binding.phPlusButton
        var phValue = variableValue.ph
        val phMinusButton : ImageView = binding.phMinusButton

        phValueScreen.text = phValue.toString()
        phPlusButton.setOnClickListener{
            phPlusButton.setBackgroundColor(Color.GREEN)
            phValue++
            phValueScreen.text = phValue.toString()
            variableValue.ph++
            Handler().postDelayed({
                phPlusButton.setBackgroundColor(0x00000000)
            }, 100)
        }

        phMinusButton.setOnClickListener{
            phMinusButton.setBackgroundColor(Color.RED)
            phValue--
            phValueScreen.text = phValue.toString()
            variableValue.ph--
            Handler().postDelayed({
                phMinusButton.setBackgroundColor(0x00000000)
            }, 100)
        }

        val ecValueScreen: TextView = binding.ecValue
        val ecPlusButton : ImageView = binding.ecPlusButton
        var ecValue = variableValue.ec
        val ecMinusButton : ImageView = binding.ecMinusButton

        ecValueScreen.text = ecValue.toString()
        ecPlusButton.setOnClickListener{
            ecPlusButton.setBackgroundColor(Color.GREEN)
            ecValue++
            ecValueScreen.text = ecValue.toString()
            variableValue.ec++
            Handler().postDelayed({
                ecPlusButton.setBackgroundColor(0x00000000)
            }, 100)
        }

        ecMinusButton.setOnClickListener{
            ecMinusButton.setBackgroundColor(Color.RED)
            ecValue--
            ecValueScreen.text = ecValue.toString()
            variableValue.ec--
            Handler().postDelayed({
                ecMinusButton.setBackgroundColor(0x00000000)
            }, 100)
        }

        val humidityValueScreen: TextView = binding.humidityValue
        val humidityPlusButton : ImageView = binding.humidityPlusButton
        var humidityValue = variableValue.humidity
        val humidityMinusButton : ImageView = binding.humidityMinusButton

        humidityValueScreen.text = humidityValue.toString()
        humidityPlusButton.setOnClickListener{
            humidityPlusButton.setBackgroundColor(Color.GREEN)
            humidityValue++
            humidityValueScreen.text = humidityValue.toString()
            Handler().postDelayed({
                humidityPlusButton.setBackgroundColor(0x00000000)
            }, 100)
        }

        humidityMinusButton.setOnClickListener{
            humidityMinusButton.setBackgroundColor(Color.RED)
            humidityValue--
            humidityValueScreen.text = humidityValue.toString()
            Handler().postDelayed({
                humidityMinusButton.setBackgroundColor(0x00000000)
            }, 100)
        }

        val temperatureValueScreen: TextView = binding.temperatureValue
        val temperaturePlusButton : ImageView = binding.temperaturePlusButton
        var temperatureValue = variableValue.temperature
        val temperatureMinusButton : ImageView = binding.temperatureMinusButton

        temperatureValueScreen.text = temperatureValue.toString()
        temperaturePlusButton.setOnClickListener{
            temperaturePlusButton.setBackgroundColor(Color.GREEN)
            temperatureValue++
            temperatureValueScreen.text = temperatureValue.toString()
            variableValue.temperature++
            Handler().postDelayed({
                temperaturePlusButton.setBackgroundColor(0x00000000)
            }, 100)
        }

        temperatureMinusButton.setOnClickListener{
            temperatureMinusButton.setBackgroundColor(Color.RED)
            temperatureValue--
            temperatureValueScreen.text = temperatureValue.toString()
            variableValue.temperature--
            Handler().postDelayed({
                temperatureMinusButton.setBackgroundColor(0x00000000)
            }, 100)
        }

        val lightIntensityValueScreen: TextView = binding.lightIntensityValue
        val lightIntensityPlusButton : ImageView = binding.lightIntensityPlusButton
        var lightIntensityValue = variableValue.light_intensity
        val lightIntensityMinusButton : ImageView = binding.lightIntensityMinusButton

        lightIntensityValueScreen.text = lightIntensityValue.toString()
        lightIntensityPlusButton.setOnClickListener{
            lightIntensityPlusButton.setBackgroundColor(Color.GREEN)
            lightIntensityValue++
            lightIntensityValueScreen.text = lightIntensityValue.toString()
            variableValue.light_intensity++
            Handler().postDelayed({
                lightIntensityPlusButton.setBackgroundColor(0x00000000)
            }, 100)
        }

        lightIntensityMinusButton.setOnClickListener{
            lightIntensityMinusButton.setBackgroundColor(Color.RED)
            lightIntensityValue--
            lightIntensityValueScreen.text = lightIntensityValue.toString()
            variableValue.light_intensity--
            Handler().postDelayed({
                lightIntensityMinusButton.setBackgroundColor(0x00000000)
            }, 100)
        }

        val saveButton : Button = binding.saveButton

        saveButton.setOnClickListener{
            saveData(variableValue)
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun saveData(variableValue: VariableValue) {
        val preference = context?.getSharedPreferences("save_variable", Context.MODE_PRIVATE)

        val prefSave = preference?.edit()
        prefSave?.apply {
            putInt("TDS_VALUE", variableValue.tds)
            putInt("PH_VALUE", variableValue.ph)
            putInt("EC_VALUE", variableValue.ec)
            putInt("HUMIDITY_VALUE", variableValue.humidity)
            putInt("TEMPERATURE_VALUE", variableValue.temperature)
            putInt("LIGHT_INTENSITY_VALUE", variableValue.light_intensity)
        }?.apply()

        Log.d("berhasil SAVE", "${variableValue}")
//        val mIntent = intent
//        finish()
//        startActivity(intent)
    }

    private fun loadVariable():VariableValue{
        val preference : SharedPreferences = requireContext().getSharedPreferences("save_variable", Context.MODE_PRIVATE)

        val variableValue = VariableValue()
        variableValue.tds = preference.getInt("TDS_VALUE", 23)
        variableValue.ph = preference.getInt("PH_VALUE", 23)
        variableValue.ec = preference.getInt("EC_VALUE",23)
        variableValue.humidity = preference.getInt("HUMIDITY_VALUE",22)
        variableValue.temperature = preference.getInt("TEMPERATURE_VALUE",23)
        variableValue.light_intensity = preference.getInt("LIGHT_INTENSITY_VALUE",23)
        return variableValue
    }


}