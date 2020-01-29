package a740362.testloginapp.di.builderClass

import a740362.testloginapp.ui.activity.login.LoginActivity
import a740362.testloginapp.ui.activity.login.LoginActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [LoginActivityModule::class])
    abstract fun provideLoginActivity() : LoginActivity

}
