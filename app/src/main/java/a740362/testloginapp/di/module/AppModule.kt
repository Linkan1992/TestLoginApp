package a740362.testloginapp.di.module

import android.app.Application
import android.content.Context
import androidx.annotation.NonNull
import a740362.testloginapp.data.network.ApiHelper
import a740362.testloginapp.data.network.AppApiHelper
import a740362.testloginapp.data.persistence.db.AppDbHelper
import a740362.testloginapp.data.persistence.db.DbHelper
import a740362.testloginapp.data.persistence.pref.AppPrefHelper
import a740362.testloginapp.data.persistence.pref.PrefHelper
import a740362.testloginapp.di.annotation.CoroutineScopeIO
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideApplicationContext(@NonNull application: Application): Context {
        return application;
    }


    @Provides
    @CoroutineScopeIO
    internal fun provideCoroutineScopeIO() : CoroutineScope = CoroutineScope(Dispatchers.IO)


    @Provides
    @Singleton
    internal fun provideDBHelper(appDbHelper: AppDbHelper) : DbHelper = appDbHelper


    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper) : ApiHelper = appApiHelper


    @Provides
    @Singleton
    internal fun providePrefHelper(appPrefHelper: AppPrefHelper) : PrefHelper = appPrefHelper


}
