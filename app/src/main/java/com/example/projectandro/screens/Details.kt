package com.example.projectandro.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projectandro.R
import com.example.projectandro.components.DividerComponent
import com.example.projectandro.components.HeadingTextComponents
import com.example.projectandro.navigation.ProjectRouterScreen
import com.example.projectandro.navigation.Screen
import com.example.projectandro.navigation.SystemBackButtonHandler

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Details(){
//    val secondary = colorResource(id = R.color.background1)
//    val primary = colorResource(id = R.color.background2)
//        Scaffold(
//            topBar = {
//                TopAppBar(
//                    title = { Text(text = "Details") },
//                    navigationIcon = {
//                        IconButton(onClick = {
//                            ProjectRouterScreen.navigateTo(Screen.HomeScreen)
//                        }) {
//                            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
//                        }
//                    },
//                    backgroundColor = Color.LightGray,
//                    modifier = Modifier.heightIn()
//
//                )
//            },
//
//        ) {
//            Surface(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(brush = Brush.linearGradient(listOf(secondary, primary))
//                    )
//                    .padding(28.dp)
//            ) {
//                Column(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .background(
//                            brush = Brush.linearGradient(listOf(secondary, primary))
//                        )
//                ) {
//                    Spacer(modifier = Modifier.height(24.dp))
//
//                    Image(painter = painterResource(id = item.imageResource),
//                        contentDescription = "",
//                        modifier = Modifier.fillMaxWidth())
//
//                    Spacer(modifier = Modifier.height(8.dp))
//                    Text(
//                        text = item.name,
//                        style = TextStyle(
//                            fontWeight = FontWeight.Bold,
//                            fontSize = 18.sp
//                        ),
//                        textAlign = TextAlign.Center,
//                        modifier = Modifier.fillMaxWidth()
//                    )
//                    Spacer(modifier = Modifier.height(8.dp))
//                    DividerComponent()
//                    Spacer(modifier = Modifier.height(8.dp))
//                    Text(
//                        text = "Description",
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .heightIn(min = 40.dp),
//                        style = TextStyle(
//                            fontSize = 24.sp,
//                            fontWeight = FontWeight.Normal,
//                            fontStyle = FontStyle.Normal
//                        ),
//                        color = colorResource(id = R.color.colorText),
//                        textAlign = TextAlign.Left,
//                    )
//                    Spacer(modifier = Modifier.height(8.dp))
//                    Text(
//                        text = item.desc,
//                        style = TextStyle(
//                            fontWeight = FontWeight.Normal,
//                            fontSize = 14.sp
//                        ),
//                        textAlign = TextAlign.Justify,
//                        modifier = Modifier.fillMaxWidth()
//                    )
//                }
//            }
//
//        }
  }


//@Preview
//@Composable
//fun DetailsScreen(){
//    Details()
//}