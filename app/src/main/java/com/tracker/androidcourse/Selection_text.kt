package com.tracker.androidcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tracker.androidcourse.ui.theme.AndroidCourseTheme
import com.tracker.androidcourse.ui.theme.AppColors


class SelectionText : ComponentActivity() {
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
fun SelectionContainers (){
    SelectionContainer {
        Column {
            Text(text = "Jamirul islam king1")
            DisableSelection {
                Text(text = "Jamirul islam king3")
            }
            Text(text = "Jamirul islam king2")
        }
    }

}
@Preview (showBackground = true)
@Composable
fun SelectionTextPreview(){
   AndroidCourseTheme {
       Surface (color = MaterialTheme.colorScheme.background) {
          Column (modifier = Modifier.fillMaxSize()) {
              SelectionContainers()
          }
       }
   }
}