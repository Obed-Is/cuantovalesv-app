package com.obed.cuantovalesv.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = azulBandera,
    onPrimary = blanco,

    secondary = azulIntermedio,
    onSecondary = blanco,

    tertiary = dorado,
    onTertiary = textoSobreDorado,

    background = azulProfundo,
    onBackground = blanco,

    surface = azulBandera,
    onSurface = blanco,

    surfaceVariant = azulIntermedio,
    onSurfaceVariant = azulClaro,

    primaryFixed = Color(0xFF000000),

    secondaryFixed = Color(0xFF0B2D75)
)

private val LightColorScheme = lightColorScheme(
    primary = verdeOlivaOscuro,
    onPrimary = marfilCalido,

    secondary = verdeSalvia,
    onSecondary = blanco,

    tertiary = verdeSalvia,
    onTertiary = blanco,

    background = arenaSuave,
    onBackground = carbonCalido,

    surface = marfilCalido,
    onSurface = carbonCalido,

    surfaceVariant = caquiClaro,
    onSurfaceVariant = grisOliva,

    primaryFixed = Color(0xFFFFFCF6),

    secondaryFixed = Color(0xFFE9E2D6)
    )

@Composable
fun CuantoValeSvTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}