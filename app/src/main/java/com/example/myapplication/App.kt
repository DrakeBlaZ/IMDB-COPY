package com.example.myapplication

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.pages.HomePage
import com.example.myapplication.pages.SearchPage

@Preview
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    val selectedRoute = remember {
        mutableStateOf("route_home")
    }
    Scaffold(

        bottomBar =
        {
            NavigationBar(selectedRoute = selectedRoute.value,
                onChange = { newRoute ->
                    selectedRoute.value = newRoute
                })

        },

        ) {
        when (selectedRoute.value){
            HomePage.route -> HomePage()
            SearchPage.route -> SearchPage()


        }
    }
}

