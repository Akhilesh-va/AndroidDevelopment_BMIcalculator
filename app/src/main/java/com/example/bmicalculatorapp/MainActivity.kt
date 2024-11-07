package com.example.bmicalculatorapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bmicalculatorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateBmiButton.setOnClickListener {
            if(binding.weightInput.text.toString().isNotEmpty() && binding.heightFeetInput.text.toString().isNotEmpty() && binding.heightInchesInput.text.toString().isNotEmpty()){
                val weight = (binding.weightInput.text.toString()).toDouble()
                val heightFeet = (binding.heightFeetInput.text.toString()).toDouble()
                val heightInches = (binding.heightInchesInput.text.toString()).toDouble()
                val totalInch = (heightFeet * 12) + heightInches;
                val heigthCm = totalInch * 2.54
                val heightMeter = heigthCm / 100
                val bmi = weight / (heightMeter * heightMeter)
                binding.title.text="Your BMI is ${bmi.toInt()}"
                when {
                    bmi>25 -> {
                        Toast.makeText(this, "OverWeight", Toast.LENGTH_SHORT).show()
                        binding.bmiStatus.text="You are OverWeight"
                        binding.background.setBackgroundResource(R.color.lightRed)


                    }
                    bmi<18 -> {
                        Toast.makeText(this, "UnderWeight", Toast.LENGTH_SHORT).show()
                        binding.bmiStatus.text="You are UnderWeight"
                        binding.background.setBackgroundResource(R.color.lightYello)
                    }
                    else -> {
                        Toast.makeText(this, "Normal", Toast.LENGTH_SHORT).show()
                        binding.bmiStatus.text="You are Normal"
                        binding.background.setBackgroundResource(R.color.lightGreen)
                    }
                }

            }else{
                Toast.makeText(this, "Fill all the Fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}