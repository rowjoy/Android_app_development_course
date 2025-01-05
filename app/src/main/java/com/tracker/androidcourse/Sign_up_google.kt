package com.tracker.androidcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tracker.androidcourse.ui.theme.AndroidCourseTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tracker.androidcourse.ui.theme.AppColors
import com.tracker.androidcourse.ui.theme.Shapes

class  SignUpGoogle : ComponentActivity (){
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
fun GoogleButton(){
    var click by remember { mutableStateOf(false) }
    val loadingData : String = "Create account..."

    Surface(
        onClick = {
            click = !click
        },
       border = BorderStroke(
           width = 1.dp,
           color = AppColors.Pink40,
       ),
        shape = Shapes.medium,
        color = MaterialTheme.colorScheme.surface,

    ) {
        
        Row (
            modifier = Modifier.padding(
                start = 12.dp,
                end = 16.dp,
                top = 12.dp,
                bottom = 12.dp,
            ).animateContentSize (
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                ),
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {

            Icon(painter = painterResource(id = R.drawable.ic_google_logo), contentDescription = "Google", tint = Color.Unspecified,)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = if(click) loadingData else "Sign up with Google")
            if (click){
                Spacer(modifier = Modifier.width(8.dp))
              CircularProgressIndicator(
                  modifier = Modifier
                      .height(16.dp)
                      .width(16.dp),
                  strokeWidth = 2.dp,
                  color = AppColors.Purple80,
              )
            }

        }

    }
}


@Preview (showBackground = true)
@Composable
fun SignUpGooglePreView (){
    AndroidCourseTheme {
        Surface {
          Column (
              modifier = Modifier.fillMaxSize(),
              horizontalAlignment = Alignment.CenterHorizontally,
              verticalArrangement = Arrangement.Center

          ){
              GoogleButton()
          }

        }
    }
}