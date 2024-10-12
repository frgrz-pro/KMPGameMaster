package org.frgrz.kmpgamemaster.features.home.ui

import org.frgrz.kmpgamemaster.data.dao.WGRoleDao

class HomeRepository(private val dao: WGRoleDao) {
    fun resetValues() {
        dao.resetValues()
    }
}