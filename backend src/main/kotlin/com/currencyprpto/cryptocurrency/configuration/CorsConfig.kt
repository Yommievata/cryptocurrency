package com.currencyprpto.cryptocurrency.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter

@Configuration
class CorsConfig {
    @Bean
    fun corsFilter(): CorsFilter {
        val source = UrlBasedCorsConfigurationSource()
        val config = CorsConfiguration()

        config.allowedOrigins = listOf("*")
        config.allowedHeaders = listOf("*")
        config.allowedMethods = listOf("*")

        source.registerCorsConfiguration("/**", config)
        return CorsFilter(source)
    }
}
