package a740362.testloginapp.ui.activity.splash

import a740362.testloginapp.base.BaseViewModel
import a740362.testloginapp.data.network.ApiHelper
import a740362.testloginapp.data.network.base.Result
import a740362.testloginapp.data.persistence.pref.PrefHelper
import a740362.testloginapp.util.AppConstants
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel(
    private val apiHelper: ApiHelper,
    private val prefHelper: PrefHelper,
    private val ioCoroutineScope: CoroutineScope
) : BaseViewModel() {

    //  private val statusLiveData = MutableLiveData<Result<String>>()

    private val statusLiveData: MutableLiveData<Result<String>> by lazy { MutableLiveData<Result<String>>() }

    val mStatusLiveData: LiveData<Result<String>>
        get() = statusLiveData

    init {
        ioCoroutineScope.launch {

            delay(AppConstants.SPLASH_TIME_IN_MILLIS)

            if (prefHelper.isLoggedIn) {
                statusLiveData.postValue(Result.Success(AppConstants.SUCCESS))
            } else
                statusLiveData.postValue(Result.Error(AppConstants.LOG_OUT))
        }
    }


}