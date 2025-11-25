package com.santosgo.marvelheroescompose.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * Extended colors for custom Marvel theme elements
 * Provides colors beyond the standard Material 3 palette
 */
@Immutable
data class ExtendedColors(
    val customHeader: Color,        // Header background color
    val onCustomHeader: Color,      // Text/icon color on header
)

// Light mode extended colors
private val extendedColorsLight = ExtendedColors(
    customHeader = customHeaderLight,
    onCustomHeader = onCustomHeaderLight,
)

// Dark mode extended colors
private val extendedColorsDark = ExtendedColors(
    customHeader = customHeaderDark,
    onCustomHeader = onCustomHeaderDark,
)

/**
 * CompositionLocal for accessing extended colors throughout the app
 */
val LocalExtendedColors = staticCompositionLocalOf {
    extendedColorsLight // Default value
}

/**
 * Extension property to access extended colors via MaterialTheme.colorScheme.extended
 */
val ColorScheme.extended: ExtendedColors
    @Composable
    get() = LocalExtendedColors.current
