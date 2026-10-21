package com.obed.cuantovalesv.screens

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.obed.cuantovalesv.ui.theme.border
import com.obed.cuantovalesv.componentes.TopBarDiseno
import com.obed.cuantovalesv.componentes.FiltrosProductos
import com.obed.cuantovalesv.componentes.ProductoCard
import com.obed.cuantovalesv.data.models.Producto
import com.obed.cuantovalesv.data.network.RetrofitCliente
import com.obed.cuantovalesv.data.repository.EstablecimientoRepository
import com.obed.cuantovalesv.viewmodels.HomeViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun HomeScreen(
    // VALORES POR DEFECTO PARA PODER VER EL PREVIEW CORRECTAMENTE
    modoOscuro: Boolean = false,
    modoOscuroCambio: (Boolean) -> Unit = {},
) {
    val homeViewModel = HomeViewModel()

    Scaffold(
        modifier = Modifier
            .offset(y = 40.dp)
            .padding(horizontal = 16.dp),
        topBar = {
            TopBarDiseno(modoOscuro, modoOscuroCambio) // importación
        }
    ) { paddingValues ->
        Contenido(
            modifier = Modifier.padding(paddingValues),
            homeViewModel = homeViewModel
        )
    }
}


/**
 * HERO, BUSQUEDA Y FILTROS DE LA APP
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Contenido(
    modifier: Modifier,
    homeViewModel: HomeViewModel
) {
    Column(
        modifier.fillMaxSize()
    ) {
        Spacer(Modifier.height(20.dp))

        Text(
            buildAnnotatedString {
                append("¿")
                append(
                    construirTextoEstilizado(
                        "Dónde esta mas barato\nlo que",
                        "necesitás",
                        MaterialTheme.colorScheme.tertiary
                    )
                )
                append("?")
            },
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 32.sp
        )

        Spacer(Modifier.height(10.dp))

        FiltrosProductos(
            listaEstablecimientos = homeViewModel.establecimientos
        )

        Spacer(Modifier.height(10.dp))

        val listaElementos: List<String> = listOf(
            "Jabón de baño Jabón de baño Jabón de baño",
            "Shampoo",
            "Pasta dental",
            "Cepillo de dientes",
            "Desodorante",
            "Crema corporal",
            "Acondicionador",
            "Jabón líquido",
            "Papel higiénico",
            "Toallas de papel",
            "Detergente",
            "Suavizante",
            "Cloro",
            "Limpiavidrios",
            "Esponja",
            "Arroz",
            "Frijoles",
            "Azúcar",
            "Sal",
            "Aceite",
            "Leche",
            "Pan",
            "Huevos",
            "Queso",
            "Café",
            "Galletas",
            "Atún",
            "Mayonesa",
            "Ketchup",
            "Cereal",
            "Agua embotellada",
            "Jugo",
            "Refresco",
            "Papas fritas",
            "Chocolate"
        )

        Card(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondaryFixed
            ),
            border = BorderStroke(1.dp, border)
        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(vertical = 16.dp, horizontal = 12.dp)
            ) {
                items(listaElementos) { elemento ->
                    val productoNuevo = Producto(
                        nombre = elemento,
                        precio = 2.24,
                        urlProducto = "https://www.walmart.com.sv/cafe-aroma-dispensador-40-sob-80-g-8/p",
                        establecimiento = "Walmart",
                        urlImagen = "https://walmartsv.vtexassets.com/arquivos/ids/594403-1200-900?v=638665117845130000&width=1200&height=900&aspect=true",
                        urlEstablecimiento = "https://www.walmart.com.sv/"
                    )
                    ProductoCard(productoNuevo)
                    Spacer(Modifier.height(6.dp))
                }
            }
        }
    }
}


fun construirTextoEstilizado(
    textoPrimario: String,
    textoEstilizado: String,
    colorTexto: Color
): AnnotatedString {
    return buildAnnotatedString {
        append("$textoPrimario ")

        withStyle(
            style = SpanStyle(
                color = colorTexto
            )
        ) {
            append(textoEstilizado)
        }
    }
}