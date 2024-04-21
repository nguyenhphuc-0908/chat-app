package com.example.chatapp_dacs3.ui.screens.mesScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatapp_dacs3.R
import com.example.chatapp_dacs3.ui.components.RoundIconButton
import com.example.chatapp_dacs3.ui.components.TextChat
import com.example.chatapp_dacs3.ui.components.TextNameUser

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MessageScreen() {
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
                    TopBarMes(
                        ReturnAction = {

                        },

                    ) {

                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface,
            ) {
                BottomBarMes()
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
    ReturnAction: () -> Unit,
    CallAction:() ->Unit
) {
    Row (modifier = Modifier
        .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ){
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            RoundIconButton(
                null,
                imageVector = Icons.Default.ArrowBack,
                modifier = Modifier
                    .size(40.dp),
                onClick = ReturnAction,
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
    }
}

@Composable
fun BottomBarMes() {

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
        MessageScreen ()
}