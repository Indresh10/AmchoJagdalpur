package com.example.amchojagdalpur.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.amchojagdalpur.model.Place
import com.example.amchojagdalpur.ui.theme.AmchoJagdalpurTheme
import com.example.amchojagdalpur.ui.util.AmchoContentType

@Composable
fun ListScreen(
    contentType: AmchoContentType,
    uiState: AmchoUiState,
    onPlaceCardClick: (Place) -> Unit,
    modifier: Modifier = Modifier
) {
    when (contentType) {
        AmchoContentType.LIST_ONLY -> PlaceCardList(
            uiState = uiState,
            onPlaceCardClick = onPlaceCardClick,
            modifier = modifier.padding(16.dp)
        )

        AmchoContentType.LIST_AND_DETAIL -> {
            Row(modifier = modifier) {
                PlaceCardList(
                    uiState = uiState,
                    onPlaceCardClick = onPlaceCardClick,
                    modifier = Modifier.weight(.8f).padding(16.dp)
                )
                DetailsScreen(uiState = uiState, modifier = Modifier.weight(1.2f))
            }
        }
    }

}

@Composable
fun PlaceCardList(
    uiState: AmchoUiState,
    onPlaceCardClick: (Place) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier, verticalArrangement = Arrangement.spacedBy(6.dp)) {
        itemsIndexed(uiState.placesList) { index, value ->
            PlaceCard(
                place = value,
                first = index == 0,
                last = index == uiState.placesList.size - 1,
                onClick = { onPlaceCardClick(value) },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaceCard(
    place: Place,
    first: Boolean,
    last: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val topCorners = if (first) 16.dp else 0.dp
    val bottomCorners = if (last) 16.dp else 0.dp
    Card(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(topCorners, topCorners, bottomCorners, bottomCorners),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.background(MaterialTheme.colorScheme.secondaryContainer).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(
                    id = place.smallImage
                ), contentDescription = null,
                modifier = Modifier.size(80.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = place.name),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListPreview() {
    AmchoJagdalpurTheme {
        ListScreen(AmchoContentType.LIST_ONLY, AmchoUiState(), {})
    }
}