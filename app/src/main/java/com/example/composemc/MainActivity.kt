package com.example.composemc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composemc.ui.theme.ComposeMcTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            initExScrollView()
            initExCardView(modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(16.dp),)
        }
    }
}

@Composable
fun initExCardView(
    modifier: Modifier
) {
    // 화면 돌려도 저장, 값 보존 가능 (remember -> rememberSaveable)
    var isFavorite by rememberSaveable {
        mutableStateOf(false)
    }

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        elevation = 5.dp
    ) {
        Box(modifier = Modifier.height(400.dp)) {
            Image(
                painter = painterResource(id = R.drawable.car), contentDescription = "poster",
                contentScale = ContentScale.Crop
            )
        }
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopEnd
        ) {
            IconButton(onClick = {
                isFavorite = !isFavorite
            }) {
                Icon(
                    imageVector = if(isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "favorite",
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
fun initExScrollView() {
    LazyColumn(
        modifier = Modifier
            .background(color = Color.Green)
            .fillMaxWidth()
    ) {
        item {
            Text(text = "Header")
        }
        items(50) { index ->
            Text(text = "compose $index")
        }
        item {
            Text(text = "Footer")
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeMcTheme {
        Greeting("Android")
    }
}