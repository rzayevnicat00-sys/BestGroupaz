package az.bestgroup.app.domain.model

enum class UserRole { CUSTOMER, ADMIN }
enum class AccountStatus { ACTIVE, SUSPENDED, DELETION_REQUESTED }
enum class AppLanguage { AZ, EN, RU }
enum class ThemePreference { LIGHT, DARK, SYSTEM }

data class User(
    val uid: String,
    val firstName: String,
    val lastName: String,
    val fullName: String,
    val email: String,
    val phone: String? = null,
    val university: String? = null,
    val faculty: String? = null,
    val specialty: String? = null,
    val educationLevel: String? = null,
    val profilePhotoUrl: String? = null,
    val role: UserRole = UserRole.CUSTOMER,
    val preferredLanguage: AppLanguage = AppLanguage.AZ,
    val theme: ThemePreference = ThemePreference.SYSTEM,
    val accountStatus: AccountStatus = AccountStatus.ACTIVE,
    val createdAt: Long? = null,
    val updatedAt: Long? = null,
    val lastActiveAt: Long? = null
)
