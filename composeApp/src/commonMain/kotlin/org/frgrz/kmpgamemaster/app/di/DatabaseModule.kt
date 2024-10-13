package org.frgrz.kmpgamemaster.app.di

import org.frgrz.kmpgamemaster.data.db.RealmDatabase
import org.frgrz.kmpgamemaster.data.entities.WGRoleDBEntity
import org.koin.dsl.module

val databaseModule = module {
    single {
        RealmDatabase(
            schema = setOf(
                WGRoleDBEntity::class,
            )
        )
    }
}
