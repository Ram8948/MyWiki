package com.ramosoft.mywiki.data.entities

data class ArticleModel(
    val `continue`: Continue,
    val query: Query,
    val warnings: Warnings
) {
    data class Continue(
        val `continue`: String, // grncontinue||revisions
        val grncontinue: String, // 0.636072957833|0.636072957833|0|0
        val imcontinue: String // 1105375|Gran_Armería,_Gdansk,_Polonia,_2013-05-20,_DD_01.jpg
    )

    data class Query(
        val pages: Map<Int,MapValue>
    ) {
        data class MapValue(
            val ns: Int, // 0
            val pageid: Int, // 4163831
            val revisions: List<Revision>,
            val title: String // Gliomatosis cerebri
        ) {
            data class Revision(
                val *: String, // * [[:it:Neuro-Oncologia]]* [[:it:Classificazione dei tumori del sistema nervoso centrale]]* [[:it:Gradazione dei tumori del sistema nervoso centrale]]*[[:en:Gliomatosis cerebri]]<br><br><gallery>Image:Gliomatosis cerebri.jpg|Radiology</br>Gliomatosis cerebri Image:Gliomatosis cerebri2.jpg|Radiology</br>Gliomatosis cerebriImage:AFIP-00405606 Gliomatosis Cerebri.jpg|Radiology</br>AFIP-00405606</gallery><gallery>Image:AFIP-00405557 Gliomatosis Cerebri.jpg|Micro</br>AFIP-00405557Image:AFIP-00405607 Gliomatosis Cerebri.jpg|Micro</br>AFIP-00405607Image:AFIP-00405608 Gliomatosis Cerebri.jpg|Micro</br>AFIP-00405608</gallery>[[Category:Gliomatosis cerebri]]
                val contentformat: String, // text/x-wiki
                val contentmodel: String // wikitext
            )
        }
    }

    data class Warnings(
        val main: Main,
        val revisions: Revisions
    ) {
        data class Main(
            val *: String // Subscribe to the mediawiki-api-announce mailing list at <https://lists.wikimedia.org/postorius/lists/mediawiki-api-announce.lists.wikimedia.org/> for notice of API deprecations and breaking changes. Use [[Special:ApiFeatureUsage]] to see usage of deprecated features by your application.
        )

        data class Revisions(
            val *: String // Because "rvslots" was not specified, a legacy format has been used for the output. This format is deprecated, and in the future the new format will always be used.
        )
    }
}