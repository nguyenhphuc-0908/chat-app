package com.example.chatapp_dacs3.ui.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.chatapp_dacs3.ui.theme.Green1
import com.example.chatapp_dacs3.ui.theme.LightGreen1

@Composable
fun MyMessage(message: String ) {
    val messageLength = message.length
    Log.d("Message.Length", messageLength.toString())
    val boxHeight = if (messageLength <= 50) 50.dp else 65.dp

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 50.dp, end = 7.dp, top = 5.dp, bottom = 5.dp),
        horizontalAlignment = Alignment.End
    ) {
        // Display message
        Box(
            modifier = Modifier
                .height(boxHeight)
                .background(LightGreen1)
                .padding(15.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            Text(text = message, modifier = Modifier.align(Alignment.CenterEnd), style = TextStyle(color = Color.White))
        }
    }
}

@Composable
fun FriendMessage(message: String ) {
    val messageLength = message.length
    val boxHeight = if (messageLength < 20) 50.dp else 70.dp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 7.dp, end = 50.dp, top = 5.dp, bottom = 5.dp),
        horizontalAlignment = Alignment.Start
    ) {
        // Display message
        Box(
            modifier = Modifier
                .height(boxHeight)
                .background(Color.LightGray)
                .padding(15.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            Text(text = message)
        }
    }
}

