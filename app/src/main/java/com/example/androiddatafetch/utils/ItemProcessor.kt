package com.example.androiddatafetch.utils

import com.example.androiddatafetch.data.Item

object ItemProcessor {
    fun processItems(items: List<Item>?): Map<Int, List<Item>> {
        return items
            ?.filter { it.name?.isNotBlank() == true } // Remove items with blank/null names
            ?.sortedWith(compareBy<Item> { it.listId }
                .thenBy { extractNumber(it.name) } // Sort by extracted number if present
                .thenBy { it.name }) // Sort alphabetically if no numbers
            ?.groupBy { it.listId } // Group by listId
            ?: emptyMap()
    }

    /**
     * Extracts the first number found in the string.
     * If no number is found, returns Int.MAX_VALUE to push non-numeric names to the end.
     */
    fun extractNumber(name: String?): Int {
        val numberRegex = "\\d+".toRegex() // Regular expression to find numbers
        val numberMatch = numberRegex.find(name ?: "")?.value
        return numberMatch?.toIntOrNull() ?: Int.MAX_VALUE
    }

}