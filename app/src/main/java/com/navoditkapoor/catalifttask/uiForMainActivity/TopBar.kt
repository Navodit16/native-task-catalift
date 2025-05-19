package com.navoditkapoor.catalifttask.uiForMainActivity


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.res.painterResource
import com.navoditkapoor.catalifttask.R
import androidx.compose.ui.res.vectorResource



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Image(painter = painterResource(R.drawable.catalift_logo), contentDescription = "Catalift Logo")
        },
        actions = {
            Row {
                IconInCircle(Icons.Default.Person, "Profile")
                Spacer(modifier = Modifier.width(16.dp))
                IconInCircle(Icons.Default.Notifications, "Notifications")
                Spacer(modifier = Modifier.width(16.dp))
                IconInCircle(
                   ImageVector.vectorResource(R.drawable.baseline_chat_24),
                    contentDescription = "Chat"
                )
                Spacer(modifier = Modifier.width(16.dp))
            }
        }
    )
}

@Composable
fun IconInCircle(icon: ImageVector, contentDescription: String) {
    Box(
        modifier = Modifier
            .size(32.dp)
            .background(MaterialTheme.colorScheme.primary, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = Color.White
        )
    }
}