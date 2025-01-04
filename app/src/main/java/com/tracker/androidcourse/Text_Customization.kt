package com.tracker.androidcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tracker.androidcourse.ui.theme.AndroidCourseTheme
import com.tracker.androidcourse.ui.theme.AppColors

class  TextCustomization : ComponentActivity(){
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
            )
            ){
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




@Preview (showBackground = true)
@Composable
fun TextCustoMizationPreview (){
    AndroidCourseTheme {
        Surface {
             Column (modifier = Modifier.fillMaxSize()) {
                   CustomText1()
                 CustomText2()
                 CustomText3()
             }
        }
    }
}