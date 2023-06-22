package com.elina.samplecodelabjc.feature.shared.repository

/**
 * Created by Elina on 31/05/2023.
 */

class HomeRepository : BaseRepository() {
    fun getHomeFromApi() =
        apiService.getHome(warehouseId = 1)
}
