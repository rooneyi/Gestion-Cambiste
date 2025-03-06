package com.example.gestioncambiste

import android.app.Application
import com.example.gestioncambiste.data.database.AppDatabase
import com.example.gestioncambiste.data.repository.UserRepository

class GestionCambisteApplication : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { UserRepository(database.userDao()) }
}