package com.smart.clinic.featuers.auth.otp

import com.smart.clinic.core.BaseViewModel

class OtpViewModel : BaseViewModel<OtpState, OtpAction, OtpEffect>(
    OtpState()
) {

    override fun onEachAction(action: OtpAction) {
        when (action) {
            is OtpAction.OnSendOtpClicked -> {

            }

            else -> Unit

        }
    }
}