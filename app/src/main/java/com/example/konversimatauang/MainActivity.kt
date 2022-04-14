package com.example.konversimatauang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.konversimatauang.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var  binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.convertButton.setOnClickListener()
        {
            convert()
        }
    }

    fun convert()
    {
        val stringInTextField = binding.plainTextInputEditText.text.toString()
        val cost = stringInTextField.toDoubleOrNull()
        val selectedId = binding.convertOptions.checkedRadioButtonId
        val convertPrecentage = when (selectedId)
        {
            R.id.euro -> 15620.81
            R.id.usdollar -> 14366.00
            R.id.japaneseyen -> 114.51
            else -> 03831.34
        }
        
        var Result = convertPrecentage * cost!!
        val formattedConvert = NumberFormat.getCurrencyInstance().format(Result)
        binding.result.text = getString(R.string.convert_result, formattedConvert)
    }
}