package com.example.projectandro.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projectandro.R
import com.example.projectandro.components.HeadingTextComponents
import com.example.projectandro.navigation.ProjectRouterScreen
import com.example.projectandro.navigation.Screen
import com.example.projectandro.navigation.SystemBackButtonHandler

@Composable
fun TermsAndCondition(){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(16.dp)
    ) {
        HeadingTextComponents(value = stringResource(id = R.string.terms_and_condition_header))
    }
    SystemBackButtonHandler {
        ProjectRouterScreen.navigateTo(Screen.SignUpScreen)
    }
}

@Preview
@Composable
fun TermsAndConditionScreenPreview(){
    TermsAndCondition()
}