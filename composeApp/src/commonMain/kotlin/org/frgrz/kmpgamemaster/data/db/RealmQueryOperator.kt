package org.frgrz.kmpgamemaster.data.db


infix fun <T : Any> String.equalTo(that: T) =
    RealmQueryConstraint.EqualTo(this, that)

infix fun <T : Any> String.greaterThan(that: T) =
    RealmQueryConstraint.GreaterThan(this, that)

infix fun <T : Any> String.greaterThanOrEqualTo(that: T) =
    RealmQueryConstraint.GreaterThanOrEqualTo(this, that)

infix fun <T : Any> String.lessThan(that: T) =
    RealmQueryConstraint.LessThan(this, that)

infix fun <T : Any> String.lessThanOrEqualTo(that: T) =
    RealmQueryConstraint.LessThanOrEqualTo(this, that)