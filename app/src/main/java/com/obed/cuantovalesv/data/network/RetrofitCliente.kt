package com.obed.cuantovalesv.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitCliente {
    // APLICACION (API) CON IIS
    private const val BASE_URL: String = "http://192.168.1.3:3030/"

    // Construccion del cliente para usar retrofit
    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val establecimientoApi: EstablecimientoApi by lazy {
        retrofit.create(EstablecimientoApi::class.java)
    }
}