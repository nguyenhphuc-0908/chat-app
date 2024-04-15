package com.example.chatapp_dacs3.ui.screens.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatapp_dacs3.R
import com.example.chatapp_dacs3.ui.theme.ChatApp_DACS3Theme

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun Home() {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.onSurface,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp),

                title = {
                    Row (
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(end = 15.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        RoundIconButton(null,imageVector = Icons.Default.Search) {

                        }
                        Text("Home", color = Color.White)
                        RoundIconButton(imageResId = R.drawable.newuser,null) {

                        }
                    }


                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    val texts = listOf("Message", "Calls","Contacts", "Settings")
                    val icons = listOf(
                        painterResource(id = R.drawable.chatbubble),
                        painterResource(id = R.drawable.call),
                        painterResource(id = R.drawable.contacts),
                        painterResource(id = R.drawable.settings)
                    )

                    for (i in 0 .. 3) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                painter = icons[i],
                                contentDescription = null,
                                tint = Color.Gray,
                                modifier = Modifier.size(37.dp)
                            )
                            Text(text = texts[i],style = TextStyle(fontSize = 10.sp)
                                , color = Color.Gray)
                        }
                    }

                }
            }
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
        ) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(70.dp))
            {

            }
        }
    }
}

@Composable
fun RoundIconButton(
    imageResId: Int?,
    imageVector: ImageVector?,
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier.size(60.dp),
        content = {
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .padding(12.dp)
                    .clip(CircleShape),
                contentAlignment = Alignment.Center,
                content = {
                    if(imageResId != null){
                        Image(
                            painter = painterResource(id = imageResId),
                            contentDescription = "",
                            modifier = Modifier.size(50.dp)
                        )
                    }
                    else if(imageVector != null){
                        Icon(
                            imageVector = imageVector,
                            contentDescription = "",
                            tint = Color.White,
                            modifier = Modifier.size(50.dp)
                        )
                    }
                },

                )
        }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    ChatApp_DACS3Theme {
        Home()
    }
}