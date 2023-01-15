package com.easyprog.genshin.di.modules

import com.easyprog.data.storage.RoomDatabaseApp
import com.easyprog.domain.repositories.*
import com.easyprog.domain.repositories.implementations.*
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
    fun providePurposeRepository(roomDatabaseApp: RoomDatabaseApp): GoalsRepository {
        return GoalsRepositoryImpl(localDataSource = roomDatabaseApp)
    }

    @Singleton
    @Provides
    fun provideHeroesRepository(roomDatabaseApp: RoomDatabaseApp): HeroesRepository {
        return HeroesRepositoryImpl(localDataSource = roomDatabaseApp)
    }

    @Singleton
    @Provides
    fun provideHeroProfileRepository(roomDatabaseApp: RoomDatabaseApp): HeroProfileRepository {
        return HeroProfileRepositoryImpl(localDataSource = roomDatabaseApp)
    }

}