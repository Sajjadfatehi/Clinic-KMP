package com.smart.clinic.core.designsystem.component


import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.smart.clinic.core.designsystem.theme.ClinicTheme
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClinicTopAppBar(
    title: String,
    navigationIconId: DrawableResource? = null,
    navigationIconContentDescription: String = "",
    actionIconId: DrawableResource? = null,
    actionIconContentDescription: String = "",
    modifier: Modifier = Modifier,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(
        containerColor = ClinicTheme.colorScheme.backgroundBase
    ),
    onNavigationClick: () -> Unit = {},
    onActionClick: () -> Unit = {},
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                style = ClinicTheme.typography.headingH6,
                color = ClinicTheme.colorScheme.foregroundStrong
            )
        },
        navigationIcon = {
            navigationIconId?.let {
                IconButton(onClick = onNavigationClick) {
                    Icon(
                        painter = painterResource(navigationIconId),
                        contentDescription = navigationIconContentDescription,
                        tint = MaterialTheme.colorScheme.onSurface,
                    )
                }
            }
        },
        actions = {
            IconButton(onClick = onActionClick) {
                actionIconId?.let {
                    Icon(
                        painter = painterResource(actionIconId),
                        contentDescription = actionIconContentDescription,
                        tint = MaterialTheme.colorScheme.onSurface,
                    )
                }
            }
        },
        colors = colors,
        modifier = modifier.testTag("niaTopAppBar"),
    )
}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Preview()
//@Composable
//private fun NiaTopAppBarPreview() {
//    ClinicTheme {
//        NiaTopAppBar(
//            titleRes = Res.string.untitled,
//            navigationIcon = NiaIcons.Search,
//            navigationIconContentDescription = "Navigation icon",
//            actionIcon = NiaIcons.MoreVert,
//            actionIconContentDescription = "Action icon",
//        )
//    }
//}
