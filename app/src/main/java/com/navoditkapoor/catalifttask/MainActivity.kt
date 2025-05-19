package com.navoditkapoor.catalifttask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.navoditkapoor.catalifttask.ui.theme.CataliftTheme
import com.navoditkapoor.catalifttask.uiForMainActivity.BottomNav
import com.navoditkapoor.catalifttask.uiForMainActivity.PostCard
import com.navoditkapoor.catalifttask.uiForMainActivity.SearchBar
import com.navoditkapoor.catalifttask.uiForMainActivity.TopBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CataliftTheme {
                Scaffold(
                    topBar = { TopBar() },
                    bottomBar = { BottomNav() },
                    content = { padding ->
                        Column(
                            modifier = Modifier
                                .padding(padding)
                                .fillMaxSize()
                        ) {
                            SearchBar()
                            PostCard()
                        }
                    }
                )
            }
        }
    }
}