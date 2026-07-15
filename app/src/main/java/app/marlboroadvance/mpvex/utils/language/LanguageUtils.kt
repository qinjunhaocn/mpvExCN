package app.marlboroadvance.mpvex.utils.language

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import app.marlboroadvance.mpvex.ui.theme.AppLanguage
import java.util.Locale

object LanguageUtils {
    fun applyLanguage(context: Context, language: AppLanguage) {
        val locale = when (language) {
            AppLanguage.System -> Locale.getDefault()
            AppLanguage.English -> Locale("en")
            AppLanguage.Chinese -> Locale("zh")
        }
        setLocale(context, locale)
    }

    private fun setLocale(context: Context, locale: Locale) {
        Locale.setDefault(locale)

        val resources = context.resources
        val configuration = Configuration(resources.configuration)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            configuration.setLocale(locale)
        } else {
            @Suppress("DEPRECATION")
            configuration.locale = locale
        }

        @Suppress("DEPRECATION")
        resources.updateConfiguration(configuration, resources.displayMetrics)
    }

    fun getSystemLanguage(): String {
        return Locale.getDefault().language
    }
}
