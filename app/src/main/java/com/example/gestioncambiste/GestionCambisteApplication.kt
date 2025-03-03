package com.example.gestioncambiste

import android.app.Application
import com.example.gestioncambiste.ui.AppDatabase
import com.example.gestioncambiste.ui.UserRepository

class GestionCambisteApplication : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { UserRepository(database.userDao()) }
}