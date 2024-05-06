package com.example.chatapp_dacs3.ui.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.chatapp_dacs3.R
import com.example.chatapp_dacs3.model.LastFriend
import com.example.chatapp_dacs3.model.StatusFriend


class HomeViewModel : ViewModel() {
    var statusFriend by mutableStateOf<List<StatusFriend>?>(null)
        private set
    var lastFriend by mutableStateOf<List<LastFriend>?>(null)
        private set
    fun fetchStatusFriend() {
        val friends = listOf(
            StatusFriend(R.drawable.newuser, "Nguyen Phuc"),
            StatusFriend(R.drawable.newuser, "Mai Thuong"),
            StatusFriend(R.drawable.newuser, "Tran Dang"),
            StatusFriend(R.drawable.newuser, "Wong Da"),
            StatusFriend(R.drawable.newuser, "Ton Lu"),
            StatusFriend(R.drawable.newuser, "Tao La Ai"),
            StatusFriend(R.drawable.newuser, "Phuc Is Me"),
            StatusFriend(R.drawable.newuser, "EEEEEE"),
            StatusFriend(R.drawable.newuser, "DDDDg")
        )
        statusFriend = friends
    }

    fun fetchLastFriend() {
        val friends = listOf(
            LastFriend(R.drawable.newuser, "Nguyen Phuc","Hello you are my teacher",34),
            LastFriend(R.drawable.newuser, "Ton Lu","Im a dog",0),
            LastFriend(R.drawable.avatar_garena_2, "TDDDD",":)))))))))",32),
            LastFriend(R.drawable.newuser, "Nguyen Phuc","Hello you are my teacher",34),
            LastFriend(R.drawable.newuser, "Nguyen Phuc","Hello you are my teacher",34),
            LastFriend(R.drawable.newuser, "Nguyen Phuc","Hello you are my teacher",34),
            LastFriend(R.drawable.newuser, "Nguyen Phuc","Hello you are my teacher",34),
            LastFriend(R.drawable.newuser, "Nguyen Phuc","Hello you are my teacher",34),
            LastFriend(R.drawable.newuser, "Nguyen Phuc","Hello you are my teacher",34),
            LastFriend(R.drawable.newuser, "Nguyen Phuc","Hello you are my teacher",34),


        )
        lastFriend = friends
    }
}





