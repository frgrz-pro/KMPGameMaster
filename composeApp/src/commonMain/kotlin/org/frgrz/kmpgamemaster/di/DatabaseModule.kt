package org.frgrz.kmpgamemaster.di

import org.frgrz.kmpgamemaster.data.db.RealmDatabase
import org.frgrz.kmpgamemaster.data.entities.WGRoleEntity
import org.frgrz.kmpgamemaster.db.WGRoleDao
import org.frgrz.kmpgamemaster.db.WGRoleDaoImpl
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
}

