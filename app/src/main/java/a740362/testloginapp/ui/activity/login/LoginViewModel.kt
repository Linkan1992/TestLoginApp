package a740362.testloginapp.ui.activity.login

import a740362.testloginapp.base.BaseViewModel
import a740362.testloginapp.data.network.ApiHelper
import a740362.testloginapp.data.network.base.Result
import a740362.testloginapp.data.persistence.db.DbHelper
import a740362.testloginapp.data.persistence.pref.PrefHelper
import androidx.lifecycle.LiveData

class LoginViewModel(
    dbHelper: DbHelper,
    apiHelper: ApiHelper,
    prefHelper: PrefHelper
) : BaseViewModel() {

    private val testLiveData: LiveData<Result<String>> =
        applyResultTransformation(apiHelper.getTestLiveData())

    val mTestLiveData: LiveData<Result<String>>
        get() = testLiveData

    init {
        apiHelper.appLogin("Admin", "Admin")
    }

}
