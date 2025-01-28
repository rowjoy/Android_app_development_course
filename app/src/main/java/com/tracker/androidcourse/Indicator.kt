package com.tracker.androidcourse

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.MaterialTheme


@Composable
fun IndicatorWidget (
    canvasSize: Dp = 300.dp,
  //  indicatorBgColor :  Color = MaterialTheme.colors.onSurface.copy(alpha = 0.1f,),
    indicatorBgColor : Color = Color.Gray.copy(alpha = 0.2f),
    startAngle: Float = 150f,
    sweepAngle: Float = 250f,
    useCenter: Boolean = false,
    bgStockwidth: Float = 100f
){
   Column (

       modifier = Modifier
           .size(canvasSize)
           .drawBehind {
               val componentSize = size / 1.2f;
               backgroundIndicator( // this is backgroundIndicator component
                   indicatorColor = indicatorBgColor,
                   startAngle = startAngle,
                   sweepAngle = sweepAngle,
                   useCenter = useCenter,
                   componentSize = componentSize,
                   width = bgStockwidth
               );
               foregroundIndicator(
                   foregroundIndicatorSize = componentSize
               );
           }
   ) {

   }
}

@Composable
@Preview(showBackground = true)
fun IndicatorPreview (){
     IndicatorWidget();
}


fun DrawScope.backgroundIndicator (
    indicatorColor :  Color,
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
){
   drawArc(
       size = foregroundIndicatorSize,
       color = Color.Red,
       startAngle = 150f,
       sweepAngle = 200f,
       useCenter = false,
       style = Stroke(
         width = 100f,
           cap = StrokeCap.Round
       ),
       topLeft = Offset(
           x = (size.width - foregroundIndicatorSize.width) / 2f,
           y = (size.height -foregroundIndicatorSize.height) / 2f
       )
   );
}





