package com.ramosoft.mywiki.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

data class CategoryModel(
    val batchcomplete: Boolean, // true
    val `continue`: Continue,
    val query: Query
) {
    data class Continue(
        val accontinue: String, // List_of_Austrian_films
        val `continue`: String // -||
    )

    data class Query(
        val allcategories: List<Allcategory>
    ) {
        @Entity(tableName = "category_table")
        data class Allcategory(
            @PrimaryKey(autoGenerate = true)
            val id: Int,
            val category: String // List of 20th-century terrorist incidents
        )
    }
}