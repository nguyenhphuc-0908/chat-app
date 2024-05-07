package com.example.chatapp_dacs3.ui.screens.home

import androidx.compose.foundation.clickable
import com.example.chatapp_dacs3.ui.theme.Green1
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.chatapp_dacs3.R
import com.example.chatapp_dacs3.model.LastFriend
import com.example.chatapp_dacs3.model.StatusFriend
import com.example.chatapp_dacs3.ui.components.RoundIconButton
import com.example.chatapp_dacs3.ui.components.*

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    openFriendChat:() -> Unit,
) {
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
                    TopBar(
                        findUserAction = {
                        }
                    )
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface,
            ) {
                BottomBar()
            }
        },
    ) { innerPadding ->
        LaunchedEffect(true) {
            viewModel.fetchStatusFriend()
            viewModel.fetchLastFriend()
        }
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
        ) {

            viewModel.statusFriend?.let {
                ListOfStatusFriend(it)
            }
            viewModel.lastFriend?.let {
                ListMyChat(openFriendChat = openFriendChat,it)
            }
        }
    }
}


@Composable
fun TopBar(
    findUserAction: () -> Unit,
) {
    Row (
        modifier = Modifier
            .fillMaxSize()
            .padding(end = 15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        RoundIconButton(
            null,
            imageVector = Icons.Default.Search,
            modifier = Modifier
                .size(50.dp),
            onClick = findUserAction,
        )
        Text("Home", color = Green1)
        RoundIconButton(
            imageResId = R.drawable.newuser,
            null,
            modifier = Modifier.size(50.dp)
        ) {

        }
    }
}

@Composable
fun BottomBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        val texts = listOf("Message", "Calls","Contacts", "Settings")
        val icons = listOf(
            painterResource(id = R.drawable.chat_bubble),
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
                    tint =
                    if (i==0) Green1
                    else Color.Gray,
                    modifier = Modifier.size(37.dp)
                )
                Text(text = texts[i],style = TextStyle(fontSize = 10.sp)
                    , color =
                    if (i==0) Green1
                    else Color.Gray,
                )
            }
        }

    }
}

@Composable
fun OneChatFriend(
    avatar: Int?,
    name: String,
    lastMessage: String,
    lastTimeMessage: String,
    openFriendChat: () -> Unit
) {
    Row (modifier = Modifier
        .fillMaxWidth()
        .clickable() {
            openFriendChat()
        }
        .padding(start = 15.dp, end = 15.dp)
        .height(75.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
//        Avatar
        Column (
            modifier = Modifier
                .fillMaxHeight()
                .width(70.dp),
                verticalArrangement = Arrangement.Center
        ){
            RoundIconButton(
                imageResId = avatar,
                null,
                modifier = Modifier
                    .width(65.dp)
                    .aspectRatio(1f)
            ) {}
        }
//        Other
        Column (
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ){
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween

            ){
                TextNameUser(name)
                TimeAgoChat(lastTimeMessage)
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                TextChat(lastMessage)
            }
        }
    }
}

@Composable
fun TimeAgoChat(
    text: String
) {
    Text(text = "$text ago",
        style = TextStyle(fontSize = 8.sp,
            fontWeight = FontWeight.W300
        ),
        maxLines = 1)
}

@Composable
fun ListMyChat(
    openFriendChat: () -> Unit,
    friends: List<LastFriend>
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding()
    ){
        friends.forEach {friend->
        OneChatFriend(
            avatar = friend.avatar,
            name = friend.name,
            lastMessage = friend.lastMessage,
            lastTimeMessage = friend.timeAgo.toString(),
            openFriendChat = openFriendChat
            )
        }
    }
}

@Composable
fun StatusFriend(
    friends: List<StatusFriend>
) {
    friends.forEach {friend->
        Column (modifier = Modifier
            .height(100.dp)
            .width(80.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            RoundIconButton(
                imageResId = friend.avatar,
                null,
                modifier = Modifier
                    .width(70.dp)
                    .aspectRatio(1f)
            ) {}
            Text(text = friend.name,
                modifier = Modifier.padding(top = 0.dp),
                style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.SemiBold),
                textAlign = TextAlign.Center,
                maxLines = 1,
            )
        }
    }
}

@Composable
fun ListOfStatusFriend(
    friends: List<StatusFriend>
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)
        .fillMaxWidth()
        .horizontalScroll(rememberScrollState())
    ) {
        StatusFriend(friends = friends)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    HomeScreen (
        viewModel = viewModel(),
        openFriendChat = {},
    )
}

