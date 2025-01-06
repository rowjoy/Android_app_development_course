package com.tracker.androidcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePainter
import coil3.compose.SubcomposeAsyncImage
import coil3.compose.SubcomposeAsyncImageContent
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.tracker.androidcourse.ui.theme.AndroidCourseTheme

class  CoilImages : ComponentActivity (){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCourseTheme {
                Surface {
                   // CoilImageView()
                }
            }
        }
    }
}


@Composable
fun CoilImageView (){
    Box (
        modifier = Modifier.fillMaxSize()
    ) {
       Column {
           AsyncImage(
               model = ImageRequest.Builder(LocalContext.current)
                   .data("https://img.freepik.com/free-vector/abstract-spring-flower-background-illustration_460848-12688.jpg")
                   .crossfade(true)
                   .build(),
               contentDescription = "Images",
           )
           SubcomposeAsyncImage(
               model = "https://img.freepik.com/free-vector/abstract-spring-flower-background-illustration_460848-12688.jpg",
               contentDescription = "Hello"
           ) {
               val state by painter.state.collectAsState()
               if (state is AsyncImagePainter.State.Success) {
                   SubcomposeAsyncImageContent()
               } else {
                   CircularProgressIndicator()
               }
           }

       }


    }
}


@Preview (showBackground = true)
@Composable
fun CoilImagesPreview (){
    AndroidCourseTheme {
        Surface (
            modifier = Modifier.fillMaxSize()
        ) {
            CoilImageView()

        }
    }
}