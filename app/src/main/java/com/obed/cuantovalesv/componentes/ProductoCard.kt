package com.obed.cuantovalesv.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.obed.cuantovalesv.R
import com.obed.cuantovalesv.data.models.Producto
import com.obed.cuantovalesv.ui.theme.border

@Composable
@Preview(showBackground = true)
fun ProductoCard(
    producto: Producto = Producto(
        nombre = "Cafe",
        precio = 2.24,
        urlProducto = "https://www.walmart.com.sv/cafe-aroma-dispensador-40-sob-80-g-8/p",
        establecimiento = "Walmart",
        urlImagen = "https://walmartsv.vtexassets.com/arquivos/ids/594403-1200-900?v=638665117845130000&width=1200&height=900&aspect=true",
        urlEstablecimiento = "https://www.walmart.com.sv/"
    )
) {
    var isFocusCard by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .focusable()
            .onFocusChanged { isFocusCard = it.isFocused }
            .border(
                width = 1.dp,
                shape = RoundedCornerShape(12.dp),
                color = if (isFocusCard) MaterialTheme.colorScheme.tertiary else border
            ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(16.dp),
        ) {
            AsyncImage(
                model = producto.urlImagen,
                contentDescription = null,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
            )
            Spacer(Modifier.width(16.dp))
            Column(

            ) {
                Text(
                    "Conocé el detalle",
                    fontSize = 11.sp,
                    lineHeight = 4.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    producto.nombre,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )

                Text(
                    producto.precio.let { "$${it}" } ?: "Precio no disponible",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 4.sp,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }

            Spacer(Modifier.weight(1f))

            IconButton(
                onClick = {}
            ) {
                Image(
                    painter = painterResource(R.drawable.chevron_right),
                    contentDescription = "Ver detalle"
                )
            }
        }
    }
}