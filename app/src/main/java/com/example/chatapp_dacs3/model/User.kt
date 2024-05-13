package com.example.chatapp_dacs3.model

data class User(val avatar: Int,
                val name: String,
                val lastMessage: String?,
                val timeAgo: Int?,
                val isFriend: Boolean?=false,
                val isOnline: Boolean?=false,
    ) {
    constructor(avatar: Int, name: String) : this(avatar, name, null, null, false, false)
}

