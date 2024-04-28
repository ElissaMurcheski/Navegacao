package com.example.mylogin.ui.screns

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mylogin.R
import com.example.mylogin.components.ButtonFillMaxWidth

@Composable
fun MainScreen(username: String, onLogOutClick: () -> Unit) {
    Column {
        Row {
            Text(
                username,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Row {
            ButtonFillMaxWidth(R.string.logOut, onClick = { onLogOutClick() }, Modifier.padding(top = 600.dp))
        }
    }
}