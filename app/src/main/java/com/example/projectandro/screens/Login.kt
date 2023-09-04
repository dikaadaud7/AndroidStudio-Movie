package com.example.projectandro.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
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
import com.example.projectandro.components.ButtonComponent
import com.example.projectandro.components.ButtonHomeComponent
import com.example.projectandro.components.ButtonLoginComponent
import com.example.projectandro.components.ClickableLoginTextComponent
import com.example.projectandro.components.ConfirmPasswordTextField
import com.example.projectandro.components.ConfirmPasswordTextFieldLogin
import com.example.projectandro.components.DividerTextComponent
import com.example.projectandro.components.HeadingTextComponents
import com.example.projectandro.components.ImageHomeComponent
import com.example.projectandro.components.LoginFill
import com.example.projectandro.components.MyTextFieldEmail
import com.example.projectandro.components.MyTextFieldEmailLogin
import com.example.projectandro.components.NormalTextComponents
import com.example.projectandro.components.RegistrationFill
import com.example.projectandro.components.UnderlineSpanComponents
import com.example.projectandro.database.User
import com.example.projectandro.navigation.ProjectRouterScreen
import com.example.projectandro.navigation.Screen
import com.example.projectandro.navigation.SystemBackButtonHandler


@Composable
fun Login(){
    val loginFill = remember {
        mutableStateOf(LoginFill("",""))
    }
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(28.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {

        HeadingTextComponents(value = stringResource(id = R.string.welcome_back))
        Spacer(modifier = Modifier.height(20.dp))
        ImageHomeComponent()
        Spacer(modifier = Modifier.height(40.dp))
        MyTextFieldEmailLogin(labelValue = stringResource(id = R.string.email),
            painterResource(id = R.drawable.ic_email),
            loginFill = loginFill)
        ConfirmPasswordTextFieldLogin(labelValue = stringResource(id = R.string.password),
            painterResource(id = R.drawable.ic_lock),
            loginFill = loginFill)
        Spacer(modifier = Modifier.height(40.dp))
        UnderlineSpanComponents(value = stringResource(id = R.string.forgot_password))
        Spacer(modifier = Modifier.height(20.dp))
        ButtonLoginComponent(value = stringResource(id = R.string.login),
            loginFill = loginFill)
        DividerTextComponent()
        ClickableLoginTextComponent(tryingToLogin = false,
            onTextSelected = {
                ProjectRouterScreen.navigateTo(Screen.SignUpScreen)
            })
        }
    }

}

@Preview
@Composable
fun LoginScreen(){
    Login()
}