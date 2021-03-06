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

    //for session handling
    private val IS_USER_LOGGED_IN = "IS_USER_LOGGED_IN"
    private val ACCOUNT_ID = "ACCOUNT_ID"
    private val USER_NAME = "USER_NAME"
    private val NAME = "NAME"
    private val SESSION_ID = "SESSION_ID"
    //for session handling

    private val sharedPreferences: SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context)

    @SuppressLint("ApplySharedPref")
    override fun setUserGenres(genres: String?): Observable<Boolean> {
        return Observable.fromCallable {
            sharedPreferences.edit().putString(USER_GENRES, genres ?: NULL_TYPE).commit()
            true
        }
    }

    override fun getIsUserLoggedIn(): Boolean {
        return sharedPreferences.getBoolean(IS_USER_LOGGED_IN, false)
    }

    override fun setIsUserLoggedIn() {
        sharedPreferences.edit().putBoolean(IS_USER_LOGGED_IN, true).apply()
    }

    override fun getSessionIdFromPreference(): String? {
        return if (sharedPreferences.getString(SESSION_ID, NULL_TYPE) == NULL_TYPE)
            null
        else
            sharedPreferences.getString(SESSION_ID, NULL_TYPE)
    }

    override fun setSessionIdIntoPreference(sessionId: String?) {
        sharedPreferences.edit().putString(SESSION_ID, sessionId ?: NULL_TYPE).apply()
    }

    override fun getAccountId(): Int? {
        return if (sharedPreferences.getInt(ACCOUNT_ID, -1) == -1)
            null
        else
            sharedPreferences.getInt(ACCOUNT_ID, -1)
    }

    override fun setAccountId(accountId: Int?) {
        sharedPreferences.edit().putInt(ACCOUNT_ID, accountId ?: -1).apply()
    }

    override fun getUserName(): String? {
        return if (sharedPreferences.getString(USER_NAME, NULL_TYPE) == NULL_TYPE)
            null
        else
            sharedPreferences.getString(USER_NAME, NULL_TYPE)
    }

    override fun setUserName(userName: String?) {
        sharedPreferences.edit().putString(USER_NAME, userName ?: NULL_TYPE).apply()
    }

    override fun getName(): String? {
        return if (sharedPreferences.getString(NAME, NULL_TYPE) == NULL_TYPE)
            null
        else
            sharedPreferences.getString(NAME, NULL_TYPE)
    }

    override fun setName(name: String?) {
        sharedPreferences.edit().putString(NAME, name ?: NULL_TYPE).apply()
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