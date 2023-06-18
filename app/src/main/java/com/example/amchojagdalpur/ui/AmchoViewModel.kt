package com.example.amchojagdalpur.ui

import androidx.annotation.DrawableRes
import androidx.lifecycle.ViewModel
import com.example.amchojagdalpur.model.Category
import com.example.amchojagdalpur.model.Place
import com.example.amchojagdalpur.model.PlaceRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class AmchoViewModel:ViewModel() {
    private val _uiState = MutableStateFlow(AmchoUiState())
    val uiState : StateFlow<AmchoUiState>
        get() = _uiState
    fun updateCategory(category: Category){
        val places = PlaceRepo.places.filter {
            it.category == category
        }
        _uiState.update {
            it.copy(currentCategory = category, placesList = places, currentPlace = places.first())
        }
    }
    fun updatePlace(place: Place){
        _uiState.update {
            it.copy(currentPlace = place)
        }
    }
}