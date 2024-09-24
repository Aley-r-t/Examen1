package com.contreras.rodrigo.laboratoriocalificado1

fun areAnagrams(word1: String, word2: String): Boolean {
    // Eliminamos espacios
    val cleanWord1 = word1.replace(" ", "").lowercase()
    val cleanWord2 = word2.replace(" ", "").lowercase()

    if (cleanWord1.length != cleanWord2.length) {
        return false
    }

    val charCount = mutableMapOf<Char, Int>()
    // Recorremos cada carácter en la primera palabra.
    for (char in cleanWord1) {
        charCount[char] = charCount.getOrDefault(char, 0) + 1
    }

    // Recorremos cada carácter en la segunda palabra.
    for (char in cleanWord2) {
        // Si el carácter no está en el mapa o su conteo es 0, las palabras no son anagramas.
        if (charCount[char] == null || charCount[char] == 0) {
            return false
        }
        // Decrementamos el conteo del carácter en el mapa.
        charCount[char] = charCount[char]!! - 1
    }

    // Si llegamos aquí, todas las letras se emparejaron correctamente, así que son anagramas.
    return true
}

// Ejemplos de uso
fun main() {
    println(areAnagrams("listen", "silent")) // Salida: true
    println(areAnagrams("hello", "world"))   // Salida: false
}
