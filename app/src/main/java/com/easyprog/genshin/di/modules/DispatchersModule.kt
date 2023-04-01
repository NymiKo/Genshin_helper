package com.easyprog.genshin.di.modules

import com.easyprog.genshin.DispatchersList
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DispatchersModule {

    @Singleton
    @Provides
    fun provideDispatchersList(): DispatchersList = DispatchersList.Base()

}