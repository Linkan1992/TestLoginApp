package a740362.testloginapp.di.builderClass

import a740362.testloginapp.ui.activity.login.LoginActivity
import a740362.testloginapp.ui.activity.login.LoginActivityModule
import a740362.testloginapp.ui.activity.main.MainActivity
import a740362.testloginapp.ui.activity.main.MainActivityModule
import a740362.testloginapp.ui.activity.splash.SplashActivity
import a740362.testloginapp.ui.activity.splash.SplashActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    abstract fun provideSplashActivity() : SplashActivity

    @ContributesAndroidInjector(modules = [LoginActivityModule::class])
    abstract fun provideLoginActivity() : LoginActivity

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun provideMainActivity() : MainActivity

}
