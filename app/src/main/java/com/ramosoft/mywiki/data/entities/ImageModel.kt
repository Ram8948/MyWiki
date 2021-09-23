package com.ramosoft.mywiki.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

data class ImageModel(
    val batchcomplete: String,
    val `continue`: Continue,
    val query: Query
) {
    data class Continue(
        val `continue`: String, // gcmcontinue||
        val gcmcontinue: String // file|3030313131372031352d34342d323030322d544f2d475255505045522d524f53412d51414a41522d464c49534552322e4a50470a3030313131372031352d34342d323030322d544f2d475255505045522d524f53412d51414a41522d464c49534552322e4a5047|24259710
    )

    data class Query(
        val pages: Map<Int,MapValue>
    ) {
        data class MapValue(
            val imageinfo: List<Imageinfo>,
            val imagerepository: String, // local
            val ns: Int, // 6
            val pageid: Int, // 49179423
            val title: String // File:"Broke, baby sick, and car trouble!" - Dorothea Lange's photo of a Missouri family of five in the vicinity of Tracy, California.jpg
        ) {
            @Entity(tableName = "Imageinfo")
            data class Imageinfo(
                @PrimaryKey(autoGenerate = true)
                val id: Int,
                val descriptionshorturl: String, // https://commons.wikimedia.org/w/index.php?curid=49179423
                val descriptionurl: String, // https://commons.wikimedia.org/wiki/File:%22Broke,_baby_sick,_and_car_trouble!%22_-_Dorothea_Lange%27s_photo_of_a_Missouri_family_of_five_in_the_vicinity_of_Tracy,_California.jpg
                val timestamp: String, // 2016-06-01T22:33:46Z
                val url: String, // https://upload.wikimedia.org/wikipedia/commons/9/91/%22Broke%2C_baby_sick%2C_and_car_trouble%21%22_-_Dorothea_Lange%27s_photo_of_a_Missouri_family_of_five_in_the_vicinity_of_Tracy%2C_California.jpg
                val user: String // Adam Cuerden
            )
        }
    }
}