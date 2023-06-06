package com.example.recifefit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.recifefit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerButton.setOnClickListener {
            val intentsegundatela = Intent(this, Segundatela::class.java)
            startActivity(intentsegundatela)
        }
        /**
        val lognome = binding.emailEditText
        val login = binding.passwordEditText
        binding.loginButton.setOnClickListener{
        if(lognome.text.toString()=="Arthur" && login.text.toString()=="1234")
        val inten: Intent = Intent(this, Segundatela::class.java)
        val texto = lognome.text.toString()
        inten.putExtra("nome", texto)
        startActivity(inten)
        }*/
        val lognome = binding.emailEditText
        val login = binding.passwordEditText
        login.setOnClickListener {
            if (lognome.text.toString() == "Arthur" && login.text.toString() == "1234") {
                val inten = Intent(this, CadastroMovimento::class.java)
                val texto = lognome.text.toString()
                inten.putExtra("nome", texto)
                startActivity(inten)
            } else {
                Toast.makeText(this, R.string.msgError, Toast.LENGTH_SHORT).show()
            }

        }
    }
}
