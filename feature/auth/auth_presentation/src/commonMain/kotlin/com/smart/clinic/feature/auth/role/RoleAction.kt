package com.smart.clinic.feature.auth.role

interface RoleAction {
    data class RoleCardClicked(val type: RoleType) : RoleAction
}