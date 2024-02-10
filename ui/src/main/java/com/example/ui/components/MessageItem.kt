package com.example.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.ui.R

@Composable
fun MessageItem(
    text: String,
    time: String,
    myMessage: Boolean,
    image: Painter,
    modifier: Modifier = Modifier
) {
    val layoutDirection = if (myMessage) {
        LayoutDirection.Ltr
    } else {
        LayoutDirection.Rtl
    }
    CompositionLocalProvider(LocalLayoutDirection provides layoutDirection) {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = image,
                    contentDescription = "Profile Image",
                    modifier = Modifier.size(30.dp),
                )
                Text(
                    text = time,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            if (myMessage) {
                MyMessageText(text = text)
            } else {
                OtherMessageText(text)
            }
            Spacer(modifier = Modifier.width(30.dp))
        }
    }

}

@Preview
@Composable
fun PreviewMyMessageItem() {
    MessageItem("Hello", "12:30", true, painterResource(id = R.drawable.my_avatar))
}

@Preview
@Composable
fun PreviewOtherMessageItem() {
    MessageItem("Hello", "12:30", false, painterResource(id = R.drawable.other_avatar))
}