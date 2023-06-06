package com.example.recifefit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recifefit.databinding.ActivityHomeBinding


class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nomePassado = binding.nomeDesgraca
        val recebernome = intent.getStringExtra("nome")

        nomePassado.text= recebernome


    }

}