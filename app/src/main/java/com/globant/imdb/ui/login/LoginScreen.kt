package com.globant.imdb.ui.login

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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.globant.imdb.R
import com.globant.imdb.ui.theme.Charcoal
import com.globant.imdb.ui.theme.GoldenPoppy
import com.globant.imdb.ui.theme.White
import com.globant.imdb.ui.theme.WhiteSmoke

@Composable
fun LoginScreen(

) {
    var emailState by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GoldenPoppy)
            .padding(horizontal = 46.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_imdb_logo),
            contentDescription = stringResource(id = R.string.splash_logo),
            modifier = Modifier
                .width(168.6.dp)
                .align(CenterHorizontally)
        )
        Spacer(
            Modifier.height(15.dp)
        )
        Text(
            text = stringResource(id = R.string.user),
            modifier = Modifier
                .fillMaxWidth(),
            color = Charcoal,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(
            Modifier.height(8.dp)
        )
        OutlinedTextField(
            value = emailState,
            modifier = Modifier
                .fillMaxWidth()
                .background(WhiteSmoke, RoundedCornerShape(8.dp)),
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = WhiteSmoke,
                unfocusedBorderColor = WhiteSmoke
            ),
            maxLines = 1,
            singleLine = true,
            onValueChange = {
                emailState = it
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            )
        )
        Spacer(
            Modifier.height(15.dp)
        )
        Text(
            text = stringResource(id = R.string.password),
            modifier = Modifier
                .fillMaxWidth(),
            color = Charcoal,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(
            Modifier.height(8.dp)
        )
        OutlinedTextField(
            value = emailState,
            modifier = Modifier
                .fillMaxWidth()
                .background(WhiteSmoke, RoundedCornerShape(8.dp)),
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = WhiteSmoke,
                unfocusedBorderColor = WhiteSmoke
            ),
            maxLines = 1,
            singleLine = true,
            onValueChange = {
                emailState = it
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            )
        )
        Spacer(
            Modifier.height(5.dp)
        )
        Text(
            text = stringResource(id = R.string.forgot_password),
            modifier = Modifier
                .fillMaxWidth(),
            color = Charcoal,
            fontSize = 12.sp,
            fontWeight = FontWeight.Light,
            fontStyle = FontStyle.Italic
        )
        Spacer(
            Modifier.height(28.dp)
        )
        Button(
            onClick = {
                /*TODO*/
            },
            enabled = true,
            colors = ButtonDefaults.buttonColors(Charcoal),
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = stringResource(id = R.string.login),
                fontSize = 20.sp,
            )
        }
        Spacer(
            Modifier.height(37.dp)
        )
        Text(
            text = stringResource(id = R.string.login_with),
            modifier = Modifier
                .align(CenterHorizontally),
            color = Charcoal,
            fontSize = 16.sp,
            fontWeight = FontWeight.Light,
            fontStyle = FontStyle.Italic
        )
        Spacer(
            Modifier.height(23.dp)
        )
        Row(
            modifier = Modifier
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
            Spacer(
                Modifier.width(16.dp)
            )
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
            Spacer(
                Modifier.width(16.dp)
            )
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
        Spacer(
            Modifier.height(23.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(id = R.string.no_account),
                color = Charcoal,
                fontSize = 16.sp,
                fontStyle = FontStyle.Italic
            )
            Spacer(
                Modifier.width(4.dp)
            )
            Text(
                text = stringResource(id = R.string.sign_up),
                color = Charcoal,
                fontSize = 16.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}