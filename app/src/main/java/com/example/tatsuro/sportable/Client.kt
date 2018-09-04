package com.example.tatsuro.sportable

import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Retrofit用のクライアント
 */

interface EijuClient {
    @GET("/feed/rdf/")
    fun get() : Observable<Article>
}