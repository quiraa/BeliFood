package com.quiraadev.goculinary.ui.screens.detail

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
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: CulinaryRepository
): ViewModel() {
    private val _culinary = MutableStateFlow<UiState<CulinaryEntity>>(UiState.Loading)
    val culinary = _culinary.asStateFlow()

    fun getCulinary(itemId : Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getItem(itemId)
                .catch { error -> _culinary.value = UiState.Error(error.message.toString()) }
                .collect{ culinary -> _culinary.value = UiState.Success(culinary) }
        }
    }

    fun updateWishlistedCulinary(itemId : Int, isWishlisted : Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateWishlistedItem(itemId, isWishlisted)
        }
    }
}