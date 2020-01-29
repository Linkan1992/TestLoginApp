package a740362.testloginapp.data.persistence.pref

import a740362.testloginapp.util.AppConstants
import android.content.SharedPreferences
import javax.inject.Inject

class AppPrefHelper @Inject
constructor(private val sharedPref: SharedPreferences) : PrefHelper {

  override var isLoggedIn: Boolean
    get() = sharedPref.getBoolean(AppConstants.IS_LOGGED_IN_KEY, false)
    set(value) {
      sharedPref.edit().putBoolean(AppConstants.IS_LOGGED_IN_KEY, value).apply()
    }


  override var userId: String?
    get() = sharedPref.getString(AppConstants.USER_ID, "")
    set(value) {
      sharedPref.edit().putString(AppConstants.USER_ID, value).apply()
    }


}
