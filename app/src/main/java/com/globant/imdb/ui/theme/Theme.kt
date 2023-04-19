package com.globant.imdb.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = GoldenPoppy,
    onPrimary = Nobel,
    secondary = GoldenPoppy,
    onSecondary = Nobel,
    error = FreeSpeechRed,
    onError = FreeSpeechRed,
    background = WhiteSmoke,
    onBackground = Charcoal,
    surface = WhiteSmoke,
    onSurface = Charcoal
)

private val LightColorPalette = lightColors(
    primary = Nobel,
    onPrimary = GoldenPoppy,
    secondary = Nobel,
    onSecondary = GoldenPoppy,
    error = FreeSpeechRed,
    onError = FreeSpeechRed,
    background = WhiteSmoke,
    onBackground = Charcoal,
    surface = WhiteSmoke,
    onSurface = Charcoal
)

@Composable
fun IMDbTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}