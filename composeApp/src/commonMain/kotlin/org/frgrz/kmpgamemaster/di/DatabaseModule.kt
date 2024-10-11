package org.frgrz.kmpgamemaster.di

import org.frgrz.kmpgamemaster.data.dao.WGRoleDao
import org.frgrz.kmpgamemaster.data.dao.WGRoleDaoImpl
import org.frgrz.kmpgamemaster.data.datasource.WGRoleLocalDataSourceImpl
import org.frgrz.kmpgamemaster.data.db.RealmDatabase
import org.frgrz.kmpgamemaster.data.entities.WGRoleEntity
import org.frgrz.kmpgamemaster.data.mappers.WGRoleModelMapper
import org.frgrz.kmpgamemaster.features.wolfgame.WGRoleLocalDataSource
import org.koin.dsl.module

val databaseModule = module {
    single {
        RealmDatabase(
            schema = setOf(
                WGRoleEntity::class,
            )
        )
    }

    single<WGRoleDao> { WGRoleDaoImpl(get()) }
    factory { WGRoleModelMapper() }
    factory<WGRoleLocalDataSource> { WGRoleLocalDataSourceImpl(get(), get()) }
}

