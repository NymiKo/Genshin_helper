package com.easyprog.genshin.di.modules

import com.easyprog.data.storage.RoomDatabaseApp
import com.easyprog.domain.repositories.HeroSettingsRepository
import com.easyprog.domain.repositories.implementations.HeroSettingsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideHeroSettingsRepository(roomDatabaseApp: RoomDatabaseApp): HeroSettingsRepository {
        return HeroSettingsRepositoryImpl(localDataSource = roomDatabaseApp)
    }

}