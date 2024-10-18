package org.frgrz.kmpgamemaster.features.wolfgame.di

import org.frgrz.kmpgamemaster.data.dao.WGRoleDao
import org.frgrz.kmpgamemaster.data.dao.WGRoleDaoImpl
import org.frgrz.kmpgamemaster.features.wolfgame.data.WGGameCache
import org.frgrz.kmpgamemaster.features.wolfgame.data.WGRoleFilterMapper
import org.frgrz.kmpgamemaster.features.wolfgame.data.WGRoleLocalDataSource
import org.frgrz.kmpgamemaster.features.wolfgame.data.WGRoleLocalDataSourceImpl
import org.frgrz.kmpgamemaster.features.wolfgame.data.WGRoleModelMapper
import org.frgrz.kmpgamemaster.features.wolfgame.domain.GameLogCache
import org.frgrz.kmpgamemaster.features.wolfgame.domain.GameLogRepository
import org.frgrz.kmpgamemaster.features.wolfgame.domain.GameLogRepositoryImpl
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.GetRolesForFilterUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.GetRoleSelectionUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.WGRoleRepository
import org.frgrz.kmpgamemaster.features.wolfgame.domain.WGRoleRepositoryImpl
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.PlayerNameValidationUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.CacheGameConfigurationUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.CachePlayersUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.GetCachedPlayersUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.GetGameConfigurationUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.deck.GenerateRoleDeckUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.UpdateRoleSelectionUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.deck.GetRoleCategoriesUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.deck.MapRoleViewModelUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.deck.GetExtraRolesUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.deck.GetSoloRolesUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.deck.GetVillagerRolesUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.deck.GetWolfRolesUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.deck.VerifyRoleCompatibilityUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.log.LogPlayerChangedUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.log.GetLogUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.log.LogCacheGameSettingsUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.log.LogRoleAssignedUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.domain.usecases.log.LogRoleDeckUseCase
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.LogScreenViewModel
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.GameScreenViewModel
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.SetupScreenViewModel
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.PlayersScreenViewModel
import org.frgrz.kmpgamemaster.features.wolfgame.presentation.RolesScreenViewModel
import org.koin.dsl.module

val wgModule = module {

    //region Data Access

    factory<WGRoleDao> { WGRoleDaoImpl(db = get()) }
    factory<WGRoleLocalDataSource> { WGRoleLocalDataSourceImpl(dao = get()) }
    single { WGGameCache() }
    single { GameLogCache() }

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

    factory<GameLogRepository> {
        GameLogRepositoryImpl(
            cache = get()
        )
    }

    //region DB UseCases

    factory { GetRolesForFilterUseCase(repository = get()) }
    factory { UpdateRoleSelectionUseCase(repository = get()) }
    factory { GetRoleSelectionUseCase(repository = get()) }

    //region Cache UseCases

    factory { CachePlayersUseCase(repository = get()) }
    factory { GetCachedPlayersUseCase(repository = get()) }
    factory { CacheGameConfigurationUseCase(repository = get()) }
    factory { GetGameConfigurationUseCase(repository = get()) }

    //region Deck UseCases

    factory { GetRoleCategoriesUseCase() }
    factory { MapRoleViewModelUseCase(mapper = get()) }
    factory { GetExtraRolesUseCase() }
    factory { GetSoloRolesUseCase() }
    factory { GetVillagerRolesUseCase() }
    factory { GetWolfRolesUseCase() }
    factory { VerifyRoleCompatibilityUseCase() }
    factory {
        GenerateRoleDeckUseCase(
            verifyRoleCompatibilityUseCase = get(),
            categorizeRolesUseCase = get(),
            mapRolesToViewModelUseCase = get(),
            selectWolvesUseCase = get(),
            selectSoloUseCase = get(),
            selectVillagersUseCase = get(),
            selectExtraRolesUseCase = get(),
            logger = get()
        )
    }

    //region Other Use Cases

    factory { PlayerNameValidationUseCase() }
    factory { GetLogUseCase(repository = get()) }
    factory { LogPlayerChangedUseCase(repository = get()) }
    factory { LogCacheGameSettingsUseCase(repository = get()) }
    factory { LogRoleDeckUseCase(repository = get()) }
    factory { LogRoleAssignedUseCase(repository = get()) }

    //region ViewModels

    factory {
        SetupScreenViewModel(
            getRoleSelectionUseCase = get(),
            getCachedPlayersUseCase = get(),
            cacheGameSettingsUseCase = get()
        )
    }

    factory {
        RolesScreenViewModel(
            filterRolesListUseCase = get(),
            updateRoleCheckUseCase = get()
        )
    }

    factory {
        PlayersScreenViewModel(
            cachePlayersUseCase = get(),
            validateEntryUseCase = get(),
            log = get()
        )
    }

    factory {
        GameScreenViewModel(
            getGameConfigurationUseCase = get(),
            getRoleDeckUseCase = get(),
            logCacheGameSettingsUseCase = get(),
            logRoleAssignedUseCase = get()
        )
    }

    factory {
        LogScreenViewModel(
            getLogUseCase = get()
        )
    }

}
