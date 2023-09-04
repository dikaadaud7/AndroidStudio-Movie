package com.example.projectandro.screens

import android.annotation.SuppressLint
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
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projectandro.R
import com.example.projectandro.components.HeadingHomeTextComponents
import com.example.projectandro.components.ListHomeComponent
import com.example.projectandro.navigation.ProjectRouterScreen
import com.example.projectandro.navigation.Screen
import com.example.projectandro.navigation.SystemBackButtonHandler

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Home(){
    val secondary = colorResource(id = R.color.background1)
    val primary = colorResource(id = R.color.background2)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { androidx.compose.material.Text(text = "Home") },
                navigationIcon = {
                    IconButton(onClick = {
                        ProjectRouterScreen.navigateTo(Screen.LoginScreen)
                    }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                backgroundColor = Color.LightGray,
            )
        },

        ) {
        Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.linearGradient(listOf(secondary, primary))
            )
            .padding(8.dp)
    ) {

        Column(
            modifier = Modifier.fillMaxWidth()
                .background(brush = Brush.linearGradient(listOf(secondary, primary))
                )
                .heightIn(16.dp)
        ) {
            Text(
                text = "List Of Cars",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                style = TextStyle(
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Normal
                )
                , color = colorResource(id = R.color.colorText),
                textAlign = TextAlign.Left,
            )
            Spacer(modifier = Modifier.height(8.dp))
            ListHomeComponent()
            }

        }
    }
        SystemBackButtonHandler {
            ProjectRouterScreen.navigateTo(Screen.LoginScreen)
        }


}


@Preview
@Composable
fun HomeScreen(){
    Home()
}