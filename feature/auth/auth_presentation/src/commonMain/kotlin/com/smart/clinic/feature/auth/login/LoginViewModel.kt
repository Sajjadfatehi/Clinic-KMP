package com.smart.clinic.feature.auth.login

import com.smart.clinic.common.commonUi.baseViewMolde.BaseViewModel


class LoginViewModel : BaseViewModel<LoginState, LoginAction, LoginEffect>(
    LoginState()
) {
    override fun onEachAction(action: LoginAction) {
        when (action) {
            is LoginAction.OnPhoneNumberChanges -> {
                setState {
                    copy(phoneNumber = action.phoneNumber)
                }
            }

            else -> {
                UInt
            }
        }
    }
}