package com.example.chatapp_dacs3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chatapp_dacs3.ui.screens.home.HomeScreen
import com.example.chatapp_dacs3.ui.screens.home.HomeViewModel
import com.example.chatapp_dacs3.ui.screens.message.MessageScreen
import com.example.chatapp_dacs3.ui.screens.signIn.SignInScreen
import com.example.chatapp_dacs3.ui.theme.ChatApp_DACS3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Main()
        }
    }
}
@Composable
fun ErrorDialog(
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Error") },
        text = { Text("Invalid username or password.") },
        confirmButton = {
            Button(
                onClick = onDismiss,
                colors = ButtonDefaults.buttonColors(
                    MaterialTheme.colorScheme.secondaryContainer
                )
            ) {
                Text("OK")
            }
        }
    )
}

@Composable
fun Main() {

    val navController = rememberNavController()
    var showDialog by remember { mutableStateOf(false) }
    var isVisibleSignIn by remember { mutableStateOf(true) }

    val viewModel: HomeViewModel = remember { HomeViewModel() }

    ChatApp_DACS3Theme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NavHost(navController = navController, startDestination = "signIn" ){
                composable("signIn"){
                    EnterAnimation {
                        SignInScreen { username, password ->
                            if(username == "phuc" && password == "0908")
                                navController.navigate("home")
                            else
                                showDialog = true
                        }
                        if (showDialog) {
                            ErrorDialog(onDismiss = { showDialog = false })
                        }
                    }
                }
                composable("home"){
                    EnterAnimation {
                        HomeScreen(
                            viewModel = viewModel,
                            openFriendChat = {
                                navController.navigate("mesFriend")
                            })
                    }
                }
                composable("mesFriend"){
                    MessageScreen(

                    )
                }

            }
        }
    }
}

@Composable
fun EnterAnimation(content: @Composable () -> Unit) {
    AnimatedVisibility(
        visibleState = MutableTransitionState(
            initialState = false
        ).apply { targetState = true },
        modifier = Modifier,
        enter = slideInVertically(
            initialOffsetY = { -40 }
        ) + expandVertically(
            expandFrom = Alignment.Top
        ) + fadeIn(initialAlpha = 0.3f),
        exit = slideOutVertically() + shrinkVertically() + fadeOut(),
    ) {
        content()
    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    Main()
}
