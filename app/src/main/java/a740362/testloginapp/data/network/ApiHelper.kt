package a740362.testloginapp.data.network

import androidx.lifecycle.LiveData
import a740362.testloginapp.data.network.base.Result

interface ApiHelper{

    fun appLogin(username : String, password : String)

    fun getApiLiveData() : LiveData<Result<String>>;

}
