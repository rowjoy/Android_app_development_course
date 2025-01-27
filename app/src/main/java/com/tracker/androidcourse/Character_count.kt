package com.tracker.androidcourse

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tracker.androidcourse.ui.theme.AndroidCourseTheme
import org.w3c.dom.Text


@Composable
fun Character_count (){
  var name by remember { mutableStateOf(value = "") }
    val maxValue = 10;
  Column (
      modifier = Modifier.fillMaxSize(),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
      
  ) {

     OutlinedTextField(
         value = name,
         label = { Text(text = "Enter number")},
         onValueChange = {
            if (it.length <= maxValue){
                name = it
            }
         }
     )

  }

}


@Preview (showBackground = true)
@Composable
fun CharCountPre(){
   AndroidCourseTheme {
       Surface {
           Character_count()
       }
   }
}


