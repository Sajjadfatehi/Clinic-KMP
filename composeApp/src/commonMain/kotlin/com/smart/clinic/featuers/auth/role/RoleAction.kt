package com.smart.clinic.featuers.auth.role

interface RoleAction {
    data class RoleCardClicked(val type: RoleType) : RoleAction
}