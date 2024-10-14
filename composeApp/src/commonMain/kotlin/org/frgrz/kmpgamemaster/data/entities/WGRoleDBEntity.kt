package org.frgrz.kmpgamemaster.data.entities

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.BsonObjectId
import org.mongodb.kbson.ObjectId

open class WGRoleDBEntity : RealmObject {

    constructor()

    constructor(
        role: WGRole = WGRole.DEFAULT,
        default: Boolean = false,
    ): this() {
        this.default = default
        this.selected = default
        this.role = role.name
    }

    @PrimaryKey
    var id: ObjectId = BsonObjectId()
    var default: Boolean = false
    var selected: Boolean = false
    var role: String = ""

    enum class WGRole {
        ANGEL,
        ASSASSIN,
        ASTRONOMER, //TODO Rename resources Astronomer
        BEAR_HANDLER,
        BERSERK,
        BIG_BAG_WOLF,
        BLACK_WOLF,
        BLACKSMITH,
        BLUE_WOLF,
        BULLY,
        CASSANDRA,
        COMEDIAN,
        CORRUPTER,
        CUPID,
        DEFLECTOR,
        DEMONIAC_SOUL,
        DRUGGIST,
        DUELISTS,
        FOX,
        GENTLEMAN,
        GUARD,
        GURU,
        HITMAN, //TODO Rename Accusateurs
        HUNTER,
        IDIOT,
        LITTLE_GIRL,
        MARSHALL,
        MAYOR,
        MOON_SON,
        NOCTAMBULIST, //TODO Rename SLEEP_WALKER
        OLD_KNIGHT,
        PEASANT,
        PIED_PIPER,
        PRIEST,
        PYROMANIAC, //TODO Rename resources Pyromaniac
        RANGER,
        SEER,
        SORCERER,
        THIEF,
        THREE_BROTHERS,
        TRAITOR,
        TWO_SISTERS,
        VILLAGE_ELDER,
        WHITE_SOOTHSAYER,
        WHITE_WOLF,
        WILD_KID,
        WIZARD,
        WOLF_BERSERK,
        WOLF_DOG,
        WOLF_FAN,
        WOLF_KITTEN,
        WOLF;

        companion object {
            val DEFAULT = PEASANT
        }
    }
}
