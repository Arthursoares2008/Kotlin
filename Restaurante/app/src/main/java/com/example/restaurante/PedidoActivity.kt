package com.example.restaurante

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restaurante.databinding.ActivityPedidoBinding

class PedidoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPedidoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPedidoBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

// Obtém os valores das quantidades de pizza, salada e hambúrguer da intent
        val i = intent
        val quantidadePizza = i.getStringExtra("quantidadePizza").toString().toInt()
        val quantidadeSalada = i.getStringExtra("quantidadeSalada").toString().toInt()
        val quantidadeHamburguer = i.getStringExtra("quantidadeHamburguer").toString().toInt()

// Calcula os preços com base nas quantidades
        val precoPizza = quantidadePizza * 8
        val precoSalada = quantidadeSalada * 10
        val precoHamburguer = quantidadeHamburguer * 12

// Cria uma string com o resumo do pedido
        val texto = "Resumo do Pedido\n" +
                "Pizza: $quantidadePizza Preço: $$precoPizza\n" +
                "Salada: $quantidadeSalada Preço: $$precoSalada\n" +
                "Hamburguer: $quantidadeHamburguer Preço: $$precoHamburguer\n"

// Exibe o resumo na interface do usuário
        binding.textResumo.text = texto
    }
}
