package com.ramosoft.mywiki.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

data class ImageModel(
    val batchcomplete: Boolean, // true
    val `continue`: Continue,
    val query: Query
) {
    data class Continue(
        val aicontinue: String, // "A_Challenge_for_Robin_Hood"(1967).jpg
        val `continue`: String // -||
    )

    data class Query(
        val allimages: List<Allimage>
    ) {
        @Entity(tableName = "Imageinfo")
        data class Allimage(
            @PrimaryKey(autoGenerate = true)
            val id: Int,
            val descriptionshorturl: String, // https://en.wikipedia.org/w/index.php?curid=49816251
            val descriptionurl: String, // https://en.wikipedia.org/wiki/File:!!!_(Chk_Chk_Chk)_-_One_Girl_One_Boy_cover_art.jpg
            val name: String, // !!!_(Chk_Chk_Chk)_-_One_Girl_One_Boy_cover_art.jpg
            val ns: Int, // 6
            val timestamp: String, // 2017-12-31T06:16:58Z
            val title: String, // File:!!! (Chk Chk Chk) - One Girl One Boy cover art.jpg
            val url: String // https://upload.wikimedia.org/wikipedia/en/b/ba/%21%21%21_%28Chk_Chk_Chk%29_-_One_Girl_One_Boy_cover_art.jpg
        )
    }
}