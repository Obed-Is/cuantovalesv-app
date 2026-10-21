package com.obed.cuantovalesv.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.obed.cuantovalesv.R
import com.obed.cuantovalesv.screens.construirTextoEstilizado
import com.obed.cuantovalesv.ui.theme.blanco
import com.obed.cuantovalesv.ui.theme.negro

/**
 * NAVBAR PRINCIPAL DE LA APP
 */
@Composable
@Preview(showBackground = true)
fun TopBarDiseno(modoOscuro: Boolean = true, modoOscuroCambio: (Boolean) -> Unit = {}) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.tertiary,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(
                    horizontal = 16.dp,
                    vertical = 10.dp
                )
        ) {
            Text(
                "$",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = if (modoOscuro) {
                    negro
                } else {
                    blanco
                },
            )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column() {
            Text(
                construirTextoEstilizado("Cuánto Vale", "SV", MaterialTheme.colorScheme.tertiary),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                "\uD83C\uDDF8\uD83C\uDDFB Precios de El Salvador",
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = 13.sp,
                lineHeight = 10.sp
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Switch(
            checked = modoOscuro,
            onCheckedChange = modoOscuroCambio,
            thumbContent = {
                Icon(
                    painter = painterResource(if (modoOscuro) R.drawable.moon else R.drawable.sun),
                    contentDescription = null,
                    modifier = Modifier.size(SwitchDefaults.IconSize),
                    // esto le dice que use el color que le definí, no el del tema
                    tint = Color.Unspecified
                )
            }
        )
    }
}