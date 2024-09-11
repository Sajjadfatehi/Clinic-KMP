package com.smart.clinic.feature.auth.role

import com.smart.clinic.common.commonUi.baseViewMolde.BaseViewModel

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