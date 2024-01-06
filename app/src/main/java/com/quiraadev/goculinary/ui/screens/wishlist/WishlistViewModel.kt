package com.quiraadev.goculinary.ui.screens.wishlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quiraadev.goculinary.data.local.CulinaryEntity
import com.quiraadev.goculinary.data.repository.CulinaryRepository
import com.quiraadev.goculinary.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WishlistViewModel @Inject constructor(
    private val repository : CulinaryRepository
) : ViewModel() {
    private val _allWislistedItem = MutableStateFlow<UiState<List<CulinaryEntity>>>(UiState.Loading)
    val allWishlistedItem  = _allWislistedItem.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllWishlistedItems()
                .catch { error -> _allWislistedItem.value = UiState.Error(error.message.toString()) }
                .collect { items -> _allWislistedItem.value = UiState.Success(items)}
        }
    }

    fun updateWishlistedItem(itemId : Int, isWishlisted : Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateWishlistedItem(itemId, isWishlisted)
        }
    }

//    fun deleteAllWishlistedItem() {
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.deleteAllItem()
//        }
//    }
}