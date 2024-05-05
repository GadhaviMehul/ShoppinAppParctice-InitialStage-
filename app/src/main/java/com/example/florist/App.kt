package com.example.florist

import android.app.Application
import android.content.Context
import com.example.florist.repository.Repository
import com.example.florist.api.ApiService
import com.example.florist.api.RetrofitHelper

class App : Application() {
    lateinit var repository: Repository

    companion object {
        private var instance: App? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        initialize()
    }

    private fun initialize() {
        val apiService = RetrofitHelper.getInstance().create(ApiService::class.java)
        repository = Repository(apiService, applicationContext)
    }

}