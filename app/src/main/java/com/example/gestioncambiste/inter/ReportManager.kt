package com.example.gestioncambiste.inter

import java.util.Date

interface ReportManager {
    fun generateDailyProfitReport(date: Date): Double
    fun generateMonthlyProfitReport(month: Int, year: Int): Double
}