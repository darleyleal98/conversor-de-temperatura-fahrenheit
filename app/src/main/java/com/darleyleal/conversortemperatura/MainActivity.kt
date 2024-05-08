package com.darleyleal.conversortemperatura

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.darleyleal.conversortemperatura.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonConverter.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val temperatura = binding.editText.text.toString()
        if (view.id == R.id.button_converter) {
            binding.textResultado.text = converterParaCelcius(temperatura.toFloat()).toString()
        }
    }

    private fun converterParaCelcius(temperatura: Float): Float {
        return (temperatura * 1.8F) + 32
    }
}