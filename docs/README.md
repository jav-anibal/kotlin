# 📚 Documentación - Marvel Heroes Compose

Esta carpeta contiene toda la documentación educativa del proyecto Marvel Heroes Compose, diseñada para preparar estudiantes para exámenes de Desarrollo de Interfaces con Jetpack Compose.

---

## 📂 Contenido de la Documentación

### 📖 [INDICE_CURSO.md](./INDICE_CURSO.md)
**🎯 Empieza aquí primero**

Guía completa de cómo usar toda la documentación:
- Plan de estudio de 7 días
- Plan intensivo de 1 día
- Rutas según tu nivel (Principiante/Intermedio/Avanzado)
- Checklist pre-examen
- Consejos y estrategias

---

### 📕 [MINI_CURSO_DESARROLLO_INTERFACES.md](./MINI_CURSO_DESARROLLO_INTERFACES.md)
**Tutorial Completo de Jetpack Compose**

Curso completo en 11 secciones:
1. Fundamentos de Jetpack Compose
2. Arquitectura de UI en Android
3. Sistema de Theming (Material Design 3)
4. Componentes Reutilizables
5. Listas y LazyColumn
6. Diseño Responsivo
7. Colores Personalizados
8. Tipografía Personalizada
9. Patrones de Diseño Comunes
10. Ejercicios Prácticos
11. Checklist para Examen

**Duración estimada:** 90 minutos de lectura

---

### ⚡ [GUIA_RAPIDA_EXAMEN.md](./GUIA_RAPIDA_EXAMEN.md)
**Cheatsheet de Referencia Rápida**

Guía rápida con:
- Sintaxis básica de Composables
- Layouts esenciales
- Modificadores comunes
- Componentes Material 3
- Colores y tipografía
- Patrones de código
- Errores comunes
- Preguntas típicas de examen

**Duración estimada:** 15 minutos de lectura
**Uso:** Repaso rápido antes del examen

---

### 🏋️ [EJERCICIOS_PRACTICA.md](./EJERCICIOS_PRACTICA.md)
**9 Ejercicios Prácticos con Soluciones**

Ejercicios progresivos:

**🟢 Nivel Básico (Ejercicios 1-3):**
- Card personalizada
- Lista simple con LazyColumn
- Header fijo + Lista

**🟡 Nivel Intermedio (Ejercicios 4-6):**
- Estado interactivo
- Filtrado de lista
- Diseño responsivo

**🔴 Nivel Avanzado (Ejercicios 7-9):**
- Tema personalizado
- Colores extendidos
- Proyecto completo (App Contactos)

**Duración estimada:** 3-4 horas de práctica

---

### 🎨 [THEME_BUILDER_GUIDE.md](./THEME_BUILDER_GUIDE.md)
**Guía de Material Theme Builder**

Guía especializada en theming:
- Uso de Material Theme Builder
- Crear colores extendidos
- Nomenclatura "on" y "Container"
- Accesibilidad y contraste
- Dynamic Color (Android 12+)
- Ejemplos completos

---

## 🎯 Guía Rápida de Uso

### Si eres **Principiante**:
1. Lee [INDICE_CURSO.md](./INDICE_CURSO.md)
2. Estudia [MINI_CURSO_DESARROLLO_INTERFACES.md](./MINI_CURSO_DESARROLLO_INTERFACES.md)
3. Practica [EJERCICIOS_PRACTICA.md](./EJERCICIOS_PRACTICA.md) (1-4)
4. Repasa con [GUIA_RAPIDA_EXAMEN.md](./GUIA_RAPIDA_EXAMEN.md)

### Si eres **Intermedio**:
1. Repasa [MINI_CURSO_DESARROLLO_INTERFACES.md](./MINI_CURSO_DESARROLLO_INTERFACES.md) (secciones clave)
2. Practica [EJERCICIOS_PRACTICA.md](./EJERCICIOS_PRACTICA.md) (3-7)
3. Estudia [THEME_BUILDER_GUIDE.md](./THEME_BUILDER_GUIDE.md)
4. Ten [GUIA_RAPIDA_EXAMEN.md](./GUIA_RAPIDA_EXAMEN.md) como referencia

### Si eres **Avanzado**:
1. Consulta [GUIA_RAPIDA_EXAMEN.md](./GUIA_RAPIDA_EXAMEN.md)
2. Haz [EJERCICIOS_PRACTICA.md](./EJERCICIOS_PRACTICA.md) (7-9)
3. Profundiza con [THEME_BUILDER_GUIDE.md](./THEME_BUILDER_GUIDE.md)

### **El día antes del examen**:
1. Repasa [GUIA_RAPIDA_EXAMEN.md](./GUIA_RAPIDA_EXAMEN.md)
2. Revisa el "Checklist para Examen" en [MINI_CURSO_DESARROLLO_INTERFACES.md](./MINI_CURSO_DESARROLLO_INTERFACES.md)
3. Intenta [EJERCICIOS_PRACTICA.md](./EJERCICIOS_PRACTICA.md) ejercicio 9 sin ayuda

---

## 📊 Estadísticas

- **Total de documentos:** 5 archivos
- **Total de páginas:** ~115 páginas
- **Ejercicios prácticos:** 9 ejercicios completos
- **Código de ejemplo:** Basado en Marvel Heroes Compose

---

## 🎓 Conceptos Cubiertos

### Fundamentales
- ✅ @Composable y declaración de UI
- ✅ Column, Row, Box, LazyColumn
- ✅ Modifier (padding, size, fillMaxWidth)
- ✅ Estado con remember y mutableStateOf
- ✅ MaterialTheme (colores y tipografía)

### Intermedios
- ✅ Componentes reutilizables
- ✅ Hoisting de estado
- ✅ Window Size Classes
- ✅ LazyColumn vs Column
- ✅ Cards y layouts personalizados

### Avanzados
- ✅ ExtendedColors con CompositionLocal
- ✅ Tema personalizado completo
- ✅ Google Fonts integration
- ✅ Material Design 3 completo
- ✅ Arquitectura de proyecto

---

## 💡 Tips de Estudio

1. **Lee el [INDICE_CURSO.md](./INDICE_CURSO.md) primero** para entender cómo usar todo el material
2. **Practica escribiendo el código a mano**, no copies y pegues
3. **Experimenta** modificando los ejemplos
4. **Crea tu propio proyecto** aplicando lo aprendido
5. **Consulta el proyecto Marvel Heroes** como referencia de código real

---

## 🚀 Proyecto de Referencia

El código fuente del proyecto Marvel Heroes Compose implementa todos los conceptos explicados en esta documentación:

```
app/src/main/java/.../
├── ui/
│   ├── screens/HeroListScreen.kt
│   ├── components/commons.kt
│   ├── components/cards.kt
│   └── theme/
│       ├── Color.kt
│       ├── Theme.kt
│       ├── Type.kt
│       └── ExtendedColors.kt
├── model/Hero.kt
└── data/Datasource.kt
```

**Estudia especialmente:**
- `ExtendedColors.kt` - Colores personalizados
- `Theme.kt` - CompositionLocalProvider
- `HeroListScreen.kt` - Diseño adaptativo
- `commons.kt` - MedHeaderComp con colores personalizados

---

## 📞 Soporte

Si encuentras errores o tienes sugerencias para mejorar la documentación, revisa:
- El código fuente del proyecto Marvel Heroes
- La documentación oficial de [Jetpack Compose](https://developer.android.com/jetpack/compose)
- Los [Codelabs de Google](https://developer.android.com/courses/compose-course)

---

## ✨ Última Actualización

**Fecha:** Noviembre 2025
**Versión:** 1.0
**Basado en:** Jetpack Compose con Material Design 3

---

**¡Buena suerte en tu examen de Desarrollo de Interfaces!** 🎉
