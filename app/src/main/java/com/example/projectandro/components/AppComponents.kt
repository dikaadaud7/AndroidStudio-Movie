package com.example.projectandro.components

import android.app.Application
import android.media.Image
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projectandro.R
import com.example.projectandro.database.MyApplication
import com.example.projectandro.database.User
import com.example.projectandro.navigation.ProjectRouterScreen
import com.example.projectandro.navigation.Screen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@Composable
fun NormalTextComponents(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        )
        , color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center,
    )
}

@Composable
fun HeadingTextComponents(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        )
        , color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center,
    )
}

@Composable
fun HeadingHomeTextComponents(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        )
        , color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Left,
    )
}


data class RegistrationFill(
    val firstname: String,
    val lastname: String,
    val email: String,
    val password: String,
    val confirmPass: String,
)
data class LoginFill(
    val email: String,
    val password: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldFirstName(labelValue: String, painterResource: Painter , registrationFill: MutableState<RegistrationFill>){


    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.small),
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.colorPrimary),
            focusedLabelColor = colorResource(id = R.color.colorPrimary),
            cursorColor = colorResource(id = R.color.colorPrimary),
            containerColor = colorResource(id = R.color.colorGreyLight)
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        singleLine = true,
        maxLines = 1,
        value = registrationFill.value.firstname,
        onValueChange = {
            newValue -> registrationFill.value = registrationFill.value.copy(firstname = newValue)
        },
        leadingIcon = {
        Icon(painter = painterResource, contentDescription ="" )
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldLastName(labelValue: String, painterResource: Painter,registrationFill: MutableState<RegistrationFill>){


    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.small),
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.colorPrimary),
            focusedLabelColor = colorResource(id = R.color.colorPrimary),
            cursorColor = colorResource(id = R.color.colorPrimary),
            containerColor = colorResource(id = R.color.colorGreyLight)
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        singleLine = true,
        maxLines = 1,
        value = registrationFill.value.lastname,
        onValueChange = {
                newValue -> registrationFill.value = registrationFill.value.copy(lastname = newValue)
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription ="" )
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldEmail(labelValue: String, painterResource: Painter,registrationFill: MutableState<RegistrationFill>){

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.small),
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.colorPrimary),
            focusedLabelColor = colorResource(id = R.color.colorPrimary),
            cursorColor = colorResource(id = R.color.colorPrimary),
            containerColor = colorResource(id = R.color.colorGreyLight)
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        singleLine = true,
        maxLines = 1,
        value = registrationFill.value.email,
        onValueChange = {
                newValue -> registrationFill.value = registrationFill.value.copy(email = newValue)
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription ="" )
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(labelValue: String, painterResource: Painter,registrationFill: MutableState<RegistrationFill>){

    val passwordVisible = remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.small),
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.colorPrimary),
            focusedLabelColor = colorResource(id = R.color.colorPrimary),
            cursorColor = colorResource(id = R.color.colorPrimary),
            containerColor = colorResource(id = R.color.colorGreyLight)
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password , imeAction = ImeAction.Next),
        singleLine = true,
        maxLines = 1,
        value = registrationFill.value.password,
        onValueChange = {
                newValue -> registrationFill.value = registrationFill.value.copy(password = newValue)
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription ="" )
        },
        trailingIcon = {
            val iconImage = if (passwordVisible.value){
                Icons.Filled.Visibility
            }else{
                Icons.Filled.VisibilityOff
            }
            var description = if (passwordVisible.value){
                stringResource(id = R.string.hide_password)
            }else{
                stringResource(id = R.string.show_password)
            }

            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = iconImage, contentDescription = description)

            }
        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else
        PasswordVisualTransformation()
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfirmPasswordTextField(labelValue: String, painterResource: Painter,registrationFill: MutableState<RegistrationFill>){

    val localFocusManager = LocalFocusManager.current
    val passwordVisible = remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.small),
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.colorPrimary),
            focusedLabelColor = colorResource(id = R.color.colorPrimary),
            cursorColor = colorResource(id = R.color.colorPrimary),
            containerColor = colorResource(id = R.color.colorGreyLight)
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password , imeAction = ImeAction.Next),
        singleLine = true,
        keyboardActions = KeyboardActions{
            localFocusManager.clearFocus()
        },
        maxLines = 1,
        value = registrationFill.value.confirmPass,
        onValueChange = {
                newValue -> registrationFill.value = registrationFill.value.copy(confirmPass = newValue)
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription ="" )
        },
        trailingIcon = {
            val iconImage = if (passwordVisible.value){
                Icons.Filled.Visibility
            }else{
                Icons.Filled.VisibilityOff
            }
            var description = if (passwordVisible.value){
                stringResource(id = R.string.hide_password)
            }else{
                stringResource(id = R.string.show_password)
            }

            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = iconImage, contentDescription = description)

            }
        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else
            PasswordVisualTransformation()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldEmailLogin(labelValue: String, painterResource: Painter,loginFill: MutableState<LoginFill>){

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.small),
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.colorPrimary),
            focusedLabelColor = colorResource(id = R.color.colorPrimary),
            cursorColor = colorResource(id = R.color.colorPrimary),
            containerColor = colorResource(id = R.color.colorGreyLight)
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        singleLine = true,
        maxLines = 1,
        value = loginFill.value.email,
        onValueChange = {
                newValue -> loginFill.value = loginFill.value.copy(email = newValue)
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription ="" )
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfirmPasswordTextFieldLogin(labelValue: String, painterResource: Painter,loginFill: MutableState<LoginFill>){

    val localFocusManager = LocalFocusManager.current
    val passwordVisible = remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.small),
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.colorPrimary),
            focusedLabelColor = colorResource(id = R.color.colorPrimary),
            cursorColor = colorResource(id = R.color.colorPrimary),
            containerColor = colorResource(id = R.color.colorGreyLight)
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password , imeAction = ImeAction.Next),
        singleLine = true,
        keyboardActions = KeyboardActions{
            localFocusManager.clearFocus()
        },
        maxLines = 1,
        value = loginFill.value.password,
        onValueChange = {
                newValue -> loginFill.value = loginFill.value.copy(password = newValue)
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription ="" )
        },
        trailingIcon = {
            val iconImage = if (passwordVisible.value){
                Icons.Filled.Visibility
            }else{
                Icons.Filled.VisibilityOff
            }
            var description = if (passwordVisible.value){
                stringResource(id = R.string.hide_password)
            }else{
                stringResource(id = R.string.show_password)
            }

            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = iconImage, contentDescription = description)

            }
        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else
            PasswordVisualTransformation()
    )
}


@Composable
fun CheckBoxComponent(value: String , onTextSelected: (String) -> Unit){
    Row (modifier = Modifier
        .fillMaxWidth()
        .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically,
    ){
        val checkedState = remember {
            mutableStateOf(false)
        }
        Checkbox(checked = checkedState.value,
            onCheckedChange = {
                checkedState.value != checkedState.value
            })
        ClickableTextComponent(value = value , onTextSelected)
    }
}


@Composable
fun ClickableTextComponent(value: String, onTextSelected: (String) -> Unit){
    val initialText = "By continuing you accept our "
    val privacyAndPolicyText = "Privacy Policy"
    val andText = " and "
    val termsAndConditionText = "Term of Use"
    val primary = colorResource(id = R.color.colorPrimary)

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = primary)){
            pushStringAnnotation(tag = privacyAndPolicyText , annotation =  privacyAndPolicyText)
            append(privacyAndPolicyText)
        }
        append(andText)
        withStyle(style = SpanStyle(color = primary)){
            pushStringAnnotation(tag = termsAndConditionText , annotation =  termsAndConditionText)
            append(termsAndConditionText)
        }
    }

    ClickableText(text = annotatedString , onClick = {offset ->
        annotatedString.getStringAnnotations(offset,offset)
            .firstOrNull()?.also { span ->
                Log.d("ClickableTextComponent","{$span}")
                if (span.item == termsAndConditionText || span.item == privacyAndPolicyText){
                    onTextSelected(span.item)
                }
            }
    })
}

@Composable
fun ButtonComponent(value: String) {
    Button(
        onClick = {ProjectRouterScreen.navigateTo(Screen.LoginScreen)},
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        shape = RoundedCornerShape(50.dp)
    ) {
        val secondary = colorResource(id = R.color.colorSecondary)
        val primary = colorResource(id = R.color.colorPrimary)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(listOf(secondary, primary)),
                    shape = RoundedCornerShape(50.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            androidx.compose.material.Text(
                text = value,
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

        }

    }
}

@Composable
fun ButtonSignUpComponent(value: String,registrationFill: MutableState<RegistrationFill>) {
    val context = LocalContext.current
    fun isEmailValid(email: String): Boolean{
        val pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }
    fun isPasswordValid(password: String): Boolean{
        return password.length >= 6 && password.any{it.isDigit()}
    }
    fun isFirstNameValid(firstname: String): Boolean{
        return firstname.length >=3
    }
    fun isLastNameValid(lastname: String): Boolean{
        return lastname.length >=3
    }
    Button(
        onClick = {
            val application = context.applicationContext as Application
            val database = (application as MyApplication).database
            val userDao = database.userDao()

            val input = registrationFill.value

            if (input.firstname.isNotEmpty()&&
                input.lastname.isNotEmpty() &&
                input.email.isNotEmpty() &&
                input.password.isNotEmpty() &&
                input.confirmPass.isNotEmpty()&&
                input.confirmPass == input.password &&
                isEmailValid(input.email) &&
                isPasswordValid(input.password) &&
                isFirstNameValid(input.firstname) &&
                isLastNameValid(input.lastname)){

                val entity = User(firstname = input.firstname,
                    lastname = input.lastname,
                    email = input.email,
                    password =  input.password,
                    confirmPassword = input.confirmPass)
                CoroutineScope(Dispatchers.IO).launch {
                    userDao.insert(entity)
                    Log.d("DatabaseLogging", "Data inserted: $entity")                }
                ProjectRouterScreen.navigateTo(Screen.LoginScreen)
                Toast.makeText(context, "Success To Register An Account", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(context, "Fields Must Be Filled!!" , Toast.LENGTH_SHORT).show()
            }

        },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        shape = RoundedCornerShape(50.dp)
    ) {
        val secondary = colorResource(id = R.color.colorSecondary)
        val primary = colorResource(id = R.color.colorPrimary)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(listOf(secondary, primary)),
                    shape = RoundedCornerShape(50.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            androidx.compose.material.Text(
                text = value,
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

        }

    }
}

var userIsLogin: User? = null

@Composable
fun ButtonLoginComponent(value: String, loginFill: MutableState<LoginFill>) {
    val context = LocalContext.current
    Button(
        onClick = {
            val email = loginFill.value.email
            val password = loginFill.value.password

            val userDao = (context.applicationContext as MyApplication).database.userDao()

            CoroutineScope(Dispatchers.IO).launch {
                val user = userDao.getUserByEmail(email)
                withContext(Dispatchers.Main){
                    if (user != null && user.password == password){
                        userIsLogin = user
                        Toast.makeText(context, "Login success", Toast.LENGTH_SHORT).show()
                        ProjectRouterScreen.navigateTo(Screen.HomeMoviesScreen)
                    }else{
                        Toast.makeText(context, "Email Or Password Incorrect", Toast.LENGTH_SHORT).show()
                    }

                }
            }

        },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        shape = RoundedCornerShape(50.dp)
    ) {
        val secondary = colorResource(id = R.color.colorSecondary)
        val primary = colorResource(id = R.color.colorPrimary)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(listOf(secondary, primary)),
                    shape = RoundedCornerShape(50.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            androidx.compose.material.Text(
                text = value,
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

        }

    }
}


@Composable
fun ButtonHomeComponent(value: String) {
    Button(
        onClick = {ProjectRouterScreen.navigateTo(Screen.HomeScreen)},
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        shape = RoundedCornerShape(50.dp)
    ) {
        val secondary = colorResource(id = R.color.colorSecondary)
        val primary = colorResource(id = R.color.colorPrimary)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(listOf(secondary, primary)),
                    shape = RoundedCornerShape(50.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            androidx.compose.material.Text(
                text = value,
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

        }

    }
}

@Composable
fun DividerTextComponent(){
    Row (modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically){
        Divider(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            color = colorResource(id = R.color.colorGrey),
            thickness = 1.dp
        )

        Text(text = "Or",
            modifier = Modifier.padding(8.dp),
            fontSize = 18.sp,
            color = colorResource(id = R.color.colorText)
        )
        
        Divider(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            color = colorResource(id = R.color.colorGrey),
            thickness = 1.dp
        )
        
    }
}

@Composable
fun DividerComponent(){
    Row (modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically){
        Divider(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            color = colorResource(id = R.color.colorGrey),
            thickness = 1.dp
        )

        Divider(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            color = colorResource(id = R.color.colorGrey),
            thickness = 1.dp
        )

    }
}

@Composable
fun ClickableLoginTextComponent( onTextSelected: (String) -> Unit){
    val initialText = "Already Have Account? "
    val loginText = "Login"
    val primary = colorResource(id = R.color.colorPrimary)

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = primary)){
            pushStringAnnotation(tag = loginText , annotation =  loginText)
            append(loginText)
        }
    }

    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 21.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        ),
        text = annotatedString , onClick = {offset ->
        annotatedString.getStringAnnotations(offset,offset)
            .firstOrNull()?.also { span ->
                Log.d("ClickableTextComponent","{$span}")
                if (span.item == loginText){
                    onTextSelected(span.item)
                }
            }
    })
}

@Composable
fun UnderlineSpanComponents(value: String){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        )
        , color = colorResource(id = R.color.colorGrey),
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline
    )
}

@Composable
fun ClickableLoginTextComponent(tryingToLogin: Boolean = true, onTextSelected: (String) -> Unit){
    val initialText = if (tryingToLogin) "Already Have Account? " else "Don't have an account yet? "
    val loginText = if (tryingToLogin) "Login" else "Register"
    val primary = colorResource(id = R.color.colorPrimary)

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = primary)){
            pushStringAnnotation(tag = loginText , annotation =  loginText)
            append(loginText)
        }
    }

    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 21.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        ),
        text = annotatedString , onClick = {offset ->
            annotatedString.getStringAnnotations(offset,offset)
                .firstOrNull()?.also { span ->
                    Log.d("ClickableTextComponent","{$span}")
                    if (span.item == loginText){
                        onTextSelected(span.item)
                    }
                }
        })
}

@Composable
fun ImageHomeComponent(){
    Surface(
        modifier = Modifier.fillMaxWidth()
    ) {
        val imageResource = painterResource(id = R.drawable.illustration_started)
        androidx.compose.foundation.Image(
            modifier = Modifier.fillMaxWidth(),
            painter = imageResource,
            contentDescription = "Background")
    }
}

@Composable
fun ListHomeComponent(){
    val secondary = colorResource(id = R.color.background1)
    val primary = colorResource(id = R.color.background2)
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.linearGradient(listOf(secondary, primary))
            )
    ){
        val itemList = listOf(
            GridItem("Porche I7",
                R.drawable.ic_porche,
                "The Porsche 911 Turbo's delivery of speed is nothing short of freaky fast. " +
                        "Its all-wheel-drive launches are courtesy a standard 573-hp 3.7-liter flat-six or a 640-hp version for Turbo S models."),
            GridItem("Lamborgini Terzo",
                R.drawable.ic_lambo_terzo,
                "The limited edition hybrid hypercar will feature an electric motor at the front wheels and the Italian auto manufacturer’s 6.5-liter V12 engine at the rear axle. " +
                        "Working in unison, the car is rumored to have a combined output of 838 horsepower (625 kilowatts)."),
            GridItem("Dodge Challanger 392",
                R.drawable.ic_dodge,
                "The Challenger is equipped with a Bilstein high-performance suspension with 3-mode active damping and rear stabilizer bar to tackle whatever the road sends its way. " +
                        "Car and Driver says of top-tier Challenger 392 models: " +
                        "“they’re quick as hell in a straight line and handle well enough to hustle down twisty back roads”."),
            GridItem("McLarent P1",
                R.drawable.ic_mclaren,
                "The McLaren P1 is a sports car produced by British marque McLaren Automotive. It is a plug-in hybrid with a mid-engine layout. It was first shown at the 2012 Paris Motor Show," +
                        "with sales of the P1 beginning in the United Kingdom in October 2013 and all of the limited run of 375 units sold by November 2013." +
                        "Production ended in early December 2015. The United States accounted for 34% of the units and Europe for 26%."),
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = Brush.linearGradient(listOf(secondary, primary)))
            ,
            content = {
                items(items = itemList.chunked(2)) { rowItems ->
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ){
                        rowItems.forEach { item ->
                            GridItemCard(item) {
                                ProjectRouterScreen.navigateTo(Screen.LoginScreen)
                            }
                    }
                    }

                }
            }
        )
    }
}
data class GridItem(val name: String, @DrawableRes val imageResource: Int, val desc : String)

@Composable
fun GridItemCard(item: GridItem, onItemClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .width(180.dp)
            .height(180.dp)
        ,
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .clickable(onClick = onItemClick),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = item.imageResource),
                contentDescription = null,
                modifier = Modifier.size(120.dp)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = item.name,
                style = TextStyle(fontSize = 16.sp),
            )
        }
    }
}
