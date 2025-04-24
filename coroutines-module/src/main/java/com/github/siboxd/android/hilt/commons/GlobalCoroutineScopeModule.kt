package com.github.siboxd.android.hilt.commons

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GlobalCoroutineScopeModule {

    @Singleton
    @Provides
    @ApplicationCoroutineScope
    fun provideApplicationCoroutineScope(
        @LogThrownExceptionHandler logThrownExceptionHandler: CoroutineExceptionHandler
    ): CoroutineScope = CoroutineScope(
        SupervisorJob() + logThrownExceptionHandler
    )
}

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class ApplicationCoroutineScope