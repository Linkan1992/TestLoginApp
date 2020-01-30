package a740362.testloginapp.ui.activity.main

import a740362.testloginapp.base.BaseViewModel
import a740362.testloginapp.data.network.ApiHelper
import a740362.testloginapp.data.persistence.db.DbHelper
import a740362.testloginapp.data.persistence.pref.PrefHelper
import androidx.databinding.ObservableField

class MainViewModel(
    private val dbHelper: DbHelper,
    private val apiHelper: ApiHelper,
    private val prefHelper: PrefHelper
) : BaseViewModel() {


    private val userId = ObservableField<String>()

    val mUserId: ObservableField<String>
        get() = userId

    init {
        mUserId.set(prefHelper.userId)
    }


}