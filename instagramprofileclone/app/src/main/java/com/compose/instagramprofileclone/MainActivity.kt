package com.compose.instagramprofileclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.compose.instagramprofileclone.ui.theme.InstagramProfileCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramProfileCloneTheme {
                ProfileScreen()
            }
        }
    }
}