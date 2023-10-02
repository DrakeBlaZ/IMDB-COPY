package com.example.myapplication

import android.graphics.drawable.Icon
import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.Alternative
import com.example.myapplication.ui.theme.OnPrimary
import com.example.myapplication.ui.theme.OnSecondary

sealed class NavigationItem(
    val route: String,
    val title: String,
    val icon: ImageVector
)

object HomePage : NavigationItem("route_home", "Home", Icons.Filled.Home)
object SearchPage : NavigationItem("route_search", "Search", Icons.Filled.Search)
object ProfilePage : NavigationItem("route_profile", "Profile", Icons.Filled.AccountCircle)
object VideoPage : NavigationItem("route_video", "Video", Icons.Filled.PlayArrow)


@Composable
fun NavigationBar(
    selectedRoute: String = HomePage.route,
    onChange: (String) -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .background(OnPrimary)
            .padding(16.dp)

    )
    {
        NavBarItem(
            page = HomePage,
            selected = HomePage.route == selectedRoute,
            modifier = Modifier.clickable {
                onChange(HomePage.route)
            })
        NavBarItem(
            page = SearchPage,
            selected = SearchPage.route == selectedRoute,
            modifier = Modifier.clickable {
                onChange(SearchPage.route)
            })
        NavBarItem(
            page = VideoPage,
            selected = VideoPage.route == selectedRoute,
            modifier = Modifier.clickable {
                onChange(VideoPage.route)
            })
        NavBarItem(
            page = ProfilePage,
            selected = ProfilePage.route == selectedRoute,
            modifier = Modifier.clickable {
                onChange(ProfilePage.route)
            })
    }
}

@Composable
fun NavBarItem(page: NavigationItem, selected: Boolean = false, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(horizontal = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            imageVector = page.icon,
            contentDescription = page.title,
            modifier = Modifier.size(24.dp),
            colorFilter = ColorFilter.tint(
                if(selected) OnSecondary else Alternative
            )
        )
        Text(text = page.title,
            color = if (selected) OnSecondary else Alternative)
    }
}