package com.tracker.androidcourse

import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tracker.androidcourse.ui.theme.AndroidCourseTheme
import com.tracker.androidcourse.ui.theme.Shapes

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
fun GradientButtonView (
    buttonName : String,
    onClick: () -> Unit,
    colors: List<Color>,
){

     Button(
         onClick = onClick,
         colors = ButtonDefaults.buttonColors(
             containerColor = Color.Transparent,
             contentColor = Color.Unspecified
         ),

         modifier = Modifier
             .fillMaxWidth()
             .height(55.dp)
             .padding(
                 horizontal = 10.dp
             )
             .background(
                 shape = Shapes.medium,
                 brush = Brush.linearGradient(
                     colors = colors,

                 )
             ),
         shape = Shapes.medium,
     ) {
         Text(text = buttonName,
             color = Color.White,
             fontSize = 22.sp,
             fontWeight = FontWeight.Bold,
             letterSpacing = 2.sp,
         )
     }
}



@Preview (showBackground = true)
@Composable
fun GradientButtonActPreView (){
    AndroidCourseTheme {
        Surface {
            Column (
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                GradientButtonView(
                    buttonName = "Login",
                    onClick = {},
                    colors = listOf(
                        Color(0xFF56AB2F), // Start color
                        Color(0xFFA8E063)  // End color
                    ),
                )
                Spacer(modifier = Modifier.height(20.dp))

                GradientButtonView(
                    buttonName = "Tap me",
                    onClick = { /*TODO*/ },
                    colors = listOf(
                        Color(0xFF24C6DC),
                        Color(0xFF514A9D)
                    ),
                )
                Spacer(modifier = Modifier.height(20.dp))
                GradientButtonView(
                    buttonName = "Tap me",
                    onClick = { /*TODO*/ },
                    colors = listOf(
                        Color(0xFF283048),
                        Color(0xFF859398)
                    ),
                )
                Spacer(modifier = Modifier.height(20.dp))
                GradientButtonView(
                    buttonName = "Tap me",
                    onClick = { /*TODO*/ },
                    colors = listOf(
                        Color(0xFF333333),
                        Color(0xFFdd1818)
                    ),
                )
                Spacer(modifier = Modifier.height(20.dp))
                GradientButtonView(
                    buttonName = "Tap me",
                    onClick = { /*TODO*/ },
                    colors = listOf(
                        Color(0xFF44A08D),
                        Color(0xFF093637)
                    ),
                )

            }
        }
    }
}