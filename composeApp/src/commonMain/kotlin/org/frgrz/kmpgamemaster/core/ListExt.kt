package org.frgrz.kmpgamemaster.core

fun <T> List<T>.removeAllOccurrences(itemToRemove: T): List<T> {
    return this.filterNot { it == itemToRemove }
}

fun <T> List<T>.removeByFilter(predicate: (T) -> Boolean): List<T> {
    return this.filterNot(predicate)
}

fun <T> List<T>.removeAllFromAnotherList(otherList: List<T>): List<T> {
    return this.filterNot { otherList.contains(it) }
}

fun <T> List<T>.moveItemsBeforeIndexToEnd(randomIndex: Int): List<T> {
    if (randomIndex <= 0 || randomIndex >= this.size) {
        return this // Return original list if index is invalid
    }
    return this.subList(randomIndex, this.size) + this.subList(0, randomIndex)
}

fun Boolean.toInt() = if (this) 1 else 0