package com.example.amchojagdalpur.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.TravelExplore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.amchojagdalpur.R
import com.example.amchojagdalpur.model.CatRepo
import com.example.amchojagdalpur.model.Category
import com.example.amchojagdalpur.ui.theme.AmchoJagdalpurTheme

@Composable
fun HomeScreen(
    gridSize: Int,
    onClick: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "logo"
        )
        Text(
            text = stringResource(id = R.string.welcome_message),
            style = MaterialTheme.typography.displayLarge,
            textAlign = TextAlign.Center
        )
        CategoryCardList(
            gridSize = gridSize,
            categoryList = CatRepo.categories,
            onClick = onClick,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxHeight()
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryCardList(
    gridSize: Int,
    categoryList: List<Category>,
    onClick: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(gridSize),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        items(categoryList) {
            CategoryCard(
                category = it,
                onClick = { onClick(it) },
                modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally)
            )
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun CategoryCard(
    category: Category,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(elevation = CardDefaults.cardElevation(4.dp), onClick = onClick, modifier = modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = category.image),
                contentDescription = stringResource(
                    id = category.name
                ),
                modifier = Modifier.fillMaxWidth().height(128.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = category.name),
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.titleMedium
            )
            CategoryCount(count = category.count, modifier = Modifier.padding(4.dp))
        }
    }
}

@Composable
fun CategoryCount(count: Int, modifier: Modifier = Modifier) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = Icons.Rounded.TravelExplore,
            contentDescription = stringResource(id = R.string.explore)
        )
        Text(
            text = stringResource(id = R.string.places, count),
            modifier = Modifier.padding(horizontal = 4.dp),
            style = MaterialTheme.typography.labelMedium
        )
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    AmchoJagdalpurTheme {
        HomeScreen(2, {})
    }
}