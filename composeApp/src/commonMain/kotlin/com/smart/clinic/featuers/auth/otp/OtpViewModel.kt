package com.smart.clinic.featuers.auth.otp

import com.smart.clinic.core.BaseViewModel

class OtpViewModel : BaseViewModel<OtpState, OtpAction, OtpEffect>(
    OtpState()
) {

    override fun onEachAction(action: OtpAction) {
        when (action) {
            is OtpAction.OnSendOtpClicked -> {

            }

            is OtpAction.OnOtpChanged -> {
                setState {
                    copy(otp = action.otp)
                }
            }

            else -> Unit

        }
    }
}