package com.example.virtualtourist.ui.screen.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.virtualtourist.R
import com.example.virtualtourist.ui.theme.inter
import com.example.virtualtourist.ui.utils.isScrollingUp
import com.example.virtualtourist.ui.widgets.RouteCardFull

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {
    val lazyListState = rememberLazyListState()
    val density = LocalDensity.current
    LaunchedEffect(Unit) {
        viewModel.init(navController)
    }
    PullToRefreshBox(
        isRefreshing = viewModel.state.connection.loading,
        onRefresh = { viewModel.refresh(navController) },
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            AnimatedVisibility(
                visible = lazyListState.isScrollingUp().value,
                enter = slideInVertically {
                    with(density) { -80.dp.roundToPx() }
                } + expandVertically(
                    expandFrom = Alignment.Top
                ) + fadeIn(
                    initialAlpha = 0.3f
                ),
                exit = slideOutVertically() + shrinkVertically() + fadeOut()
            ) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp, top = 20.dp)
                        .border(2.dp, colorScheme.onSurface, RoundedCornerShape(16.dp))
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.search),
                            contentDescription = "Поиск",
                            tint = colorScheme.primary
                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.logo_small),
                        contentDescription = "Маленький логотип",
                        Modifier.height(32.dp).padding(bottom=2.dp)
                    )
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.profile),
                            contentDescription = "Профиль",
                            tint = colorScheme.primary
                        )
                    }
                }
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .horizontalScroll(rememberScrollState())
            ) {
                Spacer(Modifier.width(20.dp))
                Box(
                    Modifier
                        .background(colorScheme.primary, RoundedCornerShape(8.dp))
                        .padding(horizontal = 24.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = "Для вас",
                        fontWeight = FontWeight.Medium,
                        fontFamily = inter,
                        color = colorScheme.background,
                        fontSize = 14.sp,
                        lineHeight = 14.sp
                    )
                }
                Spacer(Modifier.width(20.dp))
            }
            LazyColumn(modifier = Modifier.padding(horizontal = 20.dp), state = lazyListState) {
                items(viewModel.state.routes) {
                    RouteCardFull(route = it, toggleSubscription = { i, v -> }, onClick = {})
                    Spacer(modifier = Modifier.height(24.dp))
                }
            }
        }
    }
}