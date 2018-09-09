package com.example.tatsuro.sportable

import com.squareup.moshi.Json

data class Rss(
        @field:Json(name = "title")  var rssTitle: String,
        @field:Json(name = "author") var rssContributor: String,
        @field:Json(name = "link")   var rssUrl: String
)