package com.example.chatapp_dacs3.ui.screens.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatapp_dacs3.ui.components.CustomTextField
import com.example.chatapp_dacs3.ui.components.RoundIconButton
import com.example.chatapp_dacs3.ui.screens.message.MessageScreen
import com.example.chatapp_dacs3.ui.screens.message.TopBarMes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(

) {
    Scaffold(
        topBar =
        {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onSurface,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .padding(0.dp)
                ,
                title = {
                    TopBarSearch()
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
        }

    ) {innerPadding->
        Column (
            Modifier.padding(innerPadding)
        ){
            

        }
    }
}


@Composable
fun RecentSearch() {

}

@Composable
fun TopBarSearch(){
 Column(
     Modifier.fillMaxSize(),
     verticalArrangement = Arrangement.Center
 ) {
     CustomTextField(
         leadingIcon = {
             Icon(
                 Icons.Filled.Search,
                 null,
                 tint = LocalContentColor.current.copy(alpha = 0.3f),
             )
         },
         trailingIcon = null,
         modifier = Modifier
             .background(
                 MaterialTheme.colorScheme.surface,
                 RoundedCornerShape(percent = 50)
             )
             .padding(2.dp)
             .height(30.dp),
         fontSize = 14.sp,
         placeholderText = "Search"
     )
 }
}





@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SearchPreview() {
    SearchScreen()
}