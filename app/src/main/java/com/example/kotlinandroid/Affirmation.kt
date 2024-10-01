package com.example.kotlinandroid

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

// chaque affirmation se compose d'une image et d'une chaine
data class Affirmation(
    @StringRes val stringResourceId : Int,  // id du text d'affirmation stocké dans une ressource de chaine
    @DrawableRes val imageResourcedId : Int // id de l'image d'affirmation stockée dans une ressource drawable
    )
