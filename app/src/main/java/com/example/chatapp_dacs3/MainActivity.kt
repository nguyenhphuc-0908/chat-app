package com.example.chatapp_dacs3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chatapp_dacs3.ui.animations.EnterAnimation
import com.example.chatapp_dacs3.ui.components.ErrorDialog
import com.example.chatapp_dacs3.ui.screens.SplashScreen
import com.example.chatapp_dacs3.ui.screens.home.HomeScreen
import com.example.chatapp_dacs3.ui.screens.home.HomeViewModel
import com.example.chatapp_dacs3.ui.screens.info.InfoScreen
import com.example.chatapp_dacs3.ui.screens.info.InfoViewModel
import com.example.chatapp_dacs3.ui.screens.message.MessageScreen
import com.example.chatapp_dacs3.ui.screens.message.MessageViewModel
import com.example.chatapp_dacs3.ui.screens.search.SearchScreen
import com.example.chatapp_dacs3.ui.screens.search.SearchViewModel
import com.example.chatapp_dacs3.ui.screens.signIn.SignInScreen
import com.example.chatapp_dacs3.ui.screens.signUp.SignUpScreen
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
fun Main() {
    val navController = rememberNavController()
    var showDialog by remember { mutableStateOf(false) }

    ChatApp_DACS3Theme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NavHost(navController = navController, startDestination = Destination.Splash.route ){

                composable(Destination.Splash.route) {
                    EnterAnimation {
                        SplashScreen(navController)
                    }
                }

                composable(Destination.SignIn.route){
                    EnterAnimation {
                        SignInScreen (navController = navController)
                        { username, password ->
                            if(username == "1" && password == "1")
                                navController.navigate(Destination.Home.route)
                            else
                                showDialog = true
                        }
                        if (showDialog) {
                            ErrorDialog(onDismiss = { showDialog = false })
                        }
                    }
                }

                composable(Destination.SignUp.route){
                    EnterAnimation {
                        SignUpScreen (navController = navController)
                        {username, nickname, password, confirmpassword ->

                        }
                        if (showDialog) {
                            ErrorDialog(onDismiss = { showDialog = false })
                        }
                    }
                }

                composable(Destination.Home.route){
                    val viewModel: HomeViewModel = remember { HomeViewModel() }
                    EnterAnimation {
                        HomeScreen(
                            viewModel = viewModel,
                            openFriendChat = {
                                navController.navigate(Destination.Message.route)
                            },
                            openSearch = {
                                navController.navigate(Destination.Search.route)
                            },
                            openMyinfo = {
                                navController.navigate(Destination.Info.route)
                            }

                        )
                    }
                }

                composable(Destination.Message.route){
                    val viewModel: MessageViewModel = remember { MessageViewModel() }
                    EnterAnimation {
                        MessageScreen(
                        viewModel = viewModel,
                            popBackStack = {
                                navController.popBackStack()
                            }
                        )
                    }
                }

                composable(Destination.Search.route){
                    val viewModel: SearchViewModel = remember { SearchViewModel() }
                    EnterAnimation {
                        SearchScreen(
                            viewModel = viewModel,
                            popBackStack = {
                                navController.popBackStack()
                            }
                        )
                    }
                }
                composable(Destination.Info.route){
                    val viewModel: InfoViewModel = remember { InfoViewModel() }
                    EnterAnimation {
                        InfoScreen(
                            viewModel = viewModel,
                            popBackStack = {
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }
        }
    }
}

sealed class Destination(val route: String){
    object Splash: Destination("splash")
    object Home: Destination("home")
    object SignIn: Destination("signin")
    object SignUp: Destination("signup")
    object Message: Destination("message")
    object Setting: Destination("setting")
    object Contact: Destination("contact")
    object Call: Destination("call")
    object Search: Destination("search")
    object Info: Destination("info")

}


@Preview(showBackground = true)
@Composable
fun Preview() {
    Main()
}
