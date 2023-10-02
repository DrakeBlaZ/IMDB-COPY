package com.example.myapplication.pages

import android.content.res.Resources.Theme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.SearchPage

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SearchPage() {
    var searchbar by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1C1C20))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextField(
            value = searchbar,
            onValueChange = { searchbar = it },
            leadingIcon = {Icon(imageVector = Icons.Default.Search,contentDescription = "")},
            placeholder = { Text(text = "Buscar en IMDB")},
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        )
    }
}