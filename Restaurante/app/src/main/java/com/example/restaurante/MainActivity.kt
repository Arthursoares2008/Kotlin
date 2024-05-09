package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)


// Obtém o nome de usuário da intent
        val username = intent.extras?.getString("username")

// Se o nome de usuário não estiver vazio, exibe uma saudação
        if (!username.isNullOrEmpty()) {
            binding.textOla.setText("Olá $username")
        }

// Configura o botão "Fechar" para finalizar a ação
        binding.buttonFechar.setOnClickListener {
            finishAffinity()
        }

// Configura o botão "Pedir" para iniciar a SplashActivity com as quantidades de itens
        binding.buttonPedir.setOnClickListener {
            val i = Intent(this, SplashActivity::class.java)
            i.putExtra("QuantidadePizza", binding.editQuantidadePizza.text.toString())
            i.putExtra("QuantidadeSalada", binding.editQuantidadeSalada.text.toString())
            i.putExtra("QuantidadeHamburguer", binding.editQuantidadeHamburguer.text.toString())
            startActivity(i)
            finish()
        }

// Configura os checkboxes para atualizar as quantidades e visibilidade dos preços
// Check box da pizza
        binding.checkPizza.setOnClickListener {
            if (binding.checkPizza.isChecked()) {
                binding.editQuantidadePizza.setText("1")
                binding.textPrecoPizza.visibility = View.VISIBLE
            } else {
                binding.editQuantidadePizza.setText("0")
                binding.textPrecoPizza.visibility = View.GONE
            }
        }

// Check box da Salada
        binding.checkSalada.setOnClickListener {
            if (binding.checkSalada.isChecked()) {
                binding.editQuantidadeSalada.setText("1")
                binding.textPrecoSalada.visibility = View.VISIBLE
            } else {
                binding.editQuantidadeSalada.setText("0")
                binding.textPrecoSalada.visibility = View.GONE
            }
        }

// Check box do Hamburguer
        binding.checkHamburger.setOnClickListener {
            if (binding.checkHamburger.isChecked()) {
                binding.editQuantidadeHamburguer.setText("1")
                binding.textPrecoHamburguer.visibility = View.VISIBLE
            } else {
                binding.editQuantidadeHamburguer.setText("0")
                binding.textPrecoHamburguer.visibility = View.GONE
            }
        }
    }
}
