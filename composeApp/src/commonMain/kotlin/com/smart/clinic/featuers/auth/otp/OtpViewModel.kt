package com.smart.clinic.featuers.auth.otp

import com.smart.clinic.core.BaseViewModel
import com.smart.clinic.data.TestProvider

class OtpViewModel(
    val testProvider: TestProvider
) : BaseViewModel<OtpState, OtpAction, OtpEffect>(
    OtpState(desc = testProvider.myPrint())
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