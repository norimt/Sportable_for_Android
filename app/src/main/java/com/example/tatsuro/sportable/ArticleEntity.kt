package com.example.tatsuro.sportable

import org.simpleframework.xml.*

@Root(strict = false)
class Article {
    @set:ElementList(entry = "item", inline = true)
    @get:ElementList(entry = "item", inline = true)
    var articleEntities: List<ArticleEntity>? = null
}

@Root(name = "item", strict = false)
class ArticleEntity {

    @set:Element(name = "title")
    @get:Element(name = "title")
    var title: String? = null

    @set:Element(name = "link")
    @get:Element(name = "link")
    var link: String? = null

    @set:Element(name = "date")
    @get:Element(name = "date")
    var date: String? = null

    @set:Element(name = "creator", required = false)
    @get:Element(name = "creator", required = false)
    var creator: String? = null

    @set:Element(name = "description", required = false)
    @get:Element(name = "description", required = false)
    var description: String? = null
}