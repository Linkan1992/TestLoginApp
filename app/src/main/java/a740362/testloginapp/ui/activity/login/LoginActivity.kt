package a740362.testloginapp.ui.activity.login

import a740362.testloginapp.BR
import a740362.testloginapp.R
import a740362.testloginapp.ViewModelProviderFactory
import a740362.testloginapp.base.BaseActivity
import a740362.testloginapp.data.network.base.Result
import a740362.testloginapp.databinding.ActivityLoginBinding
import a740362.testloginapp.ui.activity.main.MainActivity
import a740362.testloginapp.util.AppConstants
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import javax.inject.Inject

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {

  companion object {

    fun newIntent(context: Context) {
      val intent = Intent(context, LoginActivity::class.java)
      context.startActivity(intent)
    }

  }

  @Inject
  lateinit var viewModelProviderFactory: ViewModelProviderFactory


  private val loginViewModel: LoginViewModel by lazy {
    ViewModelProviders.of(this, viewModelProviderFactory).get(LoginViewModel::class.java)
  }


  override val layoutId: Int
    get() = R.layout.activity_login


  override val viewModel: LoginViewModel
    get() = loginViewModel


  override val bindingVariable: Int
    get() = BR.viewModel


  override val toolbar: Toolbar?
    get() = null


  override fun initOnCreate(savedInstanceState: Bundle?) {
      subscribeToLiveData()
  }

  private fun subscribeToLiveData() {

    loginViewModel.mTestLiveData.observe(this){result: Result<String> ->
      when(result){
        is Result.Success ->{
          MainActivity.newIntent(this)
          finish()
        }
        is Result.Error ->{
          result.message?.let { showToast(it) }
        }
      }
    }

    loginViewModel.mValidatorLiveData.observe(this){ validationMap : Map<String, Boolean> ->

      showToast(AppConstants.INVALID_CRED)

    }

  }


}
