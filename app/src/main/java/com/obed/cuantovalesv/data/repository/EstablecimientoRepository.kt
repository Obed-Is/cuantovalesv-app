package com.obed.cuantovalesv.data.repository

import com.obed.cuantovalesv.data.network.EstablecimientoApi

class EstablecimientoRepository(
    val apiEstablecimiento: EstablecimientoApi
) {
    suspend fun obtenerEstablecimientos() : List<String> {
        return apiEstablecimiento.obtenerEstablecimientos()
    }
}