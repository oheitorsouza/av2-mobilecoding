package com.example.recifefit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.recifefit.databinding.ActivityCadastroMovimentoBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CadastroMovimento : AppCompatActivity() {
    private lateinit var binding: ActivityCadastroMovimentoBinding
    private lateinit var dbRef:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroMovimentoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var recNome = binding.recNome
        var recLocal = binding.recLocal
        var recHora = binding.recHora
        var cadbutton = binding.cadbutton

        dbRef = FirebaseDatabase.getInstance().getReference("Empregador")


        cadbutton.setOnClickListener{
            val movNome = recNome.text.toString()
            val movLocal = recLocal.text.toString()
            val movHora = recHora.text.toString()

            if(movNome.isEmpty()){
                recNome.error = "Por favor insira um nome"
            }
            if(movLocal.isEmpty()){
                recLocal.error = "Por favor insira um Cargo"
            }
            if(movHora.isEmpty()){
                recHora.error = "Por favor insira um Salário"
            }

            val movId = dbRef.push().key!!

            val empregador = Movimentos(movId, movNome, movLocal, movHora)

            dbRef.child(movId).setValue(empregador)
                .addOnCompleteListener{
                    Toast.makeText(this, "Cadastro realizado", Toast.LENGTH_SHORT).show()

                    recNome.text.clear()
                    recLocal.text.clear()
                    recHora.text.clear()

                }.addOnFailureListener{err ->
                    Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_SHORT).show()
                }
        }

    }


}
