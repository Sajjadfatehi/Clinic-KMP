package com.smart.clinic.feature.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.smart.clinic.core.designsystem.theme.ClinicTheme
import com.smart.clinic.feature.home.utils.TopLevelDestination
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.resources.vectorResource

@Composable
fun HomeScreen(navController: NavController) {

    val viewModel = viewModel { HomeViewModel() }
    HomeScreen(viewModel, navController) {
        viewModel.submitAction(it)
    }

}

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    navController: NavController,
    onAction: (HomeAction) -> Unit,
) {

    val viewState by viewModel.state.collectAsState()
    HomeScreen(viewState, navController, onAction)

}

@Composable
fun HomeScreen(
    viewState: HomeState,
    navController: NavController,
    onAction: (HomeAction) -> Unit,
) {
    var currentScreen by remember { mutableStateOf(TopLevelDestination.SEARCH) }
    Scaffold(
        bottomBar = {
            CustomBottomNavigation(
                currentScreen = currentScreen,
                onTabSelected = { screen -> currentScreen = screen }
            )
        }
    ) { innerPadding ->
//        NavHost(navController, startDestination = Profile, Modifier.padding(innerPadding)) {
//            composable<Profile> { ProfileScreen(...) }
//            composable<Friends> { FriendsScreen(...) }
//        }

        Box(
            Modifier.fillMaxSize().background(ClinicTheme.colorScheme.backgroundBase),
            contentAlignment = Alignment.Center
        ) {
            Text("text sajjad")
        }
    }
}


@Composable
fun CustomBottomNavigation(
    currentScreen: TopLevelDestination,
    onTabSelected: (TopLevelDestination) -> Unit,
) {

    Column(
        modifier = Modifier
            .fillMaxWidth().height(64.dp)
            .background(ClinicTheme.colorScheme.backgroundBase),
    ) {

        HorizontalDivider(
            thickness = ClinicTheme.strokes.base,
            color = ClinicTheme.colorScheme.divider
        )

        Spacer(Modifier.height(4.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(ClinicTheme.colorScheme.backgroundBase)
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TopLevelDestination.entries.forEach { item ->
                key(item) {
                    BottomSheetNavigationItem(
                        modifier = Modifier.weight(1f),
                        item = item,
                        currentScreen = currentScreen
                    ) {
                        onTabSelected(it)
                    }
                }
            }
        }
    }
}

@Composable
fun BottomSheetNavigationItem(
    modifier: Modifier = Modifier,
    item: TopLevelDestination,
    currentScreen: TopLevelDestination,
    onTabSelected: (TopLevelDestination) -> Unit,
) {

    Column(
        modifier = modifier.clickable(
            indication = null,
            interactionSource = remember { MutableInteractionSource() }
        ) {
            onTabSelected(item)
        },
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val isSelected = item == currentScreen
        Icon(
            imageVector = vectorResource(
                if (isSelected) item.selectedIcon
                else item.unselectedIcon
            ), contentDescription = "item icon",
            modifier = Modifier.size(20.dp)
        )
        AnimatedVisibility(
            visible = isSelected,
            enter = fadeIn() + expandVertically(),
            exit = fadeOut() + shrinkVertically(),
        ) {
            Text(
                text = stringResource(item.titleTextId),
                modifier = Modifier,
                color = if (isSelected) Color.Blue else Color.Black,
                style = ClinicTheme.typography.labelSmall
            )
        }
    }

}
