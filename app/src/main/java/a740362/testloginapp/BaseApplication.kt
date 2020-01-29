package a740362.testloginapp

import a740362.testloginapp.di.component.AppComponent
import a740362.testloginapp.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class BaseApplication : DaggerApplication() {

    private val appComponent : AppComponent by lazy { DaggerAppComponent.builder()
        .application(this)
        .build() }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return appComponent;
    }

    override fun onCreate() {
        super.onCreate()

        appComponent.inject(this);

    }

}
