package com.easyprog.genshin.di.modules

import com.easyprog.data.storage.RoomDatabaseApp
import com.easyprog.domain.repositories.HeroSettingsRepository
import com.easyprog.domain.repositories.HeroesRepository
import com.easyprog.domain.repositories.MainActivityRepository
import com.easyprog.domain.repositories.PurposeRepository
import com.easyprog.domain.repositories.implementations.HeroSettingsRepositoryImpl
import com.easyprog.domain.repositories.implementations.HeroesRepositoryImpl
import com.easyprog.domain.repositories.implementations.MainActivityRepositoryImpl
import com.easyprog.domain.repositories.implementations.PurposeRepositoryImpl
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

    @Singleton
    @Provides
    fun provideMainActivityRepository(roomDatabaseApp: RoomDatabaseApp): MainActivityRepository {
        return MainActivityRepositoryImpl(localDataSource = roomDatabaseApp)
    }

    @Singleton
    @Provides
    fun providePurposeRepository(roomDatabaseApp: RoomDatabaseApp): PurposeRepository {
        return PurposeRepositoryImpl(localDataSource = roomDatabaseApp)
    }

    @Singleton
    @Provides
    fun provideHeroesRepository(roomDatabaseApp: RoomDatabaseApp): HeroesRepository {
        return HeroesRepositoryImpl(localDataSource = roomDatabaseApp)
    }

}