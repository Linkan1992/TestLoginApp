package a740362.testloginapp.ui.activity.splash

import a740362.testloginapp.BR
import a740362.testloginapp.R
import a740362.testloginapp.ViewModelProviderFactory
import a740362.testloginapp.base.BaseActivity
import a740362.testloginapp.data.network.base.Result
import a740362.testloginapp.databinding.ActivitySplashBinding
import a740362.testloginapp.ui.activity.login.LoginActivity
import a740362.testloginapp.ui.activity.main.MainActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import javax.inject.Inject

class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory


    private val splashViewModel: SplashViewModel by lazy {
        ViewModelProviders.of(this, viewModelProviderFactory).get(SplashViewModel::class.java)
    }

    override val layoutId: Int
        get() = R.layout.activity_splash


    override val viewModel: SplashViewModel
        get() = splashViewModel


    override val bindingVariable: Int
        get() = BR.viewModel


    override val toolbar: Toolbar?
        get() = null


    override fun initOnCreate(savedInstanceState: Bundle?) {
        subscribeToLiveData()
    }

    private fun subscribeToLiveData() {

        splashViewModel.mStatusLiveData.observe(this, Observer { result ->
            when (result) {
                is Result.Success -> {
                    MainActivity.newIntent(this)
                    finish()
                }
                is Result.Error -> {
                    LoginActivity.newIntent(this)
                    finish()
                }
            }
        })

    }
}
