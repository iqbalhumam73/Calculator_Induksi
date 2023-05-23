package com.mandiri.calculator_induksi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.mandiri.calculator_induksi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), FragmentInteraction {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }

    override fun tvOperationChange(newOperationValue: String) {
        Log.d("Masuk ke sini", "angka berubah")
        binding.tvOperation.setText(newOperationValue)
    }

    override fun tvResultChange(result: String) {
        binding.tvResult.setText(result)
    }

    override fun getTvOperation(): String {
        return binding.tvOperation.text.toString()
    }

    override fun getResult(): String {
        return binding.tvResult.text.toString()
    }

}