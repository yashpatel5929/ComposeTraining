package com.example.compsedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compsedemo.ui.theme.CompseDemoTheme

class ExerciseActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompseDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val image = painterResource(id = R.drawable.bg_compose_background)
                    ComposeArticle(
                        Modifier, image, stringResource(id = R.string.title), stringResource(
                            id = R.string.titleHeader
                        ), stringResource(id = R.string.body)
                    )
                }
            }
        }

    }
}


@Composable
fun ComposeArticle(
    modifier: Modifier,
    image: Painter,
    title: String,
    titleHeader: String,
    body: String
) {
    Column(modifier = modifier.fillMaxSize()) {
        Image(painter = image, contentDescription = null, modifier = modifier.fillMaxWidth())
        Text(text = title, modifier = modifier.padding(16.dp), fontSize = 24.sp)
        Text(text = titleHeader, modifier = modifier.padding(16.dp), textAlign = TextAlign.Justify)
        Text(text = body, modifier = modifier.padding(16.dp), textAlign = TextAlign.Justify)
    }
}