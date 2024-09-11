package com.smart.clinic.feature.auth.otp

import com.smart.clinic.common.commonUi.baseViewMolde.BaseViewModel


class OtpViewModel(
) : BaseViewModel<OtpState, OtpAction, OtpEffect>(
    OtpState(desc = "")
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