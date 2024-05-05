package com.example.chatapp_dacs3.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.example.chatapp_dacs3.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ImageMessage(
    imageResId: Int,
    isMyImage: Boolean
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = if (isMyImage)50.dp else 7.dp,
                end =   if (isMyImage)7.dp else 50.dp,
                top = 5.dp,
                bottom = 5.dp),
        horizontalAlignment =
        if (isMyImage)
            Alignment.End
        else
            Alignment.Start,

    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = "",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .aspectRatio(1.5f)
                .fillMaxSize()
                .size(200.dp) ,
            alignment =
            if (isMyImage)
                Alignment.CenterEnd
            else
                Alignment.CenterStart
        )
    }
}