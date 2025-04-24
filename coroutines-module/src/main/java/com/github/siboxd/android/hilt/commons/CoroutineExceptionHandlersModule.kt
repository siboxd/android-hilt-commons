package com.github.siboxd.android.hilt.commons

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineExceptionHandler
import timber.log.Timber
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoroutineExceptionHandlersModule {

    @Singleton
    @Provides
    @LogThrownExceptionHandler
    fun provideLogThrownExceptionHandler(): CoroutineExceptionHandler =
        CoroutineExceptionHandler { _, throwable ->
            Timber.e(throwable, "Current coroutine died. Investigate why.")
        }

    @Singleton
    @Provides
    @ReThrowExceptionHandler
    fun provideReThrowExceptionHandler(): CoroutineExceptionHandler =
        CoroutineExceptionHandler { _, throwable -> throw throwable }
}

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class LogThrownExceptionHandler

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class ReThrowExceptionHandler