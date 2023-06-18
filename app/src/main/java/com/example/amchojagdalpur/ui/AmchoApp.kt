package com.example.amchojagdalpur.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Map
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.amchojagdalpur.R
import com.example.amchojagdalpur.ui.util.AmchoContentType

enum class AmchoScreen {
    Home,
    Category,
    Place
}

/**
 * Composable for the main app screen
 *
 * @param windowSize gives device width
 * @param viewModel viewModel for the app
 * @param modifier Composable modifier
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmchoApp(
    windowSize: WindowWidthSizeClass,
    viewModel: AmchoViewModel,
    modifier: Modifier = Modifier
) {
    val contentType =
        if (windowSize == WindowWidthSizeClass.Expanded) AmchoContentType.LIST_AND_DETAIL else AmchoContentType.LIST_ONLY
    val gridSize = when (windowSize) {
        WindowWidthSizeClass.Compact -> 2
        WindowWidthSizeClass.Medium -> 3
        WindowWidthSizeClass.Expanded -> 4
        else -> 2
    }
    val navController = rememberNavController()
    val uiState by viewModel.uiState.collectAsState()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val ctx = LocalContext.current
    Scaffold(
        topBar = {
            AmchoTopBar(
                visible = AmchoScreen.valueOf(
                    backStackEntry?.destination?.route ?: AmchoScreen.Home.name
                ) != AmchoScreen.Home,
                canNavigateBack = navController.previousBackStackEntry != null,
                onNavigateBack = { navController.navigateUp() },
                title = when (AmchoScreen.valueOf(
                    backStackEntry?.destination?.route ?: AmchoScreen.Home.name
                )) {
                    AmchoScreen.Home -> ""
                    AmchoScreen.Category -> stringResource(id = uiState.currentCategory.name)
                    AmchoScreen.Place -> stringResource(id = uiState.currentPlace.name)
                }
            )
        },
        floatingActionButton = {
            val currentScreen =
                AmchoScreen.valueOf(backStackEntry?.destination?.route ?: AmchoScreen.Home.name)
            if (currentScreen == AmchoScreen.Place || (currentScreen == AmchoScreen.Category && contentType == AmchoContentType.LIST_AND_DETAIL))
                AmchoFab(onClick = {
                    val intent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("geo:0,0?q=" + uiState.currentPlace.address)
                    )
                    ctx.startActivity(intent)
                })
        },
        floatingActionButtonPosition = FabPosition.End
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = AmchoScreen.Home.name,
            modifier = modifier.padding(paddingValues)
        ) {
            composable(AmchoScreen.Home.name) {
                HomeScreen(gridSize, onClick = {
                    viewModel.updateCategory(category = it)
                    navController.navigate(AmchoScreen.Category.name)
                }, modifier = Modifier.padding(8.dp))
            }
            composable(AmchoScreen.Category.name) {
                ListScreen(
                    contentType = contentType,
                    uiState = uiState,
                    onPlaceCardClick = {
                        viewModel.updatePlace(it)
                        if (contentType == AmchoContentType.LIST_ONLY)
                            navController.navigate(AmchoScreen.Place.name)
                    },
                    modifier = Modifier.fillMaxHeight()
                )
            }
            composable(AmchoScreen.Place.name) {
                DetailsScreen(uiState = uiState, modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmchoTopBar(
    visible: Boolean,
    canNavigateBack: Boolean,
    onNavigateBack: () -> Unit,
    title: String,
    modifier: Modifier = Modifier
) {
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn() + expandVertically(),
        exit = fadeOut() + shrinkVertically()
    ) {
        TopAppBar(
            title = {
                Text(
                    text = title,
                    style = MaterialTheme.typography.displayMedium,
                    color = MaterialTheme.colorScheme.onPrimary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = modifier,
            navigationIcon = {
                if (canNavigateBack) {
                    IconButton(onClick = onNavigateBack) {
                        Icon(
                            imageVector = Icons.Rounded.ArrowBack,
                            contentDescription = stringResource(id = R.string.back_button),
                            tint = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }
            }
        )
    }
}

@Composable
fun AmchoFab(onClick: () -> Unit, modifier: Modifier = Modifier) {
    FloatingActionButton(onClick = onClick, modifier = modifier) {
        Icon(imageVector = Icons.Rounded.Map, contentDescription = "Goto")
    }
}



