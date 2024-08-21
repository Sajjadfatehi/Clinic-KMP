package com.smart.clinic.featuers.auth.role

import com.smart.clinic.core.BaseViewModel

class RoleViewModel : BaseViewModel<RoleState, RoleAction, RoleEffect>(
    RoleState()
) {

    override fun onEachAction(action: RoleAction) {
        when (action) {
            is RoleAction.RoleCardClicked -> {

            }

            else -> Unit
        }
    }
}