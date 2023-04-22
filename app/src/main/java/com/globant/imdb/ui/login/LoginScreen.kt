package com.globant.imdb.ui.login

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.globant.imdb.R
import com.globant.imdb.navigation.NavRoutes
import com.globant.imdb.ui.theme.Charcoal
import com.globant.imdb.ui.theme.GoldenPoppy
import com.globant.imdb.ui.theme.LightSilver
import com.globant.imdb.ui.theme.Nobel
import com.globant.imdb.ui.theme.White
import com.globant.imdb.ui.theme.WhiteSmoke

@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    navController: NavController
) {
    LoginContent {
        navController.navigate(NavRoutes.Main.route)
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginContent(
    navToMain: () -> Unit
) {
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisibility by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GoldenPoppy)
            .padding(horizontal = 46.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {
        Logo()

        Spacer(Modifier.height(15.dp))

        LabelUser()

        Spacer(Modifier.height(8.dp))

        FieldUser(
            value = email,
            onValueChanged = { email = it.trim() },
            focusManager = focusManager
        )

        Spacer(Modifier.height(15.dp))

        LabelPassword()

        Spacer(Modifier.height(8.dp))

        FieldPassword(
            value = password,
            onValueChanged = { password = it.trim() },
            passwordVisibility = passwordVisibility,
            onPasswordVisibilityChanged = { passwordVisibility = !it },
            focusManager = focusManager
        )

        Spacer(Modifier.height(5.dp))

        ForgotPassword()

        Spacer(Modifier.height(28.dp))

        LoginButton(email, password, { }, keyboardController)

        Spacer(Modifier.height(37.dp))

        LabelLoginWith()

        Spacer(Modifier.height(23.dp))

        LoginProviders()

        Spacer(Modifier.height(23.dp))

        SignUp()

        Spacer(Modifier.height(20.dp))

        LabelContinueAsGuest(navToMain)
    }
}

@Composable
fun Logo() {
    Image(
        painter = painterResource(id = R.drawable.ic_imdb_logo),
        contentDescription = stringResource(id = R.string.splash_logo),
        modifier = Modifier
            .width(168.6.dp)
    )
}

@Composable
fun Label(
    @StringRes label: Int
) {
    Text(
        text = stringResource(label),
        modifier = Modifier
            .fillMaxWidth(),
        color = Charcoal,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium
    )
}

@Composable
fun LabelUser() = Label(label = R.string.user)

@Composable
fun LabelPassword() = Label(label = R.string.password)

@Composable
fun FieldUser(
    value: String,
    onValueChanged: (String) -> Unit,
    focusManager: FocusManager,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        modifier = modifier
            .fillMaxWidth()
            .background(WhiteSmoke, RoundedCornerShape(8.dp)),
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = WhiteSmoke,
            unfocusedBorderColor = WhiteSmoke
        ),
        maxLines = 1,
        singleLine = true,
        onValueChange = onValueChanged,
        keyboardActions = KeyboardActions(
            onNext = { focusManager.moveFocus(focusDirection = FocusDirection.Next) }
        ),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Email
        )
    )
}

@Composable
fun FieldPassword(
    value: String,
    onValueChanged: (String) -> Unit,
    passwordVisibility: Boolean,
    onPasswordVisibilityChanged: (Boolean) -> Unit,
    focusManager: FocusManager,
    modifier: Modifier = Modifier
) {
    val icon = if (passwordVisibility)
        painterResource(id = R.drawable.ic_visibility)
    else
        painterResource(id = R.drawable.ic_visibility_off)

    OutlinedTextField(
        value = value,
        modifier = modifier
            .fillMaxWidth()
            .background(WhiteSmoke, RoundedCornerShape(8.dp)),
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = WhiteSmoke,
            unfocusedBorderColor = WhiteSmoke
        ),
        maxLines = 1,
        singleLine = true,
        onValueChange = onValueChanged,
        trailingIcon = {
            IconButton(onClick = {
                onPasswordVisibilityChanged(passwordVisibility)
            }) {
                Icon(
                    painter = icon,
                    contentDescription = "Visibility Icon"
                )
            }
        },
        visualTransformation = if (passwordVisibility) VisualTransformation.None
        else PasswordVisualTransformation(),
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
                // TODO: Launch Login
            }
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        )
    )
}

@Composable
fun ForgotPassword(
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(id = R.string.forgot_password),
        modifier = modifier
            .fillMaxWidth(),
        color = Charcoal,
        fontSize = 12.sp,
        fontWeight = FontWeight.Light,
        fontStyle = FontStyle.Italic
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginButton(
    email: String,
    password: String,
    onClick: () -> Unit,
    keyboardController: SoftwareKeyboardController?,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = {
            keyboardController?.hide()
            onClick
        },
        enabled = true,
        colors = if (email.isNotEmpty() && password.isNotEmpty()) ButtonDefaults.buttonColors(
            Charcoal
        )
        else ButtonDefaults.buttonColors(Nobel),
        modifier = modifier
            .fillMaxWidth()
            .height(54.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = stringResource(id = R.string.login),
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            color = if (email.isNotEmpty() && password.isNotEmpty()) White else LightSilver
        )
    }
}

@Composable
fun LabelLoginWith(
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(id = R.string.login_with),
        color = Charcoal,
        fontSize = 16.sp,
        fontWeight = FontWeight.Light,
        fontStyle = FontStyle.Italic
    )
}

@Composable
fun LoginProviders(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(White),
            modifier = Modifier.size(58.dp),
            shape = CircleShape
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_apple),
                modifier = Modifier.fillMaxSize(),
                contentDescription = "Login with Apple"
            )
        }
        Spacer(Modifier.width(16.dp))
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(White),
            modifier = Modifier.size(58.dp),
            shape = CircleShape
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_facebook),
                modifier = Modifier.fillMaxSize(),
                contentDescription = "Login with Facebook"
            )
        }
        Spacer(Modifier.width(16.dp))
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(White),
            modifier = Modifier.size(58.dp),
            shape = CircleShape
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_google),
                modifier = Modifier.fillMaxSize(),
                contentDescription = "Login with Google"
            )
        }
    }
}

@Composable
fun SignUp(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.no_account),
            color = Charcoal,
            fontSize = 16.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Light
        )
        Spacer(
            Modifier.width(4.dp)
        )
        Text(
            text = stringResource(id = R.string.sign_up),
            color = Charcoal,
            fontSize = 16.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun LabelContinueAsGuest(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TextButton(
        onClick = onClick
    ) {
        Text(
            text = stringResource(id = R.string.continue_as_guest),
            color = Charcoal,
            fontSize = 16.sp,
            fontWeight = FontWeight.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginContent({  })
}