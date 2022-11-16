package com.janettha.ex_daggerhilt.repository

import com.janettha.ex_daggerhilt.data.Cryptocurrency

interface CryptocurrencyRepository {
    fun getCryptoCurrency(): List<Cryptocurrency>
}