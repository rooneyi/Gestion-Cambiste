import androidx.lifecycle.ViewModel
import com.example.gestioncambiste.inter.Transaction
import com.example.gestioncambiste.inter.TransactionManager

class TransactionViewModel(
    private val transactionManager: TransactionManager
) : ViewModel() {

    fun recordTransaction(transaction: Transaction) {
        transactionManager.recordTransaction(transaction)
    }

    fun calculateConversion(amount: Double, fromCurrency: String, toCurrency: String): Double {
        return transactionManager.calculateConversion(amount, fromCurrency, toCurrency)
    }

    fun getTotalAmount(currency: String): Double {
        return transactionManager.getTotalAmount(currency)
    }

    fun getTransactionHistory(): List<Transaction> {
        return transactionManager.getTransactionHistory()
    }
}