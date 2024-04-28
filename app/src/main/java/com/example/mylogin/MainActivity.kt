package com.example.mylogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mylogin.ui.screns.MainScreen
import com.example.mylogin.ui.screns.SignInScreen
import com.example.mylogin.ui.screns.SignUpScreen
import com.example.mylogin.ui.theme.MyLoginTheme

const val usernameAdmin = "admin"
const val passwordAdmin = "admin"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val self = this
        super.onCreate(savedInstanceState)
        setContent {
            MyLoginTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "main/{username}") {
                        composable("main/{username}") { entry ->
                            entry.arguments?.getString("username")?.let { username ->
                                MainScreen(username, onLogOutClick = {
                                    navController.popBackStack()
                                })
                            } ?: LaunchedEffect(null) {
                                navController.navigate("signIn")
                            }
                        }
                        composable("signIn") {
                            SignInScreen(self, onSignInClick = { username ->
                                navController.navigate("main/${username}")
                            }, onSignUpClick = {
                                navController.navigate("signUp")
                            })
                        }
                        composable("signUp") {
                            SignUpScreen(self, onSignUpClick = {
                                navController.popBackStack()
                            })
                        }
                    }
                }
            }
        }
    }
}