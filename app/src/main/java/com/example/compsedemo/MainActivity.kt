package com.example.compsedemo

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compsedemo.ui.theme.CompseDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompseDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val image = painterResource(R.drawable.androidparty)
                    BackGroundImage(modifier = Modifier, painter = image)
                   // Greeting(message = "Happy birthDay stranger", from = "yash")
                }
            }
        }
    }
}

@Composable
fun Greeting(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = message,
            modifier = modifier.align(Alignment.CenterHorizontally),
            fontSize = 80.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            modifier = modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(10.dp),
            fontSize = 30.sp
        )
    }
}

@Composable
fun BackGroundImage(modifier: Modifier , painter : Painter){
    Box() {
        Image(painter = painter, contentDescription = null, alpha = 0.8f , contentScale = ContentScale.Crop)
        Greeting(message = "Happy birthDay stranger", from = "yash" , modifier = modifier.padding(8.dp))
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CompseDemoTheme {
      //  Greeting(message = "Happy birthDay stranger", from = "yash")
        val image = painterResource(R.drawable.androidparty)

        BackGroundImage(modifier = Modifier, painter = image)

//        Greeting("happy ebirthday")
    }
}