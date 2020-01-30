package a740362.testloginapp.data.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import a740362.testloginapp.data.network.base.BaseRepository
import a740362.testloginapp.data.network.base.Result
import a740362.testloginapp.data.persistence.pref.PrefHelper
import a740362.testloginapp.di.annotation.CoroutineScopeIO
import a740362.testloginapp.util.AppConstants
import a740362.testloginapp.util.Validator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


class AppApiHelper @Inject
constructor(
    private val apiService: ApiService,
    @CoroutineScopeIO private val ioCoroutineScope: CoroutineScope, private val prefHelper: PrefHelper
) : BaseRepository(), ApiHelper {


    private val testLiveData: MutableLiveData<Result<String>> by lazy { MutableLiveData<Result<String>>() }

    override fun appLogin(username: String, password: String) {

        ioCoroutineScope.launch {

            testLiveData.postValue(Result.Loading())

            try {

                /**
                 * simulating network call by making delay
                 */
                delay(AppConstants.SPLASH_TIME_IN_MILLIS)

                if (Validator.isValidateCredential(username, password, AppConstants.LOGIN_ID, AppConstants.LOGIN_PASS)) {
                    prefHelper.userId = username
                    prefHelper.isLoggedIn = true
                    testLiveData.postValue(Result.Success(AppConstants.SUCCESS))

                } else testLiveData.postValue(Result.Error(AppConstants.INVALID_CRED))


            } catch (exception: Exception) {
                testLiveData.postValue(Result.Error(exception.message ?: exception.toString()))
            }

        }
    }

    override fun getTestLiveData(): LiveData<Result<String>> {
        return testLiveData
    }

}
