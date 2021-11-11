package com.example.loancalculator2

import android.os.Bundle
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.loancalculator2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        val editTextPrice : EditText = findViewById(R.id.editTextPrice)
//        val buttonCalculate: Button = findViewById(R.id.buttonCalculate)

        binding.buttonCalculate.setOnClickListener{
            //TODO : Get input from user and calculate the monthly payment
            val price : Int = Integer.parseInt(binding.editTextNumberPrice.text.toString())
            val down_payment  : Int = Integer.parseInt(binding.editTextNumberDownPayment.text.toString())
            val interest_rate : Double =  binding.editTextNumberDecimalInterestRate.text.toString().toDouble()
            val year : Int =  binding.spinner.selectedItemPosition+3
//            var year : Int = 0
//            when (index){ // when =switch
//                    0 -> {year=3}
//            }
            val car_loan : Int =price -down_payment
            val interest : Double  = car_loan* interest_rate * year
            val monthly_payment : Double = (car_loan + interest)/year/12

            val payment_per_month: TextView = findViewById(R.id.textViewPayment)
            payment_per_month.setText("$monthly_payment")
        }
        binding.buttonReset.setOnClickListener{
            //TODO : Reset All Views and outputs
            val editTextNumberPrice : EditText =findViewById(R.id.editTextNumberPrice)
            val editTextNumberDownPayment : EditText =findViewById(R.id.editTextNumberDownPayment)
            val editTextNumberDecimalInterestRate : EditText =findViewById(R.id.editTextNumberDecimalInterestRate)
            val spinner : Spinner =findViewById(R.id.spinner)
            val payment_per_month: TextView = findViewById(R.id.textViewPayment)
            editTextNumberPrice.text.clear()
            editTextNumberDownPayment.text.clear()
            editTextNumberDecimalInterestRate.text.clear()
            spinner.setSelection(0)
            payment_per_month.setText(null)
        }
    }

}