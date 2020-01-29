package a740362.testloginapp.data.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import a740362.testloginapp.data.network.base.BaseRepository
import a740362.testloginapp.data.network.base.Result
import a740362.testloginapp.data.persistence.pref.PrefHelper
import a740362.testloginapp.di.annotation.CoroutineScopeIO
import a740362.testloginapp.util.Validator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


class AppApiHelper @Inject
constructor(
  private val apiService: ApiService,
  @CoroutineScopeIO private val ioCoroutineScope: CoroutineScope, prefHelper: PrefHelper
) : BaseRepository(), ApiHelper {


  private val testLiveData: MutableLiveData<Result<String>> by lazy { MutableLiveData<Result<String>>() }

  override fun appLogin(username: String, password: String) {

    ioCoroutineScope.launch {

      testLiveData.postValue(Result.Loading())

      try {

        /**
         * simulating network call by making delay
         */
        delay(2000)

        val resp = if (Validator.isValidateCredential(username, password, "Admin", "Admin")) username else "invalid credential"

        testLiveData.postValue(Result.Success(resp))

      } catch (exception: Exception) {
        testLiveData.postValue(Result.Error(exception.message ?: exception.toString()))
      }

    }
  }

  override fun getTestLiveData(): LiveData<Result<String>> {
    return testLiveData
  }

}
