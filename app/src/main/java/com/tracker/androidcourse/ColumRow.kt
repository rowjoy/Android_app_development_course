package com.tracker.androidcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tracker.androidcourse.ui.theme.AndroidCourseTheme
import com.tracker.androidcourse.ui.theme.AppColors

class ColumRow  : ComponentActivity (){
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
fun ColumnScope.CustomSurface (weight : Float, color: Color){
    Surface (
        modifier = Modifier
            // .width(200.dp)
            .fillMaxWidth()
            .height(300.dp)
            .weight(weight),
        color  = color,
        border = BorderStroke(1.dp, AppColors.PurpleGrey80)

    ) {
        CustomText(text = "Jamirul islam")
    }
}


@Composable
fun RowScope.CustomRowSurface (){
    Surface (
        modifier = Modifier
            .width(200.dp)
            .height(200.dp),
        color = AppColors.PurpleGrey80,
    ){

    }
}






@Preview (showBackground = true)
@Composable
fun ColumRowPreview (){
    AndroidCourseTheme {
        Surface {
           Column (modifier = Modifier.fillMaxSize()) {
               Column (modifier = Modifier.fillMaxWidth().height(400.dp)) {
                   CustomSurface(weight = 1f, color = AppColors.Purple80)
               }
               Row  (modifier = Modifier.fillMaxWidth().height(400.dp)){
                   CustomRowSurface()
               }
           }
        }
    }
}