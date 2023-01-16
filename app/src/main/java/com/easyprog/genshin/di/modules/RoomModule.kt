package com.easyprog.genshin.di.modules

import android.content.Context
import androidx.room.Room
import com.easyprog.data.storage.RoomDatabaseApp
import com.easyprog.data.storage.contract.RoomContract
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context): RoomDatabaseApp =
        Room.databaseBuilder(context, RoomDatabaseApp::class.java, RoomContract.databaseApp)
            .build()

}