package com.example.amchojagdalpur.ui

import com.example.amchojagdalpur.model.CatRepo
import com.example.amchojagdalpur.model.Category
import com.example.amchojagdalpur.model.Place
import com.example.amchojagdalpur.model.PlaceRepo

data class AmchoUiState(
    val currentCategory: Category = CatRepo.categories.first(),
    val placesList: List<Place> = PlaceRepo.places.subList(0,1),
    val currentPlace: Place = placesList.first()
)
