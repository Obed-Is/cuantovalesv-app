package com.obed.cuantovalesv.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.obed.cuantovalesv.data.network.RetrofitCliente
import com.obed.cuantovalesv.data.repository.EstablecimientoRepository
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    val repoEstablecimientos = EstablecimientoRepository(
        apiEstablecimiento = RetrofitCliente.establecimientoApi
    )

    var establecimientos by mutableStateOf<List<String>>(listOf("NO SE ENCONTRARON ESTABLECIMIENTOS"))
        private set

    init {
        obtenerEstablecimientos()
    }

    fun obtenerEstablecimientos() {
        viewModelScope.launch {
            try {
                establecimientos = repoEstablecimientos.obtenerEstablecimientos()
                Log.d("API RESPUESTA", establecimientos.toString())
            } catch (e: Exception) {
                Log.d("API ERROR", e.toString())
            }
        }
    }
}