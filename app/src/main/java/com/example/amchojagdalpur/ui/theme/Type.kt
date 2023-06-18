package com.example.amchojagdalpur.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.amchojagdalpur.R

val allura = FontFamily(Font(R.font.allura_reg))
val josefin = FontFamily(
    Font(R.font.josefinsans_light, FontWeight.Normal),
    Font(R.font.josefinsans_regular, FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = josefin,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    bodySmall = TextStyle(
        fontFamily = josefin,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp
    ),
    displayLarge = TextStyle(
        fontFamily = allura,
        fontSize = 48.sp,
        lineHeight = 38.sp
    ),
    displayMedium = TextStyle(
        fontFamily = josefin,
        fontSize = 30.sp,
        lineHeight = 34.sp,
        letterSpacing = 0.5.sp,
        fontWeight = FontWeight.Bold
    ),
    headlineMedium = TextStyle(
        fontFamily = josefin,
        fontSize = 24.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.5.sp,
        fontWeight = FontWeight.Bold
    ),
    titleMedium = TextStyle(
        fontFamily = josefin,
        fontSize = 18.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.5.sp,
        fontWeight = FontWeight.Bold
    ),
    labelMedium = TextStyle(
        fontFamily = josefin,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)