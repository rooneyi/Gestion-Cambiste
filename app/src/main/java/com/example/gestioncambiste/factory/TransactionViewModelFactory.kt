import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gestioncambiste.inter.TransactionManager

class TransactionViewModelFactory(
    private val transactionManager: TransactionManager
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TransactionViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TransactionViewModel(transactionManager) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}