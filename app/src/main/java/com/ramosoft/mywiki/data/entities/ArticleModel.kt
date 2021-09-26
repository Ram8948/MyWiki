package com.ramosoft.mywiki.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

data class ArticleModel(
    val batchcomplete: Boolean, // true
    val `continue`: Continue,
    val query: Query,
    val warnings: Warnings
) {
    data class Continue(
        val `continue`: String, // grncontinue||
        val grncontinue: String // 0.094196773362|0.0941997037|43133910|0
    )

    data class Query(
        val pages: List<Page>
    ) {
        @Entity(tableName = "article_table")
        data class Page(
            val canonicalurl: String, // https://en.wikipedia.org/wiki/N%C3%A1dson_Rodrigues_de_Souza
            val contentmodel: String, // wikitext
            val editurl: String, // https://en.wikipedia.org/w/index.php?title=N%C3%A1dson_Rodrigues_de_Souza&action=edit
            val fullurl: String, // https://en.wikipedia.org/wiki/N%C3%A1dson_Rodrigues_de_Souza
            val lastrevid: Int, // 1043633882
            val length: Int, // 6430
            val ns: Int, // 0
            @PrimaryKey(autoGenerate = true)
            val pageid: Int, // 6107746
            val pagelanguage: String, // en
            val pagelanguagedir: String, // ltr
            val pagelanguagehtmlcode: String, // en
            val title: String, // Nádson Rodrigues de Souza
            val touched: String // 2021-09-22T16:16:27Z
        )
    }

    data class Warnings(
        val main: Main,
        val query: Query
    ) {
        data class Main(
            val warnings: String // Unrecognized parameter: pithumbsize.
        )

        data class Query(
            val warnings: String // Unrecognized value for parameter "prop": page
        )
    }
}