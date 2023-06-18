package com.example.amchojagdalpur.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.amchojagdalpur.model.Place
import com.example.amchojagdalpur.ui.theme.AmchoJagdalpurTheme

@Composable
fun DetailsScreen(uiState: AmchoUiState,modifier: Modifier = Modifier) {
    val place = uiState.currentPlace
    val scrollState = rememberScrollState()
    Column(modifier = modifier.verticalScroll(scrollState)) {
        DetailsImage(place = place, modifier = Modifier.fillMaxWidth())
        Text(
            text = stringResource(id = place.name),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(horizontal = 16.dp),
            textDecoration = TextDecoration.Underline
        )
        Spacer(modifier = modifier.height(8.dp))
        Text(
            text = stringResource(id = place.description),
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun DetailsImage(place: Place, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = place.bigImage),
            contentDescription = "Big Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp)
                .padding(bottom = 32.dp),
            contentScale = ContentScale.Crop
        )
        Box(
            Modifier
                .padding(12.dp)
                .align(Alignment.BottomEnd)
                .shadow(8.dp, MaterialTheme.shapes.medium)
        ) {
            Surface(
                Modifier
                    .clip(MaterialTheme.shapes.medium)
                    .background(Color.White)
            ) {
                Image(
                    painter = painterResource(
                        id = place.smallImage
                    ),
                    contentDescription = null,
                    modifier = Modifier.size(100.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailPreview() {
    AmchoJagdalpurTheme {
        DetailsScreen(AmchoUiState())
    }
}