package com.example.chatapp_dacs3.ui.screens.signUp

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SignUpScreen(onLoginClicked: (String, String) -> Unit) {
    var nickname by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmpassword by remember { mutableStateOf("") }

    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 17.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = nickname,
            onValueChange = { nickname = it },
            label = { Text("Your nickname") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            )
        )
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Your email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            )
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            )
        )
        OutlinedTextField(
            value = confirmpassword,
            onValueChange = { confirmpassword = it },
            label = { Text("Confirm Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            )
        )
        Button(
            onClick = { onLoginClicked(username, password) },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors()
        ) {
            Text("Sign Up", color = Color.White)
        }
    }
}

@Preview
@Composable
fun PreviewLoginScreen() {
    SignUpScreen(onLoginClicked = { _, _ -> })
}


