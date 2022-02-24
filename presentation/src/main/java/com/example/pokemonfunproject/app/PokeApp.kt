package com.example.pokemonfunproject.app

import android.app.Application
import com.example.domain.di.domainModule
import com.example.pokemonfunproject.di.presentationModule
import com.example.data.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PokeApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PokeApp)
            modules(listOf(presentationModule, dataModule, domainModule))
        }
    }
}