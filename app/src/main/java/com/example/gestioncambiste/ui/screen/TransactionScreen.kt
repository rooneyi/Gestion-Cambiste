import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.example.gestioncambiste.viewmodel.TransactionViewModel

@SuppressLint("RememberReturnType")
@Composable
fun TransactionScreen(transactionViewModel: TransactionViewModel) {
    val transactions = remember { transactionViewModel.getTransactionHistory() }

    LazyColumn {
        items(transactions) { transaction ->
            Text("Transaction: ${transaction.amount} ${transaction.currency}")
        }
    }
}
