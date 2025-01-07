package com.tracker.androidcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tracker.androidcourse.ui.theme.AndroidCourseTheme

class  GradientButtonAct : ComponentActivity (){
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
fun GradientButtonView (){

}



@Preview (showBackground = true)
@Composable
fun GradientButtonActPreView (){
    AndroidCourseTheme {
        Surface {
            Column (
                modifier = Modifier.fillMaxSize()
            ) {

            }
        }
    }
}