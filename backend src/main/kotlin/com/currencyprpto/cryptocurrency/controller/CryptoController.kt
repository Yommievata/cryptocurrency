package com.currencyprpto.cryptocurrency.controller

import com.currencyprpto.cryptocurrency.service.CoinApiService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/crypto")
@CrossOrigin
class CryptoController (
        private val coinApiService: CoinApiService
) {

    @GetMapping("/exchange-rate")
    fun getExchangeRate(
            @RequestParam cryptoCurrency: String,
            @RequestParam fiatCurrency: String
    ): ResponseEntity<Map<String, Double>> {
        val exchangeRate = coinApiService.getExchangeRate(cryptoCurrency, fiatCurrency)
        val response = mapOf("exchangeRate" to exchangeRate)
        return ResponseEntity.ok(response)
    }
}
