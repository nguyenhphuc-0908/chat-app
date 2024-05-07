package com.example.chatapp_dacs3.ui.screens.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.chatapp_dacs3.R
import com.example.chatapp_dacs3.model.YourRecentSearch

class SearchViewModel: ViewModel() {
    var recentSearch by mutableStateOf<List<YourRecentSearch>?>(null)
        private set
    var recommendSearch by mutableStateOf<List<YourRecentSearch>?>(null)
        private set
    fun fetchYourRecentSearch() {
        val list = listOf(
            YourRecentSearch(R.drawable.newuser, "Nguyen Phuc"),
            YourRecentSearch(R.drawable.newuser, "Mai Thuong"),
            YourRecentSearch(R.drawable.newuser, "Tran Dang"),
            YourRecentSearch(R.drawable.newuser, "Wong Da"),
            YourRecentSearch(R.drawable.newuser, "Ton Lu"),
            YourRecentSearch(R.drawable.newuser, "Tao La Ai"),
            YourRecentSearch(R.drawable.newuser, "Phuc Is Me"),
        )
        recentSearch = list
    }

    fun fetchRecommendSearch() {
        val list = listOf(
            YourRecentSearch(R.drawable.newuser, "Nguyen Phuc"),
            YourRecentSearch(R.drawable.newuser, "Mai Thuong"),
            YourRecentSearch(R.drawable.newuser, "Tran Dang"),
            YourRecentSearch(R.drawable.newuser, "Wong Da"),
            YourRecentSearch(R.drawable.newuser, "Ton Lu"),
            YourRecentSearch(R.drawable.newuser, "Tao La Ai"),
            YourRecentSearch(R.drawable.newuser, "Phuc Is Me"),
            YourRecentSearch(R.drawable.newuser, "EEEEEE"),
            YourRecentSearch(R.drawable.newuser, "DDDDg")
        )
        recommendSearch = list
    }
}