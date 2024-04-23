package com.example.chatapp_dacs3.ui.screens.message

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
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Phone
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp),

                title = {
                    TopBarMes()
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface,
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
fun TopBarMes() {
    Row (modifier = Modifier
        .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            RoundIconButton(
                null,
                imageVector = Icons.Default.ArrowBack,
                modifier = Modifier
                    .size(40.dp),
                onClick = {},
            )
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
                .width(100.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            RoundIconButton(
                imageResId = null,
                imageVector = Icons.Default.Phone,
                modifier = Modifier.size(45.dp)
            ) {

            }
            RoundIconButton(
                imageResId = null,
                imageVector = Icons.Default.Info,
                modifier = Modifier.size(45.dp)
            ) {

            }
        }
    }
}

@Composable
fun BottomBarMes(
    text: MutableState<String>
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(7.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        RoundIconButton(
            imageResId = R.drawable.file,
            imageVector = null,
            modifier = Modifier.size(47.dp)
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextfieldChatbox(
    text: MutableState<String>
) {
    TextField(
        value = text.value,
        onValueChange = {
            text.value = it
        },
        modifier = Modifier.size(220.dp, 45.dp),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            unfocusedLabelColor = Color.Black,
        ),
        shape = RoundedCornerShape(15.dp)
    )

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MesPreview() {
        MessageScreen ()
}