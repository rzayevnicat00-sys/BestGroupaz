package az.bestgroup.app.domain.model

enum class PricingType { STARTING, FIXED, PER_PAGE, CUSTOM }

data class ServiceItem(
    val id: String,
    val name: String,
    val categoryId: String,
    val description: String,
    val imageUrl: String? = null,
    val pricingType: PricingType,
    val priceAmount: Double? = null,
    val currency: String = "AZN",
    val estimatedCompletion: String? = null,
    val requirements: String? = null,
    val availabilityStatus: Boolean = true,
    val languageOptions: List<String> = emptyList()
)
