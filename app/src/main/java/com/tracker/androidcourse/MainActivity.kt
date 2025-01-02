package com.tracker.androidcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.tracker.androidcourse.ui.theme.AndroidCourseTheme
import com.tracker.androidcourse.ui.theme.AppColors
import com.tracker.androidcourse.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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
        style = Typography.bodyLarge,
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
            // .width(200.dp)
            .fillMaxWidth()
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
            .width(200.dp)
            .height(200.dp),
        color = AppColors.PurpleGrey80,
    ){

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


@Composable
fun CustomText1 (){
    Text(text = stringResource(id = R.string.app_name),
        modifier = Modifier.padding(20.dp),
        fontSize = MaterialTheme.typography.headlineLarge.fontSize,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.End,
    )
}


@Composable
fun CustomText2(){
    Text(text = "Jamirul islam".repeat(20),
        //minLines = 2,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
    )
}


@Composable
fun CustomText3 (){
    Text(

        buildAnnotatedString {
            withStyle(style = SpanStyle(
                color = AppColors.Pink80,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic
            )){
                append("A")

            }
            append("B")
            append("C")
            append("D")
            append("E")
        },
        modifier = Modifier.padding(30.dp),
    );
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidCourseTheme {
        Surface (color = MaterialTheme.colorScheme.background) {
           Column (modifier = Modifier.fillMaxSize(),
               verticalArrangement = Arrangement.spacedBy(20.dp),
               ) {
               CustomText1()
               CustomText2()
               CustomText3()

           }
        }
    }
}