package com.snackbar.customsnackbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.snackbar.customsnackbar.ui.theme.CustomSnackBarTheme
import com.snackbar.snackswipe.SnackSwipeBox
import com.snackbar.snackswipe.showSnackSwipe

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CustomSnackBarTheme {
                SnackSwipeBox { snackbarController ->
                    Column(
                        modifier = Modifier.fillMaxSize().background(Color.DarkGray),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Black
                            ),
                            onClick = {
                                snackbarController.showSnackSwipe(
                                    durationMillis = 2000,
                                    messageText = {
                                        Text(
                                            text = "It`s custom SnackSwipe",
                                            color = Color.White
                                        )
                                    },
                                    icon = {
                                        Icon(
                                            Icons.Default.CheckCircle,
                                            contentDescription = null,
                                            tint = Color.Green
                                        )
                                    },
                                    customAction = {
                                        Text(
                                            text = "Send",
                                            modifier = Modifier.clickable {},
                                            color = Color.White
                                        )
                                    },
                                    dismissAction = {
                                        IconButton(onClick = { snackbarController.close() }) {
                                            Icon(
                                                Icons.Default.Close,
                                                contentDescription = null,
                                                tint = Color.White
                                            )
                                        }
                                    }
                                )
                            }
                        ) {
                            Text(
                                text = "Show SnackSwipe",
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}
