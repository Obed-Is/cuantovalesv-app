package com.obed.cuantovalesv.data.network

import retrofit2.http.GET

interface EstablecimientoApi {

    @GET("api/productos/establecimientos")
    suspend fun obtenerEstablecimientos() : List<String>
}