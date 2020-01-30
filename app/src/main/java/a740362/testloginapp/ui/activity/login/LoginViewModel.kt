package a740362.testloginapp.ui.activity.login

import a740362.testloginapp.base.BaseViewModel
import a740362.testloginapp.data.network.ApiHelper
import a740362.testloginapp.data.network.base.Result
import a740362.testloginapp.data.persistence.db.DbHelper
import a740362.testloginapp.data.persistence.pref.PrefHelper
import a740362.testloginapp.util.AppConstants
import a740362.testloginapp.util.Validator
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class LoginViewModel(
    private val dbHelper: DbHelper,
    private val apiHelper: ApiHelper,
    private val prefHelper: PrefHelper
) : BaseViewModel() {

    private val testLiveData: LiveData<Result<String>> =
        applyResultTransformation(apiHelper.getTestLiveData())

    private val validatorLiveData = MutableLiveData<Map<String, Boolean>>()

    val idInput = ObservableField<String>()

    val passInput = ObservableField<String>()

    val mTestLiveData: LiveData<Result<String>>
        get() = testLiveData

    val mValidatorLiveData: LiveData<Map<String, Boolean>>
        get() = validatorLiveData


    fun simulateLogin() {

        val id = idInput.get()
        val pass = passInput.get()

        val validationMap = Validator.validateField(id, pass)

        if (validationMap[AppConstants.VALID]!!) {
            id?.let { userId -> pass?.let { password -> apiHelper.appLogin(userId, password) } }
        } else
            validatorLiveData.postValue(validationMap)
    }

}
