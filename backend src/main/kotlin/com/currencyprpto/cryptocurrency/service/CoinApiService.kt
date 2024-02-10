package com.currencyprpto.cryptocurrency.service

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class CoinApiService (
    private val apiKey: String,
    private val apiUrl: String,
    private val restTemplate: RestTemplate

) {

    fun getExchangeRate(cryptoCurrency: String, fiatCurrency: String): Double {
        val url = "$apiUrl/$cryptoCurrency/$fiatCurrency"
        val headers = HttpHeaders().apply {
            set("X-CoinAPI-Key", apiKey)
        }
        val entity = HttpEntity<String>(headers)

        val response = restTemplate.exchange(url, HttpMethod.GET, entity, CoinApiExchangeRate::class.java)
        return response.body?.rate ?: throw IllegalStateException("Unable to fetch exchange rate")
    }
}

data class CoinApiExchangeRate(
        @JsonProperty("rate")
        val rate: Double
)
