package com.tracker.androidcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tracker.androidcourse.ui.theme.AndroidCourseTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.CircularProgressIndicator
import androidx.wear.compose.material.ContentAlpha
import com.tracker.androidcourse.ui.theme.AppColors
import com.tracker.androidcourse.ui.theme.Shapes

class  ExpandableCard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}



@ExperimentalMaterial3Api
@Composable
fun ExpandableCardWidget (
    title : String,
    subTitle : String,
    cardColor : Color,
    elevation: Int,
){
    var expandedState by remember { mutableStateOf(false) }
    val degrees: Float = if(expandedState)  180f else 0f
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .border(
                1.dp,
                AppColors.Pink40,
                shape = Shapes.medium,
            )
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = elevation.dp,
        ),
        colors = CardDefaults.cardColors(
            containerColor = cardColor,
        ),
        shape = Shapes.medium,
        onClick = {
           expandedState = !expandedState
        }
    ) {
        Column  (modifier = Modifier
            .fillMaxWidth()
            .padding(14.dp)
        ) {
            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ){
                Text(
                    text = title,
                    modifier = Modifier.fillMaxWidth().weight(4f),
                    minLines = 1,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                )
                IconButton(
                    modifier = Modifier.alpha(ContentAlpha.medium),
                    onClick = {
                        expandedState = !expandedState
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        tint = Color.Black,
                        modifier = Modifier.fillMaxWidth().weight(1f).rotate(degrees).size(100.dp),
                        contentDescription = "Drop -Down Arrow"
                    )
                }
            }
            if (expandedState){
                Text(text = subTitle)
            }
        }

    }
}










@ExperimentalMaterial3Api
@Preview (showBackground = true)
@Composable
fun ExpandableCardView(){
    AndroidCourseTheme {
        Surface {
            Column (modifier = Modifier.fillMaxSize()) {
                ExpandableCardWidget(
                    title = "Top read more",
                    subTitle = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                    cardColor = AppColors.PurpleGrey80,
                    elevation = 20,
                )
            }
        }
    }
}