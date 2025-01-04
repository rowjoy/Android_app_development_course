package com.tracker.androidcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tracker.androidcourse.ui.theme.AndroidCourseTheme

class  BoxShape : ComponentActivity (){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         setContent {
             AndroidCourseTheme {
                 Surface {

                 }
             }
         }
    }
}



@Composable
fun boxComposa (){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ){
        Box(modifier = Modifier.background(Color.Cyan),
            contentAlignment = Alignment.Center,
        ) {
            Box(modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .background(Color.Blue))
            Greeting(
                name = "I love Computer",
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}





@Preview (showBackground = true)
@Composable
fun BoxShapePreview() {
    AndroidCourseTheme {
        Surface {
            Column (modifier = Modifier.fillMaxSize()) {
               boxComposa()
            }
        }
    }
}
