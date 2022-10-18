package com.example.odev6_shazam
import java.io.Serializable
class MyMusics(var musicId:Int,
               var musicSingerName:String,
               var musicName:String,
               var musicPictureName:String,
               var musicAlbumName:String,
               var musicPublishingDate:Int):Serializable {
}