package com.vicky7230.flux.data.prefs

/**
 * Created by vicky on 1/3/18.
 */
import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.vicky7230.flux.di.ApplicationContext
import io.reactivex.Observable
import javax.inject.Inject


class AppPreferencesHelper @Inject constructor(@ApplicationContext context: Context) :
    PreferencesHelper {

    private val NULL_TYPE = "null"
    private val USER_GENRES = "USER_GENRES"
    private val BASE_IMAGE_URL = "BASE_IMAGE_URL"
    private val ARE_GENRES_SELECTED = "ARE_GENRES_SELECTED"

    private val sharedPreferences: SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context)

    @SuppressLint("ApplySharedPref")
    override fun setUserGenres(genres: String?): Observable<Boolean> {
        return Observable.fromCallable {
            sharedPreferences.edit().putString(USER_GENRES, genres ?: NULL_TYPE).commit()
            true
        }
    }

    override fun getUserGenres(): String? {
        return if (sharedPreferences.getString(USER_GENRES, NULL_TYPE) == NULL_TYPE)
            null
        else
            sharedPreferences.getString(USER_GENRES, NULL_TYPE)
    }

    @SuppressLint("ApplySharedPref")
    override fun setBaseImageUrl(url: String?) {
        sharedPreferences.edit().putString(BASE_IMAGE_URL, url ?: NULL_TYPE).commit()
    }

    override fun getBaseImageUrl(): String? {
        return if (sharedPreferences.getString(BASE_IMAGE_URL, NULL_TYPE) == NULL_TYPE)
            null
        else
            sharedPreferences.getString(BASE_IMAGE_URL, NULL_TYPE)
    }

    @SuppressLint("ApplySharedPref")
    override fun setGenresSelected() {
        sharedPreferences.edit().putBoolean(ARE_GENRES_SELECTED, true).commit()
    }

    override fun getGenresSelected(): Boolean {
        return sharedPreferences.getBoolean(ARE_GENRES_SELECTED, false)
    }
}