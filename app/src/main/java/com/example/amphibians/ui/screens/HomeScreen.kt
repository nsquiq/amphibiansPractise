package com.example.amphibians.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.amphibians.ui.model.Amphibian
import com.example.amphibians.R
import androidx.compose.material3.Text
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.amphibians.ui.theme.AmphibiansTheme

@Composable
fun HomeScreen(
    amphibians: List<Amphibian>,
    modfier : Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    LazyColumn(
        
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(24.dp)) {

        items(
            items = amphibians,
            key = { amphibians ->
                amphibians.name

            }) { amphibian ->
            AmphibianCard(amphibian = amphibian, modifier = Modifier.fillMaxSize())
        }
    }}
    

@Composable
fun AmphibianCard(amphibian: Amphibian,modifier: Modifier =Modifier){
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(10.dp)
    ){
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Text(
                text = stringResource(R.string.amphibian_title,amphibian.name,amphibian.type)
            )
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(amphibian.imgSrc)
                    .crossfade(true)
                    .build(),
                contentDescription = null )
            Text(
                text = amphibian.description
            )
        }


    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    AmphibiansTheme {
        val mockData = List(10) {
            Amphibian(
                "Lorem Ipsum - $it",
                "$it",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do" +
                        " eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad" +
                        " minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip" +
                        " ex ea commodo consequat.",
                imgSrc = ""
            )
        }
        HomeScreen(mockData, Modifier.fillMaxSize())
    }
}