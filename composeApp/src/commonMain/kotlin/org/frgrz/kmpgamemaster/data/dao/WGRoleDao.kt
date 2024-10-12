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

            WGRoleEntity(
                role = WGRole.LITTLE_GIRL,
                default = true
            ),
            WGRoleEntity(
                role = WGRole.HUNTER,
                default = true
            ),
            WGRoleEntity(
                role = WGRole.MAYOR,
                default = true
            ),
            WGRoleEntity(
                role = WGRole.CUPID,
                default = true
            ),
            WGRoleEntity(
                role = WGRole.PEASANT,
                default = true
            ),
            WGRoleEntity(
                role = WGRole.SEER,
                default = true
            ),
            WGRoleEntity(
                role = WGRole.SORCERER,
                default = true
            ),
            WGRoleEntity(
                role = WGRole.THIEF,
                default = true
            ),
            WGRoleEntity(
                role = WGRole.WOLF,
                default = true
            ),
            WGRoleEntity(
                role = WGRole.ANGEL,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.ASSASSIN,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.ASTRONOMER,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.BEAR_HANDLER,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.BERSERK,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.BIG_BAG_WOLF,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.BLACK_WOLF,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.BLACKSMITH,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.BLUE_WOLF,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.BULLY,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.CASSANDRA,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.COMEDIAN,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.CORRUPTER,
                default = false
            ),

            WGRoleEntity(
                role = WGRole.DEFLECTOR,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.DEMONIAC_SOUL,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.DRUGGIST,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.DUELISTS,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.FOX,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.GENTLEMAN,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.GUARD,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.GURU,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.HITMAN,
                default = false
            ),

            WGRoleEntity(
                role = WGRole.IDIOT,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.MARSHALL,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.MOON_SON,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.NOCTAMBULIST,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.OLD_KNIGHT,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.PIED_PIPER,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.PRIEST,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.PYROMANIAC,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.RANGER,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.THREE_BROTHERS,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.TRAITOR,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.TWO_SISTERS,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.VILLAGE_ELDER,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.WHITE_SOOTHSAYER,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.WHITE_WOLF,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.WILD_KID,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.WIZARD,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.WOLF_BERSERK,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.WOLF_DOG,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.WOLF_FAN,
                default = false
            ),
            WGRoleEntity(
                role = WGRole.WOLF_KITTEN,
                default = false
            )
        )

        roles.forEach { db.upsert(it) }
    }
}