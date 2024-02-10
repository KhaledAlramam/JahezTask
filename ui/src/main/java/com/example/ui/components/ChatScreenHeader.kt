package com.example.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ui.R

@Composable
fun ChatScreenHeader(
    title: String,
    onBackPressed: () -> Unit,
    onCallPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(painter = painterResource(id = R.drawable.chevron_left),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary,
            modifier = modifier
                .clickable { onBackPressed() }
                .background(shape = RoundedCornerShape(10), color = Color.Transparent)
                .border(
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground),
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(10.dp))
        Text(text = title, color = MaterialTheme.colorScheme.secondary)

        Icon(painter = painterResource(id = R.drawable.phone),
            tint = MaterialTheme.colorScheme.secondary,
            contentDescription = null,
            modifier = modifier
                .clickable { onCallPressed() }
                .background(shape = RoundedCornerShape(10), color = Color.Transparent)
                .border(
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground),
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(10.dp))
    }
}