package a740362.testloginapp.ui.activity.login

import a740362.testloginapp.BR
import a740362.testloginapp.R
import a740362.testloginapp.ViewModelProviderFactory
import a740362.testloginapp.base.BaseActivity
import a740362.testloginapp.databinding.ActivityLoginBinding
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProviders
import javax.inject.Inject

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {

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


  override val customTitle: String
    get() = ""


  override val toolbar: Toolbar?
    get() = null


  override fun initOnCreate(savedInstanceState: Bundle?) {

  }


}
