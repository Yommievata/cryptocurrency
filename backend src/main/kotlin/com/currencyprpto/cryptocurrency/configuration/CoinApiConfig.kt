package com.currencyprpto.cryptocurrency.configuration

import com.currencyprpto.cryptocurrency.service.CoinApiService
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class CoinApiConfig {

    @Value("\${coinapi.api-key}")
    private lateinit var apiKey: String

    @Value("\${coinapi.url}")
    private lateinit var apiUrl: String

    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplate()
    }

    @Bean
    fun coinApiService(restTemplate: RestTemplate): CoinApiService {
        return CoinApiService(apiKey, apiUrl, restTemplate)
    }
}
