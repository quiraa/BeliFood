package com.quiraadev.goculinary.data.repository

import com.quiraadev.goculinary.data.local.CulinaryDao
import com.quiraadev.goculinary.data.local.CulinaryEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CulinaryRepository @Inject constructor(private val dao: CulinaryDao) {
    fun getAllItems() = dao.getAllCulinaryItem()
    fun getAllWishlistedItems() = dao.getAllWishlistedCulinary()
    fun getItem(itemId: Int) = dao.getCulinary(itemId)
    fun searchItem(query: String) = dao.searchCulinary(query)
    suspend fun insertAllItem(culinaries: List<CulinaryEntity>) = dao.insertAllCulinary(culinaries)
    suspend fun updateWishlistedItem(itemId: Int, isWishlisted: Boolean) =
        dao.updateWishlistedCulinary(itemId, isWishlisted)
}