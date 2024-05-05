package com.example.chatapp_dacs3.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.chatapp_dacs3.R


class HomeViewModel : ViewModel() {
    var statusFriend by mutableStateOf<List<statusFriend>?>(null)
        private set
    var lastFriend by mutableStateOf<List<lastFriend>?>(null)
        private set
    fun fetchStatusFriend() {
        val friends = listOf(
            statusFriend(R.drawable.newuser, "Nguyen Phuc"),
            statusFriend(R.drawable.newuser, "Mai Thuong"),
            statusFriend(R.drawable.newuser, "Tran Dang"),
            statusFriend(R.drawable.newuser, "Wong Da"),
            statusFriend(R.drawable.newuser, "Ton Lu"),
            statusFriend(R.drawable.newuser, "Tao La Ai"),
            statusFriend(R.drawable.newuser, "Phuc Is Me"),
            statusFriend(R.drawable.newuser, "EEEEEE"),
            statusFriend(R.drawable.newuser, "DDDDg")
        )
        statusFriend = friends
    }

    fun fetchLastFriend() {
        val friends = listOf(
            statusFriend(R.drawable.newuser, "Nguyen Phuc"),
            statusFriend(R.drawable.newuser, "Mai Thuong"),
            statusFriend(R.drawable.newuser, "Tran Dang"),
            statusFriend(R.drawable.newuser, "Wong Da"),
            statusFriend(R.drawable.newuser, "Ton Lu"),
            statusFriend(R.drawable.newuser, "Tao La Ai"),
            statusFriend(R.drawable.newuser, "Phuc Is Me"),
            statusFriend(R.drawable.newuser, "EEEEEE"),
            statusFriend(R.drawable.newuser, "DDDDg")
        )
        statusFriend = friends
    }
}





