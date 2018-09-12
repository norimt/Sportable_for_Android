package com.example.tatsuro.sportable

import com.squareup.moshi.*
import java.lang.reflect.Type

class CustomJsonAdapter(
        val moshi: Moshi) : JsonAdapter<List<Rss?>>() {

    override fun fromJson(reader: JsonReader): List<Rss?>? {
        reader.beginObject()
        if (reader.nextName() != "data") {
            return null
        }
        reader.beginArray()
        val list = arrayListOf<Rss?>()
        val adapter = moshi.adapter(Rss::class.java)
        while (reader.hasNext()) {
            list.add(adapter.fromJson(reader))
        }
        reader.endArray()

        return list
    }

    override fun toJson(writer: JsonWriter?, value: List<Rss?>?) {
        // 後で
    }

    companion object {
        val FACTORY: Factory = object : Factory {
            override fun create(type: Type, annotations: MutableSet<out Annotation>?, moshi: Moshi): CustomJsonAdapter? {
                val listType = Types.newParameterizedType(List::class.java, Rss::class.java)
                if (type == listType) {
                    return CustomJsonAdapter(moshi)
                }
                return null
            }
        }
    }
}