package com.example.demoapplication.di

import android.util.Log
import com.example.demoapplication.BuildConfig
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.google.gson.JsonSyntaxException
import okhttp3.logging.HttpLoggingInterceptor

class ApiLogger: HttpLoggingInterceptor.Logger {
    private val LOGGING_ENABLED = BuildConfig.DEBUG

    override fun log(message: String) {
        if(LOGGING_ENABLED) {
            val logName = "ApiLogger"
            if(message.startsWith("{") || message.startsWith("[")) {
                try {
                    val printPrettyJson = GsonBuilder().setPrettyPrinting()
                        .create().toJson(JsonParser().parse(message))
                    Log.d(logName, printPrettyJson)
                } catch (e: JsonSyntaxException) {
                    Log.d(logName, message)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            } else {
                Log.d(logName, message)
                return
            }
        }
    }
}