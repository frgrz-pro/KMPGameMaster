package org.frgrz.kmpgamemaster.data.dao

import kotlinx.coroutines.flow.Flow
import org.frgrz.kmpgamemaster.data.db.RealmDatabase
import org.frgrz.kmpgamemaster.data.entities.WGRole
import org.frgrz.kmpgamemaster.data.entities.WGRoleEntity

interface WGRoleDao {

    fun all(): Flow<List<WGRoleEntity>>

    fun resetValues()

}

class WGRoleDaoImpl(private val db: RealmDatabase) : WGRoleDao {

    private var isSeeded = false

    init {
        isSeeded = db.getAll<WGRoleEntity>().isNotEmpty()

        if (!isSeeded) {
            seed()
        }
    }

    override fun all(): Flow<List<WGRoleEntity>> = db.getAllAsFlow<WGRoleEntity>()

    override fun resetValues() {
        db.getAll<WGRoleEntity>()
            .map {
                val updated = it.apply { it.selected = it.default }
                db.upsert(updated)
            }
    }

    private fun seed() {
        val roles = listOf(

            WGRoleEntity(role = WGRole.LITTLE_GIRL, default = true),
            WGRoleEntity(role = WGRole.HUNTER, default = true),
            WGRoleEntity(role = WGRole.MAYOR, default = true),
            WGRoleEntity(role = WGRole.CUPID, default = true),
            WGRoleEntity(role = WGRole.PEASANT, default = true),
            WGRoleEntity(role = WGRole.SEER, default = true),
            WGRoleEntity(role = WGRole.SORCERER, default = true),
            WGRoleEntity(role = WGRole.THIEF, default = true),
            WGRoleEntity(role = WGRole.ANGEL),
            WGRoleEntity(role = WGRole.ASSASSIN),
            WGRoleEntity(role = WGRole.ASTRONOMER),
            WGRoleEntity(role = WGRole.BEAR_HANDLER),
            WGRoleEntity(role = WGRole.BERSERK),
            WGRoleEntity(role = WGRole.WOLF, default = true),
            WGRoleEntity(role = WGRole.WHITE_WOLF),
            WGRoleEntity(role = WGRole.BLACK_WOLF),
            WGRoleEntity(role = WGRole.BIG_BAG_WOLF),
            WGRoleEntity(role = WGRole.BLUE_WOLF),
            WGRoleEntity(role = WGRole.WOLF_BERSERK),
            WGRoleEntity(role = WGRole.WOLF_DOG),
            WGRoleEntity(role = WGRole.WOLF_KITTEN),
            WGRoleEntity(role = WGRole.WOLF_FAN),
            WGRoleEntity(role = WGRole.BLACKSMITH),
            WGRoleEntity(role = WGRole.BULLY),
            WGRoleEntity(role = WGRole.CASSANDRA),
            WGRoleEntity(role = WGRole.COMEDIAN),
            WGRoleEntity(role = WGRole.CORRUPTER),
            WGRoleEntity(role = WGRole.DEFLECTOR),
            WGRoleEntity(role = WGRole.DEMONIAC_SOUL),
            WGRoleEntity(role = WGRole.DRUGGIST),
            WGRoleEntity(role = WGRole.DUELISTS),
            WGRoleEntity(role = WGRole.FOX),
            WGRoleEntity(role = WGRole.GENTLEMAN),
            WGRoleEntity(role = WGRole.GUARD),
            WGRoleEntity(role = WGRole.GURU),
            WGRoleEntity(role = WGRole.HITMAN),
            WGRoleEntity(role = WGRole.IDIOT),
            WGRoleEntity(role = WGRole.MARSHALL),
            WGRoleEntity(role = WGRole.MOON_SON),
            WGRoleEntity(role = WGRole.NOCTAMBULIST),
            WGRoleEntity(role = WGRole.OLD_KNIGHT),
            WGRoleEntity(role = WGRole.PIED_PIPER),
            WGRoleEntity(role = WGRole.PRIEST),
            WGRoleEntity(role = WGRole.PYROMANIAC),
            WGRoleEntity(role = WGRole.RANGER),
            WGRoleEntity(role = WGRole.THREE_BROTHERS),
            WGRoleEntity(role = WGRole.TRAITOR),
            WGRoleEntity(role = WGRole.TWO_SISTERS),
            WGRoleEntity(role = WGRole.VILLAGE_ELDER),
            WGRoleEntity(role = WGRole.WHITE_SOOTHSAYER),
            WGRoleEntity(role = WGRole.WILD_KID),
            WGRoleEntity(role = WGRole.WIZARD),

        )

        roles.forEach { db.upsert(it) }
    }
}