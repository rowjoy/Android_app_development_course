package com.tracker.androidcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.tracker.androidcourse.ui.theme.AndroidCourseTheme
import com.tracker.androidcourse.ui.theme.AppColors

//https://youtu.be/WEpFK7K_vCk?si=avVey5XDx9-1PMET


class SuperscriptSubscript : ComponentActivity(){
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
fun SuperscriptSubscriptWidget (
    normalText : String,
    superText : String,
    superTextFontSize : TextUnit = MaterialTheme.typography.bodySmall.fontSize,
){
    Text(buildAnnotatedString {
        withStyle(
            style = SpanStyle(AppColors.Pink40,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
        ){
          append("A")
        }

        withStyle(
            style = SpanStyle(
                baselineShift = BaselineShift.Superscript,
            ),

        ){
            append("A")
        }
    })

}





@Preview (showBackground = true)
@Composable

fun SuperscriptSubscriptView (){
    AndroidCourseTheme {
        Surface {
           Column  (modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
               ){
               SuperscriptSubscriptWidget(normalText = "A", superText =  "B")
           }
        }
    }
}