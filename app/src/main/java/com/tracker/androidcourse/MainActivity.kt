package com.tracker.androidcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tracker.androidcourse.Pre_Populate_Room.Databases.PersonViewModel
import com.tracker.androidcourse.ui.theme.AndroidCourseTheme
import com.tracker.androidcourse.ui.theme.Typography

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCourseTheme {
                Surface {
                    Column (
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,


                    ){
                       var value by remember {
                           mutableStateOf(0)
                       }

                        IndicatorWidget(
                            indicatorValue = value,
                        );

                        TextField(
                            value = value.toString(),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                            ),
                            onValueChange = {
                              //  value = it.toIntOrNull() ?: 0
                                value = it.toIntOrNull() ?: 0;

                            }

                        )
                    }
                }
            }
        }
    }
}



@Composable
fun UserListShow (data: PersonViewModel){
    val  results by data.readAll.collectAsState(initial = emptyList());
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
       if (results.isNotEmpty()) {
            for ( person in results){
                Text(text = person.name)
            }
       }else{
         Text(text = "Data not found")
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