@file:OptIn(ExperimentalMaterial3Api::class)

package com.obed.cuantovalesv.componentes

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.obed.cuantovalesv.R
import com.obed.cuantovalesv.ui.theme.blanco
import com.obed.cuantovalesv.ui.theme.borderSecundario
import com.obed.cuantovalesv.ui.theme.negro
import kotlin.math.log

/**
 * Filtros de establecimientos y búsqueda de productos
 */
@Composable
@Preview(showBackground = true)
fun FiltrosProductos(
    listaEstablecimientos: List<String> = listOf(

    )
) {

    var establecimientosSeleccionado by remember { mutableStateOf<Set<String>>(emptySet()) }
    var productoBuscar = rememberTextFieldState()


    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        state = productoBuscar,
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.icono_buscar),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        },
        placeholder = {
            Text(
                "Buscar producto...",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        },
        shape = RoundedCornerShape(16.dp),
        lineLimits = TextFieldLineLimits.SingleLine,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
            focusedContainerColor = MaterialTheme.colorScheme.surfaceVariant,
            focusedBorderColor = MaterialTheme.colorScheme.tertiary,
            unfocusedBorderColor = borderSecundario
        )
    )
    Spacer(Modifier.height(10.dp))

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        var mostrarModal: Boolean by remember { mutableStateOf(false) }

        Button(
            onClick = {
                mostrarModal = true
            },
            modifier = Modifier
                .weight(1f),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.tertiary,
                contentColor = MaterialTheme.colorScheme.primaryFixed
            ),
        ) {
            Text("Establecimientos", fontWeight = FontWeight.W600)
        }

        if (mostrarModal) {
            ModalBottomSheet(
                onDismissRequest = {
                    mostrarModal = false
                }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Selecciona los establecimientos",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        style = MaterialTheme.typography.titleLarge
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    FlowRow(
                        modifier = Modifier
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        for (establecimiento in listaEstablecimientos) {
                            AssistChip(
                                onClick = {
                                    establecimientosSeleccionado =
                                        if (!establecimientosSeleccionado.contains(establecimiento)) {
                                            establecimientosSeleccionado + establecimiento
                                        } else {
                                            establecimientosSeleccionado - establecimiento
                                        }
                                },
                                label = {
                                    Text(establecimiento)
                                },
                                colors = AssistChipDefaults.assistChipColors(
                                    containerColor = if (establecimientosSeleccionado.contains(
                                            establecimiento
                                        )
                                    ) {
                                        MaterialTheme.colorScheme.onPrimary
                                    } else {
                                        Color.Transparent
                                    },
                                    labelColor = if (establecimientosSeleccionado.contains(
                                            establecimiento
                                        )
                                    ) {
                                        negro
                                    } else {
                                        blanco
                                    },
                                ),
                                modifier = Modifier
                                    .height(48.dp)
                                    .padding(vertical = 4.dp),
                            )
                        }
                    }
                }
            }
        }

        Spacer(Modifier.width(10.dp))

        Button(
            onClick = {
                Log.d("PRUEBA", productoBuscar.text.toString())
            },
            modifier = Modifier
                .weight(1f),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.tertiary,
                contentColor = MaterialTheme.colorScheme.primaryFixed
            )
        ) {
            Text("Buscar productos")
        }
    }
}