package com.navoditkapoor.catalifttask.uiForMainActivity

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.navoditkapoor.catalifttask.R

@Composable
fun BottomNav() {
    NavigationBar(containerColor = MaterialTheme.colorScheme.primary) {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home", tint = Color.White) },
            label = { Text("Home", color = Color.White) },
            selected = false,
            onClick = { /* Navigate to home */ }
        )
        NavigationBarItem(
            icon = { Icon(ImageVector.vectorResource(R.drawable.baseline_explore_24) , contentDescription = "Explore Mentors", tint = Color.White) },
            label = { Text("Explore Mentors", color = Color.White) },
            selected = true,
            onClick = { /* Navigate to explore mentors */ }
        )
        NavigationBarItem(
            icon = { Icon(ImageVector.vectorResource(R.drawable.baseline_menu_book_24) , contentDescription = "Courses", tint = Color.White) },
            label = { Text("Courses", color = Color.White) },
            selected = false,
            onClick = { /* Navigate to courses */ }
        )
    }
}
