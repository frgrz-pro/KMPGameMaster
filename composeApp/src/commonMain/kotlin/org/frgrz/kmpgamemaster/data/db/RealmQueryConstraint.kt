package org.frgrz.kmpgamemaster.data.db


sealed class RealmQueryConstraint(val query: String, open val value: Any) {
    data class EqualTo(val key: String, override val value: Any) :
        RealmQueryConstraint(query = "$key == $0", value = value)

    data class GreaterThan(val key: String, override val value: Any) :
        RealmQueryConstraint(query = "$key > $0", value = value)

    data class GreaterThanOrEqualTo(val key: String, override val value: Any) :
        RealmQueryConstraint(query = "$key >= $0", value = value)

    data class LessThan(val key: String, override val value: Any) :
        RealmQueryConstraint(query = "$key < $0", value = value)

    data class LessThanOrEqualTo(val key: String, override val value: Any) :
        RealmQueryConstraint(query = "$key <= $0", value = value)
}