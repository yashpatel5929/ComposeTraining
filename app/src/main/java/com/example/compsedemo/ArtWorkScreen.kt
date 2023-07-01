package com.example.compsedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compsedemo.ui.theme.CompseDemoTheme
import com.example.compsedemo.ui.theme.lightBlue

class ArtWorkScreen : ComponentActivity() {
    var artWorkList = mutableListOf<ArtWorkData>()
    override fun onStart() {
        super.onStart()
        setArtWorkData()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CompseDemoTheme {
                ArtWorkGallery(artWorkList)
            }
        }
    }

    private fun setArtWorkData() {
        artWorkList.add(ArtWorkData(R.drawable.naruto, resources.getString(R.string.naruto),  resources.getString(R.string.naruto_desc)))
        artWorkList.add(ArtWorkData(R.drawable.sasuke,  resources.getString(R.string.sasuke_uchiha),  resources.getString(R.string.sasuke_uchiha_desc)))
        artWorkList.add(ArtWorkData(R.drawable.kakashi,  resources.getString(R.string.kakashi),  resources.getString(R.string.kakashi_desc)))
        artWorkList.add(ArtWorkData(R.drawable.itachi,  resources.getString(R.string.itachi),  resources.getString(R.string.itachi_desc)))
        artWorkList.add(ArtWorkData(R.drawable.team7,  resources.getString(R.string.team7),  resources.getString(R.string.team7_desc)))

    }
}

@Composable
fun ArtWorkGallery(artWorkList: MutableList<ArtWorkData>) {
    var index by remember {
        mutableStateOf(0)
    }

    val imageResource = painterResource(id = artWorkList[index].image)
    val imageDescription = artWorkList[index].imageDescription
    val imageCreator = artWorkList[index].imageCreator


    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        Alignment.CenterHorizontally
    ) {
        ArtWorkImage(modifier = Modifier, imageResource)
        ArtWorkDescriptor(modifier = Modifier.fillMaxWidth(), imageDescription, imageCreator)
        ArtWorkController(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), onNextCall = {
             if(index != artWorkList.size - 1) index+=1
        }, onPreviousCall = {
            if(index != 0) index -= 1 else index = 0
        })
    }
}

@Composable
fun ArtWorkController(modifier: Modifier, onNextCall: () -> Unit, onPreviousCall: () -> Unit) {
    Row(
        modifier = modifier.padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(onClick = onPreviousCall) {
            Text(text = "Previous" , fontSize = 20.sp)
        }
        Button(onClick = onNextCall) {
            Text(text = "Next" ,fontSize = 20.sp)
        }
    }
}

@Composable
fun ArtWorkDescriptor(modifier: Modifier, imageDesc: String?, imageCreator: String?) {

    Surface(modifier.padding(20.dp), color = lightBlue) {
        Column(
            modifier
                .padding(15.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = imageDesc ?: "",
                fontSize = 30.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(600)
            )
            Text(text = imageCreator ?: "", fontSize = 17.sp, fontFamily = FontFamily.SansSerif)
        }
    }

}

@Composable
fun ArtWorkImage(modifier: Modifier, imageResource: Painter) {
    Surface(modifier = modifier.padding(40.dp), shadowElevation = 30.dp) {
        Image(
            painter = imageResource, contentDescription = "dice", modifier = modifier
                .fillMaxHeight(0.6f)
                .fillMaxWidth()
                .padding(30.dp)
        )
    }
}
