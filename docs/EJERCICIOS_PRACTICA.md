# 🏋️ Ejercicios Prácticos - Jetpack Compose
## Practica para tu Examen de Desarrollo de Interfaces

---

## 📚 Cómo Usar Esta Guía

1. **Lee el enunciado** del ejercicio
2. **Intenta resolverlo** sin ver la solución
3. **Compara** tu código con la solución
4. **Entiende** las diferencias y mejora tu código

---

## 🟢 NIVEL BÁSICO

### Ejercicio 1: Mi Primera Card

**Enunciado:**
Crea un componente llamado `TareaCard` que muestre:
- Título de la tarea
- Descripción
- Un checkbox (usa Icon con Icons.Default.CheckBox)

**Datos:**
```kotlin
data class Tarea(
    val titulo: String,
    val descripcion: String,
    val completada: Boolean
)
```

**Lo que debes crear:**
- Componente `TareaCard`
- Usar Card de Material 3
- Mostrar los 3 datos

---

#### ✅ Solución Ejercicio 1

```kotlin
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckBox
import androidx.compose.material.icons.filled.CheckBoxOutlineBlank
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class Tarea(
    val titulo: String,
    val descripcion: String,
    val completada: Boolean
)

@Composable
fun TareaCard(
    tarea: Tarea,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Checkbox icon
            Icon(
                imageVector = if (tarea.completada) {
                    Icons.Default.CheckBox
                } else {
                    Icons.Default.CheckBoxOutlineBlank
                },
                contentDescription = if (tarea.completada) "Completada" else "No completada",
                tint = if (tarea.completada) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.onSurfaceVariant
                }
            )

            // Información de la tarea
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = tarea.titulo,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = tarea.descripcion,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

// Preview para probar
@Composable
fun TareaCardPreview() {
    MaterialTheme {
        Column {
            TareaCard(
                tarea = Tarea("Estudiar Compose", "Repasar layouts", false)
            )
            TareaCard(
                tarea = Tarea("Hacer ejercicios", "Completar 5 ejercicios", true)
            )
        }
    }
}
```

**Puntos clave:**
- ✅ Card con padding y elevation
- ✅ Row para layout horizontal
- ✅ Icon condicional según estado
- ✅ Column con weight(1f) para ocupar espacio restante
- ✅ Uso de MaterialTheme para estilos

---

### Ejercicio 2: Lista Simple

**Enunciado:**
Crea una pantalla `TareasScreen` que muestre una lista de tareas usando LazyColumn.

**Datos de prueba:**
```kotlin
val tareasDePrueba = listOf(
    Tarea("Estudiar Compose", "Repasar layouts y componentes", false),
    Tarea("Hacer ejercicios", "Completar 5 ejercicios prácticos", true),
    Tarea("Crear proyecto", "Aplicación de lista de contactos", false)
)
```

---

#### ✅ Solución Ejercicio 2

```kotlin
@Composable
fun TareasScreen(
    tareas: List<Tarea>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(tareas) { tarea ->
            TareaCard(tarea = tarea)
        }
    }
}

// Para probar en MainActivity
@Composable
fun TareasApp() {
    val tareas = remember {
        listOf(
            Tarea("Estudiar Compose", "Repasar layouts y componentes", false),
            Tarea("Hacer ejercicios", "Completar 5 ejercicios prácticos", true),
            Tarea("Crear proyecto", "Aplicación de lista de contactos", false)
        )
    }

    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            TareasScreen(tareas = tareas)
        }
    }
}
```

**Puntos clave:**
- ✅ LazyColumn en lugar de Column para rendimiento
- ✅ contentPadding para espaciado interno
- ✅ verticalArrangement.spacedBy() para separar items
- ✅ Surface como contenedor principal

---

### Ejercicio 3: Header + Lista

**Enunciado:**
Modifica `TareasScreen` para añadir un header fijo (que no haga scroll) con:
- Título: "Mis Tareas"
- Subtítulo: "X tareas pendientes" (cuenta las no completadas)

---

#### ✅ Solución Ejercicio 3

```kotlin
@Composable
fun TareasScreen(
    tareas: List<Tarea>,
    modifier: Modifier = Modifier
) {
    // Calcular tareas pendientes
    val tareasPendientes = tareas.count { !it.completada }

    Column(modifier = modifier.fillMaxSize()) {
        // Header fijo (no hace scroll)
        TareasHeader(
            totalTareas = tareas.size,
            tareasPendientes = tareasPendientes
        )

        // Lista scrollable
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(tareas) { tarea ->
                TareaCard(tarea = tarea)
            }
        }
    }
}

@Composable
fun TareasHeader(
    totalTareas: Int,
    tareasPendientes: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.primaryContainer,
        shadowElevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Mis Tareas",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Text(
                text = "$tareasPendientes de $totalTareas pendientes",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}
```

**Puntos clave:**
- ✅ Column para separar header fijo de lista scrollable
- ✅ count() para calcular tareas pendientes
- ✅ Surface con shadowElevation para efecto de profundidad
- ✅ Componente Header separado (reutilizable)

---

## 🟡 NIVEL INTERMEDIO

### Ejercicio 4: Estado Interactivo

**Enunciado:**
Haz que las tareas sean clickeables y cambien su estado (completada/no completada) al hacer click.

**Pistas:**
- Usa `remember { mutableStateOf() }` para mantener el estado
- Convierte la lista en mutableStateListOf()
- Añade `onClick` a la Card

---

#### ✅ Solución Ejercicio 4

```kotlin
@Composable
fun TareasScreenInteractiva(modifier: Modifier = Modifier) {
    // Estado mutable de la lista
    val tareas = remember {
        mutableStateListOf(
            Tarea("Estudiar Compose", "Repasar layouts y componentes", false),
            Tarea("Hacer ejercicios", "Completar 5 ejercicios prácticos", true),
            Tarea("Crear proyecto", "Aplicación de lista de contactos", false)
        )
    }

    val tareasPendientes = tareas.count { !it.completada }

    Column(modifier = modifier.fillMaxSize()) {
        TareasHeader(
            totalTareas = tareas.size,
            tareasPendientes = tareasPendientes
        )

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(tareas) { index, tarea ->
                TareaCardClickeable(
                    tarea = tarea,
                    onClick = {
                        // Invertir estado de completada
                        tareas[index] = tarea.copy(completada = !tarea.completada)
                    }
                )
            }
        }
    }
}

@Composable
fun TareaCardClickeable(
    tarea: Tarea,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(2.dp),
        onClick = onClick  // ← Hacer card clickeable
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Icon(
                imageVector = if (tarea.completada) {
                    Icons.Default.CheckBox
                } else {
                    Icons.Default.CheckBoxOutlineBlank
                },
                contentDescription = null,
                tint = if (tarea.completada) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.onSurfaceVariant
                }
            )

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = tarea.titulo,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = tarea.descripcion,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
```

**Puntos clave:**
- ✅ `mutableStateListOf()` para lista mutable
- ✅ `itemsIndexed()` para obtener índice
- ✅ `copy()` para crear nueva instancia con cambio
- ✅ `onClick` en Card para hacerla interactiva
- ✅ La UI se recompone automáticamente al cambiar el estado

---

### Ejercicio 5: Filtrar Lista

**Enunciado:**
Añade un TextField arriba de la lista para filtrar tareas por título en tiempo real.

---

#### ✅ Solución Ejercicio 5

```kotlin
@Composable
fun TareasScreenConFiltro(modifier: Modifier = Modifier) {
    // Estado de la búsqueda
    var textoBusqueda by remember { mutableStateOf("") }

    // Tareas originales
    val tareasOriginales = remember {
        mutableStateListOf(
            Tarea("Estudiar Compose", "Repasar layouts y componentes", false),
            Tarea("Hacer ejercicios", "Completar 5 ejercicios prácticos", true),
            Tarea("Crear proyecto", "Aplicación de lista de contactos", false),
            Tarea("Leer documentación", "Material Design 3", false),
            Tarea("Practicar Kotlin", "Ejercicios de colecciones", true)
        )
    }

    // Tareas filtradas (se recalcula cuando cambia textoBusqueda o tareasOriginales)
    val tareasFiltradas = remember(textoBusqueda, tareasOriginales.toList()) {
        if (textoBusqueda.isEmpty()) {
            tareasOriginales
        } else {
            tareasOriginales.filter {
                it.titulo.contains(textoBusqueda, ignoreCase = true) ||
                it.descripcion.contains(textoBusqueda, ignoreCase = true)
            }
        }
    }

    Column(modifier = modifier.fillMaxSize()) {
        // Header
        TareasHeader(
            totalTareas = tareasOriginales.size,
            tareasPendientes = tareasOriginales.count { !it.completada }
        )

        // Buscador
        OutlinedTextField(
            value = textoBusqueda,
            onValueChange = { textoBusqueda = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            placeholder = { Text("Buscar tareas...") },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = null)
            },
            trailingIcon = {
                if (textoBusqueda.isNotEmpty()) {
                    IconButton(onClick = { textoBusqueda = "" }) {
                        Icon(Icons.Default.Clear, contentDescription = "Limpiar")
                    }
                }
            },
            singleLine = true
        )

        // Lista filtrada
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            if (tareasFiltradas.isEmpty()) {
                item {
                    Text(
                        text = "No se encontraron tareas",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(32.dp),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            } else {
                items(tareasFiltradas) { tarea ->
                    TareaCard(tarea = tarea)
                }
            }
        }
    }
}
```

**Puntos clave:**
- ✅ `remember(key1, key2)` para recalcular cuando cambian las keys
- ✅ `filter()` para filtrar lista
- ✅ `contains(ignoreCase = true)` para búsqueda case-insensitive
- ✅ `trailingIcon` con botón para limpiar búsqueda
- ✅ Mensaje cuando no hay resultados

---

### Ejercicio 6: Diseño Responsivo

**Enunciado:**
Haz que la lista muestre:
- 1 columna en teléfonos (COMPACT)
- 2 columnas en tablets (MEDIUM/EXPANDED)

Usa Window Size Classes.

---

#### ✅ Solución Ejercicio 6

```kotlin
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items

@Composable
fun TareasScreenResponsiva(modifier: Modifier = Modifier) {
    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass

    val tareas = remember {
        listOf(
            Tarea("Estudiar Compose", "Repasar layouts y componentes", false),
            Tarea("Hacer ejercicios", "Completar 5 ejercicios prácticos", true),
            Tarea("Crear proyecto", "Aplicación de lista de contactos", false),
            Tarea("Leer documentación", "Material Design 3", false),
            Tarea("Practicar Kotlin", "Ejercicios de colecciones", true),
            Tarea("Revisar código", "Pull request del equipo", false)
        )
    }

    Column(modifier = modifier.fillMaxSize()) {
        TareasHeader(
            totalTareas = tareas.size,
            tareasPendientes = tareas.count { !it.completada }
        )

        when (windowSizeClass.windowWidthSizeClass) {
            WindowWidthSizeClass.COMPACT -> {
                // Teléfono: 1 columna
                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(tareas) { tarea ->
                        TareaCard(tarea = tarea)
                    }
                }
            }
            else -> {
                // Tablet: 2 columnas
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(tareas) { tarea ->
                        TareaCard(tarea = tarea)
                    }
                }
            }
        }
    }
}
```

**Puntos clave:**
- ✅ `currentWindowAdaptiveInfo()` para detectar tamaño
- ✅ `when` para diferentes layouts
- ✅ `LazyVerticalGrid` para grid de 2 columnas
- ✅ `GridCells.Fixed(2)` para columnas fijas
- ✅ `horizontalArrangement` para espaciar columnas

---

## 🔴 NIVEL AVANZADO

### Ejercicio 7: Tema Personalizado

**Enunciado:**
Crea un tema custom "ProductivityTheme" con:
- Color primario: #FF6B35 (naranja)
- Color secundario: #004E89 (azul oscuro)
- Soporte para light/dark mode

---

#### ✅ Solución Ejercicio 7

**Color.kt:**
```kotlin
package com.tuapp.ui.theme

import androidx.compose.ui.graphics.Color

// Light Mode
val primaryLight = Color(0xFFFF6B35)      // Naranja
val onPrimaryLight = Color(0xFFFFFFFF)    // Blanco
val primaryContainerLight = Color(0xFFFFDAD1)
val onPrimaryContainerLight = Color(0xFF3E1000)

val secondaryLight = Color(0xFF004E89)    // Azul oscuro
val onSecondaryLight = Color(0xFFFFFFFF)
val secondaryContainerLight = Color(0xFFB8D4FF)
val onSecondaryContainerLight = Color(0xFF00172D)

// Dark Mode
val primaryDark = Color(0xFFFFB59A)       // Naranja claro
val onPrimaryDark = Color(0xFF5F1600)
val primaryContainerDark = Color(0xFF8B2800)
val onPrimaryContainerDark = Color(0xFFFFDAD1)

val secondaryDark = Color(0xFF6AAEFF)     // Azul claro
val onSecondaryDark = Color(0xFF00274F)
val secondaryContainerDark = Color(0xFF00396E)
val onSecondaryContainerDark = Color(0xFFB8D4FF)
```

**Theme.kt:**
```kotlin
package com.tuapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
)

private val DarkColorScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
)

@Composable
fun ProductivityTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography, // Del archivo Type.kt
        content = content
    )
}
```

**Uso en MainActivity:**
```kotlin
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductivityTheme {
                TareasApp()
            }
        }
    }
}
```

---

### Ejercicio 8: Colores Extendidos

**Enunciado:**
Añade colores personalizados al tema:
- `urgent` (Color(0xFFD32F2F)) - Para tareas urgentes
- `completed` (Color(0xFF388E3C)) - Para tareas completadas

Úsalos en las cards según el estado de la tarea.

---

#### ✅ Solución Ejercicio 8

**ExtendedColors.kt:**
```kotlin
package com.tuapp.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class ExtendedColors(
    val urgent: Color,
    val onUrgent: Color,
    val completed: Color,
    val onCompleted: Color,
)

// Light mode
private val extendedColorsLight = ExtendedColors(
    urgent = Color(0xFFD32F2F),       // Rojo
    onUrgent = Color(0xFFFFFFFF),
    completed = Color(0xFF388E3C),    // Verde
    onCompleted = Color(0xFFFFFFFF),
)

// Dark mode
private val extendedColorsDark = ExtendedColors(
    urgent = Color(0xFFEF5350),       // Rojo claro
    onUrgent = Color(0xFF000000),
    completed = Color(0xFF66BB6A),    // Verde claro
    onCompleted = Color(0xFF000000),
)

val LocalExtendedColors = staticCompositionLocalOf {
    extendedColorsLight
}

val ColorScheme.extended: ExtendedColors
    @Composable
    get() = LocalExtendedColors.current
```

**Actualizar Theme.kt:**
```kotlin
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun ProductivityTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val extendedColors = if (darkTheme) extendedColorsDark else extendedColorsLight

    CompositionLocalProvider(LocalExtendedColors provides extendedColors) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}
```

**Actualizar data class:**
```kotlin
data class Tarea(
    val titulo: String,
    val descripcion: String,
    val completada: Boolean,
    val urgente: Boolean = false  // ← Nuevo campo
)
```

**Card con colores extendidos:**
```kotlin
@Composable
fun TareaCardConEstado(
    tarea: Tarea,
    modifier: Modifier = Modifier
) {
    // Determinar color según estado
    val colorFondo = when {
        tarea.completada -> MaterialTheme.colorScheme.extended.completed
        tarea.urgente -> MaterialTheme.colorScheme.extended.urgent
        else -> MaterialTheme.colorScheme.surface
    }

    val colorTexto = when {
        tarea.completada -> MaterialTheme.colorScheme.extended.onCompleted
        tarea.urgente -> MaterialTheme.colorScheme.extended.onUrgent
        else -> MaterialTheme.colorScheme.onSurface
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorFondo
        )
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Icon(
                imageVector = when {
                    tarea.completada -> Icons.Default.CheckCircle
                    tarea.urgente -> Icons.Default.Warning
                    else -> Icons.Default.Circle
                },
                contentDescription = null,
                tint = colorTexto
            )

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = tarea.titulo,
                    style = MaterialTheme.typography.titleMedium,
                    color = colorTexto
                )
                Text(
                    text = tarea.descripcion,
                    style = MaterialTheme.typography.bodySmall,
                    color = colorTexto.copy(alpha = 0.8f)
                )
            }
        }
    }
}
```

**Datos de prueba:**
```kotlin
val tareasConEstado = listOf(
    Tarea("Entregar proyecto", "Fecha límite hoy", false, urgente = true),
    Tarea("Estudiar Compose", "Repasar layouts", false, urgente = false),
    Tarea("Hacer ejercicios", "Completado", true, urgente = false)
)
```

---

### Ejercicio 9: Proyecto Completo

**Enunciado:**
Crea una aplicación completa de "Contactos" con:
1. Data class Contacto (nombre, teléfono, email, foto)
2. Lista con LazyColumn
3. Filtrado por nombre
4. Diseño responsivo (1 o 2 columnas)
5. Tema personalizado
6. Cards con colores del tema

---

#### ✅ Solución Ejercicio 9 (Proyecto Completo)

**1. Model/Contacto.kt:**
```kotlin
package com.contactosapp.model

data class Contacto(
    val id: Int,
    val nombre: String,
    val telefono: String,
    val email: String,
    val foto: Int  // Drawable resource
)
```

**2. Data/ContactosDataSource.kt:**
```kotlin
package com.contactosapp.data

import com.contactosapp.R
import com.contactosapp.model.Contacto

object ContactosDataSource {
    fun obtenerContactos() = listOf(
        Contacto(1, "Ana García", "+34 612 345 678", "ana@email.com", R.drawable.avatar_1),
        Contacto(2, "Carlos López", "+34 623 456 789", "carlos@email.com", R.drawable.avatar_2),
        Contacto(3, "María Martínez", "+34 634 567 890", "maria@email.com", R.drawable.avatar_3),
        Contacto(4, "Juan Pérez", "+34 645 678 901", "juan@email.com", R.drawable.avatar_4),
        Contacto(5, "Laura Sánchez", "+34 656 789 012", "laura@email.com", R.drawable.avatar_5),
        Contacto(6, "David Rodríguez", "+34 667 890 123", "david@email.com", R.drawable.avatar_6),
    )
}
```

**3. UI/Components/ContactoCard.kt:**
```kotlin
package com.contactosapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.contactosapp.model.Contacto

@Composable
fun ContactoCard(
    contacto: Contacto,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Avatar circular
            Image(
                painter = painterResource(contacto.foto),
                contentDescription = contacto.nombre,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            // Información del contacto
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = contacto.nombre,
                    style = MaterialTheme.typography.titleMedium
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Phone,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = contacto.telefono,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = contacto.email,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}
```

**4. UI/Screens/ContactosScreen.kt:**
```kotlin
package com.contactosapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.contactosapp.data.ContactosDataSource
import com.contactosapp.model.Contacto
import com.contactosapp.ui.components.ContactoCard

@Composable
fun ContactosScreen(modifier: Modifier = Modifier) {
    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass

    var textoBusqueda by remember { mutableStateOf("") }

    val contactos = remember { ContactosDataSource.obtenerContactos() }

    val contactosFiltrados = remember(textoBusqueda) {
        if (textoBusqueda.isEmpty()) {
            contactos
        } else {
            contactos.filter {
                it.nombre.contains(textoBusqueda, ignoreCase = true) ||
                it.telefono.contains(textoBusqueda) ||
                it.email.contains(textoBusqueda, ignoreCase = true)
            }
        }
    }

    Column(modifier = modifier.fillMaxSize()) {
        // Header
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.primaryContainer,
            shadowElevation = 4.dp
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Contactos",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Text(
                    text = "${contactos.size} contactos",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }

        // Buscador
        OutlinedTextField(
            value = textoBusqueda,
            onValueChange = { textoBusqueda = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            placeholder = { Text("Buscar contactos...") },
            leadingIcon = { Icon(Icons.Default.Search, null) },
            trailingIcon = {
                if (textoBusqueda.isNotEmpty()) {
                    IconButton(onClick = { textoBusqueda = "" }) {
                        Icon(Icons.Default.Clear, "Limpiar")
                    }
                }
            },
            singleLine = true
        )

        // Lista adaptativa
        when (windowSizeClass.windowWidthSizeClass) {
            WindowWidthSizeClass.COMPACT -> {
                // 1 columna en teléfonos
                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(contactosFiltrados) { contacto ->
                        ContactoCard(contacto = contacto)
                    }
                }
            }
            else -> {
                // 2 columnas en tablets
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(contactosFiltrados) { contacto ->
                        ContactoCard(contacto = contacto)
                    }
                }
            }
        }
    }
}
```

**5. MainActivity.kt:**
```kotlin
package com.contactosapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.contactosapp.ui.screens.ContactosScreen
import com.contactosapp.ui.theme.ContactosAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContactosAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ContactosScreen()
                }
            }
        }
    }
}
```

---

## ✅ Autoevaluación

Después de completar estos ejercicios, deberías poder:

- [x] Crear data classes
- [x] Diseñar componentes reutilizables con Card, Row, Column
- [x] Implementar LazyColumn y LazyVerticalGrid
- [x] Gestionar estado con remember y mutableStateOf
- [x] Filtrar listas en tiempo real
- [x] Crear diseños responsivos con Window Size Classes
- [x] Implementar temas personalizados
- [x] Usar colores extendidos con CompositionLocal
- [x] Estructurar un proyecto completo

---

## 🎯 Próximos Pasos

1. **Practica** estos ejercicios hasta dominarlos
2. **Modifica** las soluciones con tus propias ideas
3. **Crea** tu propio proyecto desde cero
4. **Combina** conceptos de diferentes ejercicios

---

## 💡 Tips Finales

- **No copies y pegues**: Escribe el código a mano para aprenderlo mejor
- **Experimenta**: Cambia colores, tamaños, layouts
- **Debuggea**: Si algo no funciona, lee el error y busca la solución
- **Consulta** las guías rápidas cuando necesites recordar sintaxis

---

*Ejercicios creados para preparación de examen - Jetpack Compose*
*Nivel: Básico a Avanzado*
