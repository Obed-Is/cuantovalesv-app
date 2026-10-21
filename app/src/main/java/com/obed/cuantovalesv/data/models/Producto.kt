package com.obed.cuantovalesv.data.models

/**
 * Modelo del producto
 */
data class Producto (
    val nombre: String,
    val precio: Double?,
    val establecimiento: String,
    val urlProducto: String,
    val urlImagen: String,
    val urlEstablecimiento: String,
)

