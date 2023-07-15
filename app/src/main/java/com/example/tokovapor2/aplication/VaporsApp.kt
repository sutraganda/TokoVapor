package com.example.tokovapor2.aplication

import android.app.Application
import com.example.tokovapor2.repository.VaporsRepository

class VaporsApp: Application() {
    val database by lazy { VaporsDatabase.getDatabase(this) }
    val repository by lazy { VaporsRepository(database.vaporsDao()) }
}