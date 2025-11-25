# 🚀 Guía Rápida para Examen - Jetpack Compose
## Cheatsheet de Desarrollo de Interfaces

---

## ⚡ Sintaxis Básica

### Composable Mínimo
```kotlin
@Composable
fun MiComponente() {
    Text("Hola")
}
```

### Con Parámetros
```kotlin
@Composable
fun MiComponente(
    texto: String,
    modifier: Modifier = Modifier
) {
    Text(text = texto, modifier = modifier)
}
```

---

## 📐 Layouts Esenciales

### Column (Vertical)
```kotlin
Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,      // Top, Center, Bottom, SpaceBetween
    horizontalAlignment = Alignment.CenterHorizontally  // Start, Center, End
) {
    Text("Item 1")
    Text("Item 2")
}
```

### Row (Horizontal)
```kotlin
Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceBetween,  // Start, Center, End, SpaceAround
    verticalAlignment = Alignment.CenterVertically      // Top, Center, Bottom
) {
    Text("Izquierda")
    Text("Derecha")
}
```

### Box (Superposición)
```kotlin
Box(
    modifier = Modifier.size(200.dp),
    contentAlignment = Alignment.Center  // TopStart, Center, BottomEnd, etc.
) {
    Image(...)      // Fondo
    Text("Sobre")   // Encima
}
```

---

## 📜 Listas

### Column Simple (Pocos items)
```kotlin
Column {
    items.forEach { item ->
        Text(item)
    }
}
```

### LazyColumn (Muchos items)
```kotlin
LazyColumn {
    items(listaDeItems) { item ->
        Text(item.nombre)
    }
}
```

### LazyColumn con Índice
```kotlin
LazyColumn {
    itemsIndexed(lista) { index, item ->
        Text("$index: ${item.nombre}")
    }
}
```

### LazyVerticalGrid
```kotlin
LazyVerticalGrid(
    columns = GridCells.Fixed(2)  // 2 columnas
) {
    items(productos) { producto ->
        ProductoCard(producto)
    }
}
```

---

## 🎨 Modificadores Comunes

```kotlin
Modifier
    .fillMaxSize()           // Ocupa todo el espacio disponible
    .fillMaxWidth()          // Ancho completo
    .fillMaxHeight()         // Alto completo
    .size(100.dp)            // Tamaño fijo
    .width(200.dp)           // Ancho fijo
    .height(150.dp)          // Alto fijo
    .padding(16.dp)          // Padding uniforme
    .padding(horizontal = 16.dp, vertical = 8.dp)
    .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)
    .background(Color.Red)   // Color de fondo
    .clip(RoundedCornerShape(8.dp))  // Bordes redondeados
    .clickable { }           // Hacer clickeable
    .weight(1f)              // En Row/Column: toma espacio proporcional
```

---

## 🧩 Componentes Material 3

### Text
```kotlin
Text(
    text = "Hola Mundo",
    style = MaterialTheme.typography.headlineMedium,
    color = MaterialTheme.colorScheme.primary,
    fontWeight = FontWeight.Bold,
    fontSize = 20.sp,
    textAlign = TextAlign.Center,
    maxLines = 2,
    overflow = TextOverflow.Ellipsis
)
```

### Button
```kotlin
Button(
    onClick = { /* Acción */ },
    modifier = Modifier.fillMaxWidth(),
    enabled = true,
    colors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary
    )
) {
    Text("Click Me")
}
```

### Card
```kotlin
Card(
    modifier = Modifier.fillMaxWidth(),
    elevation = CardDefaults.cardElevation(4.dp),
    colors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.surface
    ),
    onClick = { }  // Opcional
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Contenido")
    }
}
```

### Image
```kotlin
Image(
    painter = painterResource(R.drawable.imagen),
    contentDescription = "Descripción",
    modifier = Modifier.size(100.dp),
    contentScale = ContentScale.Crop  // Crop, Fit, FillBounds
)
```

### TextField
```kotlin
var texto by remember { mutableStateOf("") }

OutlinedTextField(
    value = texto,
    onValueChange = { texto = it },
    label = { Text("Nombre") },
    placeholder = { Text("Ingresa tu nombre") },
    leadingIcon = { Icon(Icons.Default.Person, null) },
    singleLine = true,
    modifier = Modifier.fillMaxWidth()
)
```

### Surface
```kotlin
Surface(
    modifier = Modifier.fillMaxWidth(),
    color = MaterialTheme.colorScheme.primaryContainer,
    shadowElevation = 4.dp,
    shape = MaterialTheme.shapes.medium
) {
    Text("Contenido", modifier = Modifier.padding(16.dp))
}
```

---

## 🎨 Colores del Tema

### Acceder a Colores
```kotlin
MaterialTheme.colorScheme.primary           // Color principal
MaterialTheme.colorScheme.onPrimary         // Texto sobre primary
MaterialTheme.colorScheme.primaryContainer  // Container suave
MaterialTheme.colorScheme.secondary         // Color secundario
MaterialTheme.colorScheme.tertiary          // Color terciario
MaterialTheme.colorScheme.surface           // Fondo de componentes
MaterialTheme.colorScheme.onSurface         // Texto sobre surface
MaterialTheme.colorScheme.background        // Fondo de pantalla
MaterialTheme.colorScheme.error             // Color de error
```

### Regla "on"
```kotlin
// ✅ CORRECTO
Surface(color = MaterialTheme.colorScheme.primary) {
    Text(color = MaterialTheme.colorScheme.onPrimary)
}

// ❌ INCORRECTO (no se verá)
Surface(color = MaterialTheme.colorScheme.primary) {
    Text(color = MaterialTheme.colorScheme.primary)
}
```

---

## 🔤 Tipografía del Tema

```kotlin
MaterialTheme.typography.displayLarge      // 57sp - Títulos hero
MaterialTheme.typography.displayMedium     // 45sp
MaterialTheme.typography.displaySmall      // 36sp

MaterialTheme.typography.headlineLarge     // 32sp - Títulos de sección
MaterialTheme.typography.headlineMedium    // 28sp
MaterialTheme.typography.headlineSmall     // 24sp

MaterialTheme.typography.titleLarge        // 22sp - Títulos de cards
MaterialTheme.typography.titleMedium       // 16sp
MaterialTheme.typography.titleSmall        // 14sp

MaterialTheme.typography.bodyLarge         // 16sp - Texto principal
MaterialTheme.typography.bodyMedium        // 14sp
MaterialTheme.typography.bodySmall         // 12sp

MaterialTheme.typography.labelLarge        // 14sp - Botones
MaterialTheme.typography.labelMedium       // 12sp
MaterialTheme.typography.labelSmall        // 11sp
```

---

## 🔄 Estado

### remember (estado local)
```kotlin
@Composable
fun Contador() {
    var count by remember { mutableStateOf(0) }

    Button(onClick = { count++ }) {
        Text("Clicks: $count")
    }
}
```

### Estado Elevado (Hoisting)
```kotlin
@Composable
fun PantallaConEstado() {
    var texto by remember { mutableStateOf("") }

    Column {
        CampoTexto(
            valor = texto,
            onCambio = { texto = it }
        )
        Text("Escribiste: $texto")
    }
}

@Composable
fun CampoTexto(
    valor: String,
    onCambio: (String) -> Unit
) {
    TextField(value = valor, onValueChange = onCambio)
}
```

---

## 📱 Diseño Responsivo

### Window Size Classes
```kotlin
@Composable
fun PantallaAdaptativa() {
    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass

    when (windowSizeClass.windowWidthSizeClass) {
        WindowWidthSizeClass.COMPACT -> {
            // Teléfono vertical
            VistaCompacta()
        }
        WindowWidthSizeClass.MEDIUM -> {
            // Tablet pequeña o teléfono horizontal
            VistaMedium()
        }
        WindowWidthSizeClass.EXPANDED -> {
            // Tablet grande
            VistaExpandida()
        }
    }
}
```

---

## 🎯 Patrón Completo: Lista con Card

```kotlin
// 1. Data Class
data class Item(val id: Int, val nombre: String, val precio: Double)

// 2. Card Component
@Composable
fun ItemCard(item: Item, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = item.nombre,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "$${item.precio}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Button(onClick = { }) {
                Text("Ver")
            }
        }
    }
}

// 3. Screen with List
@Composable
fun ItemsScreen(items: List<Item>) {
    Column(modifier = Modifier.fillMaxSize()) {
        // Header fijo
        Text(
            text = "Mis Items",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )

        // Lista scrollable
        LazyColumn {
            items(items) { item ->
                ItemCard(item = item)
            }
        }
    }
}
```

---

## 🎨 Crear Tema Custom

### Color.kt
```kotlin
val primaryLight = Color(0xFF6200EE)
val onPrimaryLight = Color(0xFFFFFFFF)
val primaryDark = Color(0xFFBB86FC)
val onPrimaryDark = Color(0xFF000000)
```

### Theme.kt
```kotlin
private val LightColors = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
)

private val DarkColors = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
)

@Composable
fun MiAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}
```

---

## 🔧 Colores Extendidos (Avanzado)

### ExtendedColors.kt
```kotlin
@Immutable
data class ExtendedColors(
    val success: Color,
    val onSuccess: Color,
)

val LocalExtendedColors = staticCompositionLocalOf {
    ExtendedColors(success = Color.Green, onSuccess = Color.White)
}

val ColorScheme.extended: ExtendedColors
    @Composable
    get() = LocalExtendedColors.current
```

### Proveer en Theme.kt
```kotlin
@Composable
fun MiAppTheme(content: @Composable () -> Unit) {
    val extendedColors = ExtendedColors(
        success = Color(0xFF2E7D32),
        onSuccess = Color.White
    )

    CompositionLocalProvider(LocalExtendedColors provides extendedColors) {
        MaterialTheme(
            colorScheme = myColorScheme,
            content = content
        )
    }
}
```

### Usar
```kotlin
Button(
    colors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.extended.success
    )
) { Text("Éxito") }
```

---

## 📋 Estructura de Proyecto

```
app/src/main/java/com/tuapp/
├── model/
│   └── Item.kt                    // Data classes
├── data/
│   └── ItemsDataSource.kt         // Datos de prueba
├── ui/
│   ├── components/
│   │   ├── ItemCard.kt            // Componentes reutilizables
│   │   └── CustomButton.kt
│   ├── screens/
│   │   ├── HomeScreen.kt          // Pantallas completas
│   │   └── DetailScreen.kt
│   └── theme/
│       ├── Color.kt               // Colores
│       ├── Type.kt                // Tipografía
│       ├── Theme.kt               // Tema principal
│       └── ExtendedColors.kt      // Colores custom (opcional)
└── MainActivity.kt
```

---

## ✅ Checklist Pre-Examen

### Sintaxis Básica
- [ ] Sé escribir `@Composable`
- [ ] Conozco Column, Row, Box
- [ ] Sé usar Modifier (padding, size, fillMaxWidth)

### Listas
- [ ] Puedo crear una LazyColumn
- [ ] Sé usar `items(lista)`
- [ ] Entiendo la diferencia Column vs LazyColumn

### Componentes
- [ ] Puedo crear un componente con parámetros
- [ ] Sé usar Card, Text, Button, Image
- [ ] Siempre incluyo `modifier: Modifier = Modifier`

### Theming
- [ ] Accedo a colores con `MaterialTheme.colorScheme.primary`
- [ ] Entiendo la nomenclatura "on" (onPrimary, onSurface)
- [ ] Uso tipografía con `MaterialTheme.typography.titleMedium`

### Estado
- [ ] Sé usar `remember { mutableStateOf() }`
- [ ] Entiendo hoisting de estado
- [ ] Puedo crear callbacks `onXClick: () -> Unit`

---

## 🎯 Preguntas Típicas de Examen

### Pregunta 1: "Crea una lista de productos"
**Respuesta:**
```kotlin
data class Producto(val nombre: String, val precio: Double)

@Composable
fun ProductosScreen(productos: List<Producto>) {
    LazyColumn {
        items(productos) { producto ->
            Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                Row(modifier = Modifier.padding(16.dp)) {
                    Text(producto.nombre)
                    Spacer(Modifier.weight(1f))
                    Text("$${producto.precio}")
                }
            }
        }
    }
}
```

### Pregunta 2: "Añade un header fijo a la lista"
**Respuesta:**
```kotlin
Column(modifier = Modifier.fillMaxSize()) {
    Text(
        text = "Productos",
        style = MaterialTheme.typography.headlineMedium,
        modifier = Modifier.padding(16.dp)
    )
    LazyColumn {
        // items aquí
    }
}
```

### Pregunta 3: "Haz que la card sea clickeable"
**Respuesta:**
```kotlin
@Composable
fun ProductoCard(
    producto: Producto,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick  // ← Añadir esto
    ) {
        // Contenido
    }
}
```

---

## 🚨 Errores Comunes

### ❌ Olvidar @Composable
```kotlin
// MAL
fun MiUI() {
    Text("Hola")  // ERROR: llamada a Composable fuera de contexto
}

// BIEN
@Composable
fun MiUI() {
    Text("Hola")
}
```

### ❌ No incluir modifier
```kotlin
// MENOS FLEXIBLE
@Composable
fun MiCard(texto: String) {
    Card { Text(texto) }
}

// MEJOR (permite customización)
@Composable
fun MiCard(texto: String, modifier: Modifier = Modifier) {
    Card(modifier = modifier) { Text(texto) }
}
```

### ❌ Color hardcodeado
```kotlin
// MAL
Text(text = "Hola", color = Color.Red)

// BIEN
Text(text = "Hola", color = MaterialTheme.colorScheme.primary)
```

### ❌ Texto hardcodeado
```kotlin
// MAL
Text("Título")

// BIEN (usa recursos)
Text(stringResource(R.string.titulo))
```

---

## 💡 Tips Finales

1. **Siempre empieza por la data class**
2. **Crea el componente más pequeño primero (Card)**
3. **Luego crea la pantalla con la lista**
4. **Usa MaterialTheme para colores y tipografía**
5. **Incluye modifier en todos los componentes**
6. **Comenta código si el tiempo lo permite**
7. **LazyColumn para listas, Column para pocas cosas**

---

## 🎓 Tiempo de Examen

### Si tienes 60 minutos:
- **0-10 min:** Lee el enunciado, planifica estructura
- **10-20 min:** Crea data class y data source
- **20-40 min:** Implementa componentes y pantalla
- **40-55 min:** Prueba y ajusta
- **55-60 min:** Revisa y comenta código

---

*Guía creada para examen de Desarrollo de Interfaces*
*Última actualización: 2025*
