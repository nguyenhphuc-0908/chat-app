package com.example.chatapp_dacs3.ui.screens.homeScreen

import android.content.ContentValues
import android.util.Log
import com.example.chatapp_dacs3.ui.theme.Green1
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatapp_dacs3.R
import com.example.chatapp_dacs3.ui.theme.ChatApp_DACS3Theme
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun HomeScreen(
    findUserAction: () -> Unit,
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
                        findUserAction = { handleFindUserAction { addUser("Phúc", "D", 2004) } }
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
        Column(
            modifier = Modifier
                .padding(innerPadding),
        ) {
            ListStatusMyFriend()
        }
    }
}
fun handleFindUserAction(findUserAction: () -> Unit) {
    // Gọi lambda function tại đây
    findUserAction()
    // Thực hiện các hành động khác nếu cần

    // Trả về Unit
    return Unit
}

fun addUser(firstName: String, lastName: String, born: Int) {
    val db = Firebase.firestore
    val user = hashMapOf(
        "first" to firstName,
        "last" to lastName,
        "born" to born
    )

    db.collection("users")
        .add(user)
        .addOnSuccessListener { documentReference ->
            Log.d(ContentValues.TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
        }
        .addOnFailureListener { e ->
            Log.w(ContentValues.TAG, "Error adding document", e)
        }
}

@Composable
fun TopBar(
    findUserAction:()-> Unit?,
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
        ){
            findUserAction
        }
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
        val isClicked = remember {
            mutableStateListOf(false, false, false,false)
        }
        for (i in 0 .. 3) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable() {
                        for (j in 0..3) {
                            isClicked[j] = false
                        }
                        isClicked[i] = true
                    },
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = icons[i],
                    contentDescription = null,
                    tint =
                    if (isClicked[i]) Green1
                    else Color.Gray,
                    modifier = Modifier.size(37.dp)
                )
                Text(text = texts[i],style = TextStyle(fontSize = 10.sp)
                    , color =
                    if (isClicked[i]) Green1
                    else Color.Gray,
                )
            }
        }

    }
}

@Composable
fun ListStatusMyFriend() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)
        .fillMaxWidth()
        .horizontalScroll(rememberScrollState())
    )

    {
        for(i in 0..11){
            Column (modifier = Modifier
                .height(100.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                RoundIconButton(
                    imageResId = R.drawable.newuser,
                    null,
                    modifier = Modifier
                        .width(78.dp)
                        .aspectRatio(1f)
                ) {

                }
                Text(text = "HPhúc",color = Color.Black,
                    modifier = Modifier.padding(top = 0.dp),
                    style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                )
            }
        }
    }
}

@Composable
fun RoundIconButton(
    imageResId: Int?,
    imageVector: ImageVector?,
    modifier: Modifier,
    onClick: () -> Unit,

) {
    Box(modifier = Modifier.clip(CircleShape)){
        IconButton(
            onClick = onClick,
            modifier = modifier,
            content = {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(9.dp)
                        .clip(shape = CircleShape),
                    contentAlignment = Alignment.Center,
                    content = {
                        if(imageResId != null){
                            Image(
                                painter = painterResource(id = imageResId),
                                contentDescription = "",
                                modifier = modifier
                            )
                        }
                        else if(imageVector != null){
                            Icon(
                                imageVector = imageVector,
                                contentDescription = "",
                                tint = Green1,
                                modifier = modifier
                            )
                        }
                    },

                    )
            }
        )
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    ChatApp_DACS3Theme() {
        HomeScreen { addUser("Phuc", "D", 23) }
    }
}

