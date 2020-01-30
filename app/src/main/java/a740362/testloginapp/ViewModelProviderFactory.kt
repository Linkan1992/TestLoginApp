package a740362.testloginapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import a740362.testloginapp.data.network.ApiHelper
import a740362.testloginapp.data.persistence.db.DbHelper
import a740362.testloginapp.data.persistence.pref.PrefHelper
import a740362.testloginapp.di.annotation.CoroutineScopeIO
import a740362.testloginapp.ui.activity.login.LoginViewModel
import a740362.testloginapp.ui.activity.main.MainViewModel
import a740362.testloginapp.ui.activity.splash.SplashViewModel
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by Linkan on 29/01/20.
 *
 *
 * A provider factory that persists ViewModels [ViewModel].
 * Used if the view model has a parameterized constructor.
 */

@Singleton
class ViewModelProviderFactory @Inject
constructor(
    private val dbHelper: DbHelper,
    private val apiHelper: ApiHelper,
    private val prefHelper: PrefHelper,
    @CoroutineScopeIO private val ioCoroutineScope: CoroutineScope
) : ViewModelProvider.NewInstanceFactory() {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(SplashViewModel::class.java) -> SplashViewModel(apiHelper, prefHelper, ioCoroutineScope) as T
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> LoginViewModel(dbHelper, apiHelper, prefHelper) as T
            modelClass.isAssignableFrom(MainViewModel::class.java) -> MainViewModel(dbHelper, apiHelper, prefHelper) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name} " /*+ modelClass.name*/)
        }
    }
}
