package com.example.gestioncambiste

import com.example.gestioncambiste.inter.BalanceManagerImpl
import com.example.gestioncambiste.inter.ExchangeRateManagerImpl
import com.example.gestioncambiste.inter.ReportManagerImpl
import com.example.gestioncambiste.inter.TransactionManagerImpl
import android.app.Application
import com.example.gestioncambiste.data.database.AppDatabase
import com.example.gestioncambiste.data.repository.UserRepository

class GestionCambisteApplication : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { UserRepository(database.userDao()) }

    // Ajout des nouveaux managers
    val exchangeRateManager by lazy { ExchangeRateManagerImpl() }
    val transactionManager by lazy { TransactionManagerImpl(exchangeRateManager) }
    val balanceManager by lazy { BalanceManagerImpl(transactionManager) }
    val reportManager by lazy { ReportManagerImpl(transactionManager) }
}