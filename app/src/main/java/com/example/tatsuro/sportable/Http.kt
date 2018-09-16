package com.example.tatsuro.sportable

import android.util.Log
import java.io.BufferedInputStream
import java.io.InputStream
import java.net.URL
import javax.net.ssl.HttpsURLConnection

fun httpGet(url: String): InputStream? {
	Log.d("xtc", "httpGet called")
	val con = URL(url).openConnection() as HttpsURLConnection

	con.apply {
		requestMethod = "GET"
		connectTimeout = 3000
		readTimeout = 5000
		instanceFollowRedirects = true
	}

	try {
		con.connect()
	} catch (e: Exception) {
		e.printStackTrace()
		return null
	}
	if (con.responseCode in 200 .. 299) {
        Log.d("xtc", "get 200")
		return BufferedInputStream(con.inputStream)
	}

    Log.d("xtc", "got ${con.responseCode}")
	return null
}