package com.tracker.androidcourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tracker.androidcourse.model.Userinfo
import com.tracker.androidcourse.repocomponent.UserInfoLocalData
import com.tracker.androidcourse.ui.theme.AndroidCourseTheme
import com.tracker.androidcourse.ui.theme.AppColors




class  LazyColumCard : ComponentActivity () {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidCourseTheme {
                Surface {
                    val userInfoLocalData = UserInfoLocalData();
                    val userData = userInfoLocalData.getUserInfo();
                    LazyColumn (
                        modifier = Modifier.fillMaxHeight(),
                        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 10.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        itemsIndexed(
                            items = userData,
                            key = { index, item ->
                                item.id;
                            }
                        ){ index, userinfo ->
                            LazyColumViewCard(userinfo = userinfo)

                        }
                    }

                }
            }
        }
    }

}



@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StickyHeader (){
    val session = listOf("A", "B", "C", "D", "E", "F", "G")
    LazyColumn (
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        session.forEach { session ->
            stickyHeader {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(AppColors.Pink40)
                        .padding(15.dp),
                    text = "Session ${session}",
                    color = Color.Black
                )
            }

            items(
                count = 12
            ){
                Text(text = "Item is ${it} from the section ${session}")
            }


        }
    }
}


@Composable
fun LazyColumViewCard (userinfo: Userinfo){
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .background(AppColors.PurpleGrey80)
            .padding(10.dp)
    ) {
        Row (
          modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Column {
                Text(text = userinfo.firstName + " " + userinfo.lastName);
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Age : ${userinfo.ages} year")
            }
            Text(text = userinfo.dateTime)
        }
    }

}


@Preview (showBackground = true)
@Composable
fun  LazyPreview (){
    LazyColumViewCard(
        userinfo = Userinfo(
            id = 1,
            firstName = "Jamirul",
            lastName = "islam",
            ages = 12,
            dateTime = "12-09-2024"
        ),
    )
}

