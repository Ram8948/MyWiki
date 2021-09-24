//package com.ramosoft.mywiki.data.entities
//
//data class ArticleModel(
//    val `continue`: Continue,
//    val query: Query,
//    val warnings: Warnings
//) {
//    data class Continue(
//        val `continue`: String, // grncontinue||revisions
//        val grncontinue: String, // 0.882685155808|0.882685155808|0|0
//        val imcontinue: String // 15085855|Western_film_clapperboard.svg
//    )
//
//    data class Query(
//        val pages: Map<Int,MapValue>
//    ) {
//        data class MapValue(
//            val images: List<Image>,
//            val ns: Int, // 0
//            val pageid: Int, // 15085855
//            val revisions: List<Revision>,
//            val title: String // The Stranger (1920 film)
//        ) {
//            data class Image(
//                val ns: Int, // 6
//                val title: String // File:Question book-new.svg
//            )
//
//            data class Revision(
//                val *: String, // {{short description|1920 film}}{{More citations needed|date=June 2019}}{{use mdy dates|date=December 2014}}{{Infobox film| name           = The Stranger| image          = | image_size     = | caption        = | director       = | producer       = | writer         = [[W. C. Tuttle]]| starring       = [[Hoot Gibson]]| music          = | cinematography = | editing        = | distributor    = | released       = {{film date|1920|12|4}}| runtime        = 20 minutes| country        = United States | language       = [[Silent film|Silent]]<br>English intertitles| budget         = }}'''''The Stranger''''' is a 1920 American [[short film|short]] [[Western (genre)|Western film]] featuring [[Hoot Gibson]].==Cast==* [[Hoot Gibson]]* Dorothy Woods==See also==* [[Hoot Gibson filmography]]==External links==*{{IMDb title|id=0222402|title=The Stranger}}{{DEFAULTSORT:Stranger, The}}[[Category:1920 films]][[Category:American films]][[Category:American silent short films]][[Category:1920 Western (genre) films]][[Category:1920 short films]][[Category:American black-and-white films]][[Category:Silent American Western (genre) films]]{{1920s-Western-film-stub}}{{short-silent-film-stub}}
//                val contentformat: String, // text/x-wiki
//                val contentmodel: String // wikitext
//            )
//        }
//    }
//
//    data class Warnings(
//        val main: Main,
//        val revisions: Revisions
//    ) {
//        data class Main(
//            val *: String // Subscribe to the mediawiki-api-announce mailing list at <https://lists.wikimedia.org/postorius/lists/mediawiki-api-announce.lists.wikimedia.org/> for notice of API deprecations and breaking changes. Use [[Special:ApiFeatureUsage]] to see usage of deprecated features by your application.
//        )
//
//        data class Revisions(
//            val *: String // Because "rvslots" was not specified, a legacy format has been used for the output. This format is deprecated, and in the future the new format will always be used.
//        )
//    }
//}