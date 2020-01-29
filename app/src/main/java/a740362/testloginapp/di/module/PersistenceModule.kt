package a740362.testloginapp.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.annotation.NonNull
import androidx.room.Room
import a740362.testloginapp.data.persistence.dao.AppDatabase
import com.linkan.githubtrendingrepos.di.annotation.DatabaseInfo
import com.linkan.githubtrendingrepos.di.annotation.PreferenceInfo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PersistenceModule{

    @Provides
    @PreferenceInfo
    internal fun providePrefName() : String{
        return "TestLoginPref"
    }

    @Provides
    @DatabaseInfo
    internal fun provideDBName() : String{
        return "TestLoginApp.db"
    }

    @Provides
    @Singleton
    internal fun providePreference(@PreferenceInfo prefName : String, @NonNull application : Application) : SharedPreferences{
        return application.getSharedPreferences(prefName, Context.MODE_PRIVATE)
    }


    @Provides
    @Singleton
    internal fun provideAppDatabase(@NonNull application : Application, @DatabaseInfo dbName : String) : AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, dbName)
            .fallbackToDestructiveMigration()
            .build()
    }

}
