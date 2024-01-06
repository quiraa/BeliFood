package com.quiraadev.goculinary.ui.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quiraadev.goculinary.data.kotpref.AppPreference
import com.quiraadev.goculinary.data.local.CulinaryEntity
import com.quiraadev.goculinary.data.repository.CulinaryRepository
import com.quiraadev.goculinary.utils.CulinaryData
import com.quiraadev.goculinary.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: CulinaryRepository
) : ViewModel() {

    private val _allCulinary = MutableStateFlow<UiState<List<CulinaryEntity>>>(UiState.Loading)
    val allCulinary = _allCulinary.asStateFlow()

    private val _homeState = mutableStateOf(HomeState())
    val homeState: State<HomeState> = _homeState

    private val _isDarkMode = mutableStateOf(AppPreference.darkMode)
    val isDarkMode: State<Boolean> = _isDarkMode

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllItems().collect { culinary ->
                when (culinary.isEmpty()) {
                    true -> repository.insertAllItem(CulinaryData.dummyData)
                    else -> _allCulinary.value = UiState.Success(culinary)
                }
            }
        }
    }

    private fun searchCulinary(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.searchItem(query)
                .catch { error -> _allCulinary.value = UiState.Error(error.message.toString()) }
                .collect { culinary -> _allCulinary.value = UiState.Success(culinary) }
        }
    }

    fun updateWishlistedCulinary(id: Int, isFavorite: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateWishlistedItem(id, isFavorite)
        }
    }

    fun onQueryChange(query: String) {
        _homeState.value = _homeState.value.copy(query = query)
        searchCulinary(query)
    }
}