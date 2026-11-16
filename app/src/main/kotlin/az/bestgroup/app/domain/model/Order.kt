package az.bestgroup.app.domain.model

enum class OrderStatus { PENDING, ACCEPTED, IN_PROGRESS, READY, CANCELLED }

data class Order(
    val orderId: String,
    val customerId: String,
    val customerName: String,
    val serviceId: String,
    val serviceName: String,
    val topic: String,
    val university: String? = null,
    val faculty: String? = null,
    val specialty: String? = null,
    val educationLevel: String? = null,
    val language: String? = null,
    val pageCount: Int? = null,
    val deadlineAt: Long? = null,
    val requirementsText: String? = null,
    val price: Double? = null,
    val currency: String = "AZN",
    val status: OrderStatus = OrderStatus.PENDING,
    val createdAt: Long? = null,
    val updatedAt: Long? = null
)
