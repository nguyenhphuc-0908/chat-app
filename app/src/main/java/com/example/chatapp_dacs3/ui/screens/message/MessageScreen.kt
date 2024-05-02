package com.example.chatapp_dacs3.ui.screens.message

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.chatapp_dacs3.R
import com.example.chatapp_dacs3.ui.components.RoundIconButton
import com.example.chatapp_dacs3.ui.components.TextChat
import com.example.chatapp_dacs3.ui.components.TextNameUser

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MessageScreen() {
    val text  = remember{ mutableStateOf("") }

    Scaffold(
        topBar = {


            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.onTertiary,
                    titleContentColor = MaterialTheme.colorScheme.onSurface,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(0.dp)
                ,
                title = {
                    TopBarMes()
                },
                navigationIcon = {
                    RoundIconButton(
                        null,
                        imageVector = Icons.Default.ArrowBack,
                        modifier = Modifier
                            .fillMaxHeight(),
                        onClick = {
//                            navController.popBackStack()
                        },
                    )
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.onTertiary,
                contentColor = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier
                    .border(border = BorderStroke(
                        width = 0.1.dp, color = Color.Gray
                    )
                )
            ) {
                BottomBarMes(text = text)
            }
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
        ) {
        }
    }
}



@Composable
fun TopBarMes(
) {
    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(0.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Row (
            modifier = Modifier
                .fillMaxHeight()
                .width(270.dp)
                .clickable(){},
            verticalAlignment = Alignment.CenterVertically
        ){

            RoundIconButton(
                imageResId = R.drawable.newuser,
                null,
                modifier = Modifier.size(60.dp)
            ) {

            }
            Column {
                TextNameUser("Nguyễn HPhúc")
                TextChat(text = "Active Now")
            }
        }

        Row (
            modifier = Modifier
                .fillMaxHeight()
                .width(50.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            RoundIconButton(
                imageResId = R.drawable.info,
                imageVector = null,
                modifier = Modifier.size(50.dp)
            ) {

            }
        }
    }
}

@Composable
fun BottomBarMes(
    text: MutableState<String>,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(top = 5.dp)
            ,
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ){
        RoundIconButton(
            imageResId = R.drawable.file,
            imageVector = null,
            modifier = Modifier
                .size(47.dp)
                .rotate(15f)
        ) {
        }

        TextfieldChatbox(text = text)

        RoundIconButton(
            imageResId = R.drawable.camera,
            imageVector = null,
            modifier = Modifier.size(47.dp)
        ) {
        }
        RoundIconButton(
            imageResId = R.drawable.mic,
            imageVector = null,
            modifier = Modifier.size(47.dp)
        ) {
        }
    }
}



@Composable
fun TextfieldChatbox(
    text: MutableState<String>,
) {
//    TextField(
//        value = text.value,
//        onValueChange = {
//            text.value = it
//        },
//        shape = RoundedCornerShape(15.dp),
//        modifier = Modifier
//            .fillMaxHeight()
//            .width(230.dp)
//            .padding(vertical = 7.dp)
//        ,
//        colors = TextFieldDefaults.colors(
//            focusedIndicatorColor = Color.Transparent,
//            unfocusedIndicatorColor = Color.Transparent,
//            ),
//    )
    TextField(
        value = text.value,
        onValueChange = {
            text.value = it
        },
        modifier = Modifier
            .width(220.dp),
        shape = RoundedCornerShape(8.dp),
        colors = TextFieldDefaults.colors(
        focusedIndicatorColor =  Color.Transparent, //hide the indicator
        unfocusedIndicatorColor = Color.Transparent
        )
    )


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MesPreview() {
        MessageScreen()
}