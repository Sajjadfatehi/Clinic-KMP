package com.smart.clinic.feature.home.utils

import clinic.feature.home.home_presentation.generated.resources.Res
import clinic.feature.home.home_presentation.generated.resources.appointment
import clinic.feature.home.home_presentation.generated.resources.file
import clinic.feature.home.home_presentation.generated.resources.ic_avatar_selected
import clinic.feature.home.home_presentation.generated.resources.ic_avatar_unselected
import clinic.feature.home.home_presentation.generated.resources.ic_bell_selected
import clinic.feature.home.home_presentation.generated.resources.ic_bell_unselected
import clinic.feature.home.home_presentation.generated.resources.ic_calender_selected
import clinic.feature.home.home_presentation.generated.resources.ic_calender_unselected
import clinic.feature.home.home_presentation.generated.resources.ic_folder_selected
import clinic.feature.home.home_presentation.generated.resources.ic_folder_unselected
import clinic.feature.home.home_presentation.generated.resources.ic_search_selected
import clinic.feature.home.home_presentation.generated.resources.ic_search_unselected
import clinic.feature.home.home_presentation.generated.resources.notification
import clinic.feature.home.home_presentation.generated.resources.profile
import clinic.feature.home.home_presentation.generated.resources.search
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

enum class TopLevelDestination(
    val selectedIcon: DrawableResource,
    val unselectedIcon: DrawableResource,
    val titleTextId: StringResource,
    val route: String,
    val isSelected :Boolean
) {
    SEARCH(
        selectedIcon = Res.drawable.ic_search_selected,
        unselectedIcon = Res.drawable.ic_search_unselected,
        titleTextId = Res.string.search,
        route = "todo-search",
        isSelected = true
    ),
    APPOINTMENT(
        selectedIcon = Res.drawable.ic_calender_selected,
        unselectedIcon = Res.drawable.ic_calender_unselected,
        titleTextId = Res.string.appointment,
        route = "todo-appointment",
        isSelected = false
    ),
    FILE(
        selectedIcon = Res.drawable.ic_folder_selected,
        unselectedIcon = Res.drawable.ic_folder_unselected,
        titleTextId = Res.string.file,
        route = "todo-file",
        isSelected = false
    ),
    NOTIFICATION(
        selectedIcon = Res.drawable.ic_bell_selected,
        unselectedIcon = Res.drawable.ic_bell_unselected,
        titleTextId = Res.string.notification,
        route = "todo-notification",
        isSelected = false
    ),
    PROFILE(
        selectedIcon = Res.drawable.ic_avatar_selected,
        unselectedIcon = Res.drawable.ic_avatar_unselected,
        titleTextId = Res.string.profile,
        route = "todo-profile",
        isSelected = false
    ),
}

//sealed class TopLevelDestination(
//    val selectedIcon: DrawableResource,
//    val unselectedIcon: DrawableResource,
//    val titleTextId: StringResource,
//    val route: String,
//    open var isSelected: Boolean,
//) {
//    data class SEARCH(
//        override var isSelected: Boolean = true,
//    ) : TopLevelDestination(
//        selectedIcon = Res.drawable.ic_search_selected,
//        unselectedIcon = Res.drawable.ic_search_unselected,
//        titleTextId = Res.string.search,
//        route = "todo-search",
//        isSelected = isSelected
//    )
//
//    data class APPOINTMENT(
//        override var isSelected: Boolean = false,
//    ) : TopLevelDestination(
//        selectedIcon = Res.drawable.ic_calender_selected,
//        unselectedIcon = Res.drawable.ic_calender_unselected,
//        titleTextId = Res.string.appointment,
//        route = "todo-appointment",
//        isSelected = isSelected
//    )
//
//    data class FILE(
//        override var isSelected: Boolean = false,
//    ) : TopLevelDestination(
//        selectedIcon = Res.drawable.ic_folder_selected,
//        unselectedIcon = Res.drawable.ic_folder_unselected,
//        titleTextId = Res.string.file,
//        route = "todo-file",
//        isSelected = isSelected
//    )
//
//    data class NOTIFICATION(
//        override var isSelected: Boolean = false,
//    ) : TopLevelDestination(
//        selectedIcon = Res.drawable.ic_bell_selected,
//        unselectedIcon = Res.drawable.ic_bell_unselected,
//        titleTextId = Res.string.notification,
//        route = "todo-notification",
//        isSelected = isSelected
//    )
//
//    data class PROFILE(
//        override var isSelected: Boolean = false,
//    ) : TopLevelDestination(
//        selectedIcon = Res.drawable.ic_avatar_selected,
//        unselectedIcon = Res.drawable.ic_avatar_unselected,
//        titleTextId = Res.string.profile,
//        route = "todo-profile",
//        isSelected = isSelected
//    )
//}
