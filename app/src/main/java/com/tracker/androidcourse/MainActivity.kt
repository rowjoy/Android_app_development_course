package com.tracker.androidcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import com.tracker.androidcourse.ui.theme.AndroidCourseTheme
import com.tracker.androidcourse.ui.theme.AppColors
import com.tracker.androidcourse.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCourseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   Column {
                       Greeting("Android")
                       CustomText(text = "Jarful islam")
                   }
                }
            }
        }
    }
}




@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}



@Composable
fun  CustomText(text : String){
    Text(
        text = text,
        style = Typography.bodySmall,
       // style = Typography.,
    )
}


@Composable
fun bodyTextWidget(text : String){
    if (text.isEmpty()){
      return Text(text = "")
    } else {
      return Text(text = text,
          style = Typography.bodySmall,
          )
    }

}


@Composable
fun ColumnScope.CustomSurface ( weight : Float, color: Color){
    Surface (
        modifier = Modifier
            .width(200.dp)
            .height(300.dp)
            .weight(weight),
         color  = color,
         border = BorderStroke(1.dp,AppColors.PurpleGrey80)

        ) {
        CustomText(text = "Jamirul islam")
    }
}


@Composable
fun  RowScope.CustomRowSurface (){
    Surface (
        modifier = Modifier
            .width(100.dp)
            .height(200.dp),
        color = AppColors.PurpleGrey80,
    ){

    }
}







@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidCourseTheme {
       Column (
           modifier = Modifier.fillMaxSize(),
           verticalArrangement = Arrangement.Center

       ){
          CustomSurface(1f, AppColors.Pink40)
           CustomSurface(1f, AppColors.Pink80)
           CustomSurface(1f, AppColors.Purple80)
           Row {
               CustomRowSurface()
           }
       }
    }
}