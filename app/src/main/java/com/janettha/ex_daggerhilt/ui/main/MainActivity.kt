package com.janettha.ex_daggerhilt.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.janettha.ex_daggerhilt.R
import com.janettha.ex_daggerhilt.ui.main.adapter.CryptocurrencyAdapter
import dagger.hilt.android.AndroidEntryPoint

/*
* @AndroidEntryPoint annotation which will make the component class
* (activity, fragments, views, services, and broadcast receiver)
* ready for injection
* */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // viewModels() delegate used to get
    // ViewModel in MainActivity class
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        observeCryptoCurrency()
    }

    // Observing the live data
    private fun observeCryptoCurrency() {
        viewModel.cryptoCurrency.observe(this) {
            viewModel.cryptoCurrency.observe(this) {
                val cryptocurrencyList
                    = findViewById<RecyclerView>(R.id.cryptocurrency_list)
                cryptocurrencyList.layoutManager = LinearLayoutManager(this)
                cryptocurrencyList.adapter = CryptocurrencyAdapter(it)
            }
        }
    }
}