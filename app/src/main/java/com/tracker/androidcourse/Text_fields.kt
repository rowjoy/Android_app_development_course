package com.tracker.androidcourse

import android.os.Bundle
import android.util.Patterns
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tracker.androidcourse.ui.theme.AndroidCourseTheme
import com.tracker.androidcourse.ui.theme.AppColors
import com.tracker.androidcourse.ui.theme.Shapes
import java.util.Date

class TextFields : ComponentActivity(){
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
fun CustomTextField(
    labelName : String,
    imageVector: ImageVector,
    filedValue : String,
    trailingIconShow : Boolean = false,
    onValueChange: (String) -> Unit,
    trailingIcon: @Composable() (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None
){
   OutlinedTextField(
       minLines = 1,
       maxLines = 1,
       visualTransformation = visualTransformation,
       modifier = Modifier
           .fillMaxWidth()
           .padding(20.dp),
       value = filedValue,
       onValueChange = onValueChange,
       shape = Shapes.medium,
       label = {
           Text(text = labelName)
       },
       leadingIcon = {
           Icon(imageVector = imageVector, contentDescription = "Email" )
       },
       trailingIcon = trailingIcon,

       colors =  OutlinedTextFieldDefaults.colors(
          unfocusedBorderColor = Color.Black,
           focusedBorderColor = AppColors.Purple80,
           errorBorderColor = Color.Red,
       ),
       keyboardOptions = KeyboardOptions(

       )

   );
}

@Preview (showBackground = true)
@Composable
fun TextFieldsPreView (){
    AndroidCourseTheme {
        Surface {
            Column (modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                var emailController by remember { mutableStateOf("")}
                var passwordController by remember { mutableStateOf(value = "")}
                var passwordLockView by remember { mutableStateOf(value = true)}
                var  imageVectors: ImageVector = if (passwordLockView) Icons.Filled.Lock else Icons.Filled.Done
                var  hideEmaileIcon by remember { mutableStateOf(value = true) }
                fun isValidEmail(email: String): Boolean {
                    return Patterns.EMAIL_ADDRESS.matcher(email).matches()
                }
                var emailIsValid by remember { mutableStateOf(value = false)}
                var emailIcon :  ImageVector = if (emailIsValid) Icons.Default.Done else Icons.Default.Clear

                Text(text = "Welcome back! Glad to see you , Again!",
                      modifier = Modifier
                          .fillMaxWidth()
                          .padding(15.dp),
                      color = AppColors.Pink40,
                      lineHeight = 50.sp,
                      minLines = 2,
                      letterSpacing = 2.sp,
                      fontWeight = FontWeight.Bold,
                      fontSize = 30.sp
                    )

               CustomTextField(
                   labelName = "Enter email",
                   imageVector = Icons.Filled.Email,
                   filedValue = emailController,
                  // trailingIconShow = false,
                   trailingIcon = {
                      if (!hideEmaileIcon) Icon(imageVector =  emailIcon, contentDescription = "Done")
                   },
                   onValueChange = {
                     emailController = it.toString();
                       if (it.isNotEmpty()){
                           hideEmaileIcon = false
                           emailIsValid = isValidEmail(it)
                       }else {
                           hideEmaileIcon = true
                       }
                   }
               )
                CustomTextField(
                    labelName = "Enter password",
                    imageVector = Icons.Filled.Lock,
                    filedValue = passwordController,
                    trailingIconShow = true,
                    trailingIcon = {
                        IconButton(
                            onClick = {
                                passwordLockView = !passwordLockView
                            }) {
                            Icon( imageVector = imageVectors , contentDescription = "Lock" )

                        }
                    },
                    visualTransformation = if(!passwordLockView) VisualTransformation.None else PasswordVisualTransformation(),
                    onValueChange = {
                      passwordController = it
                    }
                )
                Button(
                    onClick = { /*TODO*/
                               println("Click : You click me Now ")
                              },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp)
                        .height(55.dp),
                    shape = Shapes.medium,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AppColors.Purple80,
                        contentColor = Color.Black,
                    )
                ) {
                    Text(text = "Login Now",
                        fontSize = 20.sp,

                        )
                }

                Box  (
                    modifier = Modifier.padding(15.dp)
                ){
                    GoogleButton(
                    )
                }




            }
        }
    }
}
