import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.request
import io.ktor.serialization.kotlinx.json.json

class Horoscope {

    private val client = HttpClient() {
        install(ContentNegotiation){
            json()
        }
    }

    suspend fun getHoroscope(sign: String, lang: String = "es"): HoroscopeDTO {
        return client.request(BASE_URL.buildURI(sign, lang)).body()
    }
}

fun String.buildURI(sign: String, lang: String): String =
    this.plus(sign).plus("?").plus("lang=$lang")


private const val BASE_URL = "https://newastro.vercel.app/"

