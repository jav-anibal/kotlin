# 📚 Mini Curso: Desarrollo de Interfaces con Jetpack Compose
## Guía Completa para Estudiantes

---

## 📖 Tabla de Contenidos

1. [Fundamentos de Jetpack Compose](#1-fundamentos-de-jetpack-compose)
2. [Arquitectura de UI en Android](#2-arquitectura-de-ui-en-android)
3. [Sistema de Theming (Material Design 3)](#3-sistema-de-theming-material-design-3)
4. [Componentes Reutilizables](#4-componentes-reutilizables)
5. [Listas y LazyColumn](#5-listas-y-lazycolumn)
6. [Diseño Responsivo](#6-diseño-responsivo)
7. [Colores Personalizados](#7-colores-personalizados)
8. [Tipografía Personalizada](#8-tipografía-personalizada)
9. [Patrones de Diseño Comunes](#9-patrones-de-diseño-comunes)
10. [Ejercicios Prácticos](#10-ejercicios-prácticos)
11. [Checklist para Examen](#11-checklist-para-examen)

---

## 1. Fundamentos de Jetpack Compose

### 🎯 Conceptos Clave

**¿Qué es Jetpack Compose?**
- Framework **declarativo** para construir UIs en Android
- Reemplaza el sistema antiguo XML + ViewBinding
- Escrito completamente en Kotlin
- UI se describe como **funciones @Composable**

### 📝 Sintaxis Básica

```kotlin
@Composable
fun MiPrimeraUI() {
    Text(text = "Hola Mundo")
}
```

**Puntos importantes para el examen:**
- ✅ Toda función de UI debe tener `@Composable`
- ✅ Los nombres de funciones Composable empiezan con **Mayúscula** (PascalCase)
- ✅ Son funciones que **describen** la UI, no la construyen imperativa mente
- ✅ Se pueden llamar desde otras funciones Composable

### 🔄 Principio de Recomposición

```kotlin
@Composable
fun Contador() {
    var count by remember { mutableStateOf(0) }

    Button(onClick = { count++ }) {
        Text("Clicks: $count")
    }
}
```

**Concepto crítico:**
- Cuando el estado (`count`) cambia, Compose **recompone** (redibuja) automáticamente
- `remember` mantiene el valor entre recomposiciones
- `mutableStateOf` crea un estado observable

---

## 2. Arquitectura de UI en Android

### 📐 Estructura de Capas

```
MarvelHeroesCompose/
├── ui/
│   ├── screens/          ← Pantallas completas
│   ├── components/       ← Componentes reutilizables
│   └── theme/            ← Sistema de temas
├── model/                ← Clases de datos
└── data/                 ← Fuentes de datos
```

### 🏗️ Patrón de Composición

**Principio:** Componentes pequeños → Componentes grandes → Pantallas

```kotlin
// 1. COMPONENTE PEQUEÑO (Atómico)
@Composable
fun UserAvatar(imageUrl: String) {
    Image(painter = painterResource(imageUrl), contentDescription = null)
}

// 2. COMPONENTE MEDIO (Molecular)
@Composable
fun UserCard(user: User) {
    Card {
        Row {
            UserAvatar(user.avatar)
            Text(user.name)
        }
    }
}

// 3. PANTALLA COMPLETA (Organismo)
@Composable
fun UserListScreen(users: List<User>) {
    LazyColumn {
        items(users) { user ->
            UserCard(user)
        }
    }
}
```

**Para el examen, recuerda:**
- ✅ **Screens** = Pantallas completas
- ✅ **Components** = Piezas reutilizables
- ✅ **Theme** = Colores, tipografía, formas

---

## 3. Sistema de Theming (Material Design 3)

### 🎨 Estructura del Tema

```kotlin
@Composable
fun MiAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) darkColorScheme() else lightColorScheme()

    MaterialTheme(
        colorScheme = colorScheme,
        typography = myTypography,
        shapes = myShapes,
        content = content
    )
}
```

### 🌈 Sistema de Colores Material 3

**Colores principales que DEBES conocer:**

| Color | Uso | Ejemplo |
|-------|-----|---------|
| `primary` | Acción principal | Botones importantes |
| `onPrimary` | Texto sobre primary | Texto en botón |
| `primaryContainer` | Fondo suave primary | Card destacada |
| `surface` | Fondos de componentes | Cards, Dialogs |
| `onSurface` | Texto sobre surface | Texto general |
| `background` | Fondo de pantalla | Screen background |
| `error` | Estados de error | Validaciones |

### 📚 Nomenclatura "on" (CRÍTICO para examen)

```kotlin
// ❌ INCORRECTO
Surface(color = MaterialTheme.colorScheme.primary) {
    Text(color = MaterialTheme.colorScheme.primary) // ¡No se verá!
}

// ✅ CORRECTO
Surface(color = MaterialTheme.colorScheme.primary) {
    Text(color = MaterialTheme.colorScheme.onPrimary) // Legible
}
```

**Regla de oro:** `on[Color]` es el color que va **SOBRE** ese color.

### 💡 Acceder a Colores del Tema

```kotlin
@Composable
fun MiComponente() {
    // Dentro de un Composable
    val colorPrimario = MaterialTheme.colorScheme.primary
    val colorTexto = MaterialTheme.colorScheme.onSurface

    Text(
        text = "Hola",
        color = colorTexto  // Usa el color del tema
    )
}
```

---

## 4. Componentes Reutilizables

### 🧩 Anatomía de un Componente

```kotlin
@Composable
fun StandardButton(
    text: String,                          // Parámetro obligatorio
    onClick: () -> Unit,                   // Callback
    modifier: Modifier = Modifier,         // SIEMPRE incluir modifier
    enabled: Boolean = true                // Parámetro opcional
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled
    ) {
        Text(text = text)
    }
}
```

**Buenas prácticas (importante para examen):**
- ✅ `modifier: Modifier = Modifier` como parámetro
- ✅ Parámetros obligatorios primero, opcionales después
- ✅ Nombres descriptivos (`text`, no `t`)
- ✅ Callbacks usan tipos función (`() -> Unit`)

### 📦 Ejemplo: Componente de Card

```kotlin
@Composable
fun HeroCard(
    hero: Hero,
    modifier: Modifier = Modifier,
    onCardClick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        onClick = onCardClick,
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(hero.photo),
                contentDescription = hero.name,
                modifier = Modifier.size(60.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = hero.name,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "Power: ${hero.power}",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}
```

**Elementos a destacar:**
- ✅ `modifier` se pasa al contenedor principal
- ✅ `CardDefaults` para configuraciones por defecto
- ✅ `MaterialTheme.typography` para estilos de texto
- ✅ `Spacer` para separación

---

## 5. Listas y LazyColumn

### 📜 LazyColumn vs Column

**Column:**
- Renderiza TODOS los elementos inmediatamente
- Uso: pocas items (< 10)

**LazyColumn:**
- Renderiza solo elementos visibles (lazy loading)
- Uso: listas grandes o dinámicas

### 🔧 Sintaxis de LazyColumn

```kotlin
@Composable
fun HeroListScreen(heroes: List<Hero>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Opción 1: items con lista
        items(heroes) { hero ->
            HeroCard(hero = hero)
        }

        // Opción 2: items con count
        items(count = heroes.size) { index ->
            HeroCard(hero = heroes[index])
        }

        // Opción 3: itemsIndexed (con índice)
        itemsIndexed(heroes) { index, hero ->
            HeroCard(hero = hero)
            if (index < heroes.size - 1) {
                Divider()
            }
        }
    }
}
```

**Conceptos clave:**
- ✅ `items()` itera sobre una lista
- ✅ `contentPadding` añade padding interno
- ✅ `verticalArrangement.spacedBy()` separa items

### 🎯 Ejemplo Completo: Lista con Header

```kotlin
@Composable
fun HeroListScreen(heroes: List<Hero>) {
    Column(modifier = Modifier.fillMaxSize()) {
        // Header fijo (no hace scroll)
        HeaderComponent(title = "Marvel Heroes")

        // Lista con scroll
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(heroes) { hero ->
                HeroCard(hero)
            }
        }
    }
}
```

---

## 6. Diseño Responsivo

### 📱 Window Size Classes

Android define 3 tamaños de ventana:

| Tamaño | Ancho | Dispositivo |
|--------|-------|-------------|
| **Compact** | < 600dp | Teléfonos (portrait) |
| **Medium** | 600-840dp | Tablets pequeñas, teléfonos (landscape) |
| **Expanded** | > 840dp | Tablets grandes, desplegables |

### 🔍 Detectar Tamaño de Pantalla

```kotlin
@Composable
fun AdaptiveScreen() {
    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass

    when (windowSizeClass.windowWidthSizeClass) {
        WindowWidthSizeClass.COMPACT -> {
            // Vista para teléfonos
            CompactLayout()
        }
        WindowWidthSizeClass.MEDIUM, WindowWidthSizeClass.EXPANDED -> {
            // Vista para tablets
            ExpandedLayout()
        }
    }
}
```

### 📐 Ejemplo: Diseño Adaptativo

```kotlin
@Composable
fun HeroListScreen(heroes: List<Hero>) {
    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass

    when (windowSizeClass.windowWidthSizeClass) {
        WindowWidthSizeClass.COMPACT -> {
            // Columna vertical para teléfonos
            LazyColumn {
                items(heroes) { hero ->
                    HeroCardCompact(hero)  // Card horizontal pequeña
                }
            }
        }
        else -> {
            // Grid para tablets
            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(heroes) { hero ->
                    HeroCardExpanded(hero)  // Card más grande
                }
            }
        }
    }
}
```

---

## 7. Colores Personalizados

### 🎨 Crear Colores Extendidos

**Problema:** Material 3 solo incluye primary, secondary, tertiary, error.
**Solución:** Crear colores extendidos para success, warning, info, etc.

### 📝 Paso 1: Definir Colores (Color.kt)

```kotlin
// En Color.kt
val successLight = Color(0xFF2E7D32)       // Verde
val onSuccessLight = Color(0xFFFFFFFF)     // Blanco sobre verde
val successDark = Color(0xFF66BB6A)        // Verde claro (dark mode)
val onSuccessDark = Color(0xFF000000)      // Negro sobre verde

val warningLight = Color(0xFFF57C00)       // Naranja
val onWarningLight = Color(0xFFFFFFFF)
val warningDark = Color(0xFFFFB74D)
val onWarningDark = Color(0xFF000000)
```

### 📝 Paso 2: Crear ExtendedColors (ExtendedColors.kt)

```kotlin
package com.tuapp.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

// 1. Definir data class con colores personalizados
@Immutable
data class ExtendedColors(
    val success: Color,
    val onSuccess: Color,
    val warning: Color,
    val onWarning: Color,
)

// 2. Crear paletas para light/dark
private val extendedColorsLight = ExtendedColors(
    success = successLight,
    onSuccess = onSuccessLight,
    warning = warningLight,
    onWarning = onWarningLight,
)

private val extendedColorsDark = ExtendedColors(
    success = successDark,
    onSuccess = onSuccessDark,
    warning = warningDark,
    onWarning = onWarningDark,
)

// 3. Crear CompositionLocal
val LocalExtendedColors = staticCompositionLocalOf {
    extendedColorsLight
}

// 4. Extensión para acceso fácil
val ColorScheme.extended: ExtendedColors
    @Composable
    get() = LocalExtendedColors.current
```

### 📝 Paso 3: Proveer en Theme.kt

```kotlin
@Composable
fun MiAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) darkColorScheme() else lightColorScheme()

    // Seleccionar colores extendidos según tema
    val extendedColors = if (darkTheme) extendedColorsDark else extendedColorsLight

    // Proveer colores extendidos
    CompositionLocalProvider(LocalExtendedColors provides extendedColors) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = myTypography,
            content = content
        )
    }
}
```

### 📝 Paso 4: Usar Colores Extendidos

```kotlin
@Composable
fun SuccessButton() {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.extended.success,
            contentColor = MaterialTheme.colorScheme.extended.onSuccess
        ),
        onClick = { }
    ) {
        Text("Guardar")
    }
}
```

**Puntos para el examen:**
- ✅ `CompositionLocal` permite pasar datos sin parámetros
- ✅ `staticCompositionLocalOf` es eficiente para valores estáticos
- ✅ `ColorScheme.extended` es una extensión para acceso limpio

---

## 8. Tipografía Personalizada

### 🔤 Google Fonts en Compose

```kotlin
// Type.kt
package com.tuapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.googlefonts.Font
import com.tuapp.R

// 1. Configurar provider (en res/values/font_provider.xml)
val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

// 2. Definir fuentes
val robotoFont = GoogleFont("Roboto")
val montserratFont = GoogleFont("Montserrat")

// 3. Crear FontFamily
val RobotoFontFamily = FontFamily(
    Font(googleFont = robotoFont, fontProvider = provider)
)

val MontserratFontFamily = FontFamily(
    Font(googleFont = montserratFont, fontProvider = provider)
)

// 4. Crear Typography
val AppTypography = Typography(
    // Headlines (títulos grandes)
    displayLarge = TextStyle(
        fontFamily = MontserratFontFamily,
        fontSize = 57.sp,
        fontWeight = FontWeight.Bold
    ),

    // Títulos de sección
    headlineMedium = TextStyle(
        fontFamily = MontserratFontFamily,
        fontSize = 28.sp,
        fontWeight = FontWeight.SemiBold
    ),

    // Cuerpo de texto
    bodyLarge = TextStyle(
        fontFamily = RobotoFontFamily,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal
    ),

    // Labels de botones
    labelLarge = TextStyle(
        fontFamily = RobotoFontFamily,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium
    )
)
```

### 📚 Escala Tipográfica Material 3

| Estilo | Uso típico |
|--------|-----------|
| `displayLarge/Medium/Small` | Números grandes, texto hero |
| `headlineLarge/Medium/Small` | Títulos de sección |
| `titleLarge/Medium/Small` | Títulos de cards, elementos |
| `bodyLarge/Medium/Small` | Texto de párrafos |
| `labelLarge/Medium/Small` | Botones, tabs |

### 💡 Usar Tipografía del Tema

```kotlin
@Composable
fun ArticuloCard(articulo: Articulo) {
    Card {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = articulo.titulo,
                style = MaterialTheme.typography.headlineSmall  // ← Del tema
            )
            Text(
                text = articulo.contenido,
                style = MaterialTheme.typography.bodyMedium     // ← Del tema
            )
        }
    }
}
```

---

## 9. Patrones de Diseño Comunes

### 🎯 Patrón 1: Screen + ViewModel (NO en este proyecto, pero común)

```kotlin
// ViewModel
class HeroViewModel : ViewModel() {
    private val _heroes = MutableStateFlow<List<Hero>>(emptyList())
    val heroes: StateFlow<List<Hero>> = _heroes.asStateFlow()

    fun loadHeroes() {
        viewModelScope.launch {
            _heroes.value = repository.getHeroes()
        }
    }
}

// Screen
@Composable
fun HeroScreen(viewModel: HeroViewModel = viewModel()) {
    val heroes by viewModel.heroes.collectAsState()

    LazyColumn {
        items(heroes) { hero ->
            HeroCard(hero)
        }
    }
}
```

### 🎯 Patrón 2: Hoisting de Estado

**Principio:** El estado debe vivir en el nivel más bajo común.

```kotlin
// ❌ MAL: Estado interno no controlable
@Composable
fun SearchBar() {
    var query by remember { mutableStateOf("") }
    TextField(
        value = query,
        onValueChange = { query = it }
    )
}

// ✅ BIEN: Estado elevado (hoisted)
@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit
) {
    TextField(
        value = query,
        onValueChange = onQueryChange
    )
}

// Uso
@Composable
fun SearchScreen() {
    var query by remember { mutableStateOf("") }

    Column {
        SearchBar(
            query = query,
            onQueryChange = { query = it }
        )
        Text("Buscando: $query")
    }
}
```

### 🎯 Patrón 3: Composición vs Herencia

**Compose favorece composición sobre herencia.**

```kotlin
// ✅ COMPOSICIÓN (preferido)
@Composable
fun StandardButton(
    text: String,
    icon: ImageVector? = null,
    onClick: () -> Unit
) {
    Button(onClick = onClick) {
        if (icon != null) {
            Icon(icon, contentDescription = null)
            Spacer(Modifier.width(8.dp))
        }
        Text(text)
    }
}

// ❌ HERENCIA (no aplicable en Compose)
// No puedes heredar de @Composable functions
```

### 🎯 Patrón 4: Slot API

```kotlin
@Composable
fun CustomCard(
    header: @Composable () -> Unit,  // Slot para header
    content: @Composable () -> Unit  // Slot para contenido
) {
    Card {
        Column {
            header()
            Divider()
            content()
        }
    }
}

// Uso
CustomCard(
    header = { Text("Título", style = MaterialTheme.typography.titleLarge) },
    content = { Text("Contenido aquí") }
)
```

---

## 10. Ejercicios Prácticos

### 🏋️ Ejercicio 1: Card Personalizada

**Objetivo:** Crear una card de producto con imagen, título, precio y botón.

```kotlin
data class Producto(
    val nombre: String,
    val precio: Double,
    val imagen: Int  // Drawable resource
)

@Composable
fun ProductoCard(
    producto: Producto,
    modifier: Modifier = Modifier,
    onComprarClick: () -> Unit
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // TODO: Imagen del producto
            Image(
                painter = painterResource(producto.imagen),
                contentDescription = producto.nombre,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))

            // TODO: Título del producto
            Text(
                text = producto.nombre,
                style = MaterialTheme.typography.titleMedium
            )

            // TODO: Precio
            Text(
                text = "$${producto.precio}",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(8.dp))

            // TODO: Botón de compra
            Button(
                onClick = onComprarClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Comprar")
            }
        }
    }
}
```

### 🏋️ Ejercicio 2: Lista Filtrable

**Objetivo:** Lista con buscador que filtra en tiempo real.

```kotlin
@Composable
fun ProductosScreen(productos: List<Producto>) {
    var searchQuery by remember { mutableStateOf("") }

    val productosFiltrados = remember(searchQuery, productos) {
        if (searchQuery.isEmpty()) {
            productos
        } else {
            productos.filter {
                it.nombre.contains(searchQuery, ignoreCase = true)
            }
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        // Buscador fijo
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            placeholder = { Text("Buscar productos...") },
            leadingIcon = { Icon(Icons.Default.Search, null) }
        )

        // Lista filtrada
        LazyColumn {
            items(productosFiltrados) { producto ->
                ProductoCard(
                    producto = producto,
                    onComprarClick = { /* TODO */ }
                )
            }
        }
    }
}
```

### 🏋️ Ejercicio 3: Tema Custom

**Objetivo:** Crear un tema con colores de marca.

```kotlin
// 1. Definir colores
private val BrandPrimary = Color(0xFF6200EE)
private val BrandSecondary = Color(0xFF03DAC6)
private val BrandError = Color(0xFFB00020)

// 2. Crear color schemes
private val LightColors = lightColorScheme(
    primary = BrandPrimary,
    secondary = BrandSecondary,
    error = BrandError,
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFFBB86FC),
    secondary = BrandSecondary,
    error = Color(0xFFCF6679),
    background = Color(0xFF121212),
    surface = Color(0xFF121212),
)

// 3. Crear tema
@Composable
fun MiMarcaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}
```

---

## 11. Checklist para Examen

### ✅ Conceptos Fundamentales

- [ ] Entiendo qué es `@Composable`
- [ ] Sé la diferencia entre Column, Row, Box
- [ ] Entiendo el concepto de recomposición
- [ ] Conozco `remember` y `mutableStateOf`
- [ ] Sé usar `Modifier` (padding, size, fillMaxWidth, etc.)

### ✅ Layouts

- [ ] Puedo crear un layout con Column y Row
- [ ] Sé usar `LazyColumn` para listas
- [ ] Conozco `LazyVerticalGrid` para grids
- [ ] Entiendo `Spacer` para separación
- [ ] Sé usar `Arrangement` y `Alignment`

### ✅ Componentes

- [ ] Puedo crear un componente reutilizable
- [ ] Sé pasar parámetros y callbacks
- [ ] Entiendo el patrón `modifier: Modifier = Modifier`
- [ ] Conozco los componentes básicos: Text, Button, Card, Image

### ✅ Theming

- [ ] Entiendo `MaterialTheme`
- [ ] Sé acceder a `MaterialTheme.colorScheme.primary`
- [ ] Conozco la nomenclatura "on" (onPrimary, onSurface)
- [ ] Puedo usar `MaterialTheme.typography`
- [ ] Entiendo light/dark mode

### ✅ Colores Personalizados

- [ ] Sé crear un `ExtendedColors` data class
- [ ] Entiendo `CompositionLocal`
- [ ] Puedo crear una extensión `ColorScheme.extended`
- [ ] Sé proveer colores con `CompositionLocalProvider`

### ✅ Diseño Responsivo

- [ ] Conozco Window Size Classes
- [ ] Sé usar `when` para layouts adaptativos
- [ ] Entiendo Compact, Medium, Expanded

### ✅ Buenas Prácticas

- [ ] Nombres en PascalCase para Composables
- [ ] Siempre incluir `modifier` como parámetro
- [ ] Extraer lógica compleja a funciones
- [ ] Usar `stringResource()` en lugar de hardcodear texto
- [ ] Comentar código cuando sea necesario

---

## 📊 Ejemplo Completo de Examen

**Pregunta típica:** "Crea una pantalla que muestre una lista de libros. Cada libro tiene título, autor y precio. Incluye un header fijo con el título 'Mi Biblioteca'. La lista debe ser scrollable."

### 🎯 Solución Completa:

```kotlin
// 1. MODEL
data class Libro(
    val titulo: String,
    val autor: String,
    val precio: Double,
    val portada: Int  // Drawable resource
)

// 2. DATA SOURCE
object LibrosDataSource {
    fun obtenerLibros() = listOf(
        Libro("El Quijote", "Cervantes", 15.99, R.drawable.quijote),
        Libro("Cien Años de Soledad", "García Márquez", 18.50, R.drawable.cien_anos),
        Libro("1984", "George Orwell", 12.99, R.drawable.mil_novecientos),
    )
}

// 3. COMPONENTE: LibroCard
@Composable
fun LibroCard(
    libro: Libro,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Portada
            Image(
                painter = painterResource(libro.portada),
                contentDescription = libro.titulo,
                modifier = Modifier.size(80.dp),
                contentScale = ContentScale.Crop
            )

            // Info del libro
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = libro.titulo,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = libro.autor,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "$${libro.precio}",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

// 4. COMPONENTE: Header
@Composable
fun BibliotecaHeader(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.primaryContainer,
        shadowElevation = 4.dp
    ) {
        Text(
            text = "Mi Biblioteca",
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            fontWeight = FontWeight.Bold
        )
    }
}

// 5. SCREEN: Pantalla completa
@Composable
fun BibliotecaScreen(
    modifier: Modifier = Modifier
) {
    val libros = remember { LibrosDataSource.obtenerLibros() }

    Column(modifier = modifier.fillMaxSize()) {
        // Header fijo (no hace scroll)
        BibliotecaHeader()

        // Lista scrollable
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(libros) { libro ->
                LibroCard(libro = libro)
            }
        }
    }
}

// 6. TEMA (opcional pero recomendado)
@Composable
fun BibliotecaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        darkColorScheme()
    } else {
        lightColorScheme()
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}

// 7. MAIN ACTIVITY (punto de entrada)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BibliotecaTheme {
                BibliotecaScreen()
            }
        }
    }
}
```

---

## 🎓 Tips para el Examen

### 📝 Estructura de Respuesta

Cuando te pidan crear una interfaz, sigue este orden:

1. **Model/Data Class** - Define las clases de datos
2. **Data Source** - Crea datos de ejemplo (si no los dan)
3. **Componente pequeño** - Card o item individual
4. **Componente grande** - Pantalla con lista
5. **Tema** - Si hay tiempo, personaliza el tema

### 🚀 Código que Siempre Funciona

**Estructura básica de cualquier screen:**

```kotlin
@Composable
fun MiPantallaScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        // Header (opcional)
        Text(
            text = "Título",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )

        // Contenido principal
        LazyColumn {
            // items aquí
        }
    }
}
```

### ⚡ Fragmentos de Código Útiles

**Card básica:**
```kotlin
Card(
    modifier = Modifier.fillMaxWidth().padding(8.dp),
    elevation = CardDefaults.cardElevation(4.dp)
) {
    Column(modifier = Modifier.padding(16.dp)) {
        // Contenido
    }
}
```

**Botón con estilo:**
```kotlin
Button(
    onClick = { },
    modifier = Modifier.fillMaxWidth()
) {
    Text("Acción")
}
```

**Imagen responsiva:**
```kotlin
Image(
    painter = painterResource(R.drawable.imagen),
    contentDescription = null,
    modifier = Modifier.size(100.dp),
    contentScale = ContentScale.Crop
)
```

---

## 🎯 Resumen de 5 Minutos

**Si solo tienes 5 minutos antes del examen, recuerda:**

1. **@Composable** en todas las funciones de UI
2. **Modifier** siempre como parámetro con default `= Modifier`
3. **LazyColumn** para listas largas, **Column** para pocas cosas
4. **MaterialTheme.colorScheme.primary** para colores del tema
5. **MaterialTheme.typography.titleMedium** para estilos de texto
6. **remember { }** para mantener estado entre recomposiciones
7. **Nomenclatura "on"**: `onPrimary` va sobre `primary`
8. Estructura: **Model → Component → Screen → Theme**

---

## 📚 Recursos Adicionales

- **Documentación oficial:** [developer.android.com/jetpack/compose](https://developer.android.com/jetpack/compose)
- **Codelabs:** [developer.android.com/courses/compose-course](https://developer.android.com/courses/compose-course)
- **Material Design 3:** [m3.material.io](https://m3.material.io)
- **Theme Builder:** [material-foundation.github.io/material-theme-builder](https://material-foundation.github.io/material-theme-builder/)

---

## ✨ Palabras Finales

**Desarrollo de interfaces en Compose se basa en 3 pilares:**

1. **Composición** - Construye UI con bloques pequeños
2. **Declarativo** - Describes QUÉ quieres, no CÓMO hacerlo
3. **Reactivo** - La UI se actualiza automáticamente cuando cambia el estado

**Practica estos conceptos y estarás listo para cualquier examen!** 🚀

---

*Creado para estudiantes de Desarrollo de Interfaces - Jetpack Compose*
*Basado en el proyecto Marvel Heroes Compose*
