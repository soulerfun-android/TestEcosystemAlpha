package com.example.testecosystemalpha.presentation

import android.app.Application
import com.example.lelele.di.DaggerApplicationComponent

class App : Application() {
    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}