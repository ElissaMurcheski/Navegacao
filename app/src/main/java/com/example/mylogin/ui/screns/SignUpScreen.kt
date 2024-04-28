package com.example.mylogin.ui.screns

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mylogin.R
import com.example.mylogin.components.ButtonFillMaxWidth
import com.example.mylogin.components.InputPassword
import com.example.mylogin.components.InputText
import com.example.mylogin.components.Label

@Composable
fun SignUpScreen(context: Context, onSignUpClick: () -> Unit) {
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }

    Column {
        Row {
            Image(
                painter = painterResource(R.mipmap.ic_user_icon_foreground),
                contentDescription = "User Icon",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )
        }
        Row {
            Label(R.string.email)
        }
        Row {
            InputText(value = username.value) { username.value = it }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Label(R.string.username)
        }
        Row {
            InputText(value = password.value) { password.value = it }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Label(R.string.password)
        }
        Row {
            InputPassword(value = email.value) { email.value = it }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            ButtonFillMaxWidth(R.string.signUp, { onSignUpClick() })
        }
    }
}