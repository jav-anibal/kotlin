package com.santosgo.marvelheroescompose.ui.theme
import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import com.santosgo.marvelheroescompose.ui.theme.AppTypography
import com.santosgo.marvelheroescompose.ui.theme.backgroundDark
import com.santosgo.marvelheroescompose.ui.theme.backgroundDarkHighContrast
import com.santosgo.marvelheroescompose.ui.theme.backgroundDarkMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.backgroundLight
import com.santosgo.marvelheroescompose.ui.theme.backgroundLightHighContrast
import com.santosgo.marvelheroescompose.ui.theme.backgroundLightMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.errorContainerDark
import com.santosgo.marvelheroescompose.ui.theme.errorContainerDarkHighContrast
import com.santosgo.marvelheroescompose.ui.theme.errorContainerDarkMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.errorContainerLight
import com.santosgo.marvelheroescompose.ui.theme.errorContainerLightHighContrast
import com.santosgo.marvelheroescompose.ui.theme.errorContainerLightMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.errorDark
import com.santosgo.marvelheroescompose.ui.theme.errorDarkHighContrast
import com.santosgo.marvelheroescompose.ui.theme.errorDarkMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.errorLight
import com.santosgo.marvelheroescompose.ui.theme.errorLightHighContrast
import com.santosgo.marvelheroescompose.ui.theme.errorLightMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.inverseOnSurfaceDark
import com.santosgo.marvelheroescompose.ui.theme.inverseOnSurfaceDarkHighContrast
import com.santosgo.marvelheroescompose.ui.theme.inverseOnSurfaceDarkMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.inverseOnSurfaceLight
import com.santosgo.marvelheroescompose.ui.theme.inverseOnSurfaceLightHighContrast
import com.santosgo.marvelheroescompose.ui.theme.inverseOnSurfaceLightMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.inversePrimaryDark
import com.santosgo.marvelheroescompose.ui.theme.inversePrimaryDarkHighContrast
import com.santosgo.marvelheroescompose.ui.theme.inversePrimaryDarkMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.inversePrimaryLight
import com.santosgo.marvelheroescompose.ui.theme.inversePrimaryLightHighContrast
import com.santosgo.marvelheroescompose.ui.theme.inversePrimaryLightMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.inverseSurfaceDark
import com.santosgo.marvelheroescompose.ui.theme.inverseSurfaceDarkHighContrast
import com.santosgo.marvelheroescompose.ui.theme.inverseSurfaceDarkMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.inverseSurfaceLight
import com.santosgo.marvelheroescompose.ui.theme.inverseSurfaceLightHighContrast
import com.santosgo.marvelheroescompose.ui.theme.inverseSurfaceLightMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.onBackgroundDark
import com.santosgo.marvelheroescompose.ui.theme.onBackgroundDarkHighContrast
import com.santosgo.marvelheroescompose.ui.theme.onBackgroundDarkMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.onBackgroundLight
import com.santosgo.marvelheroescompose.ui.theme.onBackgroundLightHighContrast
import com.santosgo.marvelheroescompose.ui.theme.onBackgroundLightMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.onErrorContainerDark
import com.santosgo.marvelheroescompose.ui.theme.onErrorContainerDarkHighContrast
import com.santosgo.marvelheroescompose.ui.theme.onErrorContainerDarkMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.onErrorContainerLight
import com.santosgo.marvelheroescompose.ui.theme.onErrorContainerLightHighContrast
import com.santosgo.marvelheroescompose.ui.theme.onErrorContainerLightMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.onErrorDark
import com.santosgo.marvelheroescompose.ui.theme.onErrorDarkHighContrast
import com.santosgo.marvelheroescompose.ui.theme.onErrorDarkMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.onErrorLight
import com.santosgo.marvelheroescompose.ui.theme.onErrorLightHighContrast
import com.santosgo.marvelheroescompose.ui.theme.onErrorLightMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.onPrimaryContainerDark
import com.santosgo.marvelheroescompose.ui.theme.onPrimaryContainerDarkHighContrast
import com.santosgo.marvelheroescompose.ui.theme.onPrimaryContainerDarkMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.onPrimaryContainerLight
import com.santosgo.marvelheroescompose.ui.theme.onPrimaryContainerLightHighContrast
import com.santosgo.marvelheroescompose.ui.theme.onPrimaryContainerLightMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.onPrimaryDark
import com.santosgo.marvelheroescompose.ui.theme.onPrimaryDarkHighContrast
import com.santosgo.marvelheroescompose.ui.theme.onPrimaryDarkMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.onPrimaryLight
import com.santosgo.marvelheroescompose.ui.theme.onPrimaryLightHighContrast
import com.santosgo.marvelheroescompose.ui.theme.onPrimaryLightMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.onSecondaryContainerDark
import com.santosgo.marvelheroescompose.ui.theme.onSecondaryContainerDarkHighContrast
import com.santosgo.marvelheroescompose.ui.theme.onSecondaryContainerDarkMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.onSecondaryContainerLight
import com.santosgo.marvelheroescompose.ui.theme.onSecondaryContainerLightHighContrast
import com.santosgo.marvelheroescompose.ui.theme.onSecondaryContainerLightMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.onSecondaryDark
import com.santosgo.marvelheroescompose.ui.theme.onSecondaryDarkHighContrast
import com.santosgo.marvelheroescompose.ui.theme.onSecondaryDarkMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.onSecondaryLight
import com.santosgo.marvelheroescompose.ui.theme.onSecondaryLightHighContrast
import com.santosgo.marvelheroescompose.ui.theme.onSecondaryLightMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.onSurfaceDark
import com.santosgo.marvelheroescompose.ui.theme.onSurfaceDarkHighContrast
import com.santosgo.marvelheroescompose.ui.theme.onSurfaceDarkMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.onSurfaceLight
import com.santosgo.marvelheroescompose.ui.theme.onSurfaceLightHighContrast
import com.santosgo.marvelheroescompose.ui.theme.onSurfaceLightMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.onSurfaceVariantDark
import com.santosgo.marvelheroescompose.ui.theme.onSurfaceVariantDarkHighContrast
import com.santosgo.marvelheroescompose.ui.theme.onSurfaceVariantDarkMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.onSurfaceVariantLight
import com.santosgo.marvelheroescompose.ui.theme.onSurfaceVariantLightHighContrast
import com.santosgo.marvelheroescompose.ui.theme.onSurfaceVariantLightMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.onTertiaryContainerDark
import com.santosgo.marvelheroescompose.ui.theme.onTertiaryContainerDarkHighContrast
import com.santosgo.marvelheroescompose.ui.theme.onTertiaryContainerDarkMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.onTertiaryContainerLight
import com.santosgo.marvelheroescompose.ui.theme.onTertiaryContainerLightHighContrast
import com.santosgo.marvelheroescompose.ui.theme.onTertiaryContainerLightMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.onTertiaryDark
import com.santosgo.marvelheroescompose.ui.theme.onTertiaryDarkHighContrast
import com.santosgo.marvelheroescompose.ui.theme.onTertiaryDarkMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.onTertiaryLight
import com.santosgo.marvelheroescompose.ui.theme.onTertiaryLightHighContrast
import com.santosgo.marvelheroescompose.ui.theme.onTertiaryLightMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.outlineDark
import com.santosgo.marvelheroescompose.ui.theme.outlineDarkHighContrast
import com.santosgo.marvelheroescompose.ui.theme.outlineDarkMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.outlineLight
import com.santosgo.marvelheroescompose.ui.theme.outlineLightHighContrast
import com.santosgo.marvelheroescompose.ui.theme.outlineLightMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.outlineVariantDark
import com.santosgo.marvelheroescompose.ui.theme.outlineVariantDarkHighContrast
import com.santosgo.marvelheroescompose.ui.theme.outlineVariantDarkMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.outlineVariantLight
import com.santosgo.marvelheroescompose.ui.theme.outlineVariantLightHighContrast
import com.santosgo.marvelheroescompose.ui.theme.outlineVariantLightMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.primaryContainerDark
import com.santosgo.marvelheroescompose.ui.theme.primaryContainerDarkHighContrast
import com.santosgo.marvelheroescompose.ui.theme.primaryContainerDarkMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.primaryContainerLight
import com.santosgo.marvelheroescompose.ui.theme.primaryContainerLightHighContrast
import com.santosgo.marvelheroescompose.ui.theme.primaryContainerLightMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.primaryDark
import com.santosgo.marvelheroescompose.ui.theme.primaryDarkHighContrast
import com.santosgo.marvelheroescompose.ui.theme.primaryDarkMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.primaryLight
import com.santosgo.marvelheroescompose.ui.theme.primaryLightHighContrast
import com.santosgo.marvelheroescompose.ui.theme.primaryLightMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.scrimDark
import com.santosgo.marvelheroescompose.ui.theme.scrimDarkHighContrast
import com.santosgo.marvelheroescompose.ui.theme.scrimDarkMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.scrimLight
import com.santosgo.marvelheroescompose.ui.theme.scrimLightHighContrast
import com.santosgo.marvelheroescompose.ui.theme.scrimLightMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.secondaryContainerDark
import com.santosgo.marvelheroescompose.ui.theme.secondaryContainerDarkHighContrast
import com.santosgo.marvelheroescompose.ui.theme.secondaryContainerDarkMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.secondaryContainerLight
import com.santosgo.marvelheroescompose.ui.theme.secondaryContainerLightHighContrast
import com.santosgo.marvelheroescompose.ui.theme.secondaryContainerLightMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.secondaryDark
import com.santosgo.marvelheroescompose.ui.theme.secondaryDarkHighContrast
import com.santosgo.marvelheroescompose.ui.theme.secondaryDarkMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.secondaryLight
import com.santosgo.marvelheroescompose.ui.theme.secondaryLightHighContrast
import com.santosgo.marvelheroescompose.ui.theme.secondaryLightMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.surfaceBrightDark
import com.santosgo.marvelheroescompose.ui.theme.surfaceBrightDarkHighContrast
import com.santosgo.marvelheroescompose.ui.theme.surfaceBrightDarkMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.surfaceBrightLight
import com.santosgo.marvelheroescompose.ui.theme.surfaceBrightLightHighContrast
import com.santosgo.marvelheroescompose.ui.theme.surfaceBrightLightMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.surfaceContainerDark
import com.santosgo.marvelheroescompose.ui.theme.surfaceContainerDarkHighContrast
import com.santosgo.marvelheroescompose.ui.theme.surfaceContainerDarkMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.surfaceContainerHighDark
import com.santosgo.marvelheroescompose.ui.theme.surfaceContainerHighDarkHighContrast
import com.santosgo.marvelheroescompose.ui.theme.surfaceContainerHighDarkMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.surfaceContainerHighLight
import com.santosgo.marvelheroescompose.ui.theme.surfaceContainerHighLightHighContrast
import com.santosgo.marvelheroescompose.ui.theme.surfaceContainerHighLightMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.surfaceContainerHighestDark
import com.santosgo.marvelheroescompose.ui.theme.surfaceContainerHighestDarkHighContrast
import com.santosgo.marvelheroescompose.ui.theme.surfaceContainerHighestDarkMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.surfaceContainerHighestLight
import com.santosgo.marvelheroescompose.ui.theme.surfaceContainerHighestLightHighContrast
import com.santosgo.marvelheroescompose.ui.theme.surfaceContainerHighestLightMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.surfaceContainerLight
import com.santosgo.marvelheroescompose.ui.theme.surfaceContainerLightHighContrast
import com.santosgo.marvelheroescompose.ui.theme.surfaceContainerLightMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.surfaceContainerLowDark
import com.santosgo.marvelheroescompose.ui.theme.surfaceContainerLowDarkHighContrast
import com.santosgo.marvelheroescompose.ui.theme.surfaceContainerLowDarkMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.surfaceContainerLowLight
import com.santosgo.marvelheroescompose.ui.theme.surfaceContainerLowLightHighContrast
import com.santosgo.marvelheroescompose.ui.theme.surfaceContainerLowLightMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.surfaceContainerLowestDark
import com.santosgo.marvelheroescompose.ui.theme.surfaceContainerLowestDarkHighContrast
import com.santosgo.marvelheroescompose.ui.theme.surfaceContainerLowestDarkMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.surfaceContainerLowestLight
import com.santosgo.marvelheroescompose.ui.theme.surfaceContainerLowestLightHighContrast
import com.santosgo.marvelheroescompose.ui.theme.surfaceContainerLowestLightMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.surfaceDark
import com.santosgo.marvelheroescompose.ui.theme.surfaceDarkHighContrast
import com.santosgo.marvelheroescompose.ui.theme.surfaceDarkMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.surfaceDimDark
import com.santosgo.marvelheroescompose.ui.theme.surfaceDimDarkHighContrast
import com.santosgo.marvelheroescompose.ui.theme.surfaceDimDarkMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.surfaceDimLight
import com.santosgo.marvelheroescompose.ui.theme.surfaceDimLightHighContrast
import com.santosgo.marvelheroescompose.ui.theme.surfaceDimLightMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.surfaceLight
import com.santosgo.marvelheroescompose.ui.theme.surfaceLightHighContrast
import com.santosgo.marvelheroescompose.ui.theme.surfaceLightMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.surfaceVariantDark
import com.santosgo.marvelheroescompose.ui.theme.surfaceVariantDarkHighContrast
import com.santosgo.marvelheroescompose.ui.theme.surfaceVariantDarkMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.surfaceVariantLight
import com.santosgo.marvelheroescompose.ui.theme.surfaceVariantLightHighContrast
import com.santosgo.marvelheroescompose.ui.theme.surfaceVariantLightMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.tertiaryContainerDark
import com.santosgo.marvelheroescompose.ui.theme.tertiaryContainerDarkHighContrast
import com.santosgo.marvelheroescompose.ui.theme.tertiaryContainerDarkMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.tertiaryContainerLight
import com.santosgo.marvelheroescompose.ui.theme.tertiaryContainerLightHighContrast
import com.santosgo.marvelheroescompose.ui.theme.tertiaryContainerLightMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.tertiaryDark
import com.santosgo.marvelheroescompose.ui.theme.tertiaryDarkHighContrast
import com.santosgo.marvelheroescompose.ui.theme.tertiaryDarkMediumContrast
import com.santosgo.marvelheroescompose.ui.theme.tertiaryLight
import com.santosgo.marvelheroescompose.ui.theme.tertiaryLightHighContrast
import com.santosgo.marvelheroescompose.ui.theme.tertiaryLightMediumContrast

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

private val mediumContrastLightColorScheme = lightColorScheme(
    primary = primaryLightMediumContrast,
    onPrimary = onPrimaryLightMediumContrast,
    primaryContainer = primaryContainerLightMediumContrast,
    onPrimaryContainer = onPrimaryContainerLightMediumContrast,
    secondary = secondaryLightMediumContrast,
    onSecondary = onSecondaryLightMediumContrast,
    secondaryContainer = secondaryContainerLightMediumContrast,
    onSecondaryContainer = onSecondaryContainerLightMediumContrast,
    tertiary = tertiaryLightMediumContrast,
    onTertiary = onTertiaryLightMediumContrast,
    tertiaryContainer = tertiaryContainerLightMediumContrast,
    onTertiaryContainer = onTertiaryContainerLightMediumContrast,
    error = errorLightMediumContrast,
    onError = onErrorLightMediumContrast,
    errorContainer = errorContainerLightMediumContrast,
    onErrorContainer = onErrorContainerLightMediumContrast,
    background = backgroundLightMediumContrast,
    onBackground = onBackgroundLightMediumContrast,
    surface = surfaceLightMediumContrast,
    onSurface = onSurfaceLightMediumContrast,
    surfaceVariant = surfaceVariantLightMediumContrast,
    onSurfaceVariant = onSurfaceVariantLightMediumContrast,
    outline = outlineLightMediumContrast,
    outlineVariant = outlineVariantLightMediumContrast,
    scrim = scrimLightMediumContrast,
    inverseSurface = inverseSurfaceLightMediumContrast,
    inverseOnSurface = inverseOnSurfaceLightMediumContrast,
    inversePrimary = inversePrimaryLightMediumContrast,
    surfaceDim = surfaceDimLightMediumContrast,
    surfaceBright = surfaceBrightLightMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestLightMediumContrast,
    surfaceContainerLow = surfaceContainerLowLightMediumContrast,
    surfaceContainer = surfaceContainerLightMediumContrast,
    surfaceContainerHigh = surfaceContainerHighLightMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestLightMediumContrast,
)

private val highContrastLightColorScheme = lightColorScheme(
    primary = primaryLightHighContrast,
    onPrimary = onPrimaryLightHighContrast,
    primaryContainer = primaryContainerLightHighContrast,
    onPrimaryContainer = onPrimaryContainerLightHighContrast,
    secondary = secondaryLightHighContrast,
    onSecondary = onSecondaryLightHighContrast,
    secondaryContainer = secondaryContainerLightHighContrast,
    onSecondaryContainer = onSecondaryContainerLightHighContrast,
    tertiary = tertiaryLightHighContrast,
    onTertiary = onTertiaryLightHighContrast,
    tertiaryContainer = tertiaryContainerLightHighContrast,
    onTertiaryContainer = onTertiaryContainerLightHighContrast,
    error = errorLightHighContrast,
    onError = onErrorLightHighContrast,
    errorContainer = errorContainerLightHighContrast,
    onErrorContainer = onErrorContainerLightHighContrast,
    background = backgroundLightHighContrast,
    onBackground = onBackgroundLightHighContrast,
    surface = surfaceLightHighContrast,
    onSurface = onSurfaceLightHighContrast,
    surfaceVariant = surfaceVariantLightHighContrast,
    onSurfaceVariant = onSurfaceVariantLightHighContrast,
    outline = outlineLightHighContrast,
    outlineVariant = outlineVariantLightHighContrast,
    scrim = scrimLightHighContrast,
    inverseSurface = inverseSurfaceLightHighContrast,
    inverseOnSurface = inverseOnSurfaceLightHighContrast,
    inversePrimary = inversePrimaryLightHighContrast,
    surfaceDim = surfaceDimLightHighContrast,
    surfaceBright = surfaceBrightLightHighContrast,
    surfaceContainerLowest = surfaceContainerLowestLightHighContrast,
    surfaceContainerLow = surfaceContainerLowLightHighContrast,
    surfaceContainer = surfaceContainerLightHighContrast,
    surfaceContainerHigh = surfaceContainerHighLightHighContrast,
    surfaceContainerHighest = surfaceContainerHighestLightHighContrast,
)

private val mediumContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkMediumContrast,
    onPrimary = onPrimaryDarkMediumContrast,
    primaryContainer = primaryContainerDarkMediumContrast,
    onPrimaryContainer = onPrimaryContainerDarkMediumContrast,
    secondary = secondaryDarkMediumContrast,
    onSecondary = onSecondaryDarkMediumContrast,
    secondaryContainer = secondaryContainerDarkMediumContrast,
    onSecondaryContainer = onSecondaryContainerDarkMediumContrast,
    tertiary = tertiaryDarkMediumContrast,
    onTertiary = onTertiaryDarkMediumContrast,
    tertiaryContainer = tertiaryContainerDarkMediumContrast,
    onTertiaryContainer = onTertiaryContainerDarkMediumContrast,
    error = errorDarkMediumContrast,
    onError = onErrorDarkMediumContrast,
    errorContainer = errorContainerDarkMediumContrast,
    onErrorContainer = onErrorContainerDarkMediumContrast,
    background = backgroundDarkMediumContrast,
    onBackground = onBackgroundDarkMediumContrast,
    surface = surfaceDarkMediumContrast,
    onSurface = onSurfaceDarkMediumContrast,
    surfaceVariant = surfaceVariantDarkMediumContrast,
    onSurfaceVariant = onSurfaceVariantDarkMediumContrast,
    outline = outlineDarkMediumContrast,
    outlineVariant = outlineVariantDarkMediumContrast,
    scrim = scrimDarkMediumContrast,
    inverseSurface = inverseSurfaceDarkMediumContrast,
    inverseOnSurface = inverseOnSurfaceDarkMediumContrast,
    inversePrimary = inversePrimaryDarkMediumContrast,
    surfaceDim = surfaceDimDarkMediumContrast,
    surfaceBright = surfaceBrightDarkMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkMediumContrast,
    surfaceContainerLow = surfaceContainerLowDarkMediumContrast,
    surfaceContainer = surfaceContainerDarkMediumContrast,
    surfaceContainerHigh = surfaceContainerHighDarkMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkMediumContrast,
)

private val highContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkHighContrast,
    onPrimary = onPrimaryDarkHighContrast,
    primaryContainer = primaryContainerDarkHighContrast,
    onPrimaryContainer = onPrimaryContainerDarkHighContrast,
    secondary = secondaryDarkHighContrast,
    onSecondary = onSecondaryDarkHighContrast,
    secondaryContainer = secondaryContainerDarkHighContrast,
    onSecondaryContainer = onSecondaryContainerDarkHighContrast,
    tertiary = tertiaryDarkHighContrast,
    onTertiary = onTertiaryDarkHighContrast,
    tertiaryContainer = tertiaryContainerDarkHighContrast,
    onTertiaryContainer = onTertiaryContainerDarkHighContrast,
    error = errorDarkHighContrast,
    onError = onErrorDarkHighContrast,
    errorContainer = errorContainerDarkHighContrast,
    onErrorContainer = onErrorContainerDarkHighContrast,
    background = backgroundDarkHighContrast,
    onBackground = onBackgroundDarkHighContrast,
    surface = surfaceDarkHighContrast,
    onSurface = onSurfaceDarkHighContrast,
    surfaceVariant = surfaceVariantDarkHighContrast,
    onSurfaceVariant = onSurfaceVariantDarkHighContrast,
    outline = outlineDarkHighContrast,
    outlineVariant = outlineVariantDarkHighContrast,
    scrim = scrimDarkHighContrast,
    inverseSurface = inverseSurfaceDarkHighContrast,
    inverseOnSurface = inverseOnSurfaceDarkHighContrast,
    inversePrimary = inversePrimaryDarkHighContrast,
    surfaceDim = surfaceDimDarkHighContrast,
    surfaceBright = surfaceBrightDarkHighContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkHighContrast,
    surfaceContainerLow = surfaceContainerLowDarkHighContrast,
    surfaceContainer = surfaceContainerDarkHighContrast,
    surfaceContainerHigh = surfaceContainerHighDarkHighContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkHighContrast,
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun MarvelHeroesComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit
) {
  val colorScheme = when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
          val context = LocalContext.current
          if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }

      darkTheme -> darkScheme
      else -> lightScheme
  }

  // Select extended colors based on theme
  val extendedColors = if (darkTheme) {
      ExtendedColors(
          customHeader = customHeaderDark,
          onCustomHeader = onCustomHeaderDark
      )
  } else {
      ExtendedColors(
          customHeader = customHeaderLight,
          onCustomHeader = onCustomHeaderLight
      )
  }

  CompositionLocalProvider(LocalExtendedColors provides extendedColors) {
      MaterialTheme(
          colorScheme = colorScheme,
          typography = AppTypography,
          content = content
      )
  }
}

