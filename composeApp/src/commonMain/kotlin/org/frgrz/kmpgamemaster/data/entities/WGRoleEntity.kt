package org.frgrz.kmpgamemaster.data.entities

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.BsonObjectId
import org.mongodb.kbson.ObjectId

data class WGRoleEntity(
    var name: Int = 0,
    var default: Boolean = false,
) : RealmObject {
    @PrimaryKey
    var id: ObjectId = BsonObjectId()
    var selected: Boolean = default
}
