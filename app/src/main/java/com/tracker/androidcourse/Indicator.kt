package com.tracker.androidcourse

import androidx.compose.animation.Animatable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.animation.core.*
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text


@Composable
fun IndicatorWidget (
    canvasSize: Dp = 300.dp,
    indicatorValue : Int = 0,
    maxIndicatorValue : Int = 1000,
    indicatorBgColor : Color = Color.Gray.copy(alpha = 0.2f),
    indicatorValueColor: Color = Color.Blue,
    bgStockwidth: Float = 100f,

    subtitle: String = "Remaining",
    subtitleColor: Color = Color.Gray,
    subtitleFontSize: TextUnit = MaterialTheme.typography.caption1.fontSize,
    dataSuffix: String = "GB",
    dataTextColor: Color = Color.Black,
    dataTextFontSize: TextUnit =  MaterialTheme.typography.title1.fontSize

){

   var allowedIndicatorValue by remember {
       mutableStateOf( maxIndicatorValue)
   }

   allowedIndicatorValue = if (indicatorValue <= maxIndicatorValue){
       indicatorValue
   }else {
       maxIndicatorValue
   }

   var animatedIndicatorValue  by remember { mutableStateOf(value = 0f) }

   LaunchedEffect(key1 = allowedIndicatorValue) {
       animatedIndicatorValue = allowedIndicatorValue.toFloat()
   }

   val percentage = (animatedIndicatorValue / maxIndicatorValue) * 100;

   val sweepAngle by animateFloatAsState(
       targetValue = (2.4 * percentage).toFloat(),
       animationSpec = tween(1000), label = ""
   );


   Column (
       modifier = Modifier
           .size(canvasSize)
           .drawBehind {
               val componentSize = size / 1.2f;
               backgroundIndicator( // this is backgroundIndicator component
                   indicatorColor = indicatorBgColor,
                   startAngle = 150f,
                   sweepAngle = 240f,
                   useCenter = false,
                   componentSize = componentSize,
                   width = bgStockwidth
               );
               foregroundIndicator(
                   foregroundIndicatorSize = componentSize,
                   startAngle = 150f,
                   sweepAngle = sweepAngle,
                   indicatorValueColor = indicatorValueColor,
                   width = bgStockwidth
               );
           },
       verticalArrangement =  Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally
   ) {
      TextElements(
         subtitle,
          subtitleColor,
          subtitleFontSize,
          allowedIndicatorValue.toString(),
          dataSuffix,
          dataTextColor,
          dataTextFontSize
      )
   }
}

@Composable
@Preview(showBackground = true)
fun IndicatorPreview (){
    IndicatorWidget();
}



@Composable
fun TextElements (
    subtitle : String,
    subtitleColor : Color,
    subtitleFontSize : TextUnit,
    dataCounter : String,
    dataSuffix : String,
    dataTextColor : Color,
    dataTextFontSize : TextUnit

    ){
     Text(
         text = subtitle,
         color =  subtitleColor,
         fontSize = subtitleFontSize,
         textAlign = TextAlign.Center,
     )

    Text(
        text = "$dataCounter ${dataSuffix.take(2)}",
        color = dataTextColor,
        fontSize = dataTextFontSize,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
    )
}


fun DrawScope.backgroundIndicator (
    indicatorColor : Color,
    startAngle: Float,
    sweepAngle: Float,
    useCenter: Boolean,
    componentSize : Size,
    width: Float
){
    drawArc(
        size = componentSize,
        color = indicatorColor,
        startAngle = startAngle,
        sweepAngle = sweepAngle,
        useCenter = useCenter,
        style = Stroke(
            width = width,
            cap = StrokeCap.Round,
        ),
        topLeft = Offset(
            x = (size.width - componentSize.width) / 2f,
            y = (size.height - componentSize.height) / 2f
        )

    );
}



fun DrawScope.foregroundIndicator (
    foregroundIndicatorSize : Size,
    startAngle: Float,
    sweepAngle: Float,
    indicatorValueColor: Color = Color.Red,
    width: Float
){
   drawArc(
       size = foregroundIndicatorSize,
       color = indicatorValueColor,
       startAngle = startAngle,
       sweepAngle = sweepAngle,
       useCenter = false,
       style = Stroke(
         width = width,
           cap = StrokeCap.Round
       ),
       topLeft = Offset(
           x = (size.width - foregroundIndicatorSize.width) / 2f,
           y = (size.height -foregroundIndicatorSize.height) / 2f
       )
   );
}


// https://www.youtube.com/watch?v=tWSwbTJjJUg&list=PLSrm9z4zp4mEWwyiuYgVMWcDFdsebhM-r&index=22
// Custom UI Component with Jetpack Compose & Canvas | Part #3 - Foreground Indicator





