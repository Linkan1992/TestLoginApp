package a740362.testloginapp.di.annotation

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

import javax.inject.Qualifier

@Qualifier
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class CoroutineScopeIO
