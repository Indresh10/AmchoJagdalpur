package com.example.amchojagdalpur.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.amchojagdalpur.R


data class Category(@DrawableRes val image:Int, @StringRes val name:Int,val count:Int = 0)

object CatRepo{
    val categories : List<Category> = listOf(
        Category(image = R.drawable.gan_big,name = R.string.resorts, count = 6),
        Category(image = R.drawable.urban_big,name = R.string.restaurants, count = 4),
        Category(image = R.drawable.chi_big,name = R.string.tourists_spots,count = 6),
        Category(image = R.drawable.dal_big, name = R.string.parks, count = 4)
    )
}

