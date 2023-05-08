import kotlinx.serialization.Serializable

@Serializable
data class HoroscopeDTO(
    val date: String,
    val horoscope: String,
    val icon: String,
    val id: Int,
    val sign: String
)
