package a740362.testloginapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import a740362.testloginapp.data.network.ApiHelper
import a740362.testloginapp.data.persistence.db.DbHelper
import a740362.testloginapp.data.persistence.pref.PrefHelper
import a740362.testloginapp.ui.activity.login.LoginViewModel
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
    private val prefHelper: PrefHelper
) : ViewModelProvider.NewInstanceFactory() {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {

            return LoginViewModel(dbHelper, apiHelper, prefHelper) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name} " /*+ modelClass.name*/)
    }
}
