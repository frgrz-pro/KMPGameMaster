package org.frgrz.kmpgamemaster.features.wolfgame.di

import org.frgrz.kmpgamemaster.data.dao.WGRoleDao
import org.frgrz.kmpgamemaster.data.dao.WGRoleDaoImpl
import org.frgrz.kmpgamemaster.features.wolfgame.data.WGGameCache
import org.frgrz.kmpgamemaster.features.wolfgame.data.WGRoleFilterMapper
import org.frgrz.kmpgamemaster.features.wolfgame.data.WGRoleLocalDataSource
import org.frgrz.kmpgamemaster.features.wolfgame.data.WGRoleLocalDataSourceImpl
import org.frgrz.kmpgamemaster.features.wolfgame.data.WGRoleModelMapper
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.GetRolesForFilterUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.GetRoleSelectionUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.WGRoleRepository
import org.frgrz.kmpgamemaster.features.wolfgame.domain.WGRoleRepositoryImpl
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.CacheGameSettingsUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.CachePlayersUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.GetCachedPlayersUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.GetGameSettingsUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.GetRoleDeckUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.UpdateRoleSelectionUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.WGGameViewModel
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.WGSetupViewModel
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.WGPlayersViewModel
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.WGRoleViewModel
import org.koin.dsl.module

val wgModule = module {

    //region Data Access

    factory<WGRoleDao> { WGRoleDaoImpl(db = get()) }
    factory<WGRoleLocalDataSource> { WGRoleLocalDataSourceImpl(dao = get()) }
    single { WGGameCache() }

    //region Mappers

    factory { WGRoleModelMapper() }
    factory { WGRoleFilterMapper() }

    //region Repository

    factory<WGRoleRepository> {
        WGRoleRepositoryImpl(
            roleLocalDataSource = get(),
            roleModelMapper = get(),
            roleFilterMapper = get(),
            cache = get()
        )
    }

    //region UseCases

    factory { GetRolesForFilterUseCase(repository = get()) }
    factory { UpdateRoleSelectionUseCase(repository = get()) }
    factory { GetRoleSelectionUseCase(repository = get()) }
    factory { CachePlayersUseCase(repository = get()) }
    factory { GetCachedPlayersUseCase(repository = get()) }
    factory { CacheGameSettingsUseCase(repository = get()) }
    factory { GetGameSettingsUseCase(repository = get()) }
    factory { GetRoleDeckUseCase(mapper = get()) }

    //region ViewModels

    factory {
        WGSetupViewModel(
            getRoleSelectionUseCase = get(),
            getCachedPlayersUseCase = get(),
            cacheGameSettingsUseCase = get()
        )
    }

    factory {
        WGRoleViewModel(
            filterRolesListUseCase = get(),
            updateRoleCheckUseCase = get()
        )
    }

    factory {
        WGPlayersViewModel(
            cachePlayersUseCase = get()
        )
    }

    factory {
        WGGameViewModel(
            getGameSettingsUseCase = get(),
            getRoleDeckUseCase = get()
        )
    }

}
