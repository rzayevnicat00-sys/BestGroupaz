package az.bestgroup.app.domain.repository

import az.bestgroup.app.core.common.AppResult
import az.bestgroup.app.domain.model.Order
import az.bestgroup.app.domain.model.ServiceItem
import az.bestgroup.app.domain.model.User
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    val currentUser: Flow<User?>
    suspend fun signIn(email: String, password: String): AppResult<User>
    suspend fun register(firstName: String, lastName: String, email: String, phone: String, password: String): AppResult<Unit>
    suspend fun sendEmailVerification(): AppResult<Unit>
    suspend fun sendPasswordReset(email: String): AppResult<Unit>
    suspend fun signOut()
}

interface ServiceRepository {
    fun observeServices(): Flow<AppResult<List<ServiceItem>>>
    fun observeService(id: String): Flow<AppResult<ServiceItem>>
}

interface OrderRepository {
    fun observeMyOrders(uid: String): Flow<AppResult<List<Order>>>
    fun observeOrder(orderId: String): Flow<AppResult<Order>>
    suspend fun createOrder(order: Order): AppResult<String>
}

interface MessageRepository {
    // Real-time conversations/messages to be implemented with Firestore listeners in later phases.
}
