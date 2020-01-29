package a740362.testloginapp.data.persistence.db

import a740362.testloginapp.data.persistence.dao.AppDatabase
import a740362.testloginapp.di.annotation.CoroutineScopeIO
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class AppDbHelper @Inject
constructor(private val appDatabase: AppDatabase, @CoroutineScopeIO private val ioCoroutineScope : CoroutineScope) : DbHelper {

  // implement method for DB transaction defined in DBhHelper interface

}
