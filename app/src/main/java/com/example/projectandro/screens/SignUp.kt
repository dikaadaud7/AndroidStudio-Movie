package com.example.projectandro.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.projectandro.R
import com.example.projectandro.components.ButtonSignUpComponent
import com.example.projectandro.components.CheckBoxComponent
import com.example.projectandro.components.ClickableLoginTextComponent
import com.example.projectandro.components.ConfirmPasswordTextField
import com.example.projectandro.components.DividerTextComponent
import com.example.projectandro.components.HeadingTextComponents
import com.example.projectandro.components.MyTextFieldEmail
import com.example.projectandro.components.MyTextFieldFirstName
import com.example.projectandro.components.MyTextFieldLastName
import com.example.projectandro.components.NormalTextComponents
import com.example.projectandro.components.PasswordTextField
import com.example.projectandro.components.RegistrationFill
import com.example.projectandro.navigation.ProjectRouterScreen
import com.example.projectandro.navigation.Screen
import com.example.projectandro.navigation.SystemBackButtonHandler

@Composable
fun SignUpScreen(){
    val registrationFill = remember {
        mutableStateOf(RegistrationFill("", "", "", "", ""))
    }
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            NormalTextComponents(value = stringResource(id = R.string.greetings))
            HeadingTextComponents(value = stringResource(id = R.string.heading_create))
            Spacer(modifier = Modifier.heightIn(20.dp))
            MyTextFieldFirstName(
                labelValue = stringResource(id = R.string.first_name) ,
                painterResource(id = R.drawable.ic_circle_account),
                registrationFill = registrationFill
            )
            MyTextFieldLastName(
                labelValue = stringResource(id = R.string.last_name),
                painterResource = painterResource(id = R.drawable.ic_circle_account),
                registrationFill = registrationFill
            )
            MyTextFieldEmail(
                labelValue = stringResource(id = R.string.email),
                painterResource = painterResource(id = R.drawable.ic_email),
                registrationFill = registrationFill
            )
            PasswordTextField(
                labelValue = stringResource(id = R.string.password),
                painterResource = painterResource(id = R.drawable.ic_lock),
                registrationFill = registrationFill
            )
            ConfirmPasswordTextField(
                labelValue = stringResource(id = R.string.confirm_password),
                painterResource = painterResource(id = R.drawable.ic_lock),
                registrationFill = registrationFill
            )
            CheckBoxComponent(value = stringResource(id = R.string.terms_and_conditions),
                onTextSelected = {
                    ProjectRouterScreen.navigateTo(Screen.TermsAndCondition)
                })

            Spacer(modifier = Modifier.heightIn(40.dp))

            ButtonSignUpComponent(value = stringResource(id = R.string.register),
                registrationFill = registrationFill)

            Spacer(modifier = Modifier.heightIn(20.dp))

            DividerTextComponent()

            ClickableLoginTextComponent(onTextSelected = {
                ProjectRouterScreen.navigateTo(Screen.LoginScreen)
            })
        }

        SystemBackButtonHandler {
            ProjectRouterScreen.navigateTo(Screen.LoginScreen)
        }
    }

}

@Preview
@Composable
fun DefaultPreviewSignUpScreen(){
    SignUpScreen()
}