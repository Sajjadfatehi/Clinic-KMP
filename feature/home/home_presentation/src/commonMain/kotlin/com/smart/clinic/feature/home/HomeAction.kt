package com.smart.clinic.feature.home

import com.smart.clinic.feature.home.utils.TopLevelDestination

sealed interface HomeAction {
    data class SelectTopLevelDestination(val selected : TopLevelDestination) : HomeAction
}