package presentation.localization

import kmp_movies.composeapp.generated.resources.Res
import kmp_movies.composeapp.generated.resources.ic_arabic_lang
import kmp_movies.composeapp.generated.resources.ic_english_lang
import org.jetbrains.compose.resources.DrawableResource

/**
 * Created by "Mohamad Abuzaid" on 01/06/2024.
 * Email: m.abuzaid.ali@gmail.com
 */
object LocalizationUtils {
    const val AR = "ar"
    private const val EN = "en"

    val langOptions = listOf("العربية", "English")

    fun code(lang: String): String {
        return when (lang) {
            langOptions[0] -> AR
            langOptions[1] -> EN
            else -> AR
        }
    }

    fun icon(lang: String): DrawableResource {
        return when (lang) {
            langOptions[0] -> Res.drawable.ic_arabic_lang
            langOptions[1] -> Res.drawable.ic_english_lang
            else -> Res.drawable.ic_arabic_lang
        }
    }

    fun lang(code: String): String {
        return when (code) {
            AR -> langOptions[0]
            EN -> langOptions[1]
            else -> langOptions[0]
        }
    }

    fun country(code: String): String {
        return when (code) {
            AR -> "EG"
            EN -> "GB"
            else -> "EG"
        }
    }

    fun fullLocal(code: String): String {
        return when (code) {
            AR -> "ar-EG"
            EN -> "en-GB"
            else -> "ar-EG"
        }
    }
}