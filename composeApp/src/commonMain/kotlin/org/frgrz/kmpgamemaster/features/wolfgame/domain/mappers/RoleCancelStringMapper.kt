package org.frgrz.kmpgamemaster.features.wolfgame.domain.mappers

import org.frgrz.kmpgamemaster.features.wolfgame.domain.models.RoleCancel

class RoleCancelStringMapper : Mapper<RoleCancel, String> {

    override fun map(input: RoleCancel): String {
        return when (input) {
            RoleCancel.WOLVES -> "Immunisé contre les Loups"
            RoleCancel.NONE -> ""
            RoleCancel.SEERS -> "Immunisé des rôles de Voyance"
            RoleCancel.POTIONS -> "Immunisé contre les Potions"
            RoleCancel.GURUS -> "Immunisé contre les rôles de Guilde (Guru, Joueur de Flûte)"
        }
    }
}