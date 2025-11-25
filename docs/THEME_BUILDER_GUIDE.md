# Material Theme Builder - Guía para Estudiantes

## 📚 Tabla de Contenidos
1. [Aplicar Material Theme Builder](#1-aplicar-material-theme-builder)
2. [Crear Colores Extendidos (ExtendedColors.kt)](#2-crear-colores-extendidos)
3. [Usar Colores Personalizados](#3-usar-colores-personalizados)
4. [Conceptos Clave](#4-conceptos-clave)

---

## 1. Aplicar Material Theme Builder

### Paso 1: Generar tu paleta

1. Ve a: [Material Theme Builder](https://material-foundation.github.io/material-theme-builder/)

2. **Selecciona tu color principal:**
   - Click en "Primary"
   - Ingresa un color (ejemplo: `#A00012` para rojo Marvel)
   - La herramienta genera automáticamente colores secundarios, terciarios y variantes

3. **Previsualiza:**
   - Verifica cómo se ve en modo claro/oscuro
   - Revisa contraste y accesibilidad

4. **Exporta:**
   - Click en "Export" → "Jetpack Compose (Theme.kt)"
   - Descarga el archivo ZIP

### Paso 2: Integrar en tu proyecto

1. **Descomprime el ZIP y copia los archivos:**
   ```
   Color.kt → app/src/main/java/[tu.paquete]/ui/theme/
   Theme.kt → app/src/main/java/[tu.paquete]/ui/theme/
   ```

2. **Actualiza el paquete en ambos archivos:**
   ```kotlin
   // Cambiar de:
   package com.example.compose

   // A tu paquete real:
   package com.santosgo.marvelheroescompose.ui.theme
   ```

3. **Actualiza MainActivity.kt:**
   ```kotlin
   import com.santosgo.marvelheroescompose.ui.theme.MarvelHeroesComposeTheme

   setContent {
       MarvelHeroesComposeTheme(
           dynamicColor = false  // true: usa colores del wallpaper (Android 12+)
       ) {
           // Tu contenido
       }
   }
   ```

---

## 2. Crear Colores Extendidos

Material 3 tiene colores predefinidos, pero puedes crear colores personalizados.

### Paso 1: Crear `ExtendedColors.kt`

**Ubicación:** `app/src/main/java/[tu.paquete]/ui/theme/ExtendedColors.kt`

```kotlin
package com.santosgo.marvelheroescompose.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

// 1. DEFINE TUS COLORES PERSONALIZADOS
@Immutable
data class ExtendedColors(
    val success: Color,           // Verde para estados exitosos
    val onSuccess: Color,         // Texto sobre verde
    val successContainer: Color,  // Fondo de contenedor verde claro
    val onSuccessContainer: Color,// Texto en contenedor verde

    val warning: Color,           // Amarillo/naranja para advertencias
    val onWarning: Color,
    val warningContainer: Color,
    val onWarningContainer: Color,

    val info: Color,             // Azul para información
    val onInfo: Color,
    val infoContainer: Color,
    val onInfoContainer: Color,

    // Colores específicos de tu app (ejemplo: Marvel)
    val heroRed: Color,
    val onHeroRed: Color,
    val heroGold: Color,
    val onHeroGold: Color,
)

// 2. DEFINE PALETAS PARA LIGHT Y DARK MODE
private val extendedColorsLight = ExtendedColors(
    success = Color(0xFF2E7D32),          // Verde oscuro
    onSuccess = Color(0xFFFFFFFF),        // Blanco sobre verde
    successContainer = Color(0xFFA5D6A7), // Verde claro
    onSuccessContainer = Color(0xFF1B5E20),// Verde muy oscuro

    warning = Color(0xFFF57C00),          // Naranja
    onWarning = Color(0xFFFFFFFF),
    warningContainer = Color(0xFFFFE0B2),
    onWarningContainer = Color(0xFFE65100),

    info = Color(0xFF1976D2),             // Azul
    onInfo = Color(0xFFFFFFFF),
    infoContainer = Color(0xFFBBDEFB),
    onInfoContainer = Color(0xFF0D47A1),

    heroRed = Color(0xFFED1D24),          // Rojo Marvel
    onHeroRed = Color(0xFFFFFFFF),
    heroGold = Color(0xFFFFD700),         // Dorado Iron Man
    onHeroGold = Color(0xFF000000),
)

private val extendedColorsDark = ExtendedColors(
    success = Color(0xFF66BB6A),          // Verde más claro en dark
    onSuccess = Color(0xFF000000),
    successContainer = Color(0xFF2E7D32),
    onSuccessContainer = Color(0xFFC8E6C9),

    warning = Color(0xFFFFB74D),
    onWarning = Color(0xFF000000),
    warningContainer = Color(0xFFF57C00),
    onWarningContainer = Color(0xFFFFE0B2),

    info = Color(0xFF64B5F6),
    onInfo = Color(0xFF000000),
    infoContainer = Color(0xFF1976D2),
    onInfoContainer = Color(0xFFE3F2FD),

    heroRed = Color(0xFFFF5252),          // Rojo más brillante en dark
    onHeroRed = Color(0xFF000000),
    heroGold = Color(0xFFFFEB3B),
    onHeroGold = Color(0xFF000000),
)

// 3. CREA UN COMPOSITION LOCAL
val LocalExtendedColors = staticCompositionLocalOf {
    extendedColorsLight // Valor por defecto
}

// 4. EXTENSIÓN PARA ACCEDER FÁCILMENTE
val ColorScheme.extended: ExtendedColors
    @Composable
    get() = LocalExtendedColors.current
```

### Paso 2: Modificar `Theme.kt`

Agrega esta función después de `MarvelHeroesComposeTheme`:

```kotlin
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun MarvelHeroesComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
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

    // Selecciona los colores extendidos según el tema
    val extendedColors = if (darkTheme) extendedColorsDark else extendedColorsLight

    CompositionLocalProvider(LocalExtendedColors provides extendedColors) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = AppTypography,
            content = content
        )
    }
}
```

---

## 3. Usar Colores Personalizados

### En tus Composables:

```kotlin
import androidx.compose.material3.MaterialTheme
import com.santosgo.marvelheroescompose.ui.theme.extended

@Composable
fun HeroCard() {
    Card(
        colors = CardDefaults.cardColors(
            // Colores estándar de Material 3
            containerColor = MaterialTheme.colorScheme.surface,

            // O colores extendidos personalizados
            containerColor = MaterialTheme.colorScheme.extended.heroRed
        )
    ) {
        Text(
            text = "Iron Man",
            // Color de texto correspondiente
            color = MaterialTheme.colorScheme.extended.onHeroRed
        )
    }
}
```

### Ejemplos de uso:

```kotlin
// 1. Botón de éxito
Button(
    colors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.extended.success,
        contentColor = MaterialTheme.colorScheme.extended.onSuccess
    )
) {
    Text("Guardar")
}

// 2. Card de advertencia
Card(
    colors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.extended.warningContainer
    )
) {
    Text(
        text = "¡Atención!",
        color = MaterialTheme.colorScheme.extended.onWarningContainer
    )
}

// 3. Header con colores de héroe
Surface(
    color = MaterialTheme.colorScheme.extended.heroRed
) {
    Text(
        text = "MARVEL HEROES",
        color = MaterialTheme.colorScheme.extended.onHeroRed,
        style = MaterialTheme.typography.headlineLarge
    )
}
```

---

## 4. Conceptos Clave

### 4.1 Nomenclatura "On"

**Regla de Oro:** El prefijo `on` indica el color que va **SOBRE** otro color.

```kotlin
// ✅ CORRECTO
Surface(color = primary) {
    Text(color = onPrimary)  // Texto legible sobre primary
}

// ❌ INCORRECTO
Surface(color = primary) {
    Text(color = primary)  // ¡No se verá! Rojo sobre rojo
}
```

**Ejemplos:**
- `primary` (rojo) → `onPrimary` (blanco sobre rojo)
- `surface` (blanco) → `onSurface` (negro sobre blanco)
- `heroRed` (rojo) → `onHeroRed` (blanco sobre rojo)

### 4.2 Colores "Container"

Son versiones más claras/oscuras para fondos grandes.

```kotlin
// Para botones importantes
Button(containerColor = primary)  // Más vibrante

// Para cards y fondos
Card(containerColor = primaryContainer)  // Más sutil
```

### 4.3 Accesibilidad (Contraste)

Material Theme Builder genera automáticamente 3 niveles:

```kotlin
// Color.kt contiene:
val primaryLight = Color(0xFFA00012)               // Normal
val primaryLightMediumContrast = Color(0xFF8B000E) // Más contraste
val primaryLightHighContrast = Color(0xFF4E0004)   // Máximo contraste
```

Puedes añadir selector de contraste en Theme.kt:

```kotlin
@Composable
fun MarvelHeroesComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    highContrast: Boolean = false,  // ← Nuevo parámetro
    content: @Composable() () -> Unit
) {
    val colorScheme = when {
        highContrast && !darkTheme -> highContrastLightColorScheme
        highContrast && darkTheme -> highContrastDarkColorScheme
        darkTheme -> darkScheme
        else -> lightScheme
    }
    // ...
}
```

### 4.4 Dynamic Color (Android 12+)

Si `dynamicColor = true`, los colores se adaptan al wallpaper:

```kotlin
// Usuario tiene wallpaper azul → app usa tonos azules
// Usuario tiene wallpaper rosa → app usa tonos rosas

// Para deshabilitar y usar TU paleta:
MarvelHeroesComposeTheme(dynamicColor = false) {
    // Siempre usará tu rojo Marvel
}
```

---

## 📝 Resumen Rápido

1. **Theme Builder:** Genera colores automáticamente
2. **ExtendedColors:** Añade colores personalizados (success, warning, etc.)
3. **Prefijo "on":** Color de texto/iconos sobre otro color
4. **Container:** Versión más suave para fondos grandes
5. **Dynamic Color:** Adapta colores al wallpaper del usuario

---

## 🎯 Checklist Final

- [ ] `Color.kt` con paquete correcto
- [ ] `Theme.kt` con paquete correcto
- [ ] `ExtendedColors.kt` creado
- [ ] `CompositionLocalProvider` añadido en Theme.kt
- [ ] Importación en MainActivity.kt correcta
- [ ] Dynamic Color configurado según preferencia
- [ ] Colores extendidos usados en al menos 1 Composable

---

## 🚀 Ejemplo Completo: Header de Marvel

```kotlin
@Composable
fun MarvelHeader() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.extended.heroRed,
        tonalElevation = 4.dp
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.extended.heroGold
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text = "MARVEL HEROES",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.extended.onHeroRed,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
```

---

## 📖 Recursos Adicionales

- [Material 3 Color System](https://m3.material.io/styles/color/system/overview)
- [Theme Builder Web](https://material-foundation.github.io/material-theme-builder/)
- [Figma Plugin](https://www.figma.com/community/plugin/1034969338659738588/Material-Theme-Builder)
- [Compose Colors Guide](https://developer.android.com/jetpack/compose/designsystems/material3)

---

**¡Tu app ahora tiene un sistema de colores profesional y accesible!** 🎨
